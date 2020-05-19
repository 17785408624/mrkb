package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.user.UserWeiXinAndInformationGrade;

@Mapper
public interface IntegralMapper {
	int addIntegralAccount(IntegralAccount integralAccount);//添加积分流水记录
	int batchInsertIntegralAccount(List<IntegralAccount> integralAccount);//批量添加积分流水记录
	/**
	 * 
	 * @Title:             findIntegraAccount
	 * @Description:     TODO 查询积分流水 可设置用户id 与流水项数据名 不设置默认查询所有积分流水
	 * @param:             @param user_basics_id 用户id
	 * @param:             @param account_option  查询的积分流水项数据名
	 * @param:             @return   流水记录实体类集合
	 * @return:         List<IntegralAccount>   
	 * @throws
	 */
	List<IntegralAccount> findIntegraAccount(@Param("user_basics_id")int user_basics_id,
			@Param("account_option")String account_option);//查询积分流水
	List<IntegralAccount> findIntegraByPage(HashMap< String, Object> map);//查询全部积分
	/**
	 * 
	 * @Title:             findUserWXIFGrade
	 * @Description:     TODO 根据用户ID查询  用户基本信息、微信信息及会员等级
	 * @param:             @param user_basics_id 用户id
	 * @param:             @param 
	 * @param:             @return   用户、微信、实名认证及会员等级查询单个用户所有信息
	 * @return:         List<IntegralAccount>   
	 * @throws
	 */
	UserWeiXinAndInformationGrade findUserWXIFGrade(int user_basics_id);//查询单个用户所有信息
}
