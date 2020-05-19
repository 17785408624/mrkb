package com.mrkb.dao.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.medical.MedicalReportEntity;
@Mapper
public interface MedicalReportMapper {
	/**
	 * 
	 * @Title:             insertMedicalReport
	 * @Description:     TODO 插入用户体检报告数据
	 * @param:             @param medicalReportEntity
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int insertMedicalReport(MedicalReportEntity medicalReportEntity);
	/**
	 * 
	 * @Title:             selectMedicalReportToUid
	 * @Description:     TODO通过用户id查询用户的体检记录信息
	 * @param:             @param user_basics_id 用户id
	 * @param:             @return   
	 * @return:         MedicalReportEntity   体检信息实体类
	 * @throws
	 */
	MedicalReportEntity selectMedicalReportToUid(int user_basics_id);//通过用户id查询用户的体检记录信息
	/**
	 * 
	 * @Title:             updateMedicalRepor
	 * @Description:     TODO 更新用户体检报告数据
	 * @param:             @param medicalReportEntity
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int updateMedicalRepor(MedicalReportEntity medicalReportEntity);
	

}
