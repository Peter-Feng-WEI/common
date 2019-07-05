package com.mybatis.plus.mapper.entity;

/**
 * Condition - 条件查询
 *
 * Created by feng.wei on 2017/07/14.
 */
public class Condition extends Example {
	public Condition(Class<?> entityClass) {
		super(entityClass);
	}

	public Condition(Class<?> entityClass, boolean exists) {
		super(entityClass, exists);
	}

	public Condition(Class<?> entityClass, boolean exists, boolean notNull) {
		super(entityClass, exists, notNull);
	}
}
