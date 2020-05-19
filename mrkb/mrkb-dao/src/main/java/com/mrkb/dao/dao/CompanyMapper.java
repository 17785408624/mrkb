/**
 * FileName:         CompanyMapper.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-8     下午4:55:12
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-8     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.company.CompanyBasicsEntity;
import com.mrkb.dao.modle.company.CompanyLeadFounderEntity;
import com.mrkb.dao.modle.company.CompanyShow;
import com.mrkb.dao.modle.user.UserInformationEntity;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Mapper
public interface CompanyMapper {
	CompanyBasicsEntity findone(CompanyBasicsEntity companyBasicsEntity);//查询单个公司
	/**
	 * 
	 * @Title:             insertCompany
	 * @Description:     TODO 插入公司信息
	 * @param:             @param companyBasicsEntity 公司实体类
	 * @param:             @return   添加数据的id
	 * @return:         int   数据主键
	 * @throws
	 */
   int insertCompany(CompanyBasicsEntity companyBasicsEntity);
   /**
    * 
    * @Title:             selectCompanyShow
    * @Description:     TODO 查询前端显示公司信息所需数据
    * @param:             @param company_type 公司类型 1为总公司 2为分公司 0为查询全部类型
    * @param:             @return   
    * @return:         List<CompanyShow> 封装前端显示公司所需信息实体类集合
    * @throws
    */
   List<CompanyShow> selectCompanyShow(@Param("company_type")int company_type);//查询前端显示公司信息所需数据
   /**
    * 
    * @Title:             findAllLeadFounder
    * @Description:     TODO 查询领衔创办人的相关信息
    * @param:             @param 
    * @param:             @return   
    * @return:         List<CompanyLeadFounderEntity> 封装前端显示领衔创办人所需信息实体类集合
    * @throws
    */
   List<CompanyLeadFounderEntity> findAllLeadFounder(HashMap<String,Object> map);//查询领衔创办人的相关信息
   List<UserInformationEntity> findStatisticalUnion(HashMap<String,Object> map);//根据公司查询公司所有联合创办人数量
   List<CompanyBasicsEntity> findLv(CompanyBasicsEntity companyBasicsEntity);//根据公司等级该公司以及所在省的高级公司
   int updateCompany(CompanyBasicsEntity companyBasicsEntity);//修改公司信息
}
