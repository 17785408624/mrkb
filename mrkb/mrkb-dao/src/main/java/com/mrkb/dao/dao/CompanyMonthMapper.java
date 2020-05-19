package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.company.CompanyMonthSales;

@Mapper
public interface CompanyMonthMapper {
	CompanyMonthSales findMonthSalesOne(CompanyMonthSales companyMonthSales);//查询对应日期的销售量是否存在
	List<CompanyMonthSales> selectCompanyMonth();//查询全部
	List<CompanyMonthSales> selectCompanyMonthone(HashMap<String, Object> map);//查询全部
	int insertCompanyMonth(CompanyMonthSales company);//添加
	int updateCompanyMonth(CompanyMonthSales company);//修改
	int updateCompanyCompany(HashMap<String, Object> map);//修改公司总金额
	CompanyMonthSales findsuper(HashMap<String, Object> map);
	CompanyMonthSales selectCompanyMonthByMonth(CompanyMonthSales companyMonthSales);//按月份及company_id查询各个奖金池收入情况
}
