/**
 * FileName:         CompanyShow.java
 * @Description:     TODO 封装前端显示公司所需信息
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-8     下午6:13:07
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-8     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.company;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class CompanyShow {
	private Integer user_information_id;//数据主键
	private Integer user_basics_id;//用户id 数据主键
	private Integer company_id;//主键
	private String award_name;//奖励名
	private String add_config;//增加规则（1：公司员工购买商品/服务）
	private String award_issue_cycle;//奖励发放周期（1：以每月特定号数发放，2：以每年特定日期发放。3以添加日期计算每隔多少天发放一次）
	private String award_issue_data;//奖励发放时间
	private String award_add_data;//奖励添加时间
	private String information_phone;//用户手机号
	private String information_qq;//用户qq账号
	private String information_Email;//用户电子邮箱
	private String information_compellation;//用户真实姓名
	private String information_card;//用户身份证号
	private String user_nickname;//用户昵称
	private String company_telephone;//公司联系电话
	private String company_type;//公司类型（1对应总公司 2对应分公司）
	public Integer getUser_information_id() {
		return user_information_id;
	}
	public void setUser_information_id(Integer user_information_id) {
		this.user_information_id = user_information_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public String getAward_name() {
		return award_name;
	}
	public void setAward_name(String award_name) {
		this.award_name = award_name;
	}
	public String getAdd_config() {
		return add_config;
	}
	public void setAdd_config(String add_config) {
		this.add_config = add_config;
	}
	public String getAward_issue_cycle() {
		return award_issue_cycle;
	}
	public void setAward_issue_cycle(String award_issue_cycle) {
		this.award_issue_cycle = award_issue_cycle;
	}
	public String getAward_issue_data() {
		return award_issue_data;
	}
	public void setAward_issue_data(String award_issue_data) {
		this.award_issue_data = award_issue_data;
	}
	public String getAward_add_data() {
		return award_add_data;
	}
	public void setAward_add_data(String award_add_data) {
		this.award_add_data = award_add_data;
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
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getCompany_telephone() {
		return company_telephone;
	}
	public void setCompany_telephone(String company_telephone) {
		this.company_telephone = company_telephone;
	}
	public String getCompany_type() {
		return company_type;
	}
	public void setCompany_type(String company_type) {
		this.company_type = company_type;
	}
	@Override
	public String toString() {
		return "CompanyShow [user_information_id=" + user_information_id
				+ ", user_basics_id=" + user_basics_id + ", company_id="
				+ company_id + ", award_name=" + award_name + ", add_config="
				+ add_config + ", award_issue_cycle=" + award_issue_cycle
				+ ", award_issue_data=" + award_issue_data
				+ ", award_add_data=" + award_add_data + ", information_phone="
				+ information_phone + ", information_qq=" + information_qq
				+ ", information_Email=" + information_Email
				+ ", information_compellation=" + information_compellation
				+ ", information_card=" + information_card + ", user_nickname="
				+ user_nickname + ", company_telephone=" + company_telephone
				+ ", company_type=" + company_type + "]";
	}
	
	
	
}
