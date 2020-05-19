package com.mrkb.service;

import java.util.HashMap;
import java.util.List;

import com.mrkb.dao.modle.company.CompanyBasicsEntity;
import com.mrkb.dao.modle.company.CompanyLeadFounderEntity;


public interface CompanyBasicsService {

	/**
	 * 修改公司状态
	 * 实体类：CompanyBasicsEntity
	 * @return
	 */
	int updateCompanyBasicsState(CompanyBasicsEntity companyBasics);//修改公司状态
	int updateCompanyBasicsAgree(CompanyBasicsEntity companyBasics);//同意公司申请
	/**
	 * 查询公司状态
	 * 实体类：CompanyBasicsEntity
	 */
	List<CompanyBasicsEntity> findCompanyBasics(HashMap<String, Object> map);//查询公司状态
	/**
	 * 移除公司,修改用户补充表相关字段
	 * 实体类：CompanyBasicsEntity
	 */
	CompanyBasicsEntity upComBasicsAnduinformation(CompanyBasicsEntity companyBasics);
	/**
	 * 添加分公司，将领衔创办人下面所有用户分配到新公司
	 * @param CompanyBasicsEntity 需要传入公司实体
	 * @return 添加的公司数量（只有0和1），0未成功,1成功添加了公司。
	 */
	int addCompany(CompanyBasicsEntity companyBasicsEntity);//添加公司
	/**
	 * 查询领衔创办人的相关信息
	 * @param CompanyBasicsEntity month_date 销售月份  
	 * @return List<CompanyLeadFounderEntity>
	 */
	List<CompanyLeadFounderEntity> findAllLeadFounder(HashMap<String,Object> map);//查询领衔创办人的相关信息
}
