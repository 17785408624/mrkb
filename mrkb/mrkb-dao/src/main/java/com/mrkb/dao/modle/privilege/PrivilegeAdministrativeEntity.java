/**
 * FileName:         PrivilegeAdministrativeEntity.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-22     下午4:31:45
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-22     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.privilege;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class PrivilegeAdministrativeEntity {
	private Integer administrative_id;//主键
	private Integer administrative_priority;//管理组优先级（从小到大）
	private String administrative_name;//管理组名称
	private String administrative_describe;//管理组描述
	public Integer getAdministrative_id() {
		return administrative_id;
	}
	public void setAdministrative_id(Integer administrative_id) {
		this.administrative_id = administrative_id;
	}
	public Integer getAdministrative_priority() {
		return administrative_priority;
	}
	public void setAdministrative_priority(Integer administrative_priority) {
		this.administrative_priority = administrative_priority;
	}
	public String getAdministrative_name() {
		return administrative_name;
	}
	public void setAdministrative_name(String administrative_name) {
		this.administrative_name = administrative_name;
	}
	public String getAdministrative_describe() {
		return administrative_describe;
	}
	public void setAdministrative_describe(String administrative_describe) {
		this.administrative_describe = administrative_describe;
	}
	@Override
	public String toString() {
		return "PrivilegeAdministrativeEntity [administrative_id="
				+ administrative_id + ", administrative_priority="
				+ administrative_priority + ", administrative_name="
				+ administrative_name + ", administrative_describe="
				+ administrative_describe + "]";
	}

}
