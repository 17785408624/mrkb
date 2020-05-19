package com.mrkb.dao.modle.user;

public class GradeUpgradeConditionGroupConditionEntity {
	private Integer condition_group_condition_id;//主键
	private Integer condition_group_id;//升级条件组id
	private Integer condition_id;//升级条件id
	public Integer getCondition_group_condition_id() {
		return condition_group_condition_id;
	}
	public void setCondition_group_condition_id(Integer condition_group_condition_id) {
		this.condition_group_condition_id = condition_group_condition_id;
	}
	public Integer getCondition_group_id() {
		return condition_group_id;
	}
	public void setCondition_group_id(Integer condition_group_id) {
		this.condition_group_id = condition_group_id;
	}
	public Integer getCondition_id() {
		return condition_id;
	}
	public void setCondition_id(Integer condition_id) {
		this.condition_id = condition_id;
	}
	@Override
	public String toString() {
		return "GradeUpgradeConditionGroupConditionEntity [condition_group_condition_id="
				+ condition_group_condition_id
				+ ", condition_group_id="
				+ condition_group_id + ", condition_id=" + condition_id + "]";
	}

}
