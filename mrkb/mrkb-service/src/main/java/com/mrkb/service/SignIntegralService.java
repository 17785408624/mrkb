/**
 * FileName:         SignIntegralService.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-10-25     上午14:40:02
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

import com.mrkb.dao.modle.integr.SignIntegralEntity;



/**
 *@param
 *@return
 * @author liangyi
 *
 */
public interface SignIntegralService {
	/**
	 * 
	 * @Title:             findAllSignIntegral
	 * @Description:      查询所有签到积分列表信息
	 * @param:             @param signIntegralEntity
	 * @param:             @return   
	 * @return:         List<SignIntegralEntity>   
	 * @throws
	 */
	List<SignIntegralEntity> findAllSignIntegral(SignIntegralEntity signIntegralEntity);//查询所有签到积分
	/**
	 * 
	 * @Title:             addSignIntegral
	 * @Description:        新增每日签到积分记录
	 * @param:             @param SignIntegralEntity
	 * @param:             @return   
	 * @return:         SignIntegralEntity   
	 * @throws
	 */
	SignIntegralEntity addSignIntegral(SignIntegralEntity signIntegralEntity);//每日签到新增积分
	
	
	 
	 
	SignIntegralEntity findMaxTimeStamp(SignIntegralEntity signIntegralEntity);//获取某一用户的最大时间戳；

}
