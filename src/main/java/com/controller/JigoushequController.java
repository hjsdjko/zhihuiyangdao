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

import com.entity.JigoushequEntity;

import com.service.JigoushequService;
import com.entity.view.JigoushequView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 机构社区人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jigoushequ")
public class JigoushequController {
    private static final Logger logger = LoggerFactory.getLogger(JigoushequController.class);

    @Autowired
    private JigoushequService jigoushequService;


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
//        if(StringUtil.isNotEmpty(role) && "老人".equals(role)){
//            params.put("yonghuId",request.getSession().getAttribute("userId"));
//        }
        params.put("orderBy","id");
        PageUtils page = jigoushequService.queryPage(params);

        //字典表数据转换
        List<JigoushequView> list =(List<JigoushequView>)page.getList();
        for(JigoushequView c:list){
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
        JigoushequEntity jigoushequ = jigoushequService.selectById(id);
        if(jigoushequ !=null){
            //entity转view
            JigoushequView view = new JigoushequView();
            BeanUtils.copyProperties( jigoushequ , view );//把实体数据重构到view中

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
    public R save(@RequestBody JigoushequEntity jigoushequ, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jigoushequ:{}",this.getClass().getName(),jigoushequ.toString());
        Wrapper<JigoushequEntity> queryWrapper = new EntityWrapper<JigoushequEntity>()
            .eq("username", jigoushequ.getUsername())
            .or()
            .eq("jigoushequ_phone", jigoushequ.getJigoushequPhone())
            .or()
            .eq("jigoushequ_id_number", jigoushequ.getJigoushequIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JigoushequEntity jigoushequEntity = jigoushequService.selectOne(queryWrapper);
        if(jigoushequEntity==null){
            jigoushequ.setCreateTime(new Date());
            jigoushequ.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      jigoushequ.set
        //  }
            jigoushequService.insert(jigoushequ);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JigoushequEntity jigoushequ, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jigoushequ:{}",this.getClass().getName(),jigoushequ.toString());
        //根据字段查询是否有相同数据
        Wrapper<JigoushequEntity> queryWrapper = new EntityWrapper<JigoushequEntity>()
            .notIn("id",jigoushequ.getId())
            .andNew()
            .eq("username", jigoushequ.getUsername())
            .or()
            .eq("jigoushequ_phone", jigoushequ.getJigoushequPhone())
            .or()
            .eq("jigoushequ_id_number", jigoushequ.getJigoushequIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JigoushequEntity jigoushequEntity = jigoushequService.selectOne(queryWrapper);
        if("".equals(jigoushequ.getJigoushequPhoto()) || "null".equals(jigoushequ.getJigoushequPhoto())){
                jigoushequ.setJigoushequPhoto(null);
        }
        if(jigoushequEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jigoushequ.set
            //  }
            jigoushequService.updateById(jigoushequ);//根据id更新
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
        jigoushequService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        JigoushequEntity jigoushequ = jigoushequService.selectOne(new EntityWrapper<JigoushequEntity>().eq("username", username));
        if(jigoushequ==null || !jigoushequ.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(jigoushequ.getId(),username, "jigoushequ", "机构社区人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","机构社区人员");
        r.put("username",jigoushequ.getJigoushequName());
        r.put("tableName","jigoushequ");
        r.put("userId",jigoushequ.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JigoushequEntity jigoushequ){
    //    	ValidatorUtils.validateEntity(user);
        if(jigoushequService.selectOne(new EntityWrapper<JigoushequEntity>().eq("username", jigoushequ.getUsername()).orNew().eq("jigoushequ_phone",jigoushequ.getJigoushequPhone()).orNew().eq("jigoushequ_id_number",jigoushequ.getJigoushequIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        jigoushequ.setCreateTime(new Date());
        jigoushequService.insert(jigoushequ);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        JigoushequEntity jigoushequ = new JigoushequEntity();
        jigoushequ.setPassword("123456");
        jigoushequ.setId(id);
        jigoushequService.updateById(jigoushequ);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrJigoushequ(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        JigoushequEntity jigoushequ = jigoushequService.selectById(id);
        return R.ok().put("data", jigoushequ);
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

