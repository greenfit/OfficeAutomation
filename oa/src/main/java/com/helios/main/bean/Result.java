package com.helios.main.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class Result implements Serializable {
	
	private static final long serialVersionUID = 4961243324946965488L;
	
	private int code;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
