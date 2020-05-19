package com.mrkb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.ArticleMapper;
import com.mrkb.dao.modle.article.ArticleEntity;
import com.mrkb.service.ArticleService;
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
	@Resource
	private ArticleMapper articleMapper;
 
	@Override
	public List<ArticleEntity> findAllArticle(ArticleEntity articleEntity) {
		
		return articleMapper.findAllArticle(articleEntity);
	}

	@Override
	public ArticleEntity findArticleById(ArticleEntity articleEntity) {
		
		return articleMapper.findArticleById(articleEntity);
	}

	
	
	

}

