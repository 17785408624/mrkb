package com.mrkb.shiro.service;

import java.util.List;

import com.mrkb.shiro.model.Permission;

public interface ShiroUserPermissionService {

	/**
	 * 根据用户名查询用户权限
	 * @param userName
	 * @return
	 */
	List<Permission> findByUserName(String userName);
	
	
	
	/**
	 * 权限分页查询
	 * @param permission
	 * @return
	 */
	List<Permission> list(Permission permission);


	/**
	 * 根据菜单ID查询菜单权限
	 * @return
	 */
	Permission getPemissionByMenuId(Integer menu_id);


	
	/**
	 * 新增菜单权限
	 * @param permission
	 * @return
	 */
	Integer savePermission(Permission permission);

	

	/**
	 * 修改菜单权限
	 * @param permission
	 * @return
	 */
	Integer updatePermission(Permission permission);

	

	/**
	 * 删除权限
	 * @param id
	 * @return
	 */
	Integer removePermission(Integer id);
	
}
