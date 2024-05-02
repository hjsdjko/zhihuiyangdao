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

import com.entity.JiarenEntity;

import com.service.JiarenService;
import com.entity.view.JiarenView;
import com.service.LaorenService;
import com.entity.LaorenEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 家人
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaren")
public class JiarenController {
    private static final Logger logger = LoggerFactory.getLogger(JiarenController.class);

    @Autowired
    private JiarenService jiarenService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private LaorenService laorenService;


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
        PageUtils page = jiarenService.queryPage(params);

        //字典表数据转换
        List<JiarenView> list =(List<JiarenView>)page.getList();
        for(JiarenView c:list){
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
        JiarenEntity jiaren = jiarenService.selectById(id);
        if(jiaren !=null){
            //entity转view
            JiarenView view = new JiarenView();
            BeanUtils.copyProperties( jiaren , view );//把实体数据重构到view中

            //级联表
            LaorenEntity laoren = laorenService.selectById(jiaren.getLaorenId());
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
    public R save(@RequestBody JiarenEntity jiaren, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaren:{}",this.getClass().getName(),jiaren.toString());
        Wrapper<JiarenEntity> queryWrapper = new EntityWrapper<JiarenEntity>()
            .eq("username", jiaren.getUsername())
            .or()
            .eq("jiaren_phone", jiaren.getJiarenPhone())
            .or()
            .eq("jiaren_id_number", jiaren.getJiarenIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiarenEntity jiarenEntity = jiarenService.selectOne(queryWrapper);
        if(jiarenEntity==null){
            jiaren.setCreateTime(new Date());
            jiaren.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      jiaren.set
        //  }
            jiarenService.insert(jiaren);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiarenEntity jiaren, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiaren:{}",this.getClass().getName(),jiaren.toString());
        //根据字段查询是否有相同数据
        Wrapper<JiarenEntity> queryWrapper = new EntityWrapper<JiarenEntity>()
            .notIn("id",jiaren.getId())
            .andNew()
            .eq("username", jiaren.getUsername())
            .or()
            .eq("jiaren_phone", jiaren.getJiarenPhone())
            .or()
            .eq("jiaren_id_number", jiaren.getJiarenIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiarenEntity jiarenEntity = jiarenService.selectOne(queryWrapper);
        if("".equals(jiaren.getJiarenPhoto()) || "null".equals(jiaren.getJiarenPhoto())){
                jiaren.setJiarenPhoto(null);
        }
        if(jiarenEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jiaren.set
            //  }
            jiarenService.updateById(jiaren);//根据id更新
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
        jiarenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        JiarenEntity jiaren = jiarenService.selectOne(new EntityWrapper<JiarenEntity>().eq("username", username));
        if(jiaren==null || !jiaren.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(jiaren.getId(),username, "jiaren", "家人");
        R r = R.ok();
        r.put("token", token);
        r.put("role","家人");
        r.put("username",jiaren.getJiarenName());
        r.put("tableName","jiaren");
        r.put("userId",jiaren.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JiarenEntity jiaren){
    //    	ValidatorUtils.validateEntity(user);
        if(jiarenService.selectOne(new EntityWrapper<JiarenEntity>().eq("username", jiaren.getUsername()).orNew().eq("jiaren_phone",jiaren.getJiarenPhone()).orNew().eq("jiaren_id_number",jiaren.getJiarenIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        jiaren.setCreateTime(new Date());
        jiarenService.insert(jiaren);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        JiarenEntity jiaren = new JiarenEntity();
        jiaren.setPassword("123456");
        jiaren.setId(id);
        jiarenService.updateById(jiaren);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrJiaren(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        JiarenEntity jiaren = jiarenService.selectById(id);
        return R.ok().put("data", jiaren);
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

