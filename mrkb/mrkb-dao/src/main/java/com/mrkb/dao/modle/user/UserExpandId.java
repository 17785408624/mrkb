package com.mrkb.dao.modle.user;

public class UserExpandId {
	private Integer user_expand_id;
	private Integer user_details_id;
	private Integer user_basics_id;
	private String details_value;
	private String details_ps;
	private Integer priority_level;
	public Integer getUser_expand_id() {
		return user_expand_id;
	}
	public void setUser_expand_id(Integer user_expand_id) {
		this.user_expand_id = user_expand_id;
	}
	public Integer getUser_details_id() {
		return user_details_id;
	}
	public void setUser_details_id(Integer user_details_id) {
		this.user_details_id = user_details_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getDetails_value() {
		return details_value;
	}
	public void setDetails_value(String details_value) {
		this.details_value = details_value;
	}
	public String getDetails_ps() {
		return details_ps;
	}
	public void setDetails_ps(String details_ps) {
		this.details_ps = details_ps;
	}
	public Integer getPriority_level() {
		return priority_level;
	}
	public void setPriority_level(Integer priority_level) {
		this.priority_level = priority_level;
	}
	@Override
	public String toString() {
		return "UserExpandId [user_expand_id=" + user_expand_id
				+ ", user_details_id=" + user_details_id + ", user_basics_id="
				+ user_basics_id + ", details_value=" + details_value
				+ ", details_ps=" + details_ps + ", priority_level="
				+ priority_level + "]";
	}
	

}
