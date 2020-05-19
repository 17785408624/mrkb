package com.mrkb.service;

import java.util.HashMap;
import java.util.List;

import com.mrkb.dao.modle.company.CompanyMonthSales;


public interface CompanyMonthService {

	List<CompanyMonthSales> selectCompanyMonth();//查询全部
//	int settlement(HashMap<String, Object> map);//结算公司月收入
	CompanyMonthSales  selectCompanyMonthByMonth(CompanyMonthSales companyMonthSales);//按月份查询各个奖金池收入情况
}
