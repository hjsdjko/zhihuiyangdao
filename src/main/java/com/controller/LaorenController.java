package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.JiarenEntity;
import com.service.JiarenService;
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

import com.entity.LaorenEntity;

import com.service.LaorenService;
import com.entity.view.LaorenView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 老人
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/laoren")
public class LaorenController {
    private static final Logger logger = LoggerFactory.getLogger(LaorenController.class);

    @Autowired
    private LaorenService laorenService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private JiarenService jiarenService;



    //级联表service


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
            params.put("id",jiaren.getLaorenId());
        }
        params.put("orderBy","id");
        PageUtils page = laorenService.queryPage(params);

        //字典表数据转换
        List<LaorenView> list =(List<LaorenView>)page.getList();
        for(LaorenView c:list){
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
        LaorenEntity laoren = laorenService.selectById(id);
        if(laoren !=null){
            //entity转view
            LaorenView view = new LaorenView();
            BeanUtils.copyProperties( laoren , view );//把实体数据重构到view中

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
    public R save(@RequestBody LaorenEntity laoren, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,laoren:{}",this.getClass().getName(),laoren.toString());
        Wrapper<LaorenEntity> queryWrapper = new EntityWrapper<LaorenEntity>()
            .eq("username", laoren.getUsername())
            .or()
            .eq("laoren_phone", laoren.getLaorenPhone())
            .or()
            .eq("laoren_id_number", laoren.getLaorenIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaorenEntity laorenEntity = laorenService.selectOne(queryWrapper);
        if(laorenEntity==null){
            laoren.setCreateTime(new Date());
            laoren.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      laoren.set
        //  }
            laorenService.insert(laoren);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LaorenEntity laoren, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,laoren:{}",this.getClass().getName(),laoren.toString());
        //根据字段查询是否有相同数据
        Wrapper<LaorenEntity> queryWrapper = new EntityWrapper<LaorenEntity>()
            .notIn("id",laoren.getId())
            .andNew()
            .eq("username", laoren.getUsername())
            .or()
            .eq("laoren_phone", laoren.getLaorenPhone())
            .or()
            .eq("laoren_id_number", laoren.getLaorenIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaorenEntity laorenEntity = laorenService.selectOne(queryWrapper);
        if("".equals(laoren.getYonghuPhoto()) || "null".equals(laoren.getYonghuPhoto())){
                laoren.setYonghuPhoto(null);
        }
        if(laorenEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      laoren.set
            //  }
            laorenService.updateById(laoren);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        laorenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        LaorenEntity laoren = laorenService.selectOne(new EntityWrapper<LaorenEntity>().eq("username", username));
        if(laoren==null || !laoren.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(laoren.getId(),username, "laoren", "老人");
        R r = R.ok();
        r.put("token", token);
        r.put("role","老人");
        r.put("username",laoren.getLaorenName());
        r.put("tableName","laoren");
        r.put("userId",laoren.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody LaorenEntity laoren){
    //    	ValidatorUtils.validateEntity(user);
        if(laorenService.selectOne(new EntityWrapper<LaorenEntity>().eq("username", laoren.getUsername()).orNew().eq("laoren_phone",laoren.getLaorenPhone()).orNew().eq("laoren_id_number",laoren.getLaorenIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        laoren.setCreateTime(new Date());
        laorenService.insert(laoren);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        LaorenEntity laoren = new LaorenEntity();
        laoren.setPassword("123456");
        laoren.setId(id);
        laorenService.updateById(laoren);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrLaoren(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        LaorenEntity laoren = laorenService.selectById(id);
        return R.ok().put("data", laoren);
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }






}

