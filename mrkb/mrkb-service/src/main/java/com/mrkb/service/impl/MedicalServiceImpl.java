package com.mrkb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.common.utils.publicUtil;
import com.mrkb.dao.dao.MedicalRecordMapper;
import com.mrkb.dao.dao.MedicalReportMapper;
import com.mrkb.dao.dao.UserInformationMapper;
import com.mrkb.dao.modle.medical.MedicalEntity;
import com.mrkb.dao.modle.medical.MedicalRecordEntity;
import com.mrkb.dao.modle.medical.MedicalReportEntity;
import com.mrkb.dao.modle.user.UserInformationEntity;
import com.mrkb.service.MedicalService;

@Transactional(rollbackFor = Exception.class)
@Service
public class MedicalServiceImpl implements MedicalService{
	@Resource
	UserInformationMapper userInformationMapper;
	@Resource
	MedicalReportMapper medicalReportMapper;
	@Resource
	MedicalRecordMapper medicalRecordMapper;
	/**
	 * 
	 * <p>Title: saveMedical</p >
	 * <p>Description: </p > 保存用户体检报告
	 * @param medicalEntity
	 * @param user_basics_id
	 * @return user_basics_id
	 * @see com.medicinefood.service.MedicalService#saveMedical(com.medicinefood.entity.medical.MedicalEntity, int)
	 */
	@Override
	public int saveMedical(MedicalEntity medicalEntity,int user_basics_id) {
		String timeStr=medicalEntity.getEndTime()!=null?medicalEntity.getEndTime():medicalEntity.getTime();
		Long time = null;//保存数据的时间
		if(timeStr==null){
			time=new Date().getTime();
		}else{
			time=(Long) publicUtil.dataTransform(timeStr);
		}
		MedicalReportEntity medicalReportEntity=medicalReportMapper.
				selectMedicalReportToUid(user_basics_id);//查询用户的体检报告
		MedicalReportEntity mrp=new MedicalReportEntity(medicalEntity);
		mrp.setUser_basics_id(user_basics_id);
		if(medicalReportEntity==null){//判断用户是否已存在体检报告
			mrp.setReport_add_date(time);
			medicalReportMapper.insertMedicalReport(mrp);
		}else{
			mrp.setReport_edit_date(time);
			medicalReportMapper.updateMedicalRepor(mrp);
		}
		MedicalRecordEntity mec=new MedicalRecordEntity(medicalEntity);
		mec.setUser_basics_id(user_basics_id);
		mec.setRecord_add_date(time);
		mec.setInformation_card(mec.getIdcard());
		medicalRecordMapper.insertMedicalRecord(mec);
		return user_basics_id;
	}
	@Override
	public MedicalRecordEntity findMrepNew(int user_basics_id) {
		// TODO Auto-generated method stub
		UserInformationEntity ue=userInformationMapper.
				selectUserInformationEntityToUserId(user_basics_id);//根据用户id查询用户的补充信息
		if(ue==null||ue.getInformation_card()==null){//用户暂无身份证信息
			return null;
		}
		return medicalRecordMapper.selectMrepAddDate_MaxToInfo_card(ue.getInformation_card());
	}
	@Override
	public List<MedicalRecordEntity> findMrepToDate(Long startTime,
			Long endTime, int user_basics_id) {
		// TODO Auto-generated method stub
		UserInformationEntity ue=userInformationMapper.
				selectUserInformationEntityToUserId(user_basics_id);//根据用户id查询用户的补充信息
		if(ue==null||ue.getInformation_card()==null){//用户暂无身份证信息
			return null;
		}
		return medicalRecordMapper.selectMrepToDateAndIcard(startTime, endTime, ue.getInformation_card());
	}
	@Override
	public int saveMedicalRecord(MedicalEntity medicalEntity) {
		// TODO Auto-generated method stub
		String timeStr=medicalEntity.getEndTime()!=null?medicalEntity.getEndTime():medicalEntity.getTime();
		Long time = null;//保存数据的时间
		if(timeStr==null){
			time=new Date().getTime();
		}else{
			time=(Long) publicUtil.dataTransform(timeStr);
		}
		MedicalRecordEntity mec=new MedicalRecordEntity(medicalEntity);
		mec.setInformation_card(mec.getIdcard());//身份证信息
		mec.setRecord_add_date(time);
		medicalRecordMapper.insertMedicalRecord(mec);
		return mec.getUser_basics_id();
	}
	@Override
	public List<MedicalRecordEntity> findMrepToMRIds(int[] medical_record_ids) {
		// TODO Auto-generated method stub
		return medicalRecordMapper.selectMrepToMRIds(medical_record_ids);
	}

}
