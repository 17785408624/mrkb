/** 
 * FileName:         filialeAwardConfig.java
 * @Description:     TODO 公司奖励设置
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-2     下午5:18:26
 * Copyright:        Copyright(C) 2016-2017 csz
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-2     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.company;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class CompanyAwardConfigEntity {
	private Integer company_award_config_id;//数据主键
	private Integer company_id;//分公司id
	private String award_name;//奖励名
	private String award_issue_cycle;//奖励发放周期（1：以每月特定号数发放，2：以每年特定日期发放。3以添加日期计算每隔一段时间发放一次，4以每天某个整点发放，5以每个小时特定时间发放）
	private String award_issue_data;//奖励发放时间
	private String award_particular_grant_type;//奖励人群（1：以会员等级区分人群）
	private String award_object_id;//奖励目标id (根据奖励人群不同，记录不同id 如果奖励对象为会员组。将记录等级id)
	private String company_award_add_condition;//增加条件（1 对应所属公司会员产生购买服务的消费）
	private String company_award_add_count;//增加值计算方式（1对应按商品价格百分比计算，2为设置固定值）
	private String company_award_add_value;//增加值
	private String company_award_tyep;//奖励项（1 奖金 2旅游积分）
	private String company_award_value;//奖励剩余值
	public Integer getCompany_award_config_id() {
		return company_award_config_id;
	}
	public void setCompany_award_config_id(Integer company_award_config_id) {
		this.company_award_config_id = company_award_config_id;
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
	public String getAward_particular_grant_type() {
		return award_particular_grant_type;
	}
	public void setAward_particular_grant_type(String award_particular_grant_type) {
		this.award_particular_grant_type = award_particular_grant_type;
	}
	public String getAward_object_id() {
		return award_object_id;
	}
	public void setAward_object_id(String award_object_id) {
		this.award_object_id = award_object_id;
	}
	public String getCompany_award_add_condition() {
		return company_award_add_condition;
	}
	public void setCompany_award_add_condition(String company_award_add_condition) {
		this.company_award_add_condition = company_award_add_condition;
	}
	public String getCompany_award_add_count() {
		return company_award_add_count;
	}
	public void setCompany_award_add_count(String company_award_add_count) {
		this.company_award_add_count = company_award_add_count;
	}
	public String getCompany_award_add_value() {
		return company_award_add_value;
	}
	public void setCompany_award_add_value(String company_award_add_value) {
		this.company_award_add_value = company_award_add_value;
	}
	public String getCompany_award_tyep() {
		return company_award_tyep;
	}
	public void setCompany_award_tyep(String company_award_tyep) {
		this.company_award_tyep = company_award_tyep;
	}
	public String getCompany_award_value() {
		return company_award_value;
	}
	public void setCompany_award_value(String company_award_value) {
		this.company_award_value = company_award_value;
	}
	@Override
	public String toString() {
		return "CompanyAwardConfigEntity [company_award_config_id="
				+ company_award_config_id + ", company_id=" + company_id
				+ ", award_name=" + award_name + ", award_issue_cycle="
				+ award_issue_cycle + ", award_issue_data=" + award_issue_data
				+ ", award_particular_grant_type="
				+ award_particular_grant_type + ", award_object_id="
				+ award_object_id + ", company_award_add_condition="
				+ company_award_add_condition + ", company_award_add_count="
				+ company_award_add_count + ", company_award_add_value="
				+ company_award_add_value + ", company_award_tyep="
				+ company_award_tyep + ", company_award_value="
				+ company_award_value + "]";
	}

	
	
}
