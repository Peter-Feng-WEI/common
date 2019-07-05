package com.mybatis.plus.mapper.common.base;

import com.mybatis.plus.mapper.common.base.insert.InsertMapper;
import com.mybatis.plus.mapper.common.base.insert.InsertSelectiveMapper;
import com.mybatis.plus.mapper.common.special.InsertListMapper;

/**
 * 通用Mapper接口,基础查询
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface BaseInsertMapper<T> extends InsertMapper<T>, InsertListMapper<T>, InsertSelectiveMapper<T> {

}