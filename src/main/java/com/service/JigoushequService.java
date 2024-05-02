package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JigoushequEntity;
import java.util.Map;

/**
 * 机构社区人员 服务类
 */
public interface JigoushequService extends IService<JigoushequEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}