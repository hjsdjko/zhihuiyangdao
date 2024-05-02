package com.dao;

import com.entity.JiuzhenjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiuzhenjiluView;

/**
 * 就诊记录 Dao 接口
 *
 * @author 
 */
public interface JiuzhenjiluDao extends BaseMapper<JiuzhenjiluEntity> {

   List<JiuzhenjiluView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
