package com.mybatis.plus.mapper.common.base;

import com.mybatis.plus.mapper.common.base.delete.DeleteByPrimaryKeyMapper;
import com.mybatis.plus.mapper.common.base.delete.DeleteMapper;

/**
 * 通用Mapper接口,基础删除
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface BaseDeleteMapper<T> extends DeleteMapper<T>, DeleteByPrimaryKeyMapper<T> {

}