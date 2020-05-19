package com.mrkb.service;

import java.util.HashMap;
import java.util.List;

import com.mrkb.dao.modle.order.OrderAddr;


public interface OrderAddrService {
	OrderAddr addOrderAddr(OrderAddr orderAddr);//添加收货地址
	List<OrderAddr> findOrderAddr(int user_basics_id);//查询收货地址
	OrderAddr updateLevel(OrderAddr orderAddr);//修改默认地址
	OrderAddr updateAddress(OrderAddr orderAddr);//修改地址
	void timesrun();
	OrderAddr findOrderAddrDef(int user_basics_id);//查询默认收货地址
	OrderAddr findOrderAddrOne(HashMap<String,Object> map);//查询单个收货地址
	int deleteOrderAddr(int address_id);//删除单个收货地址

}
