package com.mrkb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.BankManageMapper;
import com.mrkb.dao.modle.bankManage.BankManageEntity;
import com.mrkb.service.BankManageService;

@Service
@Transactional
public class BankManageServiceImpl implements BankManageService{
	@Resource
	private BankManageMapper bankManageMapper;

	@Override
	public BankManageEntity addBankManage(BankManageEntity bankManageEntity) {
		 
		bankManageMapper.addBankManage(bankManageEntity);
		return bankManageEntity;
	}

	@Override
	public List<BankManageEntity> findAllBankManage(
			BankManageEntity bankManageEntity) {
	
		return bankManageMapper.findAllBankManage(bankManageEntity);
	}

	@Override
	public int updateBankManage(BankManageEntity bankManageEntity) {
		
		return bankManageMapper.updateBankManage(bankManageEntity);
	}

	@Override
	public int deleteBankManage(BankManageEntity bankManageEntity) {
	
		return  bankManageMapper.deleteBankManage(bankManageEntity);
	}

	@Override
	public BankManageEntity findBankManageById(BankManageEntity bankManageEntity) {
		
		return bankManageMapper.findBankManageById(bankManageEntity);
	}
	
	

}

