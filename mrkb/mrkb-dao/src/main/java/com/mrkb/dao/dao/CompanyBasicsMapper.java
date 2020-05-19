package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.company.CompanyBasicsEntity;

@Mapper
public interface CompanyBasicsMapper {

	/**
	 * 修改公司状态
	 * 实体类：CompanyBasicsEntity
	 * @return
	 */
	int updateCompanyBasicsState(CompanyBasicsEntity companyBasics);//修改公司状态
	/**
	 * 查询公司状态
	 * 实体类：CompanyBasicsEntity
	 */
	List<CompanyBasicsEntity> findCompanyBasicsmp(HashMap<String, Object> map);//查询公司状态
	/**
	 * 查询单个公司
	 * 实体类：CompanyBasicsEntity
	 */
	CompanyBasicsEntity findCompanyOne(int company_id);//查询公司状态
	/**
	 *移除公司
	 * 实体类：CompanyBasicsEntity
	 * @return
	 */
	int updateCompanyBasics(CompanyBasicsEntity companyBasics);//修改公司状态
    int updateCompanyBasicsAgree(CompanyBasicsEntity companyBasics);//同意公司申请
	/**
	 * 移除公司修改用户补充表相关字段
	 * 实体类：CompanyBasicsEntity
	 * @return
	 */
	int updateuserinformation (CompanyBasicsEntity companyBasics);//修改公司状态
	int addCompany(CompanyBasicsEntity companyBasicsEntity);//添加公司
}
