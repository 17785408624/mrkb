/**
 * FileName:         ExpertConsultService.java
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

import com.mrkb.dao.modle.expertConsult.ExpertConsultEntity;



/**
 *@param
 *@return
 * @author liangyi
 *
 */
public interface ExpertConsultService {
	/**
	 * 
	 * @Title:             findAllExpertConsult
	 * @Description:  查询所有专咨询信息   TODO
	 * @param:             @param expertConsultEntity
	 * @param:             @return   
	 * @return:         List<ExpertConsultEntity>   
	 * @throws
	 */
	List<ExpertConsultEntity> findAllExpertConsult(ExpertConsultEntity expertConsultEntity);//查询所有专咨询信息
	/**
	 * 
	 * @Title:             findExpertConsultById
	 * @Description:根据id查询专家咨询详情信息     TODO
	 * @param:             @param expertConsultEntity
	 * @param:             @return   
	 * @return:         ExpertConsultEntity   
	 * @throws
	 */
	ExpertConsultEntity  findExpertConsultById(ExpertConsultEntity expertConsultEntity);//根据id查询专家咨询详情信息
	/**
	 * 
	 * @Title:             deleteExpertConsultById
	 * @Description: 根据id修改专家咨询状态(审核状态(0.通过，1.待审核，2拒绝，3.删除))    TODO
	 * @param:             @param expertConsultEntity
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
    int deleteExpertConsultById(ExpertConsultEntity expertConsultEntity);//根据id修改专家咨询状态(审核状态(0.通过，1.待审核，2拒绝，3.删除))
    /**
     * 
     * @Title:             addExpertConsult
     * @Description:添加专家咨询信息     TODO
     * @param:             @param expertConsultEntity
     * @param:             @return   
     * @return:         int   
     * @throws
     */
    ExpertConsultEntity addExpertConsult(ExpertConsultEntity expertConsultEntity);//添加专家咨询信息
    /**
     * 
     * @Title:             updateExpertConsult
     * @Description:修改专家咨询信息     TODO
     * @param:             @param expertConsultEntity
     * @param:             @return   
     * @return:         int   
     * @throws
     */
    int updateExpertConsult(ExpertConsultEntity expertConsultEntity);//修改专家咨询信息
    /**
     * 
     * @Title:             thumbs_up
     * @Description:点赞     TODO
     * @param:             @param ExpertConsultEntity
     * @param:             @return   
     * @return:         int   
     * @throws
     */
    int thumbs_up(ExpertConsultEntity expertConsultEntity);//点赞

}
