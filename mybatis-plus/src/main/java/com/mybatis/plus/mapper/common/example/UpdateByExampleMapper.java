package com.mybatis.plus.mapper.common.example;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;
import com.mybatis.plus.mapper.provider.ExampleProvider;

/**
 * 通用Mapper接口,Example查询
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface UpdateByExampleMapper<T> {

	/**
	 * 根据Example条件更新实体`record`包含的全部属性，null值会被更新
	 *
	 * @param record
	 * @param example
	 * @return
	 */
	@UpdateProvider(type = ExampleProvider.class, method = "dynamicSQL")
	@Options(useCache = false, useGeneratedKeys = false)
	int updateByExample(@Param("record") T record, @Param("example") Object example);

}