/**
 * FileName:         integralAccount.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-2     上午12:39:09
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-2     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.account;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class IntegralAccount {
	private Integer integral_account_id;
	private String account_option;//改变的数据
	private Integer user_basics_id;//改变积分项的用户（关联user_basics表）
	private String account_option_name;//改变数据的名字
	private Long account_add_date;//更改积分时间（添加数据时间）
	private String integral_account_num;//更改的值
	private String integral_account_explain;//流水说明
	private Integer integral_account_type;//流水触发原因(1,购买商品,2使用奖金提现)
	private Integer integral_trigger;//流水关联触发订单id
	public Integer getIntegral_account_id() {
		return integral_account_id;
	}
	public void setIntegral_account_id(Integer integral_account_id) {
		this.integral_account_id = integral_account_id;
	}
	public String getAccount_option() {
		return account_option;
	}
	public void setAccount_option(String account_option) {
		this.account_option = account_option;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getAccount_option_name() {
		return account_option_name;
	}
	public void setAccount_option_name(String account_option_name) {
		this.account_option_name = account_option_name;
	}
	public Long getAccount_add_date() {
		return account_add_date;
	}
	public void setAccount_add_date(Long account_add_date) {
		this.account_add_date = account_add_date;
	}
	public String getIntegral_account_num() {
		return integral_account_num;
	}
	public void setIntegral_account_num(String integral_account_num) {
		this.integral_account_num = integral_account_num;
	}
	public String getIntegral_account_explain() {
		return integral_account_explain;
	}
	public void setIntegral_account_explain(String integral_account_explain) {
		this.integral_account_explain = integral_account_explain;
	}
	public Integer getIntegral_account_type() {
		return integral_account_type;
	}
	public void setIntegral_account_type(Integer integral_account_type) {
		this.integral_account_type = integral_account_type;
	}
	public Integer getIntegral_trigger() {
		return integral_trigger;
	}
	public void setIntegral_trigger(Integer integral_trigger) {
		this.integral_trigger = integral_trigger;
	}
	@Override
	public String toString() {
		return "IntegralAccount [integral_account_id=" + integral_account_id
				+ ", account_option=" + account_option + ", user_basics_id="
				+ user_basics_id + ", account_option_name="
				+ account_option_name + ", account_add_date="
				+ account_add_date + ", integral_account_num="
				+ integral_account_num + ", integral_account_explain="
				+ integral_account_explain + ", integral_account_type="
				+ integral_account_type + ", integral_trigger="
				+ integral_trigger + "]";
	}
	
	

	
}
