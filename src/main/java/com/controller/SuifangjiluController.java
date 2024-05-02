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

import com.entity.SuifangjiluEntity;

import com.entity.view.SuifangjiluView;
import com.entity.JigoushequEntity;
import com.entity.LaorenEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 随访记录
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/suifangjilu")
public class SuifangjiluController {
    private static final Logger logger = LoggerFactory.getLogger(SuifangjiluController.class);

    @Autowired
    private SuifangjiluService suifangjiluService;


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
        PageUtils page = suifangjiluService.queryPage(params);

        //字典表数据转换
        List<SuifangjiluView> list =(List<SuifangjiluView>)page.getList();
        for(SuifangjiluView c:list){
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
        SuifangjiluEntity suifangjilu = suifangjiluService.selectById(id);
        if(suifangjilu !=null){
            //entity转view
            SuifangjiluView view = new SuifangjiluView();
            BeanUtils.copyProperties( suifangjilu , view );//把实体数据重构到view中

            //级联表
            JigoushequEntity jigoushequ = jigoushequService.selectById(suifangjilu.getJigoushequId());
            if(jigoushequ != null){
                BeanUtils.copyProperties( jigoushequ , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJigoushequId(jigoushequ.getId());
            }
            //级联表
            LaorenEntity laoren = laorenService.selectById(suifangjilu.getLaorenId());
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
    public R save(@RequestBody SuifangjiluEntity suifangjilu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,suifangjilu:{}",this.getClass().getName(),suifangjilu.toString());
            suifangjilu.setInsertTime(new Date());
            suifangjilu.setCreateTime(new Date());
            String role = String.valueOf(request.getSession().getAttribute("role"));
            if("管理员".equals(role)){
              suifangjilu.setJigoushequId(0);
            }else if("机构社区人员".equals(role)){
                suifangjilu.setJigoushequId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            }
            suifangjiluService.insert(suifangjilu);
            return R.ok();
//        }else {
//            return R.error(511,"表中有相同数据");
//        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SuifangjiluEntity suifangjilu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,suifangjilu:{}",this.getClass().getName(),suifangjilu.toString());
//        //根据字段查询是否有相同数据
//        Wrapper<SuifangjiluEntity> queryWrapper = new EntityWrapper<SuifangjiluEntity>()
//            .notIn("id",suifangjilu.getId())
//            .andNew()
//            .eq("laoren_id", suifangjilu.getLaorenId())
//            .eq("jigoushequ_id", suifangjilu.getJigoushequId())
//            ;
//        logger.info("sql语句:"+queryWrapper.getSqlSegment());
//        SuifangjiluEntity suifangjiluEntity = suifangjiluService.selectOne(queryWrapper);
//        if(suifangjiluEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      suifangjilu.set
            //  }
            suifangjiluService.updateById(suifangjilu);//根据id更新
            return R.ok();
//        }else {
//            return R.error(511,"表中有相同数据");
//        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        suifangjiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

