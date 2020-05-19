package com.mrkb.dao.modle.company;

public class CoFounderMonSale {
	private Integer co_founder_mon_sale_id;//联合创办人月销售编号
	private Integer user_basics_id;//联合创办人用户编号
	private String month_date;//销售月份
	private Double mon_sale_timely=0.00;//月销售（及时）
	private Double mon_sale_untimely=0.00;//月销售（非及时，每月统计一次）
	private Double team_bonus;//个人团队销售奖励
	private Double avg_bonus;//团队平均分配奖励
	private Double achievement_bonus;//按业绩分配奖金
	private Double founder_bonus;//领衔创办人专享
	private Long start_time;//开始时间
	private Long end_time;//结束时间
	private Integer if_settlement;//是否结算(0.未结算,1.已结算)
	//查询品牌大使月销售量使用
	private String information_compellation;//品牌大使姓名
	private String weixin_portrait;//微信头像
	private Integer team_num;//团队人数
	public Integer getCo_founder_mon_sale_id() {
		return co_founder_mon_sale_id;
	}
	public void setCo_founder_mon_sale_id(Integer co_founder_mon_sale_id) {
		this.co_founder_mon_sale_id = co_founder_mon_sale_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getMonth_date() {
		return month_date;
	}
	public void setMonth_date(String month_date) {
		this.month_date = month_date;
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
	public Double getTeam_bonus() {
		return team_bonus;
	}
	public void setTeam_bonus(Double team_bonus) {
		this.team_bonus = team_bonus;
	}
	public Double getAvg_bonus() {
		return avg_bonus;
	}
	public void setAvg_bonus(Double avg_bonus) {
		this.avg_bonus = avg_bonus;
	}
	public Double getAchievement_bonus() {
		return achievement_bonus;
	}
	public void setAchievement_bonus(Double achievement_bonus) {
		this.achievement_bonus = achievement_bonus;
	}
	public Double getFounder_bonus() {
		return founder_bonus;
	}
	public void setFounder_bonus(Double founder_bonus) {
		this.founder_bonus = founder_bonus;
	}
	public Long getStart_time() {
		return start_time;
	}
	public void setStart_time(Long start_time) {
		this.start_time = start_time;
	}
	public Long getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Long end_time) {
		this.end_time = end_time;
	}
	public Integer getIf_settlement() {
		return if_settlement;
	}
	public void setIf_settlement(Integer if_settlement) {
		this.if_settlement = if_settlement;
	}
	public String getInformation_compellation() {
		return information_compellation;
	}
	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}
	public String getWeixin_portrait() {
		return weixin_portrait;
	}
	public void setWeixin_portrait(String weixin_portrait) {
		this.weixin_portrait = weixin_portrait;
	}
	public Integer getTeam_num() {
		return team_num;
	}
	public void setTeam_num(Integer team_num) {
		this.team_num = team_num;
	}
	@Override
	public String toString() {
		return "CoFounderMonSale [co_founder_mon_sale_id="
				+ co_founder_mon_sale_id + ", user_basics_id=" + user_basics_id
				+ ", month_date=" + month_date + ", mon_sale_timely="
				+ mon_sale_timely + ", mon_sale_untimely=" + mon_sale_untimely
				+ ", team_bonus=" + team_bonus + ", avg_bonus=" + avg_bonus
				+ ", achievement_bonus=" + achievement_bonus
				+ ", founder_bonus=" + founder_bonus + ", start_time="
				+ start_time + ", end_time=" + end_time + ", if_settlement="
				+ if_settlement + ", information_compellation="
				+ information_compellation + ", weixin_portrait="
				+ weixin_portrait + ", team_num=" + team_num + "]";
	}
	
}
