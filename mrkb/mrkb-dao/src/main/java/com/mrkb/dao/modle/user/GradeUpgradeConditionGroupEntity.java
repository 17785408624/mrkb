package com.mrkb.dao.modle.user;

public class GradeUpgradeConditionGroupEntity {//升级条件组实体类
	private Integer condition_group_id;//主键
	private String condition_group_name;//条件组名字
	private String condition_group_describe;//描述
	private Integer user_grade_id;//会员等级id
	public Integer getCondition_group_id() {
		return condition_group_id;
	}
	public void setCondition_group_id(Integer condition_group_id) {
		this.condition_group_id = condition_group_id;
	}
	public String getCondition_group_name() {
		return condition_group_name;
	}
	public void setCondition_group_name(String condition_group_name) {
		this.condition_group_name = condition_group_name;
	}
	public String getCondition_group_describe() {
		return condition_group_describe;
	}
	public void setCondition_group_describe(String condition_group_describe) {
		this.condition_group_describe = condition_group_describe;
	}
	public Integer getUser_grade_id() {
		return user_grade_id;
	}
	public void setUser_grade_id(Integer user_grade_id) {
		this.user_grade_id = user_grade_id;
	}
	@Override
	public String toString() {
		return "GradeUpgradeConditionGroupEntity [condition_group_id="
				+ condition_group_id + ", condition_group_name="
				+ condition_group_name + ", condition_group_describe="
				+ condition_group_describe + ", user_grade_id=" + user_grade_id
				+ "]";
	}
	
	

}
