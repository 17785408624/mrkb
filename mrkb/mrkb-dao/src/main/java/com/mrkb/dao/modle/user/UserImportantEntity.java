/**
 * FileName:         UserImportant.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-6-12     上午11:11:26
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-6-12     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.user;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class UserImportantEntity {//用户重要信息
	private Integer user_basics_id;//用户id
	private Integer user_grade_id;//等级id
	private String user_account_num;//用户账号
	private String weixin_id;//微信id
	private String information_phone;//用户手机号
	private String information_card;//用户身份证号
	private String information_compellation;//用户真实姓名
	private Integer recommend_superior;//推荐人id
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
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
	public String getWeixin_id() {
		return weixin_id;
	}
	public void setWeixin_id(String weixin_id) {
		this.weixin_id = weixin_id;
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
	public String getInformation_compellation() {
		return information_compellation;
	}
	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}
	public Integer getRecommend_superior() {
		return recommend_superior;
	}
	public void setRecommend_superior(Integer recommend_superior) {
		this.recommend_superior = recommend_superior;
	}
	@Override
	public String toString() {
		return "UserImportantEntity [user_basics_id=" + user_basics_id
				+ ", user_grade_id=" + user_grade_id + ", user_account_num="
				+ user_account_num + ", weixin_id=" + weixin_id
				+ ", information_phone=" + information_phone
				+ ", information_card=" + information_card
				+ ", information_compellation=" + information_compellation
				+ ", recommend_superior=" + recommend_superior + "]";
	}
	
}
