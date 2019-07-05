package com.mybatis.plus.mapper.common;

import com.mybatis.plus.mapper.common.example.*;

/**
 * 通用Mapper接口,Example查询
 *
 * @param <T>
 *            不能为空
 * 
 *            Created by feng.wei on 2017/07/14.
 */
public interface ExampleMapper<T> extends SelectByExampleMapper<T>, SelectCountByExampleMapper<T>,
		DeleteByExampleMapper<T>, UpdateByExampleMapper<T>, UpdateByExampleSelectiveMapper<T> {

}