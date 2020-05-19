package com.mrkb.service;

import java.util.HashMap;
import java.util.List;

import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.dao.modle.store.StoreEvaluation;
import com.mrkb.dao.modle.store.StoreGift;
import com.mrkb.dao.modle.store.StoreGiftRecordEntity;



public interface StoreService {
	int addStoreGiftRecord(StoreGiftRecordEntity storeGiftRecordEntity);//新增课程记录//添加赠送记录
	List<StoreGift> findStoreGift(StoreGift sg);//查询套餐包含的课程
	int addStoreGift(List<StoreGift> list);//添加套餐赠送课程
	StoreEvaluation addEvaluation(StoreEvaluation storeEvaluation);
	StoreBasics addStore(StoreBasics sb);//娣诲姞鍟嗗搧淇℃伅
	StoreBasics findStoreBasics(StoreBasics sb);//鏍规嵁鍟嗗搧缂栧彿鏌ヨ鍗曚釜鍟嗗搧
	List<StoreBasics> findAllStoreBasics(StoreBasics sb);//鏌ヨ鎵�鏈夊晢鍝�
	List<StoreBasics> findAllStore(StoreBasics storeBasics);//查询所有商品
	List<StoreBasics> findPersonalStoreBasics(HashMap<String,Object> map);//鏌ヨ鎵�鏈夊晢鍝�
	int deleteStore(int store_id);//鍒犻櫎鍗曚釜鍟嗗搧淇℃伅
	int updateStore(StoreBasics sb);//淇敼鍗曚釜鍟嗗搧
	int deleteStores(int store_id);//删除单个商品信息（物理删除）
	StoreEvaluation findEvaluationNew(HashMap<String,Object> map);//鏌ヨ鏈�鏂拌瘎璁�
	List<StoreEvaluation> findEvaluation(HashMap<String,Object> map);//鏌ヨ鎵�鏈夎瘎璁鸿瘎璁�
	/**
	 * 
	 * @Title:             deleteEvaluation
	 * @Description:     TODO 鍒犻櫎璇勮
	 * @param:             @param storeEvaluation涓瘎璁篒D(evaluation_id)璧嬪��
	 * @param:             @return   
	 * @return:         int   杩斿洖鍒犻櫎鐨勬潯鏁�
	 * @throws
	 */
	int deleteEvaluation(StoreEvaluation storeEvaluation);//鍒犻櫎璇勮
	/**
	 * 
	 * @Title:             deleteEvaluation
	 * @Description:     TODO 娣诲姞璇勮
	 * @param:             @param 瀵箂toreEvaluation涓墍鏈夎祴鍊�
	 * @param:             @return   
	 * @return:         StoreEvaluation   杩斿洖娣诲姞鐨勫疄浣�
	 * @throws
	 */
	StoreEvaluation addEvaluation(StoreEvaluation storeEvaluation,HashMap<String,Object> map,StoreBasics sbs);//娣诲姞璇勮
	/**
	 * 
	 * @Title:             findCountStore
	 * @Description:     TODO
	 * @param:             @param 鍟嗗搧鐨勭被鍨媠tore_type
	 * @param:             @return   
	 * @return:         int   鍟嗗搧鐨勬�绘暟
	 * @throws
	 */
	int findCountStore(HashMap<String,Object> map);//鏌ヨ鍟嗗搧鎬绘暟
	/**
	 * 
	 * @Title:             findStoreBasicsByPage
	 * @Description:     TODO 鍒嗛〉鏌ヨ鎵�鏈夊晢鍝�
	 * @param:             @param map 鍟嗗搧绫诲瀷(store_type),璧峰琛�(end_page)
	 * @param:             @return   
	 * @return:         List<StoreBasics>   
	 * @throws
	 */
	List<StoreBasics> findStoreBasicsByPage(HashMap<String,Object> map);//鍒嗛〉鏌ヨ鎵�鏈夊晢鍝�
	int updateStoreByStatus(StoreBasics storeBasics);//鏍规嵁store_id淇敼鍟嗗搧瀹℃牳鐘舵��
	/**
	 * 
	 * @Title:             findStoreByState
	 * @Description:     TODO 鏍规嵁瀹℃牳鐘舵�佺姸鎬佷负0鏌ヨ鍟嗗搧淇℃伅
	 * @param:             @param storeBasics
	 * @param:             @return   
	 * @return:         List<StoreBasics>   
	 * @throws
	 */
	List<StoreBasics> findStoreByState(StoreBasics storeBasics);//鏍规嵁瀹℃牳鐘舵�佺姸鎬佷负0鏌ヨ鍟嗗搧淇℃伅
	StoreBasics findStoreByOne(StoreBasics storeBasics);//鏍规嵁瀹℃牳鐘舵�佺姸鎬佷负1鏌ヨ鍟嗗搧璇︽儏 
	int deleteStoreEvaluationById(StoreEvaluation storeEvaluation); //鐗╃悊鍒犻櫎鍗曟潯璇勮
	StoreEvaluation findStoreEvaluationById(StoreEvaluation storeEvaluation);//鏌ヨ鍟嗗搧璇勮淇℃伅璇︽儏锛堝崟涓級
	int updateStoreEvaluationState(StoreEvaluation storeEvaluation);//审核商品评论
}
