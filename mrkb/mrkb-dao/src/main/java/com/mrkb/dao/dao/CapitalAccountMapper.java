/**
 * FileName:         capitalAccountMapper.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-1     下午11:18:22
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-1     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.account.CapitalAccount;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Mapper
public interface CapitalAccountMapper {
	/**
	 * 
	 * @Title:             batchInsertCapitalAccount
	 * @Description:     批量添加资金流水记录
	 * @param:             @param capitalAccountList 资金流水记录的实体类集合
	 * @param:             @return   
	 * @return:         int   添加的记录条数
	 * @throws
	 */
	int batchInsertCapitalAccount(List<CapitalAccount>capitalAccountList);
	/**
	 * 
	 * @Title:             insertCapitalAccount
	 * @Description:     TODO 添加一条资金流水记录
	 * @param:             @param capitalAccount 资金流水记录实体类
	 * @param:             @return   
	 * @return:         int 记录数据id
	 * @throws
	 */
	int insertCapitalAccount(CapitalAccount capitalAccount);
	/**
	 * 
	 * @Title:             findCapitalAccountByPage
	 * @Description:     TODO 查询所有购买记录
	 * @param:             @param capitalAccount 资金流水记录实体类
	 * @param:             @return   
	 * @return:         List 查询所有
	 * @throws
	 */
	List<CapitalAccount> findCapitalAccountByPage(HashMap<String, Object> map);
	/**
	 * 
	 * @Title:             findCapitalOne
	 * @Description:     TODO 根据用户ID查询所有购买记录
	 * @param:             @param capitalAccount 资金流水记录实体类
	 * @param:             @return   
	 * @return:         List 查询所有
	 * @throws
	 */
	List<CapitalAccount> findCapitalOne(int to_user_basics_id);//根据用户ID查询所有购买记录
	/**
	 * 
	 * @Title:             findCapitalOne
	 * @Description:     TODO 公司ID查询公司购买记录
	 * @param:             @param capitalAccount 资金流水记录实体类
	 * @param:             @return   
	 * @return:         List 查询公司购买记录
	 * @throws
	 */
	List<CapitalAccount> findCapitalCompany(HashMap<String, Object> map);//公司ID查询公司或品牌大使购买记录
}
