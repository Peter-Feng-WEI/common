package com.mybatis.plus.mapper.common;

import com.mybatis.plus.mapper.common.special.InsertListMapper;
import com.mybatis.plus.mapper.common.special.InsertUseGeneratedKeysMapper;

/**
 * 通用Mapper接口,MySql独有的通用方法
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface MySqlMapper<T> extends InsertListMapper<T>, InsertUseGeneratedKeysMapper<T> {

}