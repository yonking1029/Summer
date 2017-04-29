package com.oil.comm.enums;

import java.io.Serializable;

/**
 * 
 * 返回DTO状态枚举.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月29日 下午3:15:37<br>
 * @see 
 * @since JDK 1.7.0
 */
public enum ReturnStatusEnum implements Serializable{
	/**
	 * 成功
	 */
	SUCCESS(true, "操作成功"),
	/**
	 * 异常
	 */
	FAIL(false, "操作失败");
	
	ReturnStatusEnum(boolean status, String info) {
		this.setValue(status);
		this.setInfo(info);
	}

	private boolean status;

	private String info;

	public boolean getValue() {
		return status;
	}

	public void setValue(boolean status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
