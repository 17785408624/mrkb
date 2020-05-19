package com.mrkb.service.impl;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.BasicStoreMapper;
import com.mrkb.dao.dao.OrderMapper;
import com.mrkb.dao.dao.StoreEvaluationMapper;
import com.mrkb.dao.dao.StoreGiftRecordMapper;
import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.dao.modle.store.StoreEvaluation;
import com.mrkb.dao.modle.store.StoreGift;
import com.mrkb.dao.modle.store.StoreGiftRecordEntity;
import com.mrkb.service.StoreService;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {
	@Resource
	private BasicStoreMapper basicStoreMapper;
	@Resource
	private StoreEvaluationMapper storeEvaluationMapper;
	@Resource
	private OrderMapper basicOrderMapper;
	@Resource
	private StoreGiftRecordMapper storeGiftRecordMapper;
	
	public StoreBasics addStore(StoreBasics sb) {
		basicStoreMapper.addStore(sb);
		return sb;
	}
	@Override
	public List<StoreBasics> findStoreBasicsByPage(HashMap<String, Object> map) {
		return basicStoreMapper.findStoreBasicsByPage(map);
	}
	public StoreBasics findStoreBasics(StoreBasics sb) {
		int store_id=sb.getStore_id();
		return basicStoreMapper.findStoreBasics(store_id);
	}
	@Override
	public int findCountStore(HashMap<String,Object> map) {
		return basicStoreMapper.findCountStore(map);
	}
	public List<StoreBasics> findAllStoreBasics(StoreBasics storeBasics) {
		return basicStoreMapper.findAllStoreBasics(storeBasics);
	}
	public List<StoreBasics> findAllStore(StoreBasics storeBasics) {
		return basicStoreMapper.findAllStore(storeBasics);
	}
	public int deleteStore(int store_id) {
		return basicStoreMapper.deleteStore(store_id);
	}

	@Override
	public List<StoreBasics> findPersonalStoreBasics(HashMap<String, Object> map) {
		return basicStoreMapper.findPersonalStoreBasics(map);
	}

	@Override
	public int updateStore(StoreBasics sb) {
		return basicStoreMapper.updateStore(sb);
	}

	@Override
	public StoreEvaluation findEvaluationNew(HashMap<String, Object> map) {
		return storeEvaluationMapper.findEvaluationNew(map);
	}

	@Override
	public List<StoreEvaluation> findEvaluation(HashMap<String, Object> map) {
		return storeEvaluationMapper.findEvaluation(map);
	}
	@Override
	public int deleteEvaluation(StoreEvaluation storeEvaluation) {
		return storeEvaluationMapper.deleteEvaluation(storeEvaluation);
	}
	@Override
	public StoreEvaluation addEvaluation(StoreEvaluation storeEvaluation,
			HashMap<String, Object> map, StoreBasics sbs) {
		//basicOrderMapper.updateOrderOne(map);
		int store_id=sbs.getStore_id();
		StoreBasics sb=basicStoreMapper.findStoreBasics(store_id);
		String store_name=sb.getStore_name();
		storeEvaluation.setStore_name(store_name);
		storeEvaluationMapper.addEvaluation(storeEvaluation);
		return storeEvaluation;
	}
	@Override
	public StoreEvaluation addEvaluation(StoreEvaluation storeEvaluation) {
		storeEvaluationMapper.addEvaluation(storeEvaluation);
		return storeEvaluation;
	}
	@Override
	public int updateStoreByStatus(StoreBasics storeBasics) {
		return basicStoreMapper.updateStoreByStatus(storeBasics);
	}
	@Override
	public List<StoreBasics> findStoreByState(StoreBasics storeBasics) {
		return basicStoreMapper.findStoreByState(storeBasics);
	}
	@Override
	public StoreBasics findStoreByOne(StoreBasics storeBasics) {
		return basicStoreMapper.findStoreByOne(storeBasics);
	}
	@Override
	public int deleteStoreEvaluationById(StoreEvaluation storeEvaluation) {
		return storeEvaluationMapper.deleteStoreEvaluationById(storeEvaluation);
	}
	@Override
	public StoreEvaluation findStoreEvaluationById(
			StoreEvaluation storeEvaluation) {
		return storeEvaluationMapper.findStoreEvaluationById(storeEvaluation);
	}
	@Override
	public int deleteStores(int store_id) {
		return basicStoreMapper.deleteStores(store_id);
	}
	@Override
	public int updateStoreEvaluationState(StoreEvaluation storeEvaluation) {
		return storeEvaluationMapper.updateStoreEvaluationState(storeEvaluation);
	}
	@Override
	public List<StoreGift> findStoreGift(StoreGift sg) {
		return basicStoreMapper.findStoreGift(sg);
	}
	@Override
	public int addStoreGift(List<StoreGift> list) {
		System.out.println(list);
		return basicStoreMapper.addStoreGift(list);
	}
	@Override
	public int addStoreGiftRecord(StoreGiftRecordEntity storeGiftRecordEntity) {
		return	storeGiftRecordMapper.addStoreGiftRecord(storeGiftRecordEntity);
	}



}
