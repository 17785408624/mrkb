package com.mrkb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.ConverFlowMapper;
import com.mrkb.dao.modle.user.ConverFlow;
import com.mrkb.service.ConverFlowService;

@Service
@Transactional
public class ConverFlowServiceImpl implements ConverFlowService{
	@Resource
	private ConverFlowMapper converFlowMapper;
	
	
	@Override
	public ConverFlow addConverFlow(ConverFlow cf) {
		int conver_id=converFlowMapper.addConverFlow(cf);
		cf.setConver_id(conver_id);
		return cf;
				
	}

}
