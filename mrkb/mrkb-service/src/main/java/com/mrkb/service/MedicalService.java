package com.mrkb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.medical.MedicalEntity;
import com.mrkb.dao.modle.medical.MedicalRecordEntity;


public interface MedicalService {
	/**
	 * 
	 * @Title:             saveMedical
	 * @Description:     TODO 保存用户体检报告
	 * @param:             @param medicalEntity 用户体检数据
	 * @param:             @param user_basics_id 用户id
	 * @param:             @return  user_basics_id 
	 * @return:         int   
	 * @throws
	 */
	int saveMedical(MedicalEntity medicalEntity ,int user_basics_id);
	/**
	 * 
	 * @Title:             saveMedicalRecord
	 * @Description:     TODO 保存体检记录
	 * @param:             @param medicalEntity 体检数据
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int saveMedicalRecord(MedicalEntity medicalEntity);
	/**
	 * 
	 * @Title:             findMrepNew
	 * @Description:     TODO 根据用户id查询用户最新的体检记录
	 * @param:             @param user_basics_id用户id
	 * @param:             @return   
	 * @return:         MedicalRecordEntity   
	 * @throws
	 */
	MedicalRecordEntity findMrepNew(int user_basics_id);
	/**
	 * 
	 * @Title:             findMrepToDate
	 * @Description:     TODO 根据一段时间范围查询用户的体检记录
	 * @param:             @param startTime 范围开始时间
	 * @param:             @param endTime  范围结束时间
	 * @param:             @param user_basics_id 用户id
	 * @param:             @return   
	 * @return:         List<MedicalRecordEntity>   
	 * @throws
	 */
	List<MedicalRecordEntity> findMrepToDate(Long startTime,Long endTime,int user_basics_id);
	/**
	 * 
	 * @Title:             findMrepToMRIds
	 * @Description:     TODO 根据多个体检记录id查询体检记录数据
	 * @param:             @param medical_record_ids //体检记录id
	 * @param:             @return   体检记录数据
	 * @return:         List<MedicalRecordEntity>   
	 * @throws
	 */
	List<MedicalRecordEntity> findMrepToMRIds(int[]medical_record_ids);//根据多个体检记录id查询体检记录数据
}
