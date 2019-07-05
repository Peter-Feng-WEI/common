package com.mybatis.plus.mapper.provider.base;

import org.apache.ibatis.mapping.MappedStatement;
import com.mybatis.plus.mapper.mapperhelper.MapperHelper;
import com.mybatis.plus.mapper.mapperhelper.MapperTemplate;
import com.mybatis.plus.mapper.mapperhelper.SqlHelper;

/**
 * BaseSelectProvider实现类，基础方法实现类
 *
 * Created by feng.wei on 2017/07/14.
 */
public class BaseSelectProvider extends MapperTemplate {

	public BaseSelectProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}

	/**
	 * 查询
	 *
	 * @param ms
	 * @return
	 */
	public String selectOne(MappedStatement ms) {
		Class<?> entityClass = getEntityClass(ms);
		// 修改返回值类型为实体类型
		setResultType(ms, entityClass);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.selectAllColumns(entityClass));
		sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.whereAllIfColumns(entityClass, isNotEmpty()));
		return sql.toString();
	}

	/**
	 * 查询
	 *
	 * @param ms
	 * @return
	 */
	public String select(MappedStatement ms) {
		Class<?> entityClass = getEntityClass(ms);
		// 修改返回值类型为实体类型
		setResultType(ms, entityClass);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.selectAllColumns(entityClass));
		sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.whereAllIfColumns(entityClass, isNotEmpty()));
		sql.append(SqlHelper.orderByDefault(entityClass));
		return sql.toString();
	}

	/**
	 * 查询
	 *
	 * @param ms
	 * @return
	 */
	public String selectByRowBounds(MappedStatement ms) {
		return select(ms);
	}

	/**
	 * 根据主键进行查询
	 *
	 * @param ms
	 */
	public String selectByPrimaryKey(MappedStatement ms) {
		final Class<?> entityClass = getEntityClass(ms);
		// 将返回值修改为实体类型
		setResultType(ms, entityClass);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.selectAllColumns(entityClass));
		sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.wherePKColumns(entityClass));
		return sql.toString();
	}

	/**
	 * 查询总数
	 *
	 * @param ms
	 * @return
	 */
	public String selectCount(MappedStatement ms) {
		Class<?> entityClass = getEntityClass(ms);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.selectCount(entityClass));
		sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.whereAllIfColumns(entityClass, isNotEmpty()));
		return sql.toString();
	}

	/**
	 * 根据主键查询总数
	 *
	 * @param ms
	 * @return
	 */
	public String existsWithPrimaryKey(MappedStatement ms) {
		Class<?> entityClass = getEntityClass(ms);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.selectCountExists(entityClass));
		sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.wherePKColumns(entityClass));
		return sql.toString();
	}

	/**
	 * 查询全部结果
	 *
	 * @param ms
	 * @return
	 */
	public String selectAll(MappedStatement ms) {
		final Class<?> entityClass = getEntityClass(ms);
		// 修改返回值类型为实体类型
		setResultType(ms, entityClass);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.selectAllColumns(entityClass));
		sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
		sql.append(SqlHelper.orderByDefault(entityClass));
		return sql.toString();
	}
}
