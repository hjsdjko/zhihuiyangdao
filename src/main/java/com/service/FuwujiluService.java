package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FuwujiluEntity;
import java.util.Map;

/**
 * 服务记录 服务类
 */
public interface FuwujiluService extends IService<FuwujiluEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}