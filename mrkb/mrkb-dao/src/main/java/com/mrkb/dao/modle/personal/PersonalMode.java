package com.mrkb.dao.modle.personal;

public class PersonalMode {
	private Integer mode_id;
	private Integer type_id;
	private String mode_name;
	private Integer user_basics_id;
	private Long add_date;
	private String type_name;
	public Integer getMode_id() {
		return mode_id;
	}
	public void setMode_id(Integer mode_id) {
		this.mode_id = mode_id;
	}
	public String getMode_name() {
		return mode_name;
	}
	public void setMode_name(String mode_name) {
		this.mode_name = mode_name;
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
	@Override
	public String toString() {
		return "PersonalMode [mode_id=" + mode_id + ", type_id=" + type_id
				+ ", mode_name=" + mode_name + ", user_basics_id="
				+ user_basics_id + ", add_date=" + add_date + ", type_name="
				+ type_name + "]";
	}
	
}
