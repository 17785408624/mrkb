package com.mrkb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.UserExpertMapper;
import com.mrkb.dao.dao.UserInformationMapper;
import com.mrkb.dao.modle.user.ExpertEntity;
import com.mrkb.service.ExpertService;

@Service
@Transactional
public class ExpertServiceImpl implements ExpertService{
	@Resource
	private UserExpertMapper userExpertMapper;
	@Resource
	private UserInformationMapper userInformationMapper;
	
	@Override
	public ExpertEntity addExpert(ExpertEntity eey) {
//		UserInformationEntity ufe=userInformationMapper.selectUserInformationEntityToUserId(eey.getUser_basics_id());
//		if(ufe==null){
//			return null;
//		}
		userExpertMapper.addExpert(eey);
		return eey;
	}

	@Override
	public List<ExpertEntity> findExpert(ExpertEntity eey) {
		List<ExpertEntity> leey=userExpertMapper.findExpert(eey);
		return leey;
	}

	@Override
	public int deleteExpert(int expert_id) {
		return userExpertMapper.deleteExpert(expert_id);
	}

	@Override
	public ExpertEntity updateExpert(ExpertEntity eey) {
		userExpertMapper.updateExpert(eey);
		return eey;
	}

}
