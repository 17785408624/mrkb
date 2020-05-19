/**
 * FileName:         UserSession.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-30     下午4:18:43
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-30     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.shiro.cookieutil;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.session.SessionException;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class SessionEntity {
    
	
	
	
	public SessionEntity(Object object) throws SessionException {
		super();
		int createType=0;//创建方式
		HttpServletRequest request = null;
		if(object instanceof HttpServletRequest){
			request=(HttpServletRequest) object;
			createType=SessionServiceUtil.REQUESTCREATE;//request创建方式
		}
		switch (createType) {
		case SessionServiceUtil.REQUESTCREATE://request创建方式
			Object objectSession= SessionServiceUtil.getSessionToRequest(request);//通过请求的request获取用户信息
			if(objectSession instanceof HashMap){
				HashMap WeixinLogin=(HashMap) objectSession;
				setUser_basics_id(Integer.valueOf((String) WeixinLogin.get("user_basics_id")));
				setWeixin_id(WeixinLogin.get("weixin_id").toString());
				setUser_grade_id(Integer.valueOf(WeixinLogin.get("user_grade_id").toString()));
			}else if(objectSession instanceof SessionEntity){
				SessionEntity WeixinLogin=(SessionEntity) objectSession;
				setUser_basics_id( WeixinLogin.getUser_basics_id());
				setWeixin_id(WeixinLogin.getWeixin_id());
				setUser_grade_id(WeixinLogin.getUser_grade_id());
			}
			break;
		case SessionServiceUtil.COOKIENAMECREATE:
			break;
        default:
			break;
		}
	}
	
	public SessionEntity(String sessionKey,HttpSession httpSession) {
		super();
		HashMap WeixinLogin=(HashMap) SessionServiceUtil.getSessionToSessionKey(sessionKey, httpSession);//通过seesionkey
    }
	
	
	public SessionEntity() {
		super();
	}
	
	public SessionEntity(Integer user_basics_id, String weixin_id,
			Integer user_grade_id, String user_account_num,
			String information_compellation, String information_phone,
			String information_card, Integer recommend_superior,
			String[] privilegeUrls) {
		super();
		this.user_basics_id = user_basics_id;
		this.weixin_id = weixin_id;
		this.user_grade_id = user_grade_id;
		this.user_account_num = user_account_num;
		this.information_compellation = information_compellation;
		this.information_phone = information_phone;
		this.information_card = information_card;
		this.recommend_superior = recommend_superior;
		this.privilegeUrls = privilegeUrls;
	}




	private Integer user_basics_id;//用户id
	private String weixin_id;//微信id
	private Integer user_grade_id;//等级id
	private String user_account_num;//用户账号
	private String information_compellation;//用户姓名
	private String information_phone;//用户手机号
	private String information_card;//用户身份证号
	private Integer recommend_superior;//推荐人id
	private String[] privilegeUrls;//用户拥有的权限路径
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getWeixin_id() {
		return weixin_id;
	}
	public void setWeixin_id(String weixin_id) {
		this.weixin_id = weixin_id;
	}
	public Integer getUser_grade_id() {
		return user_grade_id;
	}
	public void setUser_grade_id(Integer user_grade_id) {
		this.user_grade_id = user_grade_id;
	}
	public String getUser_account_num() {
		return user_account_num;
	}
	public void setUser_account_num(String user_account_num) {
		this.user_account_num = user_account_num;
	}
	public String getInformation_compellation() {
		return information_compellation;
	}
	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}
	public String getInformation_phone() {
		return information_phone;
	}
	public void setInformation_phone(String information_phone) {
		this.information_phone = information_phone;
	}
	public String getInformation_card() {
		return information_card;
	}
	public void setInformation_card(String information_card) {
		this.information_card = information_card;
	}
	public Integer getRecommend_superior() {
		return recommend_superior;
	}
	public void setRecommend_superior(Integer recommend_superior) {
		this.recommend_superior = recommend_superior;
	}
	public String[] getPrivilegeUrls() {
		return privilegeUrls;
	}
	public void setPrivilegeUrls(String[] privilegeUrls) {
		this.privilegeUrls = privilegeUrls;
	}
	@Override
	public String toString() {
		return "SessionEntity [user_basics_id=" + user_basics_id
				+ ", weixin_id=" + weixin_id + ", user_grade_id="
				+ user_grade_id + ", user_account_num=" + user_account_num
				+ ", information_compellation=" + information_compellation
				+ ", information_phone=" + information_phone
				+ ", information_card=" + information_card
				+ ", recommend_superior=" + recommend_superior
				+ ", privilegeUrls=" + Arrays.toString(privilegeUrls) + "]";
	}
	

	
}
