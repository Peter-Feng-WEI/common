package com.mybatis.plus.mapper.common;

import com.mybatis.plus.mapper.common.sqlserver.InsertMapper;
import com.mybatis.plus.mapper.common.sqlserver.InsertSelectiveMapper;

/**
 * 通用Mapper接口,SqlServerMapper独有的通用方法
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface SqlServerMapper<T> extends InsertMapper<T>, InsertSelectiveMapper<T> {

}