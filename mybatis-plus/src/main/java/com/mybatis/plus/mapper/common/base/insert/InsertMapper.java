package com.mybatis.plus.mapper.common.base.insert;

import org.apache.ibatis.annotations.InsertProvider;
import com.mybatis.plus.mapper.provider.base.BaseInsertProvider;

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
	 * 保存一个实体，null的属性也会保存，不会使用数据库默认值
	 *
	 * @param record
	 * @return
	 */
	@InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
	int insert(T record);

}