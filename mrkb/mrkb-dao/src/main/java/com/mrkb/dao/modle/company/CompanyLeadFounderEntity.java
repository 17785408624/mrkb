package com.mrkb.dao.modle.company;

public class CompanyLeadFounderEntity {

	private Integer user_basics_id;//用户ID 
	private String information_compellation;//姓名
	private String company_name;//公司名称
	private String company_address;//公司地址
	private Integer status_state;//公司状态
	private Long apply_date;//注册时间
	private Double mon_sale_timely;//月销售(及时)
	private Double mon_sale_untimely;//月销售(非及时)
	private Double founder_bonus;//领衔创办人奖金池
	private Integer integral_basics;//积分
	private Integer integral_travel;//旅游积分
	private Integer user_grade_id;//等级ID
	private String month_date;//销售月份
	private Integer company_id;//公司ID
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public String getMonth_date() {
		return month_date;
	}
	public void setMonth_date(String month_date) {
		this.month_date = month_date;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getInformation_compellation() {
		return information_compellation;
	}
	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public Integer getStatus_state() {
		return status_state;
	}
	public void setStatus_state(Integer status_state) {
		this.status_state = status_state;
	}
	public Long getApply_date() {
		return apply_date;
	}
	public void setApply_date(Long apply_date) {
		this.apply_date = apply_date;
	}
	public Double getMon_sale_timely() {
		return mon_sale_timely;
	}
	public void setMon_sale_timely(Double mon_sale_timely) {
		this.mon_sale_timely = mon_sale_timely;
	}
	public Double getMon_sale_untimely() {
		return mon_sale_untimely;
	}
	public void setMon_sale_untimely(Double mon_sale_untimely) {
		this.mon_sale_untimely = mon_sale_untimely;
	}
	public Double getFounder_bonus() {
		return founder_bonus;
	}
	public void setFounder_bonus(Double founder_bonus) {
		this.founder_bonus = founder_bonus;
	}
	public Integer getIntegral_basics() {
		return integral_basics;
	}
	public void setIntegral_basics(Integer integral_basics) {
		this.integral_basics = integral_basics;
	}
	public Integer getIntegral_travel() {
		return integral_travel;
	}
	public void setIntegral_travel(Integer integral_travel) {
		this.integral_travel = integral_travel;
	}
	public Integer getUser_grade_id() {
		return user_grade_id;
	}
	public void setUser_grade_id(Integer user_grade_id) {
		this.user_grade_id = user_grade_id;
	}
	@Override
	public String toString() {
		return "CompanyLeadFounderEntity [user_basics_id=" + user_basics_id
				+ ", information_compellation=" + information_compellation
				+ ", company_name=" + company_name + ", company_address="
				+ company_address + ", status_state=" + status_state
				+ ", apply_date=" + apply_date + ", mon_sale_timely="
				+ mon_sale_timely + ", mon_sale_untimely=" + mon_sale_untimely
				+ ", founder_bonus=" + founder_bonus + ", integral_basics="
				+ integral_basics + ", integral_travel=" + integral_travel
				+ ", user_grade_id=" + user_grade_id + ", month_date="
				+ month_date + ", company_id=" + company_id + "]";
	}
	
}
