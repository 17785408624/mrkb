package com.mrkb.shiro.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.common.util.BaseDao;
import com.mrkb.shiro.model.Permission;

@Mapper
public interface ShiroUserPermissionMapper extends BaseDao{
	//查询用户角色权限
	List<Permission> findByUserName(String userName);
	
	//删除用户角色权限
	int removeUserPermisson(Integer role_id);
	
	//新增角色菜单权限
	int insertRolePermission(Map<String, Object>param);
	
	//根据菜单ID查询菜单权限
	public List<Map<String, Object>> findRolePermissionByMenuid(Integer menu_id);
	
	//删除角色菜单权限
	public int removePermission(Integer id);
	
	//检查菜单是否在权限表
	public int checkIsPermission(Integer menu_id);
	
	//检查是否存在角色权限表 
	public int checkIsRolePermmission(Map<String, Object>param);
}
