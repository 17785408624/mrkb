package com.mrkb.dao.modle.personal;

public class PersonalType {
	private Integer type_id;
	private String type_name;
	private Integer user_basics_id;
	private Long add_date;
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	@Override
	public String toString() {
		return "PersonalType [type_id=" + type_id + ", type_name=" + type_name
				+ ", user_basics_id=" + user_basics_id + ", add_date="
				+ add_date + "]";
	}

}
