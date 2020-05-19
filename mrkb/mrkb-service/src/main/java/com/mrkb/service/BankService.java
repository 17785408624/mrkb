package com.mrkb.service;

import java.util.List;

import com.mrkb.dao.modle.bank.BankEntity;


public  interface BankService {
	
	/**
	 * 
	 * @Title:             addBank
	 * @Description:     TODO 添加银行卡信息
	 * @param:             @param bankEntity 银行卡基本数据实体类
	 * @param:             @return   
	 * @return:            BankEntity   
	 * @throws
	 */
	 BankEntity addBank(BankEntity bankEntity);//添加银行卡信息
	/**
	 * 
	 * @Title:             findAllBank
	 * @Description:     TODO 查询所有银行卡信息数据
	 * @param:             @param bankEntity 银行卡基本数据实体类
	 * @param:             @return   
	 * @return:           List<BankEntity>   
	 * @throws
	 */
	List<BankEntity> findAllBank(BankEntity bankEntity);//查询所有银行卡信息
	
	
	
	/**
	 * 
	 * @Title:             updateBank
	 * @Description:     TODO 修改银行卡信息
	 * @param:             @param bankEntity 银行卡基本数据实体类
	 * @param:             @return   
	 * @return:             BankEntity  
	 * @throws
	 */
	int updateBank(BankEntity bankEntity);//修改银行卡信息
	/**
	 * 
	 * @Title:             deleteBank
	 * @Description:     TODO 删除银行卡信息
	 * @param:             @param bankEntity 银行卡基本数据实体类
	 * @param:             @return   
	 * @return:             int  
	 * @throws
	 */
	int deleteBank(BankEntity bankEntity);//删除银行卡信息
	
	/**
	 * 
	 * @Title:             findBanklById
	 * @Description:     TODO 查询单个银行卡信息
	 * @param:             @param bankEntity 银行卡基本数据实体类
	 * @param:             @return   
	 * @return:            BankEntity
	 */
	BankEntity findBanklById(BankEntity bankEntity);//查询单个银行卡信息

}
