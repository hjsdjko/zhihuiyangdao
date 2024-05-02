package com.dao;

import com.entity.SuifangjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SuifangjiluView;

/**
 * 随访记录 Dao 接口
 *
 * @author 
 */
public interface SuifangjiluDao extends BaseMapper<SuifangjiluEntity> {

   List<SuifangjiluView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
