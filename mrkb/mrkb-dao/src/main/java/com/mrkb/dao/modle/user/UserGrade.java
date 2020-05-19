/**
 * FileName:         userGrade.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-2     上午2:55:32
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-2     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.user;

/**
 * @param
 * @return
 * @author moerka-1
 * 
 */
public class UserGrade {
	private Integer user_grade_id;// 等级id
	private String grade_name;// 等级名字
	private String grade_describe;// 等级描述
	private String grade_nickname;// 等级昵称
	private String grade_benefit;// 等级受益
	private String upgrade_order;//升级顺序
	private String grade_introduce;//会员等级介绍
	public Integer getUser_grade_id() {
		return user_grade_id;
	}
	public void setUser_grade_id(Integer user_grade_id) {
		this.user_grade_id = user_grade_id;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public String getGrade_describe() {
		return grade_describe;
	}
	public void setGrade_describe(String grade_describe) {
		this.grade_describe = grade_describe;
	}
	public String getGrade_nickname() {
		return grade_nickname;
	}
	public void setGrade_nickname(String grade_nickname) {
		this.grade_nickname = grade_nickname;
	}
	public String getGrade_benefit() {
		return grade_benefit;
	}
	public void setGrade_benefit(String grade_benefit) {
		this.grade_benefit = grade_benefit;
	}
	public String getUpgrade_order() {
		return upgrade_order;
	}
	public void setUpgrade_order(String upgrade_order) {
		this.upgrade_order = upgrade_order;
	}
	public String getGrade_introduce() {
		return grade_introduce;
	}
	public void setGrade_introduce(String grade_introduce) {
		this.grade_introduce = grade_introduce;
	}
	@Override
	public String toString() {
		return "UserGrade [user_grade_id=" + user_grade_id + ", grade_name="
				+ grade_name + ", grade_describe=" + grade_describe
				+ ", grade_nickname=" + grade_nickname + ", grade_benefit="
				+ grade_benefit + ", upgrade_order=" + upgrade_order
				+ ", grade_introduce=" + grade_introduce + "]";
	}
	

}
