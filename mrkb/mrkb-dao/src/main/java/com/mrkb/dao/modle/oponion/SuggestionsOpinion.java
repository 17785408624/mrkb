package com.mrkb.dao.modle.oponion;

public class SuggestionsOpinion {

	private Integer opinion_id;//意见ID
	private Integer user_basics_id;//用户编号
	private String tel_phone;//联系方式
	private String suggest_opinion;//意见内容
	private Integer star_level;//星级(1-5级)
	private Long add_date;//添加日期
	private Integer status_state;//审核状态(0运行，1待审核，2未通过，3删除)


	public Integer getOpinion_id() {
		return opinion_id;
	}
	public void setOpinion_id(Integer opinion_id) {
		this.opinion_id = opinion_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getTel_phone() {
		return tel_phone;
	}
	public void setTel_phone(String tel_phone) {
		this.tel_phone = tel_phone;
	}
	public String getSuggest_opinion() {
		return suggest_opinion;
	}
	public void setSuggest_opinion(String suggest_opinion) {
		this.suggest_opinion = suggest_opinion;
	}
	public Integer getStar_level() {
		return star_level;
	}
	public void setStar_level(Integer star_level) {
		this.star_level = star_level;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	public Integer getStatus_state() {
		return status_state;
	}
	public void setStatus_state(Integer status_state) {
		this.status_state = status_state;
	}
	@Override
	public String toString() {
		return "SuggestionsOpinion [opinion_id=" + opinion_id
				+ ", user_basics_id=" + user_basics_id + ", tel_phone="
				+ tel_phone + ", suggest_opinion=" + suggest_opinion
				+ ", star_level=" + star_level + ", add_date=" + add_date
				+ ", status_state=" + status_state + "]";
	}
	
	
}
