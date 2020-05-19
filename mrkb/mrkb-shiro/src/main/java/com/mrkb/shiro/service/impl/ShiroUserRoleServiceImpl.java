package com.mrkb.shiro.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrkb.shiro.mapper.ShiroUserPermissionMapper;
import com.mrkb.shiro.mapper.ShiroUserRoleMapper;
import com.mrkb.shiro.model.Role;
import com.mrkb.shiro.service.ShiroUserRoleService;

@Service
public class ShiroUserRoleServiceImpl implements ShiroUserRoleService {

	//角色
	@Autowired
	private ShiroUserRoleMapper roleMapper;
	
	//权限
	@Autowired
	private ShiroUserPermissionMapper permissionMapper;
	
	//log对象 操作日志
    private static final transient Logger log = LoggerFactory.getLogger(ShiroUserRoleServiceImpl.class);
	
	/**
	 * 根据用户名查询用户角色
	 * @param userName
	 * @return
	 */
	public List<Role> findByUserName(String userName) {
		List<Role> list_role = new ArrayList<Role>();
		list_role = roleMapper.findByUserName(userName);
		return list_role;
	}


	/**
	 * 新增角色
	 */
	public int addRole(Role role) {
		Integer num = 0;
		try {
			num = roleMapper.insert(role);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("新增角色异常");
			return 0;
		}
		return num;
	}


	/**
	 * 删除角色
	 */
	public int removeRole(Integer roleid) {
		Integer num = 0;
		try {
			num = roleMapper.delete(roleid);
			if(num>0){
				permissionMapper.removeUserPermisson(roleid);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("删除角色异常");
			return 0;
		}
		return num;
	}


	/**
	 * 修改角色
	 */
	public int updateRole(Role role) {
		Integer num = 0;
		try {
			num = roleMapper.update(role);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("修改角色异常");
			return 0;
		}
		return num;
	}


	/**
	 * 根据ID查询角色
	 */
	public Role getRoleByid(Integer roleid) {
		Role role = new Role();
		try {
			role = (Role) roleMapper.get(roleid);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("查询角色异常");
			return null;
		}
		return role;
	}

	

	/**
	 * 分页查询角色列表
	 */
	public List<Role> list(Role role) {
		List<Role> list = new ArrayList<Role>();
		try {
			list = roleMapper.pageList(role);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("查询角色分页异常");
		}
		return list;
	}


	/**
	 * 根据用户编号查询用户角色
	 */
	public Map<String, Object> getRoleByUserId(Integer user_id) {
		Map<String, Object>role = new HashMap<String, Object>();
		try {
			role = roleMapper.getRoleByUserId(user_id);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("系统后台根据用户编号查询用户角色异常");
			log.error("系统后台根据用户编号查询用户角色异常");
			return null;
		}
		return role;
	}

}
