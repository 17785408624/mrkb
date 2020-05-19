/**
 * FileName:         privilegeGatherPrivilegeEntity.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-16     下午2:42:10
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
public class PrivilegeGatherPrivilegeEntity {//权限集权限
	private Integer privilege_gather_id;//权限集id
	private Integer privilege_id;//单个权限id
	public Integer getPrivilege_gather_id() {
		return privilege_gather_id;
	}
	public void setPrivilege_gather_id(Integer privilege_gather_id) {
		this.privilege_gather_id = privilege_gather_id;
	}
	public Integer getPrivilege_id() {
		return privilege_id;
	}
	public void setPrivilege_id(Integer privilege_id) {
		this.privilege_id = privilege_id;
	}
	@Override
	public String toString() {
		return "privilegeGatherPrivilegeEntity [privilege_gather_id="
				+ privilege_gather_id + ", privilege_id=" + privilege_id + "]";
	}
	public PrivilegeGatherPrivilegeEntity(Integer privilege_gather_id,
			Integer privilege_id) {
		super();
		this.privilege_gather_id = privilege_gather_id;
		this.privilege_id = privilege_id;
	}
	public PrivilegeGatherPrivilegeEntity() {
		super();
	}
	

}
