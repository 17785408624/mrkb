package com.mrkb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.BankMapper;
import com.mrkb.dao.modle.bank.BankEntity;
import com.mrkb.service.BankService;

@Service
@Transactional
public class BankServiceImpl implements BankService{
	@Resource
	private BankMapper bankMapper;
	@Override
	public BankEntity addBank(BankEntity bankEntity) {
		bankMapper.addBank(bankEntity);
		return bankEntity;
	}

	@Override
	public List<BankEntity> findAllBank(BankEntity bankEntity) {
		
		return bankMapper.findAllBank(bankEntity);
	}

	@Override
	public int updateBank(BankEntity bankEntity) {
		
		return bankMapper.updateBank(bankEntity);
	}

	@Override
	public int deleteBank(BankEntity bankEntity) {
		
		return bankMapper.deleteBank(bankEntity);
	}

	@Override
	public BankEntity findBanklById(BankEntity bankEntity) {
		
		return bankMapper.findBankById(bankEntity);
	}
	

}

