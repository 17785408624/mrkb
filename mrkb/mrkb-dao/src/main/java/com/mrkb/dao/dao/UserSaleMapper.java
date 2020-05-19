package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.sale.UserSale;

@Mapper
public interface UserSaleMapper {
	int addUserSale(UserSale us);//添加个人业绩
	int updateUserSale(UserSale us);//修改个人业绩
	List<UserSale> findSaleDay(UserSale us);//查询日业绩
	List<UserSale> findAllUserSalsesByMonth(UserSale userSale);//根据月份查询个人销售信息
	List<UserSale> findAllUserSalsesByDays(UserSale userSale);//根据日期查询个人销售信息
}
