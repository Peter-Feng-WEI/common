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
public interface UpdateByExampleSelectiveMapper<T> {

	/**
	 * 根据Example条件更新实体`record`包含的不是null的属性值
	 *
	 * @param record
	 * @param example
	 * @return
	 */
	@UpdateProvider(type = ExampleProvider.class, method = "dynamicSQL")
	@Options(useCache = false, useGeneratedKeys = false)
	int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);

}