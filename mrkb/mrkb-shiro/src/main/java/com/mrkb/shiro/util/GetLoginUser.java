package com.mrkb.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.mrkb.shiro.model.User;

public class GetLoginUser {
	
	/**
	 * 获取登陆用户信息
	 * @return
	 */
	public static User getUserInfo() {
		Subject currentUser = SecurityUtils.getSubject();
		return (User) currentUser.getSession().getAttribute("LOGINUSER");
	}

}
