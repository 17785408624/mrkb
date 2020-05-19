package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.article.ArticleEntity;

@Mapper
public interface ArticleMapper {
	List<ArticleEntity>findAllArticle(ArticleEntity articleEntity);//查询status=0的article信息
	ArticleEntity findArticleById(ArticleEntity articleEntity);//根据article_id查询status=0的单个article信息
}