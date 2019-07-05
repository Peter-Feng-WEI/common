package com.mybatis.plus.mapper.common.base;

import com.mybatis.plus.mapper.common.base.select.*;

/**
 * 通用Mapper接口,基础查询
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface BaseSelectMapper<T> extends SelectOneMapper<T>, SelectMapper<T>, SelectAllMapper<T>,
		SelectCountMapper<T>, SelectByPrimaryKeyMapper<T>, ExistsWithPrimaryKeyMapper<T> {

}