package com.mrkb.dao.dao;


import com.mrkb.dao.modle.store.Business;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BusinessMapper {
	int add(Business business);//添加商家
	List<Business> findAll(Business business);//查询所有银行卡信息
    Business findById(Business business);//查询银行卡信息通过card_id
	int update(Business business);//修改银行卡信息
	int delete(Business business);//删除银行卡信息

}