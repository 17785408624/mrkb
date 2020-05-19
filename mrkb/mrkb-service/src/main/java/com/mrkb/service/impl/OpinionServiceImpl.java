package com.mrkb.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.OpinionMapper;
import com.mrkb.dao.modle.oponion.SuggestionsOpinion;
import com.mrkb.service.OpinionService;


@Service
@Transactional
public class OpinionServiceImpl implements OpinionService{
	@Resource
	private OpinionMapper opinionMapper;//
	
	@Override
	public SuggestionsOpinion addOpinion(SuggestionsOpinion suggestionsOpinion) {
		 opinionMapper.addOpinion(suggestionsOpinion);
		 return suggestionsOpinion;
	}
    /*查询待审核意见*/
	@Override
	public List<SuggestionsOpinion> findSugOpinionByStatus(
			HashMap<String, Object> map) {
		
		return opinionMapper.findSugOpinionByStatus(map);
	}
    /*更新待审核意见审核状态*/
	@Override
	public int updateSugByStatus(SuggestionsOpinion sug) {
		return opinionMapper.updateSugByStatus(sug);
	}

}
