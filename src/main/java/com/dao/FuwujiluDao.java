package com.dao;

import com.entity.FuwujiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FuwujiluView;

/**
 * 服务记录 Dao 接口
 *
 * @author 
 */
public interface FuwujiluDao extends BaseMapper<FuwujiluEntity> {

   List<FuwujiluView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
