package com.dao;

import com.entity.JiarenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiarenView;

/**
 * 家人 Dao 接口
 *
 * @author 
 */
public interface JiarenDao extends BaseMapper<JiarenEntity> {

   List<JiarenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
