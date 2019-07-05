package com.mybatis.plus.mapper.common.condition;

import org.apache.ibatis.annotations.DeleteProvider;
import com.mybatis.plus.mapper.provider.ConditionProvider;

/**
 * 通用Mapper接口,Condition查询
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface DeleteByConditionMapper<T> {

	/**
	 * 根据Condition条件删除数据
	 *
	 * @param condition
	 * @return
	 */
	@DeleteProvider(type = ConditionProvider.class, method = "dynamicSQL")
	int deleteByCondition(Object condition);

}