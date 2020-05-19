package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.integr.SignIntegralEntity;

@Mapper
public interface SignIntegralMapper {
	List<SignIntegralEntity> findAllSignIntegral(SignIntegralEntity signIntegralEntity);//查询所有签到积分
    int addSignIntegral(SignIntegralEntity SignIntegralEntity);//每日签到新增积分
    SignIntegralEntity  findMaxTimeStamp(SignIntegralEntity signIntegralEntity);//获取某一用户的最大时间戳；
    
}