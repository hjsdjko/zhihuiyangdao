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

import com.dao.SuifangjiluDao;
import com.entity.SuifangjiluEntity;
import com.service.SuifangjiluService;
import com.entity.view.SuifangjiluView;

/**
 * 随访记录 服务实现类
 */
@Service("suifangjiluService")
@Transactional
public class SuifangjiluServiceImpl extends ServiceImpl<SuifangjiluDao, SuifangjiluEntity> implements SuifangjiluService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<SuifangjiluView> page =new Query<SuifangjiluView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
