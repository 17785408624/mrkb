package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.user.GradeUpgradeConditionGroupEntity;

@Mapper
public interface GradeUpgradeConditionGroupMapper {
	 GradeUpgradeConditionGroupEntity selectG_U_C_GroupToC_G_id(int condition_group_id);//通过条件组id查询条件组数据
	 int insertGradeUpgradeConditionGroupEntity(
			GradeUpgradeConditionGroupEntity gradeUpgradeConditionGroupEntity);//插入一条条件组数据
     List<GradeUpgradeConditionGroupEntity> selectG_U_C_GroupToG_id(int user_grade_id);//通过会员等级id查询条件组数据
     int deleteG_U_C_GroupToC_G_id(int condition_group_id);//通过条件组id删除条件组数据
}
