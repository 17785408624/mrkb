package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.store.StoreGiftRecordEntity;
/**
 * 赠送课程记录mapper
 * @author ly
 *
 */
@Mapper
public interface StoreGiftRecordMapper {
	int addStoreGiftRecord(StoreGiftRecordEntity storeGiftRecordEntity);//新增课程记录
	List<StoreGiftRecordEntity> findStoreGiftRecord(StoreGiftRecordEntity storeGiftRecordEntity);//赠送记录查询
	StoreGiftRecordEntity findStoreGiftRecordById(StoreGiftRecordEntity storeGiftRecordEntity);//查询单个课程赠送记录
}
