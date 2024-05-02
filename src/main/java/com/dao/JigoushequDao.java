package com.dao;

import com.entity.JigoushequEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JigoushequView;

/**
 * 机构社区人员 Dao 接口
 *
 * @author 
 */
public interface JigoushequDao extends BaseMapper<JigoushequEntity> {

   List<JigoushequView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
