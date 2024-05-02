package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.YuleEntity;

import com.service.YuleService;
import com.entity.view.YuleView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 娱乐活动
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yule")
public class YuleController {
    private static final Logger logger = LoggerFactory.getLogger(YuleController.class);

    @Autowired
    private YuleService yuleService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
     
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "老人".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = yuleService.queryPage(params);

        //字典表数据转换
        List<YuleView> list =(List<YuleView>)page.getList();
        for(YuleView c:list){
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
        YuleEntity yule = yuleService.selectById(id);
        if(yule !=null){
            //entity转view
            YuleView view = new YuleView();
            BeanUtils.copyProperties( yule , view );//把实体数据重构到view中

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
    public R save(@RequestBody YuleEntity yule, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yule:{}",this.getClass().getName(),yule.toString());
        Wrapper<YuleEntity> queryWrapper = new EntityWrapper<YuleEntity>()
            .eq("yule_name", yule.getYuleName())
            .eq("yule_types", yule.getYuleTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuleEntity yuleEntity = yuleService.selectOne(queryWrapper);
        if(yuleEntity==null){
            yule.setInsertTime(new Date());
            yule.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      yule.set
        //  }
            yuleService.insert(yule);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YuleEntity yule, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yule:{}",this.getClass().getName(),yule.toString());
        //根据字段查询是否有相同数据
        Wrapper<YuleEntity> queryWrapper = new EntityWrapper<YuleEntity>()
            .notIn("id",yule.getId())
            .andNew()
            .eq("yule_name", yule.getYuleName())
            .eq("yule_types", yule.getYuleTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YuleEntity yuleEntity = yuleService.selectOne(queryWrapper);
        if(yuleEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      yule.set
            //  }
            yuleService.updateById(yule);//根据id更新
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
        yuleService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

