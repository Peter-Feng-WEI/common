package com.mybatis.plus.mapper.entity;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;

/**
 * 分页查询的请求返回通用的bean
 * 
 * Created by feng.wei on 2017/07/01.
 */
public class PageBean<T> implements Serializable {
	private static final long serialVersionUID = 8656597559014685635L;
	private int pageNum; // 第几页
	private int pageSize; // 每页记录数
	private int pages; // 总页数
	private long total; // 总记录数

	private List<T> list; // 结果集
	private int size; // 当前页的数量 <= pageSize，该属性来自ArrayList的size属性

	/**
	 * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理， 而出现一些问题。
	 * 
	 * @param list
	 *            page结果
	 * @param navigatePages
	 *            页码数量
	 */
	public PageBean(List<T> list) {
		if (list instanceof Page) {
			Page<T> page = (Page<T>) list;
			this.pageNum = page.getPageNum();
			this.pageSize = page.getPageSize();
			this.total = page.getTotal();
			this.pages = page.getPages();
			this.list = page;
			this.size = page.size();
		}
	}

	public PageBean(int pageNum, int pageSize, Long total, List<T> list, int size) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;

		if (total % pageSize == 0)
			this.pages = total.intValue() / pageSize;
		else
			this.pages = total.intValue() / pageSize + 1;

		this.total = total;
		this.list = list;
		this.size = size;
	}

	public PageBean(int pageNum, int pageSize, int pages, long total, List<T> list, int size) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pages = pages;
		this.total = total;
		this.list = list;
		this.size = size;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
