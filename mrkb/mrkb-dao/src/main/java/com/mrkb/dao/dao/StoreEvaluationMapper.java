package com.mrkb.dao.dao;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.store.StoreEvaluation;






@Mapper
public interface StoreEvaluationMapper {
	int addEvaluation(StoreEvaluation storeEvaluation);//添加评论
	StoreEvaluation findEvaluationNew(HashMap<String,Object> map);//查询最新评论
	List<StoreEvaluation> findEvaluation(HashMap<String,Object> map);//查询所有评论评论
	StoreEvaluation findEvaluationSub(HashMap<String,Object> map);//查询下级评论评论
	int deleteEvaluation(StoreEvaluation storeEvaluation);//删除评论
	int deleteStoreEvaluationById(StoreEvaluation storeEvaluation); //物理删除单条评论
	StoreEvaluation findStoreEvaluationById(StoreEvaluation storeEvaluation);//查询商品评论信息详情（单个）
    int updateStoreEvaluationState(StoreEvaluation storeEvaluation);//审核商品评论
}