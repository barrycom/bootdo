package com.bootdo.zallhy.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 汉艺user表
 * 
 * @author barry
 * @email 1992lcg@163.com
 * @date 2017-12-26 14:41:55
 */
public class HyUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String userId;
	//
	private String userName;
	//
	private String status;

	/**
	 * 设置：
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public String getStatus() {
		return status;
	}
}
