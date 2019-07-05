package com.mybatis.plus.mapper.provider.base;

import org.apache.ibatis.mapping.MappedStatement;
import com.mybatis.plus.mapper.mapperhelper.MapperHelper;
import com.mybatis.plus.mapper.mapperhelper.MapperTemplate;
import com.mybatis.plus.mapper.mapperhelper.SqlHelper;

/**
 * BaseUpdateProvider实现类，基础方法实现类
 *
 * Created by feng.wei on 2017/07/14.
 */
public class BaseUpdateProvider extends MapperTemplate {

	public BaseUpdateProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}

	/**
	 * 通过主键更新全部字段
	 *
	 * @param ms
	 */
	public String updateByPrimaryKey(MappedStatement ms) {
		Class<?> entityClass = getEntityClass(ms);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.updateSetColumns(entityClass, null, false, false));
		sql.append(SqlHelper.wherePKColumns(entityClass));
		return sql.toString();
	}

	/**
	 * 通过主键更新不为null的字段
	 *
	 * @param ms
	 * @return
	 */
	public String updateByPrimaryKeySelective(MappedStatement ms) {
		Class<?> entityClass = getEntityClass(ms);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.updateSetColumns(entityClass, null, true, isNotEmpty()));
		sql.append(SqlHelper.wherePKColumns(entityClass));
		return sql.toString();
	}
}
