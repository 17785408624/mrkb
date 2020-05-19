/**
 * FileName:         GradeUpgradeConditionEntity.java
 * @Description:     TODO 升级条件实体类
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-25     下午7:35:40
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-25     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.user;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class GradeUpgradeConditionEntity {
	 Integer grade_upgrade_condition_id;//主键
	 Integer user_grade_id;//等级id
	 Integer condition_correlation_id;//条件关联
	 String condition_type;//条件类型(1:用户成就 2:自定义成就 3:用户购买商品 4:用户团队)
	 String condition_option;//条件项
	 String condition_value;//条件的值
	 String condition_supplement;//条件补充
	 String condition_describe;//条件描述
public Integer getGrade_upgrade_condition_id() {
	return grade_upgrade_condition_id;
}
public void setGrade_upgrade_condition_id(Integer grade_upgrade_condition_id) {
	this.grade_upgrade_condition_id = grade_upgrade_condition_id;
}
public Integer getUser_grade_id() {
	return user_grade_id;
}
public void setUser_grade_id(Integer user_grade_id) {
	this.user_grade_id = user_grade_id;
}
public Integer getCondition_correlation_id() {
	return condition_correlation_id;
}
public void setCondition_correlation_id(Integer condition_correlation_id) {
	this.condition_correlation_id = condition_correlation_id;
}
public String getCondition_type() {
	return condition_type;
}
public void setCondition_type(String condition_type) {
	this.condition_type = condition_type;
}
public String getCondition_option() {
	return condition_option;
}
public void setCondition_option(String condition_option) {
	this.condition_option = condition_option;
}
public String getCondition_value() {
	return condition_value;
}
public void setCondition_value(String condition_value) {
	this.condition_value = condition_value;
}
public String getCondition_supplement() {
	return condition_supplement;
}
public void setCondition_supplement(String condition_supplement) {
	this.condition_supplement = condition_supplement;
}
public String getCondition_describe() {
	return condition_describe;
}
public void setCondition_describe(String condition_describe) {
	this.condition_describe = condition_describe;
}
@Override
public String toString() {
	return "GradeUpgradeConditionEntity [grade_upgrade_condition_id="
			+ grade_upgrade_condition_id + ", user_grade_id=" + user_grade_id
			+ ", condition_correlation_id=" + condition_correlation_id
			+ ", condition_type=" + condition_type + ", condition_option="
			+ condition_option + ", condition_value=" + condition_value
			+ ", condition_supplement=" + condition_supplement
			+ ", condition_describe=" + condition_describe + "]";
}
   
}
