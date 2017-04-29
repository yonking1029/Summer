package com.oil.comm.dto;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.oil.comm.enums.ReturnStatusEnum;

/**
 * 
 * 控制器返回对象.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月29日 下午3:12:31<br>
 * @see 
 * @since JDK 1.7.0
 */
public class ReturnDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see com.oil.comm.enums.ReturnStatusEnum
	 */
	protected boolean status = ReturnStatusEnum.FAIL.getValue();

	/**
	 * 系统提示消息(面向用户)
	 */
	protected String msg = "操作成功";

	/**
	 * 业务编码
	 */
	private int errorCode = 0;

	/**
	 * 系统提示消息(面向系统人员)
	 */
	private String errorMsg = null;

	/**
	 * 返回的对像，正确时返回的结果.
	 */
	protected Object data = null;

	/**
	 * 构造函数.
	 */
	public ReturnDTO() {
	}

	/**
	 * 构造函数.
	 * 
	 * @param status
	 *            返回状态类型编号.
	 */
	public ReturnDTO(boolean status) {
		this.status = status;
	}

	public ReturnDTO(boolean status, String msg, int errorCode,String errorMsg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.data = data;
	}

	/**
	 * 成功返回值用简洁方式..
	 * 
	 * @return 返回值数据传输对象.
	 */
	public static ReturnDTO Success() {
		ReturnDTO dto = new ReturnDTO(ReturnStatusEnum.SUCCESS.getValue());
		return dto;
	}

	/**
	 * 成功返回值用简洁方式..
	 * 
	 * @param data
	 *            返回的数据对像.
	 * @return 返回值数据传输对象.
	 */
	public static ReturnDTO Success(Object data) {
		ReturnDTO dto = new ReturnDTO(ReturnStatusEnum.SUCCESS.getValue());
		dto.setData(data);
		return dto;
	}

	/**
	 * 成功返回值用简洁方式..
	 * 
	 * @param data
	 *            返回的数据对像.
	 * @param msg
	 *            返回的数据信息.
	 * @return 返回值数据传输对象.
	 */
	public static ReturnDTO Success(Object data, String msg) {
		ReturnDTO dto = new ReturnDTO(ReturnStatusEnum.SUCCESS.getValue());
		dto.setMsg(msg);
		dto.setData(data);
		return dto;
	}

	/**
	 * 失败返回值用简洁方式..
	 * 
	 * @param status
	 *            返回状态类型编号.
	 * @param msg
	 *            返回的数据异常信息.
	 * @return 返回值数据传输对象.
	 */
	public static ReturnDTO Error(boolean status, String msg) {
		ReturnDTO dto = new ReturnDTO(status);
		dto.setMsg(msg);
		return dto;
	}

	public void success(Object data) {
		this.status = ReturnStatusEnum.SUCCESS.getValue();
		this.data = data;
	}

	public void success(String msg, Object data) {
		this.status = ReturnStatusEnum.SUCCESS.getValue();
		this.msg = msg;
		this.data = data;
	}

	public void error(boolean status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}