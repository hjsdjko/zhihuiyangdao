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

import com.entity.QiuzhuEntity;

import com.entity.view.QiuzhuView;
import com.entity.LaorenEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 求助服务
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qiuzhu")
public class QiuzhuController {
    private static final Logger logger = LoggerFactory.getLogger(QiuzhuController.class);

    @Autowired
    private QiuzhuService qiuzhuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
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
        PageUtils page = qiuzhuService.queryPage(params);

        //字典表数据转换
        List<QiuzhuView> list =(List<QiuzhuView>)page.getList();
        for(QiuzhuView c:list){
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
        QiuzhuEntity qiuzhu = qiuzhuService.selectById(id);
        if(qiuzhu !=null){
            //entity转view
            QiuzhuView view = new QiuzhuView();
            BeanUtils.copyProperties( qiuzhu , view );//把实体数据重构到view中

            //级联表
            LaorenEntity laoren = laorenService.selectById(qiuzhu.getLaorenId());
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
    public R save(@RequestBody QiuzhuEntity qiuzhu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qiuzhu:{}",this.getClass().getName(),qiuzhu.toString());

            qiuzhu.setInsertTime(new Date());
            qiuzhu.setCreateTime(new Date());
            String role = String.valueOf(request.getSession().getAttribute("role"));
            if("老人".equals(role)){
                qiuzhu.setLaorenId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
                qiuzhu.setQiuzhuYesnoTypes(1);
            }
            qiuzhuService.insert(qiuzhu);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QiuzhuEntity qiuzhu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,qiuzhu:{}",this.getClass().getName(),qiuzhu.toString());
        qiuzhuService.updateById(qiuzhu);//根据id更新
        return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        qiuzhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

