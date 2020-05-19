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

import com.mrkb.dao.modle.company.CompanyBasicsEntity;
import com.mrkb.dao.modle.company.CompanyShow;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public interface CompanyService {
	/**
	 * 
	 * @Title:             adminAddCoFounder
	 * @Description:     TODO HashMap<String,Object> map 
	 * 传入大使编号(user_basics_id)  公司老总编号(user_basics_id_sup)  公司编号(company_id)
	 * @param:             @param int
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int adminAddCoFounder(HashMap<String,Object> map);//添加品牌大使
	int adminUpdateCoFounder(HashMap<String,Object> map);//更改员工
	/**
	 * 
	 * @Title:             addCompany
	 * @Description:     TODO 添加公司
	 * @param:             @param companyBasicsEntity 公司基本数据实体类
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
//	int addCompany(CompanyBasicsEntity companyBasicsEntity);//添加公司
	/**
	 * 
	 * @Title:             findCompanyShow
	 * @Description:     TODO 查询前端显示公司信息所需的数据
	 * @param:             @param company_type 公司类型 1为总公司 2为分公司 0为全部公司
	 * @param:             @return   公司信息
	 * @return:         List<CompanyShow>   封装前端显示公司所需信息实体类集合
	 * @throws
	 */
//	List<CompanyShow> findCompanyShow(int company_type);//查询前端显示公司信息所需的数据
//	List<CompanyBasicsEntity> findLv(CompanyBasicsEntity companyBasicsEntity);//根据公司等级查询公司
//	CompanyBasicsEntity findone(CompanyBasicsEntity companyBasicsEntity);//查询单个公司

}
