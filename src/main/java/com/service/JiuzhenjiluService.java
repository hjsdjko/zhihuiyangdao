package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiuzhenjiluEntity;
import java.util.Map;

/**
 * 就诊记录 服务类
 */
public interface JiuzhenjiluService extends IService<JiuzhenjiluEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}