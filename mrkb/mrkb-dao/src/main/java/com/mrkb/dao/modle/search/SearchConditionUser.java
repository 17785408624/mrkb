/**
 * FileName:         SearchConditionUser.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-29     下午5:00:33
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-29     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.search;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class SearchConditionUser {//封装用户信息 搜索/查询条件
	private Integer user_basics_id;//用户自增ID
	private String user_account_num;//用户账号
	private Integer user_grade_id;//用户等级id
	private Long user_register_data;//用户注册时间
	private String weixin_id;//微信id
	private String weixin_nickname;//微信昵称
	private String nick_name;//用户昵称
	private String information_phone;//用户手机号
	private String information_qq;//用户qq账号
	private String information_Email;//用户电子邮箱
	private String information_compellation;//用户真实姓名
	private String information_card;//用户身份证号
	private String information_weixin;//用户微信号
	private Integer recommend_superior;//推荐人id
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getUser_account_num() {
		return user_account_num;
	}
	public void setUser_account_num(String user_account_num) {
		this.user_account_num = user_account_num;
	}
	public Integer getUser_grade_id() {
		return user_grade_id;
	}
	public void setUser_grade_id(Integer user_grade_id) {
		this.user_grade_id = user_grade_id;
	}
	public Long getUser_register_data() {
		return user_register_data;
	}
	public void setUser_register_data(Long user_register_data) {
		this.user_register_data = user_register_data;
	}
	public String getWeixin_id() {
		return weixin_id;
	}
	public void setWeixin_id(String weixin_id) {
		this.weixin_id = weixin_id;
	}
	public String getWeixin_nickname() {
		return weixin_nickname;
	}
	public void setWeixin_nickname(String weixin_nickname) {
		this.weixin_nickname = weixin_nickname;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getInformation_phone() {
		return information_phone;
	}
	public void setInformation_phone(String information_phone) {
		this.information_phone = information_phone;
	}
	public String getInformation_qq() {
		return information_qq;
	}
	public void setInformation_qq(String information_qq) {
		this.information_qq = information_qq;
	}
	public String getInformation_Email() {
		return information_Email;
	}
	public void setInformation_Email(String information_Email) {
		this.information_Email = information_Email;
	}
	public String getInformation_compellation() {
		return information_compellation;
	}
	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}
	public String getInformation_card() {
		return information_card;
	}
	public void setInformation_card(String information_card) {
		this.information_card = information_card;
	}
	public String getInformation_weixin() {
		return information_weixin;
	}
	public void setInformation_weixin(String information_weixin) {
		this.information_weixin = information_weixin;
	}
	public Integer getRecommend_superior() {
		return recommend_superior;
	}
	public void setRecommend_superior(Integer recommend_superior) {
		this.recommend_superior = recommend_superior;
	}
	@Override
	public String toString() {
		return "SearchConditionUser [user_basics_id=" + user_basics_id
				+ ", user_account_num=" + user_account_num + ", user_grade_id="
				+ user_grade_id + ", user_register_data=" + user_register_data
				+ ", weixin_id=" + weixin_id + ", weixin_nickname="
				+ weixin_nickname + ", nick_name=" + nick_name
				+ ", information_phone=" + information_phone
				+ ", information_qq=" + information_qq + ", information_Email="
				+ information_Email + ", information_compellation="
				+ information_compellation + ", information_card="
				+ information_card + ", information_weixin="
				+ information_weixin + ", recommend_superior="
				+ recommend_superior + "]";
	}
	

}
