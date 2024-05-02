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

import com.dao.JigoushequDao;
import com.entity.JigoushequEntity;
import com.service.JigoushequService;
import com.entity.view.JigoushequView;

/**
 * 机构社区人员 服务实现类
 */
@Service("jigoushequService")
@Transactional
public class JigoushequServiceImpl extends ServiceImpl<JigoushequDao, JigoushequEntity> implements JigoushequService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JigoushequView> page =new Query<JigoushequView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
