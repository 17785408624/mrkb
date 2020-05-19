package com.mrkb.service;

import java.util.List;

import com.mrkb.dao.modle.bankManage.BankManageEntity;


public  interface BankManageService {
	
	/**
	 * 
	 * @Title:             addBankManage
	 * @Description:     TODO 添加银行信息
	 * @param:             @param bankManageEntity 银行基本数据实体类
	 * @param:             @return   
	 * @return:            BankManageEntity   
	 * @throws
	 */
	BankManageEntity addBankManage(BankManageEntity bankManageEntity);//添加银行信息
	/**
	 * 
	 * @Title:             findAllBankManage
	 * @Description:     TODO 查询所有银行信息数据
	 * @param:             @param bankEntity 银行基本数据实体类
	 * @param:             @return   
	 * @return:           List<BankManageEntity>  
	 * @throws
	 */
	List<BankManageEntity> findAllBankManage(BankManageEntity bankManageEntity);//查询所有银行信息
	
	
	
	/**
	 * 
	 * @Title:             updateBankManage
	 * @Description:     TODO 修改银行信息
	 * @param:             @param bankManageEntity 银行基本数据实体类
	 * @param:             @return   
	 * @return:             BankManageEntity  
	 * @throws
	 */
	int updateBankManage(BankManageEntity bankManageEntity);//修改银行信息
	/**
	 * 
	 * @Title:             deleteBankManage
	 * @Description:     TODO 删除银行信息
	 * @param:             @param bankManageEntity 银行基本数据实体类
	 * @param:             @return   
	 * @return:             int  
	 * @throws
	 */
	int deleteBankManage(BankManageEntity bankManageEntity);//删除银行信息
	
	/**
	 * 
	 * @Title:             findBankManageById
	 * @Description:     TODO 查询单个银行信息
	 * @param:             @param BankManageEntity 银行基本数据实体类
	 * @param:             @return   
	 * @return:            BankManageEntity
	 */
	BankManageEntity findBankManageById(BankManageEntity bankManageEntity);//查询银行信息通过bank_id

}
