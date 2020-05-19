/**
 * FileName:         PrivilegeAdministrativeAndPgAndPContain.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-24     下午6:15:24
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-24     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.privilege;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class PrivilegeAdministrativeAndPgAndPContain {//封装管理组数据与/管理组权限集数据
	private PrivilegeAdministrativeEntity privilegeAdministrativeEntity;
	private PrivilegeAdministrativeGatherEntity privilegeAdministrativeGatherEntity;
	public PrivilegeAdministrativeEntity getPrivilegeAdministrativeEntity() {
		return privilegeAdministrativeEntity;
	}
	public void setPrivilegeAdministrativeEntity(
			PrivilegeAdministrativeEntity privilegeAdministrativeEntity) {
		this.privilegeAdministrativeEntity = privilegeAdministrativeEntity;
	}
	public PrivilegeAdministrativeGatherEntity getPrivilegeAdministrativeGatherEntity() {
		return privilegeAdministrativeGatherEntity;
	}
	public void setPrivilegeAdministrativeGatherEntity(
			PrivilegeAdministrativeGatherEntity privilegeAdministrativeGatherEntity) {
		this.privilegeAdministrativeGatherEntity = privilegeAdministrativeGatherEntity;
	}
	

}
