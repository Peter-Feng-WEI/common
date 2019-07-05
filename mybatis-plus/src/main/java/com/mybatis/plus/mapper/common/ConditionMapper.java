package com.mybatis.plus.mapper.common;


import com.mybatis.plus.mapper.common.condition.*;

/**
 * 通用Mapper接口,Condition查询
 *
 * @param <T> 不能为空
 * Created by  feng.wei  on 2017/07/14.
 */
public interface ConditionMapper<T> extends
        SelectByConditionMapper<T>,
        SelectCountByConditionMapper<T>,
        DeleteByConditionMapper<T>,
        UpdateByConditionMapper<T>,
        UpdateByConditionSelectiveMapper<T> {

}