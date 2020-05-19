/**
 * FileName:         GradeUpgradeCondition.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-26     下午4:34:24
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-26     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.user.GradeUpgradeConditionEntity;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Mapper
public interface GradeUpgradeConditionMapper {
	/**
	 * 
	 * @Title:             insertGradeUpgradeCondition
	 * @Description:     TODO 新增等级升级条件
	 * @param:             @param gradeUpgradeConditionEntity 等级升级条件
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int insertGradeUpgradeCondition(
			GradeUpgradeConditionEntity gradeUpgradeConditionEntity);//新增等级升级条件
	/**
	 * 
	 * @Title:             selectGradeUpgradeConditionTo
	 * @Description:     TODO 查询等级升级条件 
	 * gradeUpgradeConditionEntity设置的值为查询条件，如果设置多个条件之间以并且链接
	 * @param:             @param gradeUpgradeConditionEntity
	 * @param:             @return   
	 * @return:         List<GradeUpgradeConditionEntity>   
	 * @throws
	 */
	List<GradeUpgradeConditionEntity> selectGradeUpgradeConditionTo(
			GradeUpgradeConditionEntity gradeUpgradeConditionEntity);//查询等级升级条件
	/**
	 * 
	 * @Title:             delectGradeUpgradeConditionTo
	 * @Description:     TODO 删除等级升级条件
	 * @param:             @param gradeUpgradeConditionEntity 升级条件实体类 
	 * 设置的值为查询条件，如果设置多个条件之间以并且链接
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
   int delectGradeUpgradeConditionTo(
		   GradeUpgradeConditionEntity gradeUpgradeConditionEntity);//删除等级升级条件
	/**
	 * 
	 * @Title:             selectG_U_C_ToCondition_group_id
	 * @Description:     TODO 通过条件组id查询升级条件
	 * @param:             @param condition_group_id 条件组id
	 * @param:             @return   
	 * @return:         List<GradeUpgradeConditionEntity>   
	 * @throws
	 */
   List<GradeUpgradeConditionEntity> selectG_U_C_ToCondition_group_id(
		   int condition_group_id);//通过条件组id查询升级条件
   /**
    * 
    * @Title:             deleteG_U_C_ToCondition_group_id
    * @Description:     TODO 通过条件组id删除升级条件
    * @param:             @param condition_group_id 条件组id
    * @param:             @return   
    * @return:         int   
    * @throws
    */
   int deleteG_U_C_ToCondition_group_id(
		   int condition_group_id);//通过条件组id删除升级条件
   
}
