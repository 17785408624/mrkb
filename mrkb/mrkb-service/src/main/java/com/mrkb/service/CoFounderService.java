/**
 * FileName:         CompanyService.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-8     下午5:05:13
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-8     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mrkb.dao.modle.company.CoFounderMonSale;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public interface CoFounderService {
	/**
	 * 
	 * @Title:             findCompanyCo
	 * @Description:     TODO HashMap<String,Object> map 
	 * 公司编号(company_id) 销售月份(month_date)
	 * @param:             @param int
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	List<CoFounderMonSale> findCompanyCo(HashMap<String,Object> map);//查询公司所有联合创办人业绩
	
	/**
	 * 
	 * @Title:             findUserTeamSubordinateIncludeOrderBasics
	 * @Description:       品牌大使查询自己及下两级销售量
	 * @param:             @param series 查询的级数
	 * @param:             @param user_basics_id 用户id
	 * @param:             @return   
	 * @return:         Map<String,List<CoFounderMonSale>> 查询用户的下2级品牌大使信息(包括自己) 
	 * @throws
	 */
	Map<String,List<CoFounderMonSale>> find2SubordinateCo(
			int series,int user_basics_id,String month_date);//查询用户的下2级品牌大使信息(包括自己)
	

}
