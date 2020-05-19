package com.mrkb.shiro.service;

import java.util.List;
import java.util.Map;

import com.mrkb.shiro.model.Role;

public interface ShiroUserRoleService {
	
	/**
	 * 根据用户名查询用户角色
	 * @param userName
	 * @return
	 */
	List<Role> findByUserName(String userName);
	
	//新增菜单
	public int addRole(Role role);
	
	//删除菜单
	int removeRole(Integer roleid);
	
	//修改菜单
	int updateRole(Role role);
	
	//根据主键查询菜单
	Role getRoleByid(Integer roleid);
	
	//菜单列表分页查询
	List<Role> list(Role role);

	//根据用户编号查询用户角色
	Map<String, Object> getRoleByUserId(Integer user_id);

}
