/**
 * FileName:         GradeUpgradeConditionAccomplish.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-27     下午2:37:20
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-27     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.user.GradeUpgradeConditionAccomplishEntity;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Mapper
public interface GradeUpgradeConditionAccomplishMapper {
	/**
	 * 
	 * @Title:             insertGradeUpgradeConditionAccomplish
	 * @Description:     TODO 添加已完成条件数据
	 * @param:             @param gradeUpgradeConditionAccomplishEntity 已完成条件数据实体类
	 * @param:             @return   
	 * @return:         int 添加条数  
	 * @throws
	 */
  int insertGradeUpgradeConditionAccomplish(GradeUpgradeConditionAccomplishEntity gradeUpgradeConditionAccomplishEntity );
/**
 * 
 * @Title:             selectGradeUpgradeConditionAccomplishToUserId
 * @Description:     TODO 查询升级条件完成状态表
 * @param:             @param gradeUpgradeConditionAccomplishEntity
 * 设置的属性为条件，多个条件已and拼接
 * @param:             @return   
 * @return:         List<GradeUpgradeConditionAccomplishEntity>   
 * @throws
 */
  List<GradeUpgradeConditionAccomplishEntity>selectGradeUpgradeConditionAccomplishToAnd(
		  GradeUpgradeConditionAccomplishEntity gradeUpgradeConditionAccomplishEntity);
  /**
   * 
   * @Title:             selectGradeUpgradeConditionAccomplishToUbIdGucId
   * @Description:     TODO 根据用户id、升级条件id查询条件完成记录
   * @param:             @param user_basics_id 用户id
   * @param:             @param grade_upgrade_condition_id 条件记录id
   * @param:             @return   
   * @return:         GradeUpgradeConditionAccomplishEntity 升级条件完成记录实体类 
   * @throws
   */
  GradeUpgradeConditionAccomplishEntity selectGradeUpgradeConditionAccomplishToUbIdGucId(@Param("user_basics_id")int user_basics_id,
		  @Param("grade_upgrade_condition_id")int grade_upgrade_condition_id);//查询等级升级条件的完成状态
  
  
  /**
   * 
   * @Title:             selectGradeUpgradeConditionAccomplishToGucaId
   * @Description:     TODO 查询的等级升级条件的完成记录
   * @param:             @param user_basics_id 用户id
   * @param:             @param grade_upgrade_condition_id 等级升级条件id  
   * @param:             @param accomplish_status 完成状态  
   * @param:             @return   
   * @return:         GradeUpgradeConditionAccomplishEntity   
   * @throws
   */
  GradeUpgradeConditionAccomplishEntity selectGradeUpgradeConditionAccomplishToUbIdGucIdAstatus(@Param("user_basics_id")int user_basics_id,@Param("grade_upgrade_condition_id")int grade_upgrade_condition_id, 
		  @Param("accomplish_status")int accomplish_status);//查询等级升级条件的完成状态
  /**
   * 
   * @Title:             removeGradeUpgradeConditionAccomplishToGucaIdToUGA
   * @Description:     TODO 删除数据
   * @param:             @param user_basics_id 用户id
   * @param:             @param grade_upgrade_condition_id 升级条件id
   * @param:             @param accomplish_status 升级条件完成的状态 1已完成 2未完成
   * @param:             @return   
   * @return:         int   删除条数
   * @throws
   */
  int deleteGradeUpgradeConditionAccomplishToGucaIdToUGA(@Param("user_basics_id")int user_basics_id,@Param("grade_upgrade_condition_id")int grade_upgrade_condition_id, 
		  @Param("accomplish_status")int accomplish_status);//删除等级升级条件的完成状态
  /**
   * 
   * @Title:             updateGradeUpgradeConditionAccomplishToGucaId
   * @Description:     TODO 根据数据主键修改状态
   * @param:             @param grade_upgrade_condition_accomplish_id 升级条件完成记录的数据自增主键
   * @param:             @param accomplish_status 修改后的状态值
   * @param:             @return   
   * @return:         int   
   * @throws
   */
  int updateGradeUpgradeConditionAccomplishToGucaIdAstatus(@Param("grade_upgrade_condition_accomplish_id")int grade_upgrade_condition_accomplish_id,
		  @Param("accomplish_status")int accomplish_status);//根据数据主键修改状态
}
