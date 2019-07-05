package com.mybatis.plus.mapper.provider.base;

import org.apache.ibatis.mapping.MappedStatement;
import com.mybatis.plus.mapper.mapperhelper.MapperHelper;
import com.mybatis.plus.mapper.mapperhelper.MapperTemplate;
import com.mybatis.plus.mapper.mapperhelper.SqlHelper;

/**
 * BaseDeleteMapper实现类，基础方法实现类-删除
 *
 * Created by feng.wei on 2017/07/14.
 */
public class BaseDeleteProvider extends MapperTemplate {

	public BaseDeleteProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}

	/**
	 * 通过条件删除
	 *
	 * @param ms
	 * @return
	 */
	public String delete(MappedStatement ms) {
		Class<?> entityClass = getEntityClass(ms);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.deleteFromTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.whereAllIfColumns(entityClass, isNotEmpty()));
		return sql.toString();
	}

	/**
	 * 通过主键删除
	 *
	 * @param ms
	 */
	public String deleteByPrimaryKey(MappedStatement ms) {
		final Class<?> entityClass = getEntityClass(ms);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.deleteFromTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.wherePKColumns(entityClass));
		return sql.toString();
	}
}
