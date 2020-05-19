package com.mrkb.dao.modle.personal;

public class PersonalServer {
	private Integer server_id;//服务ID
	private Integer mode_id;//类型ID  
	private Integer type_id;//方式ID  
	private String server_name;// 服务名称 
	private Long add_date;//添加时间 
	private Integer effective_time;//有效时间(天) 
	private Integer user_basics_id;//添加人ID  
	private String server_intro;//服务介绍
	private String server_picture;//服务图片 
	
	private String type_name;//服务方式名称
	private String mode_name;//服务类型名称
	public Integer getServer_id() {
		return server_id;
	}
	public void setServer_id(Integer server_id) {
		this.server_id = server_id;
	}
	public Integer getMode_id() {
		return mode_id;
	}
	public void setMode_id(Integer mode_id) {
		this.mode_id = mode_id;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getServer_name() {
		return server_name;
	}
	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	public Integer getEffective_time() {
		return effective_time;
	}
	public void setEffective_time(Integer effective_time) {
		this.effective_time = effective_time;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	
	public String getServer_intro() {
		return server_intro;
	}
	public void setServer_intro(String server_intro) {
		this.server_intro = server_intro;
	}
	public String getServer_picture() {
		return server_picture;
	}
	public void setServer_picture(String server_picture) {
		this.server_picture = server_picture;
	}
	
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getMode_name() {
		return mode_name;
	}
	public void setMode_name(String mode_name) {
		this.mode_name = mode_name;
	}
	@Override
	public String toString() {
		return "PersonalServer [server_id=" + server_id + ", mode_id="
				+ mode_id + ", type_id=" + type_id + ", server_name=" 
				+ server_name + ", add_date=" + add_date + ", effective_time="
				+ effective_time + ", user_basics_id=" + user_basics_id
				+ ", server_intro=" + server_intro + ", server_picture="
				+ server_picture +",type_name=" + type_name + ", mode_name=" + mode_name +"]";
	}
	
}
