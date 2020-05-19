/**
 * FileName:         capitalAccount.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-1     下午10:19:12
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-1     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.account;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class CapitalAccount {
	private Integer capital_account_id;//自增id
	private Integer to_user_basics_id;//发起人id
	private String account_explain;//流水说明
	private Long add_account_date;//添加时间
	private Double capital_number;//资金数量
	private Integer capital_trigger;//关联触发数据的id
	private Integer capital_account_type;//流水类型（1购买商品,2余额提现）
	private Integer company_id;//购买人所属公司
	private Integer co_user_basics_id;//购买人所属联合创办人
	public Integer getCapital_account_id() {
		return capital_account_id;
	}
	public void setCapital_account_id(Integer capital_account_id) {
		this.capital_account_id = capital_account_id;
	}
	public Integer getTo_user_basics_id() {
		return to_user_basics_id;
	}
	public void setTo_user_basics_id(Integer to_user_basics_id) {
		this.to_user_basics_id = to_user_basics_id;
	}
	public String getAccount_explain() {
		return account_explain;
	}
	public void setAccount_explain(String account_explain) {
		this.account_explain = account_explain;
	}
	public Long getAdd_account_date() {
		return add_account_date;
	}
	public void setAdd_account_date(Long add_account_date) {
		this.add_account_date = add_account_date;
	}
	public Double getCapital_number() {
		return capital_number;
	}
	public void setCapital_number(Double capital_number) {
		this.capital_number = capital_number;
	}
	public Integer getCapital_trigger() {
		return capital_trigger;
	}
	public void setCapital_trigger(Integer capital_trigger) {
		this.capital_trigger = capital_trigger;
	}
	public Integer getCapital_account_type() {
		return capital_account_type;
	}
	public void setCapital_account_type(Integer capital_account_type) {
		this.capital_account_type = capital_account_type;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public Integer getCo_user_basics_id() {
		return co_user_basics_id;
	}
	public void setCo_user_basics_id(Integer co_user_basics_id) {
		this.co_user_basics_id = co_user_basics_id;
	}
	@Override
	public String toString() {
		return "CapitalAccount [capital_account_id=" + capital_account_id
				+ ", to_user_basics_id=" + to_user_basics_id
				+ ", account_explain=" + account_explain
				+ ", add_account_date=" + add_account_date
				+ ", capital_number=" + capital_number + ", capital_trigger="
				+ capital_trigger + ", capital_account_type="
				+ capital_account_type + ", company_id=" + company_id
				+ ", co_user_basics_id=" + co_user_basics_id + "]";
	}
	
	
}
