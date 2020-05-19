package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.account.UserMoneyAccountEntity;

@Mapper
public interface UserMoneyAccountMapper {
	int insertUserMoneyAccount(
			UserMoneyAccountEntity userMoneyAccountEntity);//插入一条用户余额的流水记录
	/**
	 * 
	 * @Title:             selectUserMoneyAccount
	 * @Description:     TODO 查询用户余额记录表
	 * @param:             @param user_basics_id 用户id
	 * @param:             @return   
	 * @return:         List<UserMoneyAccountEntity>  余额记录 
	 * @throws
	 */
	List<UserMoneyAccountEntity>selectUserMoneyAccount(int user_basics_id);//查询用户余额记录表

}
