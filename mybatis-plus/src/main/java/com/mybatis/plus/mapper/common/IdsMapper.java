package com.mybatis.plus.mapper.common;

import com.mybatis.plus.mapper.common.ids.DeleteByIdsMapper;
import com.mybatis.plus.mapper.common.ids.SelectByIdsMapper;

/**
 * 通用Mapper接口,根据ids操作
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface IdsMapper<T> extends SelectByIdsMapper<T>, DeleteByIdsMapper<T> {

}
