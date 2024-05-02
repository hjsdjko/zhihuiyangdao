package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.JiarenEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.FuwujiluEntity;

import com.entity.view.FuwujiluView;
import com.entity.JigoushequEntity;
import com.entity.LaorenEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 服务记录
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fuwujilu")
public class FuwujiluController {
    private static final Logger logger = LoggerFactory.getLogger(FuwujiluController.class);

    @Autowired
    private FuwujiluService fuwujiluService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private JigoushequService jigoushequService;
    @Autowired
    private LaorenService laorenService;
    @Autowired
    private JiarenService jiarenService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
     
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "老人".equals(role)){
            params.put("laorenId",request.getSession().getAttribute("userId"));
        }else if(StringUtil.isNotEmpty(role) && "家人".equals(role)){
            JiarenEntity jiaren = jiarenService.selectById(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            params.put("laorenId",jiaren.getLaorenId());
        }
        params.put("orderBy","id");
        PageUtils page = fuwujiluService.queryPage(params);

        //字典表数据转换
        List<FuwujiluView> list =(List<FuwujiluView>)page.getList();
        for(FuwujiluView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FuwujiluEntity fuwujilu = fuwujiluService.selectById(id);
        if(fuwujilu !=null){
            //entity转view
            FuwujiluView view = new FuwujiluView();
            BeanUtils.copyProperties( fuwujilu , view );//把实体数据重构到view中

            //级联表
            JigoushequEntity jigoushequ = jigoushequService.selectById(fuwujilu.getJigoushequId());
            if(jigoushequ != null){
                BeanUtils.copyProperties( jigoushequ , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJigoushequId(jigoushequ.getId());
            }
            //级联表
            LaorenEntity laoren = laorenService.selectById(fuwujilu.getLaorenId());
            if(laoren != null){
                BeanUtils.copyProperties( laoren , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setLaorenId(laoren.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FuwujiluEntity fuwujilu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fuwujilu:{}",this.getClass().getName(),fuwujilu.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("管理员".equals(role)){
            fuwujilu.setJigoushequId(0);
        }else if("机构社区人员".equals(role)){
            fuwujilu.setJigoushequId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        fuwujilu.setInsertTime(new Date());
        fuwujilu.setCreateTime(new Date());
        fuwujiluService.insert(fuwujilu);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FuwujiluEntity fuwujilu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fuwujilu:{}",this.getClass().getName(),fuwujilu.toString());
        //根据字段查询是否有相同数据
        Wrapper<FuwujiluEntity> queryWrapper = new EntityWrapper<FuwujiluEntity>()
            .notIn("id",fuwujilu.getId())
            .andNew()
            .eq("laoren_id", fuwujilu.getLaorenId())
            .eq("jigoushequ_id", fuwujilu.getJigoushequId())
            .eq("fuwujilu_types", fuwujilu.getFuwujiluTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FuwujiluEntity fuwujiluEntity = fuwujiluService.selectOne(queryWrapper);
        fuwujilu.setUpdateTime(new Date());
        if(fuwujiluEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      fuwujilu.set
            //  }
            fuwujiluService.updateById(fuwujilu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fuwujiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

