package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.oponion.SuggestionsOpinion;

@Mapper
public interface OpinionMapper {
	int addOpinion(SuggestionsOpinion suggestionsOpinion);//添加意见反馈
	List<SuggestionsOpinion> findSugOpinionByStatus(HashMap<String,Object> map);//查询待审核意见
	int updateSugByStatus(SuggestionsOpinion sug);//更新待审核意见审核状态
}
