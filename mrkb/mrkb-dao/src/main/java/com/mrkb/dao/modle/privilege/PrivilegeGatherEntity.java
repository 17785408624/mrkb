/**
 * FileName:         PrivilegeGatherEntity
 * @Description:     TODO 权限组
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-16     下午1:54:29
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-16     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.privilege;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */

public class PrivilegeGatherEntity {//权限集
	private Integer privilege_gather_id;//数据主键
	private String privilege_gather_name;//权限集名称
	private String privilege_gather_describe;//权限集描述
	private Integer privilege_gather_type;//权限类型 1后台管理权限 2pc权限 3微信端权限 4app端权限
	public Integer getPrivilege_gather_id() {
		return privilege_gather_id;
	}
	public void setPrivilege_gather_id(Integer privilege_gather_id) {
		this.privilege_gather_id = privilege_gather_id;
	}
	public String getPrivilege_gather_name() {
		return privilege_gather_name;
	}
	public void setPrivilege_gather_name(String privilege_gather_name) {
		this.privilege_gather_name = privilege_gather_name;
	}
	public String getPrivilege_gather_describe() {
		return privilege_gather_describe;
	}
	public void setPrivilege_gather_describe(String privilege_gather_describe) {
		this.privilege_gather_describe = privilege_gather_describe;
	}
	public Integer getPrivilege_gather_type() {
		return privilege_gather_type;
	}
	public void setPrivilege_gather_type(Integer privilege_gather_type) {
		this.privilege_gather_type = privilege_gather_type;
	}
	@Override
	public String toString() {
		return "PrivilegeGatherEntity [privilege_gather_id="
				+ privilege_gather_id + ", privilege_gather_name="
				+ privilege_gather_name + ", privilege_gather_describe="
				+ privilege_gather_describe + ", privilege_gather_type="
				+ privilege_gather_type + "]";
	}
	
    
}
