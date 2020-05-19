package com.mrkb.shiro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrkb.shiro.mapper.ShiroUserPermissionMapper;
import com.mrkb.shiro.model.Permission;
import com.mrkb.shiro.service.ShiroUserPermissionService;
@Service
public class ShiroUserPermissionServiceImpl implements ShiroUserPermissionService {
	
	@Autowired
	private ShiroUserPermissionMapper permissionMapper;

	
	//log对象 操作日志
    private static final transient Logger log = LoggerFactory.getLogger(ShiroUserPermissionServiceImpl.class);
    
	
	/**
	 * 根据用户名查询用户权限
	 */
	public List<Permission> findByUserName(String userName) {
		List<Permission> list_permission = new ArrayList<Permission>();
		list_permission = permissionMapper.findByUserName(userName);
		return list_permission;
	}

	
	
	
	/**
	 * 权限分页查询
	 * @param permission
	 * @return
	 */
	public List<Permission> list(Permission permission) {
		List<Permission> list = new ArrayList<Permission>();
		try {
			list = permissionMapper.pageList(permission);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("查询权限分页数据异常");
			return null;
		}
		return list;
	}


	


	/**
	 * 根据菜单ID查询菜单权限
	 * @return
	 */
	public Permission getPemissionByMenuId(Integer menu_id) {
		Permission permission = new Permission();
		try {
			permission = (Permission) permissionMapper.get(menu_id);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("根据菜单ID查询菜单权限异常");
		}
		return permission;
	}




	/**
	 * 新增菜单权限
	 */
	public Integer savePermission(Permission permission) {
		Integer num = 0;
		permission.setCreate_time(new Date());
		try {
			num = permissionMapper.insert(permission);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("新增菜单权限异常");
			return 0;
		}
		return num;
	}




	/**
	 * 修改菜单权限
	 */
	public Integer updatePermission(Permission permission) {
		Integer num = 0;
		try {
			num = permissionMapper.update(permission);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("新增菜单权限异常");
			return 0;
		}
		return num;
	}




	/**
	 * 删除权限
	 * @param id
	 * @return
	 */
	public Integer removePermission(Integer id) {
		Integer num = 0;
		try {
			num = permissionMapper.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("删除权限异常");
			return 0;
		}
		return num;
	}
	

}
