package com.mrkb.dao.modle.user;

public class ExpertEntity {
	private Integer expert_id;//专家编号
	private Integer user_basics_id;//用户编号(专家)
	private String expert_name;//专家姓名
	private String expert_academic;//专家职称
	private String expert_portrait;//专家头像
	private String expert_expert;//专家介绍
	private Integer add_user_basics_id;//添加人ID
	private Long add_date;//添加时间
	public Integer getExpert_id() {
		return expert_id;
	}
	public void setExpert_id(Integer expert_id) {
		this.expert_id = expert_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getExpert_academic() {
		return expert_academic;
	}
	public void setExpert_academic(String expert_academic) {
		this.expert_academic = expert_academic;
	}
	public String getExpert_portrait() {
		return expert_portrait;
	}
	public void setExpert_portrait(String expert_portrait) {
		this.expert_portrait = expert_portrait;
	}
	public String getExpert_expert() {
		return expert_expert;
	}
	public void setExpert_expert(String expert_expert) {
		this.expert_expert = expert_expert;
	}
	public Integer getAdd_user_basics_id() {
		return add_user_basics_id;
	}
	public void setAdd_user_basics_id(Integer add_user_basics_id) {
		this.add_user_basics_id = add_user_basics_id;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	public String getExpert_name() {
		return expert_name;
	}
	public void setExpert_name(String expert_name) {
		this.expert_name = expert_name;
	}
	@Override
	public String toString() {
		return "ExpertEntity [expert_id=" + expert_id + ", user_basics_id="
				+ user_basics_id + ", expert_name=" + expert_name
				+ ", expert_academic=" + expert_academic + ", expert_portrait="
				+ expert_portrait + ", expert_expert=" + expert_expert
				+ ", add_user_basics_id=" + add_user_basics_id + ", add_date="
				+ add_date + "]";
	}

}
