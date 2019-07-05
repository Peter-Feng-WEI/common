package com.mybatis.plus.mapper.common.base.select;

import org.apache.ibatis.annotations.SelectProvider;
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
public interface SelectMapper<T> {

	/**
	 * 根据实体中的属性值进行查询，查询条件使用等号
	 *
	 * @param record
	 * @return
	 */
	@SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
	List<T> select(T record);

}