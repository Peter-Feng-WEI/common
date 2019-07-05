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
public interface InsertSelectiveMapper<T> {

	@Options(useGeneratedKeys = true, keyProperty = "id")
	@InsertProvider(type = SqlServerProvider.class, method = "dynamicSQL")
	int insertSelective(T record);

}