package com.mybatis.plus.mapper.common.example;

import org.apache.ibatis.annotations.SelectProvider;
import com.mybatis.plus.mapper.provider.ExampleProvider;

/**
 * 通用Mapper接口,Example查询
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface SelectCountByExampleMapper<T> {

	/**
	 * 根据Example条件进行查询总数
	 *
	 * @param example
	 * @return
	 */
	@SelectProvider(type = ExampleProvider.class, method = "dynamicSQL")
	int selectCountByExample(Object example);

}