package com.mybatis.plus.mapper.common.rowbounds;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import com.mybatis.plus.mapper.provider.base.BaseSelectProvider;

import java.util.List;

/**
 * 通用Mapper接口,查询
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface SelectRowBoundsMapper<T> {

	/**
	 * 根据实体属性和RowBounds进行分页查询
	 *
	 * @param record
	 * @param rowBounds
	 * @return
	 */
	@SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
	List<T> selectByRowBounds(T record, RowBounds rowBounds);

}