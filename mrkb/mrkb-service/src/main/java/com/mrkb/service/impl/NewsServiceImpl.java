package com.mrkb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.NewsMapper;
import com.mrkb.dao.modle.news.News;
import com.mrkb.dao.modle.news.NewsEvaluation;
import com.mrkb.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl implements NewsService{
	@Resource
	private NewsMapper newsMapper;
	@Override
	public News addNews(News news) {
		newsMapper.addNews(news);
		
		return news;
	}
	@Override
	public List<News> findNews(HashMap<String,Object> map) {
		return newsMapper.findNews(map);
	}
	@Override
	public News findNewsOne(HashMap<String, Object> map) {
		return newsMapper.findNewsOne(map);
	}
	@Override
	public int deleteNew(int news_id) {
		return newsMapper.deleteNew(news_id);
	}
	@Override
	public int readNews(HashMap<String, Object> map) {
		return newsMapper.readNews(map);
	}
	@Override
	public int thumbsNews(HashMap<String, Object> map) {
		return newsMapper.thumbsNews(map);
	}
	@Override
	public List<HashMap<String, Object>> findAllEssence() {
		return newsMapper.findAllEssence();
	}
	@Override
	public List<News> findEssence(List<Integer> list) {
		return newsMapper.findEssence(list);
	}
	@Override
	public int addEssence(HashMap<String, Object> map) {
		return newsMapper.addEssence(map);
	}
	@Override
	public int deleteEssence(News news) {
		return newsMapper.deleteEssence(news);
	}
	@Override
	public NewsEvaluation addEssenceEvaluation(NewsEvaluation newsEvaluation) {
		newsMapper.addEssenceEvaluation(newsEvaluation);
		return newsEvaluation;
	}
	@Override
	public List<NewsEvaluation> findEssenceEvaluation(NewsEvaluation newsEvaluation) {
		return newsMapper.findEssenceEvaluation(newsEvaluation);
	}
	@Override
	public News findNewsO(int news_id) {
		return newsMapper.findNewsO(news_id);
	}
	@Override
	public List<NewsEvaluation> findViewEvaluation(NewsEvaluation newsEvaluation) {
		return newsMapper.findViewEvaluation(newsEvaluation);
	}
	@Override
	public NewsEvaluation addViewEvaluation(NewsEvaluation newsEvaluation) {
		 newsMapper.addViewEvaluation(newsEvaluation);
		 return newsEvaluation;
	}
	@Override
	public int findEssenceOne(int news_id) {
		return newsMapper.findEssenceOne(news_id);
	}
	@Override
	public int updateViewstate(News news) {
		
		return newsMapper.updateViewstate(news);
	}
	@Override
	public List<NewsEvaluation> findNewsState(HashMap<String,Object> map) {
		
		return newsMapper.findNewsState(map);
	}
	@Override
	public int updateVideostate(NewsEvaluation news) {
		
		return newsMapper.updateVideostate(news);
	}
	@Override
	public News findNewsId(Integer news_id) {
		return newsMapper.findNewsId(news_id);
	}
	@Override
	public List<NewsEvaluation> findEssEvaluations(NewsEvaluation newsEvaluation) {
		
		return newsMapper.findEssEvaluations(newsEvaluation);
	}
	@Override
	public int updateNewsEvaluationByState(NewsEvaluation newsEvaluation) {

		return newsMapper.updateNewsEvaluationByState(newsEvaluation);
	}
	@Override
	public List<News> findNewsByState(News news) {
		
		return newsMapper.findNewsByState(news);
	}
	@Override
	public int updateNews(News news) {
		return newsMapper.updateNews(news);
	}
	@Override
	public NewsEvaluation findNewsEvaluationById(NewsEvaluation newsEvaluation) {
		return newsMapper.findNewsEvaluationById(newsEvaluation);
	}
	@Override
	public int deleteNewsEvaluation(int news_evaluation_id) {
		
		return newsMapper.deleteNewsEvaluation(news_evaluation_id);
	}
	@Override
	public NewsEvaluation findVideoEvaluationById(NewsEvaluation newsEvaluation) {
		return newsMapper.findVideoEvaluationById(newsEvaluation);
	}
	@Override
	public int deleteVideoEvaluation(int news_evaluation_id) {
		return newsMapper.deleteVideoEvaluation(news_evaluation_id);
	}
	@Override
	public int deleteNews(int news_id) {
		return newsMapper.deleteNews(news_id);
	}
	/**
	 * 根据ID查询首页轮播图详细
	 */
	public Map<String, Object> findIndexDetailStoreById(Integer news_id) {
		return newsMapper.findIndexDetailStoreById(news_id);
	}

}