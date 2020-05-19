/**
 * FileName:         UserUpgradeSchedule.java
 * @Description:     TODO 用户等级升级达成信息实体类
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-27     上午10:52:55
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

import java.util.List;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class UserUpgradeSchedule extends UserGrade {
    private List<GradeUpgradeConditionEntity>accomplishConditionList;//已完成升级条件
    private List<GradeUpgradeConditionEntity>accomplishConditionNoList;//未完成升级条件
   //private List<GradeUpgradeConditionEntity>accomplishConditionListRecords;//已完成升级条件记录
	public List<GradeUpgradeConditionEntity> getAccomplishConditionList() {
		return accomplishConditionList;
	}
	public void setAccomplishConditionList(
			List<GradeUpgradeConditionEntity> accomplishConditionList) {
		this.accomplishConditionList = accomplishConditionList;
	}
	public List<GradeUpgradeConditionEntity> getAccomplishConditionNoList() {
		return accomplishConditionNoList;
	}
	public void setAccomplishConditionNoList(
			List<GradeUpgradeConditionEntity> accomplishConditionNoList) {
		this.accomplishConditionNoList = accomplishConditionNoList;
	}
	@Override
	public String toString() {
		return "UserUpgradeSchedule [accomplishConditionList="
				+ accomplishConditionList + ", accomplishConditionNoList="
				+ accomplishConditionNoList + ", getUser_grade_id()="
				+ getUser_grade_id() + ", getGrade_name()=" + getGrade_name()
				+ ", getGrade_describe()=" + getGrade_describe()
				+ ", getGrade_nickname()=" + getGrade_nickname()
				+ ", getGrade_benefit()=" + getGrade_benefit()
				+ ", getUpgrade_order()=" + getUpgrade_order()
				+ ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
     
}
