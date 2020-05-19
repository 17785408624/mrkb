/**
 * FileName:         privilegeGarherOrPrivilegeEntity.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-17     下午6:34:05
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-17     crane-yuan       1.0             1.0

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
public class PrivilegeGarherOrPrivilege {//封装权限集和权限数据
	private PrivilegeGatherEntity privilegeGatherEntity;//权限集
	private List<PrivilegeEntity>privilegeEntityList;//单个权限集合
	public PrivilegeGatherEntity getPrivilegeGatherEntity() {
		return privilegeGatherEntity;
	}
	public void setPrivilegeGatherEntity(PrivilegeGatherEntity privilegeGatherEntity) {
		this.privilegeGatherEntity = privilegeGatherEntity;
	}
	public List<PrivilegeEntity> getPrivilegeEntityList() {
		return privilegeEntityList;
	}
	public void setPrivilegeEntityList(List<PrivilegeEntity> privilegeEntityList) {
		this.privilegeEntityList = privilegeEntityList;
	}
	@Override
	public String toString() {
		return "privilegeGarherOrPrivilege [privilegeGatherEntity="
				+ privilegeGatherEntity + ", privilegeEntityList="
				+ privilegeEntityList + "]";
	}
	public PrivilegeGarherOrPrivilege(
			PrivilegeGatherEntity privilegeGatherEntity,
			List<PrivilegeEntity> privilegeEntityList) {
		super();
		this.privilegeGatherEntity = privilegeGatherEntity;
		this.privilegeEntityList = privilegeEntityList;
	}
	public PrivilegeGarherOrPrivilege() {
		super();
		// TODO Auto-generated constructor stub
	}

}
