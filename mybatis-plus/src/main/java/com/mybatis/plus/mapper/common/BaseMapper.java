package com.mybatis.plus.mapper.common;

import com.mybatis.plus.mapper.common.base.BaseDeleteMapper;
import com.mybatis.plus.mapper.common.base.BaseInsertMapper;
import com.mybatis.plus.mapper.common.base.BaseSelectMapper;
import com.mybatis.plus.mapper.common.base.BaseUpdateMapper;

/**
 * 通用Mapper接口,其他接口继承该接口即可
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface BaseMapper<T>
		extends BaseSelectMapper<T>, BaseInsertMapper<T>, BaseUpdateMapper<T>, BaseDeleteMapper<T> {

}