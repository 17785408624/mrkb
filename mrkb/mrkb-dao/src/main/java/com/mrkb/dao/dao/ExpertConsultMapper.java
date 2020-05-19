package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.expertConsult.ExpertConsultEntity;





@Mapper
public interface ExpertConsultMapper {
	List<ExpertConsultEntity> findAllExpertConsult(ExpertConsultEntity expertConsultEntity);//查询所有专咨询信息
	ExpertConsultEntity  findExpertConsultById(ExpertConsultEntity expertConsultEntity);//根据id查询专家咨询详情信息
    int deleteExpertConsultById(ExpertConsultEntity expertConsultEntity);//根据id修改专家咨询状态(审核状态(0.通过，1.待审核，2拒绝，3.删除))
    int addExpertConsult(ExpertConsultEntity expertConsultEntity);//添加专家咨询信息
    int updateExpertConsult(ExpertConsultEntity expertConsultEntity);//修改专家咨询信息
    int thumbs_up(ExpertConsultEntity expertConsultEntity);//点赞

}