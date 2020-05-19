package com.mrkb.dao.modle.user;

public class UserIntegral {
	private Integer user_integral_id;//唯一标识
	private Integer user_basics_id;//用户id
	private Integer integral_basics=0;//积分数量
	private Integer integra_mdfdcurrency=0;//脉迪富德币数量
	private Integer integral_travel=0;//旅游积分
	private Integer integral_bonus=0;//奖金
	private Integer conver_num=0;//卡巴积分
	public Integer getUser_integral_id() {
		return user_integral_id;
	}
	public void setUser_integral_id(Integer user_integral_id) {
		this.user_integral_id = user_integral_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getIntegral_basics() {
		return integral_basics;
	}
	public void setIntegral_basics(Integer integral_basics) {
		this.integral_basics = integral_basics;
	}
	public Integer getIntegra_mdfdcurrency() {
		return integra_mdfdcurrency;
	}
	public void setIntegra_mdfdcurrency(Integer integra_mdfdcurrency) {
		this.integra_mdfdcurrency = integra_mdfdcurrency;
	}
	public Integer getIntegral_travel() {
		return integral_travel;
	}
	public void setIntegral_travel(Integer integral_travel) {
		this.integral_travel = integral_travel;
	}
	public Integer getIntegral_bonus() {
		return integral_bonus;
	}
	public void setIntegral_bonus(Integer integral_bonus) {
		this.integral_bonus = integral_bonus;
	}
	public Integer getConver_num() {
		return conver_num;
	}
	public void setConver_num(Integer conver_num) {
		this.conver_num = conver_num;
	}
	@Override
	public String toString() {
		return "UserIntegral [user_integral_id=" + user_integral_id
				+ ", user_basics_id=" + user_basics_id + ", integral_basics="
				+ integral_basics + ", integra_mdfdcurrency="
				+ integra_mdfdcurrency + ", integral_travel=" + integral_travel
				+ ", integral_bonus=" + integral_bonus + ", conver_num="
				+ conver_num + "]";
	}
	
}
