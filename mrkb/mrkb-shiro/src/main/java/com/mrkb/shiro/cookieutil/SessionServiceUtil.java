package com.mrkb.shiro.cookieutil;
/**
 * FileName:         SessionServiceUtil.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-6-14     下午5:26:33
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-6-14     crane-yuan       1.0             1.0

 * Why & What is modified:

 */

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.session.SessionException;

import com.mrkb.common.utils.encryption.NameReach;

/**
 * @param
 * @return
 * @author moerka-1
 * 
 */
public class SessionServiceUtil {
	public static final int REQUESTCREATE = 1;// 通过request 获取用户登陆的session信息
	public static final int COOKIENAMECREATE = 2;// 通过sessionName
	public static final String COOKIENAME = "sessionKey";// 值为session键的cookie键名
	
	
	public static String getSessionKey(Cookie[] cookies)
			throws SessionException {// 得到session对象的键
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(COOKIENAME)
					&& !cookie.getName().equals("") && cookie.getName() != null) {
				return cookie.getValue();
			}
		}
		throw new SessionException("保存session键的cookie为空");
	}

	/**
	 * @throws SessionException 
	 * 
	 * @Title: getSessionToRequest
	 * @Description: TODO request获取用户信息session
	 * @param: @param request
	 * @param: @return
	 * @return: SessionEntity 封装用户登陆后保存的session信息
	 * @throws
	 */
	public static Object getSessionToRequest(HttpServletRequest request) throws SessionException {// 通过请求的request获取用户信息
		Cookie[] cookie = request.getCookies();
		String sessionKey = null;
		for (Cookie cookies : cookie) {
			if (cookies.getName().equals("cookieName")||cookies.getName().equals(COOKIENAME)) {
				sessionKey = NameReach.unbind(cookies.getValue());
				break;
			}
		}
		if(request.getSession().getAttribute(sessionKey) instanceof HashMap){
			return (HashMap) request.getSession().getAttribute(sessionKey);
		}else if(request.getSession().getAttribute(sessionKey) instanceof SessionEntity){
			return (SessionEntity) request.getSession().getAttribute(sessionKey);
		}
		throw new SessionException("获取用户信息session失败");
	}

	public static Map getSessionToSessionKey(String sessionKey,
			HttpSession httpSession) {// 通过sessionkey获取当前访问设备的session信息
		HashMap WeixinLogin = (HashMap) httpSession.getAttribute(NameReach
				.unbind(sessionKey));
		return WeixinLogin;
	}

}
