package com.mybatis.plus.mapper.spring.mapper;

import java.util.Properties;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import com.mybatis.plus.mapper.common.Marker;
import com.mybatis.plus.mapper.mapperhelper.MapperHelper;
import com.mybatis.plus.mapper.util.StringUtil;

/**
 * 通用mapper的配置的注入
 * 
 * Created by feng.wei on 2017/07/11.
 *
 */
public class MapperScannerConfigurer extends org.mybatis.spring.mapper.MapperScannerConfigurer {
	private MapperHelper mapperHelper = new MapperHelper();

	public void setMarkerInterface(Class<?> superClass) {
		super.setMarkerInterface(superClass);
		if (Marker.class.isAssignableFrom(superClass)) {
			mapperHelper.registerMapper(superClass);
		}
	}

	public MapperHelper getMapperHelper() {
		return mapperHelper;
	}

	public void setMapperHelper(MapperHelper mapperHelper) {
		this.mapperHelper = mapperHelper;
	}

	/**
	 * 属性注入
	 *
	 * @param properties
	 */
	public void setProperties(Properties properties) {
		mapperHelper.setProperties(properties);
	}

	/**
	 * 注册完成后，对MapperFactoryBean的类进行特殊处理
	 *
	 * @param registry
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
		super.postProcessBeanDefinitionRegistry(registry);
		// 如果没有注册过接口，就注册默认的Mapper接口
		this.mapperHelper.ifEmptyRegisterDefaultInterface();
		String[] names = registry.getBeanDefinitionNames();
		GenericBeanDefinition definition;
		for (String name : names) {
			BeanDefinition beanDefinition = registry.getBeanDefinition(name);
			if (beanDefinition instanceof GenericBeanDefinition) {
				definition = (GenericBeanDefinition) beanDefinition;
				if (StringUtil.isNotEmpty(definition.getBeanClassName())
						&& definition.getBeanClassName().equals("org.mybatis.spring.mapper.MapperFactoryBean")) {
					definition.setBeanClass(MapperFactoryBean.class);
					definition.getPropertyValues().add("mapperHelper", this.mapperHelper);
				}
			}
		}
	}
}