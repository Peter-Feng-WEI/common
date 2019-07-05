package com.mybatis.plus.mapper.common.base.select;

import org.apache.ibatis.annotations.SelectProvider;
import com.mybatis.plus.mapper.provider.base.BaseSelectProvider;

/**
 * 通用Mapper接口,查询
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface SelectCountMapper<T> {

	/**
	 * 根据实体中的属性查询总数，查询条件使用等号
	 *
	 * @param record
	 * @return
	 */
	@SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
	int selectCount(T record);

}