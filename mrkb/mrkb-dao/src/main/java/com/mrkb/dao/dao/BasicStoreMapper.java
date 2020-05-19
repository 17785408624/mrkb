package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.dao.modle.store.StoreGift;






@Mapper
public interface BasicStoreMapper {
	int addStore(StoreBasics sb);//添加商品信息
	int addStoreGift(List<StoreGift> list);//添加套餐赠送课程
	StoreBasics findStoreBasics(int store_id);//根据商品基本条件查询商品
	List<StoreBasics> findAllStoreBasics(StoreBasics storeBasics);//根据类型查询所有商品
	List<StoreBasics> findAllStore(StoreBasics storeBasics);//查询所有商品
	List<StoreBasics> findPersonalStoreBasics(HashMap<String,Object> map);//查询所有商品
	int deleteStore(int store_id);//删除单个商品信息(逻辑删除)
	int deleteStores(int store_id);//删除单个商品信息（物理删除）
	int updateStore(StoreBasics storeBasics);//修改单个商品
	int findCountStore(HashMap<String,Object> map);//查询商品总数
	List<StoreBasics> findStoreBasicsByPage(HashMap<String,Object> map);//分页查询所有商品
	int updateStoreByStatus(StoreBasics storeBasics);//根據store_id修改商品审核状态
	List<StoreBasics> findStoreByState(StoreBasics storeBasics);//根据审核状态状态为0查询商品信息
	StoreBasics findStoreByOne(StoreBasics storeBasics);//根据审核状态状态为1查询商品详情 
	int findLetang(StoreBasics storeBasics);//查询乐唐大学所有乐唐大学课程的数量   
	List<StoreGift> findStoreGift(StoreGift sg);//查询套餐包含的课程
	List<StoreBasics> findStoreByArrayIds(@Param("store_ids")int[] idsArray);
	StoreGift findStoreGiftById(StoreGift sg);//单个套餐内容查询
	int updateStoreShelfState(StoreBasics storeBasics);//修改商品是否下架
}