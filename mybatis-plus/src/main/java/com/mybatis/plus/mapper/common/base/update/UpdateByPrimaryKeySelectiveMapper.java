package com.mybatis.plus.mapper.common.base.update;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;
import com.mybatis.plus.mapper.provider.base.BaseUpdateProvider;

/**
 * 通用Mapper接口,更新
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface UpdateByPrimaryKeySelectiveMapper<T> {

	/**
	 * 根据主键更新属性不为null的值
	 *
	 * @param record
	 * @return
	 */
	@UpdateProvider(type = BaseUpdateProvider.class, method = "dynamicSQL")
	@Options(useCache = false, useGeneratedKeys = false)
	int updateByPrimaryKeySelective(T record);

}