package com.mrkb.dao.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.bank.BankEntity;



@Mapper
public interface BankMapper {
	int addBank(BankEntity bankEntity);//添加银行卡信息
	List<BankEntity> findAllBank(BankEntity bankEntity);//查询所有银行卡信息
	BankEntity findBankById(BankEntity bankEntity);//查询银行卡信息通过card_id
	int updateBank(BankEntity bankEntity);//修改银行卡信息
	int deleteBank(BankEntity bankEntity);//删除银行卡信息

}