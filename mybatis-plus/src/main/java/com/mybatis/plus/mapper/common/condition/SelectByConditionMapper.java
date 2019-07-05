package com.mybatis.plus.mapper.common.condition;

import org.apache.ibatis.annotations.SelectProvider;
import com.mybatis.plus.mapper.provider.ConditionProvider;

import java.util.List;

/**
 * 通用Mapper接口,Condition查询
 *
 * @param <T>
 *            不能为空 Created by feng.wei on 2017/07/14.
 */
public interface SelectByConditionMapper<T> {

	/**
	 * 根据Condition条件进行查询
	 *
	 * @param condition
	 * @return
	 */
	@SelectProvider(type = ConditionProvider.class, method = "dynamicSQL")
	List<T> selectByCondition(Object condition);

}