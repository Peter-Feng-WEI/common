package com.mybatis.plus.mapper.common.example;

import org.apache.ibatis.annotations.DeleteProvider;
import com.mybatis.plus.mapper.provider.ExampleProvider;

/**
 * 通用Mapper接口,Example查询
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface DeleteByExampleMapper<T> {

	/**
	 * 根据Example条件删除数据
	 *
	 * @param example
	 * @return
	 */
	@DeleteProvider(type = ExampleProvider.class, method = "dynamicSQL")
	int deleteByExample(Object example);

}