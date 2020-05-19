/**
 * FileName:         AccountService.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-2     上午12:05:06
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-2     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.account.CapitalAccount;
import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.account.UserMoneyAccountEntity;



/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public interface AccountService {
	/**
	 * 
	 * @Title:             addCapitalAccount
	 * @Description:     TODO 添加一条资金流水记录
	 * @param:             @param capitalAccount 资金流水记录实体类
	 * @param:             @return   
	 * @return:         int   记录id
	 * @throws
	 */
	int addCapitalAccount(CapitalAccount capitalAccount);
	/**
	 * 
	 * @Title:             addIntegralAccount
	 * @Description:     TODO 添加一条积分流水记录
	 * @param:             @param IntegralAccount 积分流水记录实体类
	 * @param:             @return   
	 * @return:         int   记录id
	 * @throws
	 */
	int addIntegralAccount(IntegralAccount integralAccount);
	/**
	 * 
	 * @Title:             addIntegralAccount
	 * @Description:     TODO 批量添加积分流水记录
	 * @param:             @param IntegralAccount 积分流水记录实体类
	 * @param:             @return   
	 * @return:         int   记录id
	 * @throws
	 */
	int batchInsertIntegralAccount(List<IntegralAccount> integralAccount);
	/**
	 * 
	 * @Title:             findIntegraAccount
	 * @Description:     TODO 查询积分流水  可设置用户id 与流水项数据名 不设置默认查询所有积分流水
	 * @param:             @param user_basics_id 用户id
	 * @param:             @param account_option 流水的积分数据名
	 * @param:             @return  积分流水
	 * @return:         List<IntegralAccount> 积分流水实体类集合   
	 * @throws
	 */
	List<IntegralAccount> findIntegraAccount(int user_basics_id,String account_option);//查询用户积分流水
	/**
	 * 
	 * @Title:             findUserMoneyAccount
	 * @Description:     TODO 查询用户余额记录表
	 * @param:             @param user_basics_id 用户id
	 * @param:             @return   
	 * @return:         List<UserMoneyAccountEntity>   用户余额流水
	 * @throws
	 */
	List<UserMoneyAccountEntity>findUserMoneyAccount(int user_basics_id);//查询用户余额记录表
	/**
	 * 
	 * @Title:             findCapitalOne
	 * @Description:     TODO 公司ID查询公司 或品牌大使购买记录
	 * @param:             @param capitalAccount 资金流水记录实体类
	 * @param:             @return   
	 * @return:         List 查询公司购买记录
	 * @throws
	 */
	List<CapitalAccount> findCapitalCompany(HashMap<String, Object> map);//公司ID查询公司或品牌大使购买记录
	

}
