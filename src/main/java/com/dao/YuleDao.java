package com.dao;

import com.entity.YuleEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuleView;

/**
 * 娱乐活动 Dao 接口
 *
 * @author 
 */
public interface YuleDao extends BaseMapper<YuleEntity> {

   List<YuleView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
