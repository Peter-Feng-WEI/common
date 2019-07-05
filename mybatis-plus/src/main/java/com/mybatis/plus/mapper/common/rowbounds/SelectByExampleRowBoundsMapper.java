package com.mybatis.plus.mapper.common.rowbounds;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import com.mybatis.plus.mapper.provider.ExampleProvider;

import java.util.List;

/**
 * 通用Mapper接口,查询
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface SelectByExampleRowBoundsMapper<T> {

	/**
	 * 根据example条件和RowBounds进行分页查询
	 *
	 * @param example
	 * @param rowBounds
	 * @return
	 */
	@SelectProvider(type = ExampleProvider.class, method = "dynamicSQL")
	List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);

}