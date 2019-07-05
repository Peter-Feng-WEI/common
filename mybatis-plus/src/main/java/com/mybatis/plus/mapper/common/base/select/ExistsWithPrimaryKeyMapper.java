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
public interface ExistsWithPrimaryKeyMapper<T> {

	/**
	 * 根据主键字段查询总数，方法参数必须包含完整的主键属性，查询条件使用等号
	 *
	 * @param key
	 * @return
	 */
	@SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
	boolean existsWithPrimaryKey(Object key);

}