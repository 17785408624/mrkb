package com.mrkb.service;

import java.util.HashMap;
import java.util.List;

import com.mrkb.dao.modle.oponion.SuggestionsOpinion;


public interface OpinionService {
	/**
	 * 
	 * @Title:             addOpinion
	 * @Description:     TODO 添加意见反馈
	 * @param:             @param suggestionsOpinion
	 * @param:             @return   
	 * @return:         SuggestionsOpinion   
	 * @throws
	 */
	SuggestionsOpinion addOpinion(SuggestionsOpinion suggestionsOpinion);//添加意见反馈
	/**
	 * 
	 * @Title:             addOpinion
	 * @Description:     TODO 查询意见反馈
	 * @param status_state 审核状态 （0运行，1待审核，2未通过，3删除）         
	 * @return:  List<SuggestionsOpinion>   
	 * @description 根据status_state查询待审核意见
	 */
	
	List<SuggestionsOpinion> findSugOpinionByStatus(HashMap<String,Object> map);//根据status_state查询待审核意见
	/**
	 * 
	 * @Title:             updateSugByStatus
	 * @Description:     TODO 更新待审核意见审核状态
	 * @param status_state:审核状态 （0运行，1待审核，2未通过，3删除）, opinion_id:意见id         
	 * @return:  List<SuggestionsOpinion>   
	 * @description 根据status_state查询待审核意见
	 */
	int updateSugByStatus(SuggestionsOpinion sug);
}
