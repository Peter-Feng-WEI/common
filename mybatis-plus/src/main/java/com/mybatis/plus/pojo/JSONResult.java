package com.mybatis.plus.pojo;

import java.io.Serializable;

/**
 * 接口API统一返回的格式；
 * 
 * Created by feng.wei on 2017/08/11.
 *
 */
public class JSONResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer errcode;

	private String errmsg;

	private Object data;

	public JSONResult() {
	}

	public JSONResult(Integer errcode, String errmsg) {
		super();
		this.errcode = errcode;
		this.errmsg = errmsg;
	}

	public JSONResult(Integer errcode, String errmsg, Object data) {
		super();
		this.errcode = errcode;
		this.errmsg = errmsg;
		this.data = data;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
