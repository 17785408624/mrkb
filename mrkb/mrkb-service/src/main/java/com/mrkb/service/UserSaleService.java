package com.mrkb.service;

import java.util.List;

import com.mrkb.dao.modle.sale.UserSale;


public interface UserSaleService {
	UserSale addUserSale(UserSale us);//添加个人业绩
	
	//根据日期查询个人销售信息
	List<UserSale> findAllUserSalsesByMonth(UserSale userSale);
	
}
