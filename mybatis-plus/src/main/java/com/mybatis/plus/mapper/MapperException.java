package com.mybatis.plus.mapper;

/**
 * 通用mapper的运行异常处理。
 * 
 * Created by feng.wei on 2017/07/14.
 */
public class MapperException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MapperException() {
		super();
	}

	public MapperException(String message) {
		super(message);
	}

	public MapperException(String message, Throwable cause) {
		super(message, cause);
	}

	public MapperException(Throwable cause) {
		super(cause);
	}

}
