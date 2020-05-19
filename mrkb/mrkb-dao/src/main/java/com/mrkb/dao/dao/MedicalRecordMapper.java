package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.medical.MedicalRecordEntity;

@Mapper
public interface MedicalRecordMapper {
	/**
	 * 
	 * @Title:             insertMedicalRecord
	 * @Description:     TODO 插入一条用户的体检记录数据
	 * @param:             @param medicalRecordEntity 体检记录实体类
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int insertMedicalRecord(MedicalRecordEntity medicalRecordEntity);
	/**
	 * 
	 * @Title:             selectMedicalRecordAddDate_Max
	 * @Description:     TODO 查询用户添加时间值是最大的一条数据
	 * @param:             @param user_basics_id 用户id
	 * @param:             @return   
	 * @return:         MedicalRecordEntity 体检记录  
	 * @throws
	 */
	MedicalRecordEntity selectMrepAddDate_Max(int user_basics_id);
	/**
	 * 
	 * @Title:             selectMrepAddDate_MaxToInfo_card
	 * @Description:     TODO 查询用户添加时间值是最大的一条数据
	 * @param:             @param information_card 用户身份证号
	 * @param:             @return   
	 * @return:         MedicalRecordEntity   
	 * @throws
	 */
	MedicalRecordEntity selectMrepAddDate_MaxToInfo_card(String information_card);
	/**
	 * 
	 * @Title:             selectMrepToDate
	 * @Description:     TODO 根据时间范围和用户id查询体检记录数据
	 * @param:             @param startTime 时间范围(开始时间)
	 * @param:             @param endTime 时间范围(结束的时间)
	 * @param:             @param user_baiscs_id 用户id
	 * @param:             @return   
	 * @return:         MedicalRecordEntity 体检记录实体类  
	 * @throws
	 */
	List<MedicalRecordEntity> selectMrepToDateAndUid(@Param("startTime")Long startTime,
			@Param("endTime")Long endTime,@Param("user_baiscs_id")int user_baiscs_id);//根据时间范围和用户id查询体检记录数据
	/**
	 * 
	 * @Title:             selectMrepToDateAndIcard
	 * @Description:     TODO 根据时间范围和用户身份证号码查询体检记录数据
	 * @param:             @param startTime 时间范围(开始时间)
	 * @param:             @param endTime 时间范围(结束的时间)
	 * @param:             @param information_card 用户身份证号码
	 * @param:             @return   
	 * @return:         List<MedicalRecordEntity>   
	 * @throws
	 */
	List<MedicalRecordEntity> selectMrepToDateAndIcard(@Param("startTime")Long startTime,
			@Param("endTime")Long endTime,@Param("information_card")String information_card);//根据时间范围和用户身份证号码查询体检记录数据
	List<MedicalRecordEntity> selectMrepToMRIds(int[]medical_record_ids);
	

}
