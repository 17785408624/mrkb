/**
 * FileName:         PrivilegeAdministrativeAndPG.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-23     下午2:33:19
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-23     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.privilege;

import java.util.List;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class PrivilegeAdministrativeAndPg {//封装管理组与管理组权限集
	private PrivilegeAdministrativeEntity privilegeAdministrativeEntity;
	private List<PrivilegeGatherEntity>privilegeGatherEntityList;
	public PrivilegeAdministrativeEntity getPrivilegeAdministrativeEntity() {
		return privilegeAdministrativeEntity;
	}
	public void setPrivilegeAdministrativeEntity(
			PrivilegeAdministrativeEntity privilegeAdministrativeEntity) {
		this.privilegeAdministrativeEntity = privilegeAdministrativeEntity;
	}
	public List<PrivilegeGatherEntity> getPrivilegeGatherEntityList() {
		return privilegeGatherEntityList;
	}
	public void setPrivilegeGatherEntityList(
			List<PrivilegeGatherEntity> privilegeGatherEntityList) {
		this.privilegeGatherEntityList = privilegeGatherEntityList;
	}
	@Override
	public String toString() {
		return "PrivilegeAdministrativeAndPG [privilegeAdministrativeEntity="
				+ privilegeAdministrativeEntity
				+ ", privilegeGatherEntityList=" + privilegeGatherEntityList
				+ "]";
	}
	public PrivilegeAdministrativeAndPg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PrivilegeAdministrativeAndPg(
			PrivilegeAdministrativeEntity privilegeAdministrativeEntity,
			List<PrivilegeGatherEntity> privilegeGatherEntityList) {
		super();
		this.privilegeAdministrativeEntity = privilegeAdministrativeEntity;
		this.privilegeGatherEntityList = privilegeGatherEntityList;
	}
	

}
