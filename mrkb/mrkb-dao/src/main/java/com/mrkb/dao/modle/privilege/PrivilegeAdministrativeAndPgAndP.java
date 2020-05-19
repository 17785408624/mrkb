/**
 * FileName:         PrivilegeAdministrativeAndPgAndP.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-24     下午5:58:52
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

import java.util.List;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class PrivilegeAdministrativeAndPgAndP {//封装管理组信息，及管理组包含的权限集和管理组包含的权限数据
	private PrivilegeAdministrativeEntity privilegeAdministrativeEntity;
	private List<PrivilegeGatherEntity>privilegeGatherEntityList;
	private List<PrivilegeEntity>privilegeEntityList;
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
	public List<PrivilegeEntity> getPrivilegeEntityList() {
		return privilegeEntityList;
	}
	public void setPrivilegeEntityList(List<PrivilegeEntity> privilegeEntityList) {
		this.privilegeEntityList = privilegeEntityList;
	}
	public PrivilegeAdministrativeAndPgAndP(
			PrivilegeAdministrativeEntity privilegeAdministrativeEntity,
			List<PrivilegeGatherEntity> privilegeGatherEntityList,
			List<PrivilegeEntity> privilegeEntityList) {
		super();
		this.privilegeAdministrativeEntity = privilegeAdministrativeEntity;
		this.privilegeGatherEntityList = privilegeGatherEntityList;
		this.privilegeEntityList = privilegeEntityList;
	}
	public PrivilegeAdministrativeAndPgAndP() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PrivilegeAdministrativeAndPgAndP [privilegeAdministrativeEntity="
				+ privilegeAdministrativeEntity
				+ ", privilegeGatherEntityList="
				+ privilegeGatherEntityList
				+ ", privilegeEntityList=" + privilegeEntityList + "]";
	}
	
	
}
