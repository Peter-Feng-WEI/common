package com.mybatis.plus.mapper.common.base.delete;

import org.apache.ibatis.annotations.DeleteProvider;
import com.mybatis.plus.mapper.provider.base.BaseDeleteProvider;

/**
 * 通用Mapper接口,删除
 *
 * @param <T> 不能为空
 * 
 * Created by feng.wei  on 2017/07/14.
 */
public interface DeleteMapper<T> {

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param record
     * @return
     */
    @DeleteProvider(type = BaseDeleteProvider.class, method = "dynamicSQL")
    int delete(T record);

}