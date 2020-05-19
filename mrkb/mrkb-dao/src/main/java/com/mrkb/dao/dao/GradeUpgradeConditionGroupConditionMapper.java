package com.mrkb.dao.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.user.GradeUpgradeConditionGroupConditionEntity;
@Mapper
public interface GradeUpgradeConditionGroupConditionMapper {
	int insertGradeUpgradeConditionGroupCondition(
			GradeUpgradeConditionGroupConditionEntity
			gradeUpgradeConditionGroupConditionEntity);//插入一条会员等级升级条件组 条件数据
	
	int deleteG_U_C_G_C_ToCondition_group_id(int condition_group_id);//通过条件组id删除条件组条件数据

}
