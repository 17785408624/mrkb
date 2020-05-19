package com.mrkb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.SignIntegralMapper;
import com.mrkb.dao.modle.integr.SignIntegralEntity;
import com.mrkb.service.SignIntegralService;

@Service
@Transactional
public class SignIntegralServiceImpl implements SignIntegralService{
	@Resource
	private SignIntegralMapper signIntegralMapper;

	@Override
	public List<SignIntegralEntity> findAllSignIntegral(
			SignIntegralEntity signIntegralEntity) {
		return signIntegralMapper.findAllSignIntegral(signIntegralEntity);
	}

	@Override
	public SignIntegralEntity addSignIntegral(SignIntegralEntity signIntegralEntity) {
		signIntegralMapper.addSignIntegral(signIntegralEntity);
		return signIntegralEntity; 
	}

	@Override
	public  SignIntegralEntity findMaxTimeStamp(SignIntegralEntity signIntegralEntity) {
		
		return signIntegralMapper.findMaxTimeStamp(signIntegralEntity) ;
	}
 
	

	
	
	

}

