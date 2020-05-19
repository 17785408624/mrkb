package com.mrkb.dao.modle.privilege;

import java.io.Serializable;

public class UserOperationLog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3322584679786620277L;
	private Integer operation_id;//操作编号
	private Integer user_basics_id;//用户编号
	private String operation_module;//操作模块
	private String operation_mothod;//操作方法
	private String rsponse_time;//响应时间
	private String ip;//IP
	private Long operation_date;//操作时间
	private String operation_commite;//执行结果
	private Integer operation_type;//操作类型(1增加,2删除,3修改,4查询)
	public Integer getOperation_id() {
		return operation_id;
	}
	public void setOperation_id(Integer operation_id) {
		this.operation_id = operation_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getOperation_module() {
		return operation_module;
	}
	public void setOperation_module(String operation_module) {
		this.operation_module = operation_module;
	}
	public String getOperation_mothod() {
		return operation_mothod;
	}
	public void setOperation_mothod(String operation_mothod) {
		this.operation_mothod = operation_mothod;
	}
	public String getRsponse_time() {
		return rsponse_time;
	}
	public void setRsponse_time(String rsponse_time) {
		this.rsponse_time = rsponse_time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Long getOperation_date() {
		return operation_date;
	}
	public void setOperation_date(Long operation_date) {
		this.operation_date = operation_date;
	}
	public String getOperation_commite() {
		return operation_commite;
	}
	public void setOperation_commite(String operation_commite) {
		this.operation_commite = operation_commite;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getOperation_type() {
		return operation_type;
	}
	public void setOperation_type(Integer operation_type) {
		this.operation_type = operation_type;
	}
	@Override
	public String toString() {
		return "UserOperationLog [operation_id=" + operation_id
				+ ", user_basics_id=" + user_basics_id + ", operation_module="
				+ operation_module + ", operation_mothod=" + operation_mothod
				+ ", rsponse_time=" + rsponse_time + ", ip=" + ip
				+ ", operation_date=" + operation_date + ", operation_commite="
				+ operation_commite + ", operation_type=" + operation_type
				+ "]";
	}
	
	
}
