package com.mybatis.plus.mapper.spring.mapper;

import com.mybatis.plus.mapper.mapperhelper.MapperHelper;

/**
 * 增加mapperHelper
 *
 * @param <T>
 *            Created by feng.wei on 2017/07/14.
 */
public class MapperFactoryBean<T> extends org.mybatis.spring.mapper.MapperFactoryBean<T> {

	private MapperHelper mapperHelper;

	public MapperFactoryBean() {
	}

	public MapperFactoryBean(Class<T> mapperInterface) {
		super(mapperInterface);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void checkDaoConfig() {
		super.checkDaoConfig();
		// 通用Mapper
		if (mapperHelper.isExtendCommonMapper(getObjectType())) {
			mapperHelper.processConfiguration(getSqlSession().getConfiguration(), getObjectType());
		}
	}

	public void setMapperHelper(MapperHelper mapperHelper) {
		this.mapperHelper = mapperHelper;
	}
}
