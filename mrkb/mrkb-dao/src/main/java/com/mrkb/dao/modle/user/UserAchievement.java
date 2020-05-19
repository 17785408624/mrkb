package com.mrkb.dao.modle.user;

public class UserAchievement {
	private Integer achievement_id;//类主键
	private Integer user_basics_id;//用户id
	private Integer team_num;//团队人数
	private Integer direct_team_num;//直接推荐人数
	private Integer records_integral;//历史积分
	private String records_bonus;//历史奖金
	private Integer team_consume;//团队消费
	private Integer direct_team_consume=0;//直接推荐团队消费
	private Integer co_total_sale=0;//品牌大使累计收益
	private Integer two_team_num=0;//第二代推荐人数
	private Integer three_team_num=0;//第三代推荐人数
	private Integer integral_no_active=0;//未激活的快乐豆
	private Integer integrals_no_active=0;//未激活积分
	private Integer conver_num=0;//历史卡巴积分
	private double user_money;//钱包
	public Integer getCo_total_sale() {
		return co_total_sale;
	}
	public void setCo_total_sale(Integer co_total_sale) {
		this.co_total_sale = co_total_sale;
	}
	public Integer getAchievement_id() {
		return achievement_id;
	}
	public void setAchievement_id(Integer achievement_id) {
		this.achievement_id = achievement_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getTeam_num() {
		return team_num;
	}
	public void setTeam_num(Integer team_num) {
		this.team_num = team_num;
	}
	public Integer getDirect_team_num() {
		return direct_team_num;
	}
	public void setDirect_team_num(Integer direct_team_num) {
		this.direct_team_num = direct_team_num;
	}
	public Integer getRecords_integral() {
		return records_integral;
	}
	public void setRecords_integral(Integer records_integral) {
		this.records_integral = records_integral;
	}
	public String getRecords_bonus() {
		return records_bonus;
	}
	public void setRecords_bonus(String records_bonus) {
		this.records_bonus = records_bonus;
	}
	public Integer getTeam_consume() {
		return team_consume;
	}
	public void setTeam_consume(Integer team_consume) {
		this.team_consume = team_consume;
	}
	public Integer getDirect_team_consume() {
		return direct_team_consume;
	}
	public void setDirect_team_consume(Integer direct_team_consume) {
		this.direct_team_consume = direct_team_consume;
	}
	public Integer getTwo_team_num() {
		return two_team_num;
	}
	public void setTwo_team_num(Integer two_team_num) {
		this.two_team_num = two_team_num;
	}
	public Integer getThree_team_num() {
		return three_team_num;
	}
	public void setThree_team_num(Integer three_team_num) {
		this.three_team_num = three_team_num;
	}
	
	public Integer getIntegral_no_active() {
		return integral_no_active;
	}
	public void setIntegral_no_active(Integer integral_no_active) {
		this.integral_no_active = integral_no_active;
	}
	public Integer getIntegrals_no_active() {
		return integrals_no_active;
	}
	public void setIntegrals_no_active(Integer integrals_no_active) {
		this.integrals_no_active = integrals_no_active;
	}
	public Integer getConver_num() {
		return conver_num;
	}
	public void setConver_num(Integer conver_num) {
		this.conver_num = conver_num;
	}

	public double getUser_money() {
		return user_money;
	}

	public void setUser_money(double user_money) {
		this.user_money = user_money;
	}

	@Override
	public String toString() {
		return "UserAchievement{" +
				"achievement_id=" + achievement_id +
				", user_basics_id=" + user_basics_id +
				", team_num=" + team_num +
				", direct_team_num=" + direct_team_num +
				", records_integral=" + records_integral +
				", records_bonus='" + records_bonus + '\'' +
				", team_consume=" + team_consume +
				", direct_team_consume=" + direct_team_consume +
				", co_total_sale=" + co_total_sale +
				", two_team_num=" + two_team_num +
				", three_team_num=" + three_team_num +
				", integral_no_active=" + integral_no_active +
				", integrals_no_active=" + integrals_no_active +
				", conver_num=" + conver_num +
				", user_money=" + user_money +
				'}';
	}
}
