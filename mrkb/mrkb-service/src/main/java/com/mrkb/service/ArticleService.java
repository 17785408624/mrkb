/**
 * FileName:         SowingService.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-14     上午10:32:02
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-14     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.service;

import java.util.List;

import com.mrkb.dao.modle.article.ArticleEntity;



/**
 *@param
 *@return
 * @author liangyi
 *
 */
public interface ArticleService {
	/**
	 * 
	 * @Title:             findAllArticle
	 * @Description:     TODO 查询status=0的article信息
	 * @param:             @param articleEntity
	 * @param:             @return   
	 * @return:         List<ArticleEntity>   
	 * @throws
	 */
	List<ArticleEntity>findAllArticle(ArticleEntity articleEntity);//查询status=0的article信息
	/**
	 * 
	 * @Title:             findArticleById
	 * @Description:     TODO 根据article_id查询status=0的单个article信息
	 * @param:             @param articleEntity
	 * @param:             @return   
	 * @return:         ArticleEntity   
	 * @throws
	 */
	ArticleEntity findArticleById(ArticleEntity articleEntity);//根据article_id查询status=0的单个article信息
}
