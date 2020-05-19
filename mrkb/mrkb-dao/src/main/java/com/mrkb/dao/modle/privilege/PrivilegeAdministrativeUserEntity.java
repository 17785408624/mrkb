/**
 * FileName:         privilegeAdministrativeUser.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-22     下午4:37:43
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
public class PrivilegeAdministrativeUserEntity {//管理组用户
	private Integer administrative_id;//管理组id
	private Integer user_basics_id;//用户id
	public Integer getAdministrative_id() {
		return administrative_id;
	}
	public void setAdministrative_id(Integer administrative_id) {
		this.administrative_id = administrative_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	@Override
	public String toString() {
		return "PrivilegeAdministrativeUser [administrative_id="
				+ administrative_id + ", user_basics_id=" + user_basics_id
				+ "]";
	}
	public PrivilegeAdministrativeUserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PrivilegeAdministrativeUserEntity(Integer administrative_id,
			Integer user_basics_id) {
		super();
		this.administrative_id = administrative_id;
		this.user_basics_id = user_basics_id;
	}
	

}
