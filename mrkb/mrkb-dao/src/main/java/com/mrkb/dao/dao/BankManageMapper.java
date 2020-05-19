package com.mrkb.dao.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.bankManage.BankManageEntity;



@Mapper
public interface BankManageMapper {
	int addBankManage(BankManageEntity bankManageEntity);//添加银行信息
	List<BankManageEntity> findAllBankManage(BankManageEntity bankManageEntity);//查询所有银行信息
	BankManageEntity findBankManageById(BankManageEntity bankManageEntity);//查询银行信息通过bank_id
	int updateBankManage(BankManageEntity bankManageEntity);//修改银行信息
	int deleteBankManage(BankManageEntity bankManageEntity);//删除银行信息

}