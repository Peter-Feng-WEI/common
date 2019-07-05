package com.mybatis.plus.mapper.provider;

import com.mybatis.plus.mapper.mapperhelper.MapperHelper;
import com.mybatis.plus.mapper.mapperhelper.MapperTemplate;

/**
 * 空方法Mapper接口默认MapperTemplate
 * <p/>
 * 如BaseSelectMapper，接口纯继承，不包含任何方法
 * 
 * Created by feng.wei on 2017/07/11.
 */
public class EmptyProvider extends MapperTemplate {

	public EmptyProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}

	@Override
	public boolean supportMethod(String msId) {
		return false;
	}
}
