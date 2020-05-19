package com.mrkb.dao.modle.account;

public class UserMoneyAccountEntity {
	private int user_money_account_id;//主键
	private Integer user_basics_id;//用户id
	private Double account_value;//流水值
    private Long account_add_date;//流水添加时间
    private String account_explain;//流水说明
    private Integer account_reason;//流水触发原因（1：奖金兑换，2使用提现）
    private Integer account_correlation_id;//流水关联id
	public int getUser_money_account_id() {
		return user_money_account_id;
	}
	public void setUser_money_account_id(int user_money_account_id) {
		this.user_money_account_id = user_money_account_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Double getAccount_value() {
		return account_value;
	}
	public void setAccount_value(Double account_value) {
		this.account_value = account_value;
	}
	public Long getAccount_add_date() {
		return account_add_date;
	}
	public void setAccount_add_date(Long account_add_date) {
		this.account_add_date = account_add_date;
	}
	public String getAccount_explain() {
		return account_explain;
	}
	public void setAccount_explain(String account_explain) {
		this.account_explain = account_explain;
	}
	public Integer getAccount_reason(int i) {
		return account_reason;
	}
	public void setAccount_reason(Integer account_reason) {
		this.account_reason = account_reason;
	}
	public Integer getAccount_correlation_id() {
		return account_correlation_id;
	}
	public void setAccount_correlation_id(Integer account_correlation_id) {
		this.account_correlation_id = account_correlation_id;
	}
	@Override
	public String toString() {
		return "UserMoneyAccountEntity [user_money_account_id="
				+ user_money_account_id + ", user_basics_id=" + user_basics_id
				+ ", account_value=" + account_value + ", account_add_date="
				+ account_add_date + ", account_explain=" + account_explain
				+ ", account_reason=" + account_reason
				+ ", account_correlation_id=" + account_correlation_id + "]";
	}
	
	
    
}
