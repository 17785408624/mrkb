/**
 * FileName:         Privilege.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-3-5     下午5:11:59
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-3-5     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.privilege;

/**
 * 封装控制层方法属性 
 *@param
 *@return 
 * @author moerka-1
 *
 */

public class PrivilegeEntity {
	private Integer privilege_id;//权限的id;
	private Integer privilege_code_num;//权限数字code
	private String privilege_url;//权限url
	private String privilege_describe;//权限描述
	private String privilege_operate_name;//此操作的名字
	private Integer privilege_verify;//是否加入权限验证（1为加入）
	private Integer is_page;//0不分页,1分页
	private Integer operation_type;//操作类型(1增加,2删除,3修改,4查询)
	private Integer is_operation_log;//0不记录操作,1记录操作
	public Integer getPrivilege_id() {
		return privilege_id;
	}
	public void setPrivilege_id(Integer privilege_id) {
		this.privilege_id = privilege_id;
	}
	public Integer getPrivilege_code_num() {
		return privilege_code_num;
	}
	public void setPrivilege_code_num(Integer privilege_code_num) {
		this.privilege_code_num = privilege_code_num;
	}
	
	public String getPrivilege_url() {
		return privilege_url;
	}
	public void setPrivilege_url(String privilege_url) {
		this.privilege_url = privilege_url;
	}
	public String getPrivilege_describe() {
		return privilege_describe;
	}
	public void setPrivilege_describe(String privilege_describe) {
		this.privilege_describe = privilege_describe;
	}
	public String getPrivilege_operate_name() {
		return privilege_operate_name;
	}
	public void setPrivilege_operate_name(String privilege_operate_name) {
		this.privilege_operate_name = privilege_operate_name;
	}
	public Integer getPrivilege_verify() {
		return privilege_verify;
	}
	public void setPrivilege_verify(Integer privilege_verify) {
		this.privilege_verify = privilege_verify;
	}
	public Integer getIs_page() {
		return is_page;
	}
	public void setIs_page(Integer is_page) {
		this.is_page = is_page;
	}
	public Integer getIs_operation_log() {
		return is_operation_log;
	}
	public void setIs_operation_log(Integer is_operation_log) {
		this.is_operation_log = is_operation_log;
	}
	public Integer getOperation_type() {
		return operation_type;
	}
	public void setOperation_type(Integer operation_type) {
		this.operation_type = operation_type;
	}
	@Override
	public String toString() {
		return "PrivilegeEntity [privilege_id=" + privilege_id
				+ ", privilege_code_num=" + privilege_code_num
				+ ", privilege_url=" + privilege_url + ", privilege_describe="
				+ privilege_describe + ", privilege_operate_name="
				+ privilege_operate_name + ", privilege_verify="
				+ privilege_verify + ", is_page=" + is_page
				+ ", operation_type=" + operation_type + ", is_operation_log="
				+ is_operation_log + "]";
	}
	

}
