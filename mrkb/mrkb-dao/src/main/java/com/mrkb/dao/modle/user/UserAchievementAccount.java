package com.mrkb.dao.modle.user;

public class UserAchievementAccount {
	private Integer user_achievement_custom_id;//数据主键
	private Integer user_basics_id;//用户id
	private Integer achievement_cutom_id;//自定义成就id
	private Integer status;//状态（1：进行中，2已完成）
	public Integer getUser_achievement_custom_id() {
		return user_achievement_custom_id;
	}
	public void setUser_achievement_custom_id(Integer user_achievement_custom_id) {
		this.user_achievement_custom_id = user_achievement_custom_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getAchievement_cutom_id() {
		return achievement_cutom_id;
	}
	public void setAchievement_cutom_id(Integer achievement_cutom_id) {
		this.achievement_cutom_id = achievement_cutom_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserAchievementAccount [user_achievement_custom_id="
				+ user_achievement_custom_id + ", user_basics_id="
				+ user_basics_id + ", achievement_cutom_id="
				+ achievement_cutom_id + ", status=" + status + "]";
	}

}
