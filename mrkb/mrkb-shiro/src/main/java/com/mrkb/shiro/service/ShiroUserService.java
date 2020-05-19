package com.mrkb.shiro.service;


import java.util.List;

import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.shiro.model.SysUser;
import com.mrkb.shiro.model.User;

/**
 *
 * @author Administrator
 * @create 2017/12/2
 * @since 1.0.0
 */
public interface ShiroUserService {
	SysUser findBySysUsername(String username);
	//根据用户名查询用户信息
    User findByUsername(String username);

    //分页查询用户信息
	List<User> getUserPageList(User user);
	
	//新增系统用户
	Integer addNewUser(User user,String role_id);
	//删除用户		
	Integer removeUser(Integer user_id);
	//用户信息编辑
	Integer editUser(User user);
	//根据用户ID查询用户信息
	User findUserByUserId(Integer user_id);
	// 更改用户等级id,密码
	int updateUserBasics(BasicsUser basicsUser);
}