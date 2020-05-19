/**
 * FileName:         Login.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-31     下午4:30:55
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-31     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.visits;
import javax.servlet.http.Cookie;
/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class VisitsLogin extends Visits{
	private Cookie Cookie;//用户登陆信息的cookie
	private boolean showVerifyPicture;//是否显示登陆验证码图片 true显示 false不显示
	private boolean loginResults=false;//登陆结果，true 成功   false 失败
	
	
	public Cookie getCookie() {
		return Cookie;
	}
	public void setCookie(Cookie cookie) {
		Cookie = cookie;
	}
	public boolean isShowVerifyPicture() {
		return showVerifyPicture;
	}
	public void setShowVerifyPicture(boolean showVerifyPicture) {
		this.showVerifyPicture = showVerifyPicture;
	}
	public boolean isLoginResults() {
		return loginResults;
	}
	public void setLoginResults(boolean loginResults) {
		this.loginResults = loginResults;
	}
	@Override
	public String toString() {
		return "VisitsLogin [showVerifyPicture=" + showVerifyPicture
				+ ", loginResults=" + loginResults + "]";
	}
	public static class loginMode{
		public static final int LOGINACCOUNT = 1;// 账号登陆
		public static final int LOGINPHONE = 2;// 手机号登陆
	}
}
