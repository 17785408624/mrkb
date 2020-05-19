package com.mrkb.dao.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.store.StoreGiftMemberChangEntity;

@Mapper
public interface StoreGiftMemberChangeMapper {
	//新增课程赠送名额变更信息
	int addStoreGiftMemberChange(StoreGiftMemberChangEntity storeGiftMemberChangEntity);
	//修改课程赠送名额变更信息
	int updateStoreGiftMemberChange(StoreGiftMemberChangEntity storeGiftMemberChangEntity);
	//查询单个课程赠送名额变更信息
	StoreGiftMemberChangEntity findStoreGiftMemberChangeById(StoreGiftMemberChangEntity storeGiftMemberChangEntity);
}
