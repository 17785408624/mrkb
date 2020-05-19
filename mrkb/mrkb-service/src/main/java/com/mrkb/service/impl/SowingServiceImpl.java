package com.mrkb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.SowingMapper;
import com.mrkb.dao.modle.sowing.SowingEntity;
import com.mrkb.service.SowingService;

@Service
@Transactional
public class SowingServiceImpl implements SowingService{
	@Resource
	private SowingMapper sowingMapper;
 
	@Override
	public List<SowingEntity> findAllSowing(SowingEntity sowingEntity) {
		
		return sowingMapper.findAllSowing(sowingEntity);
	}

	@Override
	public SowingEntity findSowingById(SowingEntity sowingEntity) {
		return sowingMapper.findSowingById(sowingEntity);
	}

	@Override
	public int deleteSowingById(SowingEntity sowingEntity) {
	
		return sowingMapper.deleteSowingById(sowingEntity);
	}

	@Override
	public SowingEntity addSowing(SowingEntity sowingEntity) {
		sowingMapper.addSowing(sowingEntity);
		return sowingEntity;
	}

	@Override
	public int updateSowing(SowingEntity sowingEntity) {
		
		return sowingMapper.updateSowing(sowingEntity);
	}
	
	

}

