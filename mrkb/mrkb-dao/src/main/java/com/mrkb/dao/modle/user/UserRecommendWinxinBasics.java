/**
 * FileName:         UserMyteam.java
 * @Description:     TODO 用户实体类 包含实体类
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-18     上午11:44:01
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-18     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.user;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class UserRecommendWinxinBasics {//用户信息。包含推荐关系，微信信息，用户基本信息
	private Integer user_basics_id;//用户id
	private Integer recommend_superior;//推荐人用户id
	private String user_nickname;//用户昵称
	private String superior_user_nickname;//推荐人用户昵称
	private String weixin_nickname;//用户微信昵称
	private String superior_weixin_nickname;//推荐人微信昵称
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getRecommend_superior() {
		return recommend_superior;
	}
	public void setRecommend_superior(Integer recommend_superior) {
		this.recommend_superior = recommend_superior;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getSuperior_user_nickname() {
		return superior_user_nickname;
	}
	public void setSuperior_user_nickname(String superior_user_nickname) {
		this.superior_user_nickname = superior_user_nickname;
	}
	public String getWeixin_nickname() {
		return weixin_nickname;
	}
	public void setWeixin_nickname(String weixin_nickname) {
		this.weixin_nickname = weixin_nickname;
	}
	public String getSuperior_weixin_nickname() {
		return superior_weixin_nickname;
	}
	public void setSuperior_weixin_nickname(String superior_weixin_nickname) {
		this.superior_weixin_nickname = superior_weixin_nickname;
	}
	@Override
	public String toString() {
		return "UserRecommendWinxinBasics [user_basics_id=" + user_basics_id
				+ ", recommend_superior=" + recommend_superior
				+ ", user_nickname=" + user_nickname
				+ ", superior_user_nickname=" + superior_user_nickname
				+ ", weixin_nickname=" + weixin_nickname
				+ ", superior_weixin_nickname=" + superior_weixin_nickname
				+ "]";
	}
	
	
}
