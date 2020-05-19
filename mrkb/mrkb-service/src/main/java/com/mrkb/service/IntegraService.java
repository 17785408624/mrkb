/**
 * FileName:         IntegraService.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-9     上午11:49:48
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-9     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.service;

import java.util.HashMap;
import java.util.List;

import com.mrkb.dao.modle.account.CapitalAccount;
import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.user.UserWeiXinAndInformationGrade;


/**
 * @param
 * @return List所有积分记录
 */
public interface IntegraService {
	List<IntegralAccount> findIntegraByPage(HashMap< String, Object> map);// 查询全部积分
	/**
	 * @param
	 * @return List所有积分记录
	 */
	List<CapitalAccount> findCapitalAccountByPage(HashMap<String, Object> map);
	/**
	 * @param
	 * @return 根据用户ID查询  用户基本信息、微信信息及会员等级
	 */
	UserWeiXinAndInformationGrade findUserWXIFGrade(int user_basics_id);
	/**
	 * @param
	 * @return 根据用户ID查询所有购买记录
	 */
	List<CapitalAccount> findCapitalOne(int to_user_basics_id);
}
