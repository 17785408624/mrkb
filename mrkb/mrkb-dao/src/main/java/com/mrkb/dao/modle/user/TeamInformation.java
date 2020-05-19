package com.mrkb.dao.modle.user;

import java.math.BigDecimal;

public class TeamInformation {

	private Integer user_basics_id;//用户ID
	private Integer user_grade_id;//等级ID
	private String information_compellation;//真实姓名
	private String information_card;//身份证号
	private String grade_name;//等级名字
	private String grade_nickname;//等级昵称
	private Integer integral_basics;//晋级积分
	private Integer integral_travel;//旅游积分
	private Double integral_bonus;//奖金
	private Integer team_num;//团队人数
	private Integer direct_team_num;//直接推荐人数
	private Integer records_integral;//历史积分
	private Integer records_bonus;//历史奖金
	private Integer team_consume;//团队消费
	private Integer direct_team_consume;//直接推荐团队消费
	private Integer recommend_superior;//推荐人ID
	private String superior_information_compellation;//推荐人姓名
	private Integer recommend_type;//推荐方式
	private Integer user_resources;//客户归属(1公司资源 2个人资源)
	private String weixin_nickname;//微信昵称
	//品牌大使
	private Integer co_user_basics_id;//品牌大使编号
	private String information_compellation3;//品牌大使姓名
	
	public Integer getUser_resources() {
		return user_resources;
	}
	public void setUser_resources(Integer user_resources) {
		this.user_resources = user_resources;
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
	public Integer getRecords_bonus() {
		return records_bonus;
	}
	public void setRecords_bonus(Integer records_bonus) {
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
	public Integer getRecommend_superior() {
		return recommend_superior;
	}
	public void setRecommend_superior(Integer recommend_superior) {
		this.recommend_superior = recommend_superior;
	}
	public Integer getRecommend_type() {
		return recommend_type;
	}
	public void setRecommend_type(Integer recommend_type) {
		this.recommend_type = recommend_type;
	}
	public String getInformation_card() {
		return information_card;
	}
	public void setInformation_card(String information_card) {
		this.information_card = information_card;
	}
	
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getUser_grade_id() {
		return user_grade_id;
	}
	public void setUser_grade_id(Integer user_grade_id) {
		this.user_grade_id = user_grade_id;
	}
	public String getInformation_compellation() {
		return information_compellation;
	}
	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public String getGrade_nickname() {
		return grade_nickname;
	}
	public void setGrade_nickname(String grade_nickname) {
		this.grade_nickname = grade_nickname;
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
	public Double getIntegral_bonus() {
		return integral_bonus;
	}
	public void setIntegral_bonus(Double integral_bonus) {
		this.integral_bonus = integral_bonus;
	}
	
	public String getWeixin_nickname() {
		return weixin_nickname;
	}
	public void setWeixin_nickname(String weixin_nickname) {
		this.weixin_nickname = weixin_nickname;
	}
	public TeamInformation(){}
	public TeamInformation(Integer user_basics_id, Integer user_grade_id,
			String information_compellation, String information_card,
			String grade_name, String grade_nickname, Integer integral_basics,
			Integer integral_travel, Double integral_bonus, Integer team_num,
			Integer direct_team_num, Integer records_integral,
			Integer records_bonus, Integer team_consume,
			Integer direct_team_consume, Integer recommend_superior,
			String superior_information_compellation,
			Integer recommend_type,String weixin_nickname) {
		super();
		this.user_basics_id = user_basics_id;
		this.user_grade_id = user_grade_id;
		this.information_compellation = information_compellation;
		this.information_card = information_card;
		this.grade_name = grade_name;
		this.grade_nickname = grade_nickname;
		this.integral_basics = integral_basics;
		this.integral_travel = integral_travel;
		this.integral_bonus = integral_bonus;
		this.team_num = team_num;
		this.direct_team_num = direct_team_num;
		this.records_integral = records_integral;
		this.records_bonus = records_bonus;
		this.team_consume = team_consume;
		this.direct_team_consume = direct_team_consume;
		this.recommend_superior = recommend_superior;
		this.recommend_type = recommend_type;
		this.superior_information_compellation = superior_information_compellation;
		this.weixin_nickname = weixin_nickname;
	}
	public String getSuperior_information_compellation() {
		return superior_information_compellation;
	}
	public void setSuperior_information_compellation(
			String superior_information_compellation) {
		this.superior_information_compellation = superior_information_compellation;
	}
	public Integer getCo_user_basics_id() {
		return co_user_basics_id;
	}
	public void setCo_user_basics_id(Integer co_user_basics_id) {
		this.co_user_basics_id = co_user_basics_id;
	}
	public String getInformation_compellation3() {
		return information_compellation3;
	}
	public void setInformation_compellation3(String information_compellation3) {
		this.information_compellation3 = information_compellation3;
	}
	
}
