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

import com.mrkb.dao.modle.sowing.SowingEntity;



/**
 *@param
 *@return
 * @author liangyi
 *
 */
public interface SowingService {
	/**
	 * 
	 * @Title:             findAllSowing
	 * @Description:     TODO  查询所有轮播图信息
	 * @param:             @param sowingEntity
	 * @param:             @return   
	 * @return:         List<SowingEntity>   
	 * @throws
	 */
	List<SowingEntity> findAllSowing(SowingEntity sowingEntity);//查询所有app轮播图信息
	/**
	 * 
	 * @Title:             findSowingById
	 * @Description:     TODO 根据id查询轮播图详情信息
	 * @param:             @param sowingEntity
	 * @param:             @return   
	 * @return:         SowingEntity   
	 * @throws
	 */
	SowingEntity  findSowingById(SowingEntity sowingEntity);//根据id查询app轮播图详情信息
	
	/**
	 * 
	 * @Title:             deleteSowingById
	 * @Description:     TODO 根据id修改轮播图状态(审核状态(0.通过，1.待审核，2拒绝，3.删除))
	 * @param:             @param sowingEntity
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int deleteSowingById(SowingEntity sowingEntity);//根据id修改轮播图状态(审核状态(0.通过，1.待审核，2拒绝，3.删除))
	
	/**
	 * 
	 * @Title:             addSowing
	 * @Description:     TODO 新增轮播图信息
	 * @param:             @param sowingEntity
	 * @param:             @return   
	 * @return:         SowingEntity   
	 * @throws
	 */
	SowingEntity addSowing(SowingEntity sowingEntity);//新增轮播图信息
	/**
	 * 
	 * @Title:             updateSowing
	 * @Description:     TODO 修改轮播图
	 * @param:             @param sowingEntity
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int updateSowing(SowingEntity sowingEntity);//修改轮播图

}
