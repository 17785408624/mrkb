package com.mrkb.shiro.mapper;


import com.mrkb.shiro.model.SysUser;
import com.mrkb.shiro.model.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author Administrator
 * @create 2017/12/2
 * @since 1.0.0
 */
@Mapper
public interface ShiroUserMapper {

//	@Select(" select * from sys_user")根据用户名查询用户信息
    List<User> findByUsername(String username);
    //分页查询用户信息
	List<User> getUserPageList(User user);
	//新增系统用户
	Integer insert(User user);
	//根据用户ID查询用户信息
	User findUserByUserId(Integer user_id);
	//编辑用户信息
	Integer editUser(User user);
	//删除用户信息
	Integer removeUser(Integer user_id);

	SysUser findBySysUsername(String username);
}