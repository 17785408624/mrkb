package com.mrkb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mrkb.dao.modle.news.News;
import com.mrkb.dao.modle.news.NewsEvaluation;


public interface NewsService {
	News addNews(News news);//添加知识
	List<News> findNews(HashMap<String,Object> map);//查询知识
	News findNewsOne(HashMap<String,Object> map);//查看单个知识动态
	News findNewsO(int news_id);//根据ID查看单个知识动态
	int deleteNew(int news_id);//删除知识
	int readNews(HashMap<String,Object> map);//浏览
	int thumbsNews(HashMap<String,Object> map);//点赞
	List<HashMap<String,Object>> findAllEssence();//查询精华表
	List<News> findEssence(List<Integer> list);//查询精华
	int findEssenceOne(int news_id);//查询单个精华
	int addEssence(HashMap<String,Object> map);//添加精华
	int deleteEssence(News news);//删除精华
	NewsEvaluation addEssenceEvaluation(NewsEvaluation newsEvaluation);//添加精华评论
	List<NewsEvaluation> findEssenceEvaluation(NewsEvaluation newsEvaluation);//查看精华评论
	List<NewsEvaluation> findViewEvaluation(NewsEvaluation newsEvaluation);//查看视频评论
	NewsEvaluation addViewEvaluation(NewsEvaluation newsEvaluation);//添加视频评论
	int updateViewstate(News news);//修改新增首页状态
	List<NewsEvaluation> findNewsState(HashMap<String,Object> map);//查询视频状态
	int updateVideostate(NewsEvaluation news);//修改新增视频评论
	News findNewsId(Integer news_id);//根据ID查询单个信息
	NewsEvaluation findNewsEvaluationById(NewsEvaluation newsEvaluation);//查看用户评论详情信息
	int deleteNewsEvaluation(int news_evaluation_id);//删除评论信息
	NewsEvaluation findVideoEvaluationById(NewsEvaluation newsEvaluation);//查询用户视频评论详情信息
	int deleteVideoEvaluation(int news_evaluation_id);//删除用户视频评论信息
	int deleteNews(int news_id);//关联表删除首页功能news信息 
	/**
	 * 
	 * @Title:             findEssEvaluations
	 * @Description:     TODO 根据status_state=1查询首页功能审核数据列表
	 * @param:             @param NewsEvaluation 评论审核基本数据实体类
	 * @param:             @return   
	 * @return:            NewsEvaluation   
	 * @throws
	 */
	List<NewsEvaluation> findEssEvaluations(NewsEvaluation newsEvaluation);
	/**
	 * 
	 * @Title:             updateNewsEvaluationByState
	 * @Description:     TODO //更新审核首页功能，审核中数据 news_evaluation_id,status_state(0运行，1待审核，2未通过，3删除)
	 * @param:             @param NewsEvaluation 评论审核基本数据实体类
	 * @param:             @return   
	 * @return:            int   
	 * @throws
	 */
	int updateNewsEvaluationByState(NewsEvaluation newsEvaluation);
	/**
	 * 
	 * @Title:             findNewsByState
	 * @Description:     TODO 根据审核状态为0查看知识动态
	 * @param:             @param news
	 * @param:             @return   
	 * @return:         List<News>   
	 * @throws
	 */
	List<News> findNewsByState(News news);//根据审核状态为0查看知识动态 
	int updateNews(News news);//修改知识动态
	
	
	
	
	/**
	 * 根据ID查询首页轮播图详细
	 */
	Map<String, Object> findIndexDetailStoreById(Integer news_id);
	
}
