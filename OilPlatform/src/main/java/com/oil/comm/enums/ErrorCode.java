package com.oil.comm.enums;

public enum ErrorCode {
	/**
	 * 200：成功; 服务器已成功处理了请求.
	 */
	OK(200, "成功"),
	/**
	 * 500：异常; 服务器请求异常.
	 */
	Error(500, "服务请求异常"),
	/**
	 * 400：错误请求; 服务器不理解请求的语法.
	 */
	BadRequest(400, "错误请求"),
	/**
	 * 401：未授权; 请求要求身份验证.
	 */
	Unauthorized(401, "未授权的请求"),
	/**
	 * 403：禁止; 服务器拒绝请求.
	 */
	Forbidden(403, "服务器拒绝请求"),
	/**
	 * 404：未找到; 服务器找不到请求的网页.
	 */
	FileNotFound(404, "未找到"),
	/**
	 * 405：禁用的方法; 禁用请求中指定的方法.
	 */
	MethodNotAllowed(405, "禁用的方法");
	
	ErrorCode(int code, String info) {
		this.setCode(code);
		this.setInfo(info);
	}
	/**
	 * 返回状态编号...
	 */
	private int code;
	/**
	 * 返回状态描述信息...
	 */
	private String info;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}

