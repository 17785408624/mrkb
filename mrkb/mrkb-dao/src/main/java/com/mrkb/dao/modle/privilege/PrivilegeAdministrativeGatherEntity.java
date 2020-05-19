/**
 * FileName:         PrivilegeAdministrativeGather.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-22     下午4:36:05
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
public class PrivilegeAdministrativeGatherEntity {//管理组权限集
	private Integer administrative_id;//管理组id
	private Integer prvilege_gather_id;//权限集id
	public Integer getAdministrative_id() {
		return administrative_id;
	}
	public void setAdministrative_id(Integer administrative_id) {
		this.administrative_id = administrative_id;
	}
	public Integer getPrvilege_gather_id() {
		return prvilege_gather_id;
	}
	public void setPrvilege_gather_id(Integer prvilege_gather_id) {
		this.prvilege_gather_id = prvilege_gather_id;
	}
	@Override
	public String toString() {
		return "PrivilegeAdministrativeGather [administrative_id="
				+ administrative_id + ", prvilege_gather_id="
				+ prvilege_gather_id + "]";
	}
	public PrivilegeAdministrativeGatherEntity(Integer administrative_id,
			Integer prvilege_gather_id) {
		super();
		this.administrative_id = administrative_id;
		this.prvilege_gather_id = prvilege_gather_id;
	}
	public PrivilegeAdministrativeGatherEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
