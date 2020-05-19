/**
 * FileName:         gradeUpgradeConditionAccomplisheEntity.java
 * @Description:     TODO 已完成升级条件实体类
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-27     下午2:28:07
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-27     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.user;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class GradeUpgradeConditionAccomplishEntity extends GradeUpgradeConditionEntity{
   private Integer grade_upgrade_condition_accomplish_id;//升级条件完成状态表数据主键
   private Integer user_basics_id;//用户id
   private Long add_date;//添加时间
   private String accomplish_status;//完成状态（1已完成，2未完成）
public Integer getGrade_upgrade_condition_accomplish_id() {
	return grade_upgrade_condition_accomplish_id;
}
public void setGrade_upgrade_condition_accomplish_id(
		Integer grade_upgrade_condition_accomplish_id) {
	this.grade_upgrade_condition_accomplish_id = grade_upgrade_condition_accomplish_id;
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
public String getAccomplish_status() {
	return accomplish_status;
}
public void setAccomplish_status(String accomplish_status) {
	this.accomplish_status = accomplish_status;
}
@Override
public String toString() {
	return "GradeUpgradeConditionAccomplishEntity [grade_upgrade_condition_accomplish_id="
			+ grade_upgrade_condition_accomplish_id
			+ ", user_basics_id="
			+ user_basics_id
			+ ", add_date="
			+ add_date
			+ ", accomplish_status="
			+ accomplish_status
			+ ", grade_upgrade_condition_id="
			+ grade_upgrade_condition_id
			+ ", user_grade_id="
			+ user_grade_id
			+ ", condition_correlation_id="
			+ condition_correlation_id
			+ ", condition_type="
			+ condition_type
			+ ", condition_option="
			+ condition_option
			+ ", condition_value="
			+ condition_value
			+ ", condition_supplement="
			+ condition_supplement
			+ ", condition_describe=" + condition_describe + "]";
}

   
}
