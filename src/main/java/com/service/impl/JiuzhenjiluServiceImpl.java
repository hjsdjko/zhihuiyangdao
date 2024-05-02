package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.JiuzhenjiluDao;
import com.entity.JiuzhenjiluEntity;
import com.service.JiuzhenjiluService;
import com.entity.view.JiuzhenjiluView;

/**
 * 就诊记录 服务实现类
 */
@Service("jiuzhenjiluService")
@Transactional
public class JiuzhenjiluServiceImpl extends ServiceImpl<JiuzhenjiluDao, JiuzhenjiluEntity> implements JiuzhenjiluService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JiuzhenjiluView> page =new Query<JiuzhenjiluView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
