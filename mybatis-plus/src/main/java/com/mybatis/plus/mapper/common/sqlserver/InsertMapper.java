package com.mybatis.plus.mapper.common.sqlserver;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import com.mybatis.plus.mapper.provider.SqlServerProvider;

/**
 * 通用Mapper接口,插入
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface InsertMapper<T> {

	/**
	 * 插入数据库，`null`值也会插入，不会使用列的默认值
	 *
	 * @param record
	 * @return
	 */
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@InsertProvider(type = SqlServerProvider.class, method = "dynamicSQL")
	int insert(T record);

}