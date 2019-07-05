package com.mybatis.plus.mapper.common.base.select;

import org.apache.ibatis.annotations.SelectProvider;
import com.mybatis.plus.mapper.provider.base.BaseSelectProvider;

import java.util.List;

/**
 * Created  feng.wei  on 2017/07/14
 */
public interface SelectAllMapper<T> {

    /**
     * 查询全部结果
     *
     * @return
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    List<T> selectAll();
}
