/**
 * FileName:         filialeBasicsEntity.java
 * @Description:     TODO 公司基本数据
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-2     下午2:44:18
 * Copyright:        Copyright(C) 2016-2017
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
 * @author mark-1
 *
 */
public class CompanyBasicsEntity {
	private Integer company_id;//主键 ID
	private Integer user_basics_id;//公司老总用户id
	private String company_telephone;//公司联系电话
	private Integer company_type;//公司类型（1对应总公司 2对应分公司）
	private String company_address;//公司所在地
	private String company_account;//公司账户号
	private Double company_money;//公司账户余额
	private Integer status_state;//公司状态
	private String company_name;//公司名称
	private Long add_date;//公司添加时间
	private Long examine_date;//审核时间
	private Integer co_founder;//创办人身份
	private Long apply_date;//申请时间
	private Integer co_user_basics_id;//所属联合创办人编号
	private Integer if_co;//是否可以增加联合创办人（1可以，2不可以）
	private Integer if_founder;//领衔创办人是否有资格拿5%（1，可以拿，2不可以拿）
	private Integer super_company_id;//上级公司
	private Integer company_lv;//公司等级
	private String company_province;//公司所在省份
	private String urban_district;//公司所在地区,市
	private String area;//公司所在区县
	private String low_company_id;//公司下级
	private Integer user_basics_id_referee;//体验中心推荐人
	public Integer getIf_co() {
		return if_co;
	}
	public void setIf_co(Integer if_co) {
		this.if_co = if_co;
	}
	public Long getApply_date() {
		return apply_date;
	}
	public void setApply_date(Long apply_date) {
		this.apply_date = apply_date;
	}
	public Integer getCo_founder() {
		return co_founder;
	}
	public void setCo_founder(Integer co_founder) {
		this.co_founder = co_founder;
	}
	public Integer getCo_user_basics_id() {
		return co_user_basics_id;
	}
	public void setCo_user_basics_id(Integer co_user_basics_id) {
		this.co_user_basics_id = co_user_basics_id;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	public Long getExamine_date() {
		return examine_date;
	}
	public void setExamine_date(Long examine_date) {
		this.examine_date = examine_date;
	}
	public Integer getStatus_state() {
		return status_state;
	}
	public void setStatus_state(Integer status_state) {
		this.status_state = status_state;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getCompany_telephone() {
		return company_telephone;
	}
	public void setCompany_telephone(String company_telephone) {
		this.company_telephone = company_telephone;
	}
	public Integer getCompany_type() {
		return company_type;
	}
	public void setCompany_type(Integer company_type) {
		this.company_type = company_type;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public String getCompany_account() {
		return company_account;
	}
	public void setCompany_account(String company_account) {
		this.company_account = company_account;
	}
	public Double getCompany_money() {
		return company_money;
	}
	public void setCompany_money(Double company_money) {
		this.company_money = company_money;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public Integer getIf_founder() {
		return if_founder;
	}
	public void setIf_founder(Integer if_founder) {
		this.if_founder = if_founder;
	}
	public Integer getSuper_company_id() {
		return super_company_id;
	}
	public void setSuper_company_id(Integer super_company_id) {
		this.super_company_id = super_company_id;
	}
	public Integer getCompany_lv() {
		return company_lv;
	}
	public void setCompany_lv(Integer company_lv) {
		this.company_lv = company_lv;
	}
	public String getCompany_province() {
		return company_province;
	}
	public void setCompany_province(String company_province) {
		this.company_province = company_province;
	}
	public String getUrban_district() {
		return urban_district;
	}
	public void setUrban_district(String urban_district) {
		this.urban_district = urban_district;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLow_company_id() {
		return low_company_id;
	}
	public void setLow_company_id(String low_company_id) {
		this.low_company_id = low_company_id;
	}
	public Integer getUser_basics_id_referee() {
		return user_basics_id_referee;
	}
	public void setUser_basics_id_referee(Integer user_basics_id_referee) {
		this.user_basics_id_referee = user_basics_id_referee;
	}
	@Override
	public String toString() {
		return "CompanyBasicsEntity [company_id=" + company_id
				+ ", user_basics_id=" + user_basics_id + ", company_telephone="
				+ company_telephone + ", company_type=" + company_type
				+ ", company_address=" + company_address + ", company_account="
				+ company_account + ", company_money=" + company_money
				+ ", status_state=" + status_state + ", company_name="
				+ company_name + ", add_date=" + add_date + ", examine_date="
				+ examine_date + ", co_founder=" + co_founder + ", apply_date="
				+ apply_date + ", co_user_basics_id=" + co_user_basics_id
				+ ", if_co=" + if_co + ", if_founder=" + if_founder
				+ ", super_company_id=" + super_company_id + ", company_lv="
				+ company_lv + ", company_province=" + company_province
				+ ", urban_district=" + urban_district + ", area=" + area
				+ ", low_company_id=" + low_company_id
				+ ", user_basics_id_referee=" + user_basics_id_referee + "]";
	}
	
	
}
