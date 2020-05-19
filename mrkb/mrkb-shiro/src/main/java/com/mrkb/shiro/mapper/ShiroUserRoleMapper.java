package com.mrkb.shiro.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.common.util.BaseDao;
import com.mrkb.shiro.model.Role;

/**
 * 角色
 * @author Administrator
 *
 */
@Mapper
public interface ShiroUserRoleMapper extends BaseDao{
	
	List<Role> findByUserName(String userName);
	//根据用户编号查询用户角色
	Map<String, Object> getRoleByUserId(Integer user_id);
	//根据用户ID修改用户角色
	int updateUserRoleByUserId(Map<String, Object>param);
	//根据用户ID删除用户角色
	int delByUserId(Integer user_id);
}
