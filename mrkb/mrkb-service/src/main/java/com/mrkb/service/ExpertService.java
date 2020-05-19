package com.mrkb.service;

import java.util.List;

import com.mrkb.dao.modle.user.ExpertEntity;


public interface ExpertService {
	/**
     * 
     * @Title:             addExpert
     * @Description:     TODO 添加专家
     * @param:             @return   
     * @return:         int  
     * @throws
     */
	ExpertEntity addExpert(ExpertEntity eey);//添加专家
	
	/**
     * 
     * @Title:             findExpert
     * @Description:     TODO 查询专家
     * @param:             @return   
     * @return:         List<ExpertEntity>  
     * @throws
     */
	List<ExpertEntity> findExpert(ExpertEntity eey);//查询专家
	/**
     * 
     * @Title:             updateExpert
     * @Description:     TODO 修改专家
     * @param:             @return   
     * @return:         ExpertEntity
     * @throws
     */
	ExpertEntity updateExpert(ExpertEntity eey);//修改专家
	/**
     * 
     * @Title:             deleteExpert
     * @Description:     TODO 删除专家
     * @param:             @return   
     * @return:         int 
     * @throws
     */
	int deleteExpert(int expert_id);//删除专家

}
