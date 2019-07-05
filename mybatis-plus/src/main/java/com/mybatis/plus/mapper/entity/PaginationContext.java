package com.mybatis.plus.mapper.entity;

import javax.annotation.Resource;

/**
 * 分页查询，请求的分页相关信息，存储在本地缓存，注意：使用该ccontext，需要应用添加分页过滤器；清除各种的本地缓存；
 * 
 * Created by feng.wei on 2017/07/11.
 *
 */
@Resource
public class PaginationContext {
	// 定义两个threadLocal变量：pageNum和pageSize
	private static ThreadLocal<Integer> pageNum = new ThreadLocal<Integer>(); // 保存第几页
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>(); // 保存每页记录条数

	/*
	 * pageNum ：get、set、remove
	 */
	public static int getPageNum() {
		Integer pn = pageNum.get();
		if (pn == null) {
			return 1;
		}
		return pn;
	}

	public static void setPageNum(int pageNumValue) {
		pageNum.set(pageNumValue);
	}

	public static void removePageNum() {
		pageNum.remove();
	}

	/*
	 * pageSize ：get、set、remove
	 */
	public static int getPageSize() {
		Integer ps = pageSize.get();
		if (ps == null) {
			return 10;
		}
		return ps;
	}

	public static void setPageSize(int pageSizeValue) {
		pageSize.set(pageSizeValue);
	}

	public static void removePageSize() {
		pageSize.remove();
	}

}
