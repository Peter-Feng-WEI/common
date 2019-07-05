package com.mybatis.plus.mapper.common;

import com.mybatis.plus.mapper.common.rowbounds.SelectByExampleRowBoundsMapper;
import com.mybatis.plus.mapper.common.rowbounds.SelectRowBoundsMapper;

/**
 * 通用Mapper接口,带RowBounds参数的查询
 * <p/>
 * 配合分页插件PageHelper可以实现物理分页
 * <p/>
 * PageHelper - http://git.oschina.net/free/Mybatis_PageHelper
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface RowBoundsMapper<T> extends SelectByExampleRowBoundsMapper<T>, SelectRowBoundsMapper<T> {

}