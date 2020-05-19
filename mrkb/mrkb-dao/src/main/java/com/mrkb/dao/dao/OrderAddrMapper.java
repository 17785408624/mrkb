package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.order.OrderAddr;
import com.mrkb.dao.modle.store.StoreBasics;

@Mapper
public interface OrderAddrMapper {
	int addOrderAddr(OrderAddr orderAddr);//添加收货地址
	List<OrderAddr> findOrderAddr(int user_basics_id);//查询收货地址
	int updateLevel(OrderAddr orderAddr);//修改默认地址
	int updateLevel2(OrderAddr orderAddr);//修改默认地址
	int updateAddress(OrderAddr orderAddr);//修改地址
	void timesrun();
	OrderAddr findOrderAddrDef(int user_basics_id);//查询默认收货地址
	OrderAddr findOrderAddrOne(HashMap<String,Object> map);//查询单个收货地址
	int deleteOrderAddr(int address_id);//删除单个收货地址
	StoreBasics selectStoreBasicsId(int store_id);//根据商品ID查询详细信息
	
}