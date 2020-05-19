/**
 * FileName:         AccountServiceImpl.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-2     上午12:04:52
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-2     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.CapitalAccountMapper;
import com.mrkb.dao.dao.IntegralMapper;
import com.mrkb.dao.dao.UserMoneyAccountMapper;
import com.mrkb.dao.modle.account.CapitalAccount;
import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.account.UserMoneyAccountEntity;
import com.mrkb.service.AccountService;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Service
public class AccountServiceImpl implements AccountService{
	@Resource
	private  CapitalAccountMapper capitalAccountMapper;
	@Resource
	private IntegralMapper integralMapper;
	@Resource
	private UserMoneyAccountMapper userMoneyAccountMapper;
	
	@Override
	public int addCapitalAccount(CapitalAccount capitalAccount) {//添加一条资金流水记录
		capitalAccountMapper.insertCapitalAccount(capitalAccount);
		return 0;
	}
	@Override
	public int addIntegralAccount(IntegralAccount integralAccount) {//添加一条积分记录
		return integralMapper.addIntegralAccount(integralAccount);
	}

	@Override
	public int batchInsertIntegralAccount(List<IntegralAccount> integralAccount) {//批量添加积分记录
		return integralMapper.batchInsertIntegralAccount(integralAccount);
	}
	/**
	 * <p>Title: findIntegraAccount</p>
	 * <p>Description: </p>
	 * @param user_basics_id
	 * @param account_option
	 * @return
	 * @see com.medicinefood.service.AccountService#findIntegraAccount(int, java.lang.String)
	 */ 
	@Override
	public List<IntegralAccount> findIntegraAccount(int user_basics_id,
			String account_option) {//查询积分流水
		return integralMapper.findIntegraAccount(user_basics_id, account_option);
	}
	/**
	 * 
	 * <p>Title: findUserMoneyAccount</p >
	 * <p>Description: </p > 查询用户余额记录表
	 * @param user_basics_id 用户id
	 * @return
	 * @see com.medicinefood.service.AccountService#findUserMoneyAccount(int)
	 */
	@Override
	public List<UserMoneyAccountEntity> findUserMoneyAccount(int user_basics_id) {
		return userMoneyAccountMapper.selectUserMoneyAccount(user_basics_id);
	}
	@Override
	public List<CapitalAccount> findCapitalCompany(HashMap<String, Object> map) {
		return capitalAccountMapper.findCapitalCompany(map);
	}

}
