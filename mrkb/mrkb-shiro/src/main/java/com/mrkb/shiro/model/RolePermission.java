package com.mrkb.shiro.model;

import java.util.Date;

public class RolePermission {

	//主键
	public Integer id;
	//角色Id
	public Integer role_id;
	//权限ID
	public Integer permission_id;
	//创建时间
	public Date create_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public Integer getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "RolePermission [id=" + id + ", role_id=" + role_id + ", permission_id=" + permission_id
				+ ", create_time=" + create_time + ", getId()=" + getId() + ", getRole_id()=" + getRole_id()
				+ ", getPermission_id()=" + getPermission_id() + ", getCreate_time()=" + getCreate_time()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
