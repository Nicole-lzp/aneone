package com.cn.one.entity;

public class Status {

	// 通用模块
	public static final String SUCCESS = "0000";
	public static final String SUCCMSG = "执行成功";
	// 该用户不存在
	public static final String USERNOTERR = "1000";
	public static final String USERNOTERRMSG = "该用户不存在";
	// 用户错误模块
	public static final String USERERR = "1001";
	public static final String USERERRMSG = "用户名重名";
	// 密码错误
	public static final String PWDERR = "1002";
	public static final String PWDERRMSG = "密码错误";
	// 验证码错误
	public static final String CODEERR = "2000";
	public static final String CODEERRMSG = "验证码错误";
	
	
	private String code;
	private String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
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
		return "Status [code=" + code + ", message=" + message + "]";
	}
	
}
