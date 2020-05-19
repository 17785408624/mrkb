/**
 * FileName:         IntegraServiceImpl.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-9     上午11:50:08
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-9     crane-yuan       1.0             1.0

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
import com.mrkb.dao.modle.account.CapitalAccount;
import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.user.UserWeiXinAndInformationGrade;
import com.mrkb.service.IntegraService;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Service
public class IntegraServiceImpl implements IntegraService{

	@Resource
	private IntegralMapper integralMapper;
	@Resource
	private CapitalAccountMapper capitalAccountMapper;
	/**
	 * 查询全部积分
	 */
	@Override
	public List<IntegralAccount> findIntegraByPage(HashMap< String, Object> map) {
		return integralMapper.findIntegraByPage(map);
	}
	/**
	 * @param
	 * @return List所有购买记录
	 */
	@Override
	public List<CapitalAccount> findCapitalAccountByPage(HashMap<String, Object> map) {
		return capitalAccountMapper.findCapitalAccountByPage(map);
	}
	/**
	 * @param
	 * @return 根据用户ID查询  用户基本信息、微信信息及会员等级
	 */
	@Override
	public UserWeiXinAndInformationGrade findUserWXIFGrade(int user_basics_id) {
		return integralMapper.findUserWXIFGrade(user_basics_id);
	}
	@Override
	public List<CapitalAccount> findCapitalOne(int to_user_basics_id) {
		
		return capitalAccountMapper.findCapitalOne(to_user_basics_id);
	}

}
