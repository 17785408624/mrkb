package com.mrkb.service.impl;




import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.OrderAddrMapper;
import com.mrkb.dao.modle.order.OrderAddr;
import com.mrkb.service.OrderAddrService;

@Service
@Transactional
public class OrderAddrServiceImpl implements OrderAddrService {
	@Resource
	private OrderAddrMapper orderAddrMapper;

	@Override
	public OrderAddr addOrderAddr(OrderAddr orderAddr) {
		orderAddrMapper.addOrderAddr(orderAddr);
		return orderAddr;
	}

	@Override
	public List<OrderAddr> findOrderAddr(int user_basics_id) {
		return orderAddrMapper.findOrderAddr(user_basics_id);
	}

	@Override
	public OrderAddr updateLevel(OrderAddr orderAddr) {
		orderAddrMapper.updateLevel(orderAddr);
		orderAddrMapper.updateLevel2(orderAddr);
		return orderAddr;
	}


	@Override
	public OrderAddr updateAddress(OrderAddr orderAddr) {
		orderAddrMapper.updateAddress(orderAddr);
		return  orderAddr;
	}



	@Override
	public void timesrun() {
		System.out.println("定时器2");
		
	}

	@Override
	public OrderAddr findOrderAddrDef(int user_basics_id) {
		return orderAddrMapper.findOrderAddrDef(user_basics_id);
	}

	@Override
	public OrderAddr findOrderAddrOne(HashMap<String, Object> map) {
		return orderAddrMapper.findOrderAddrOne(map);
	}

	@Override
	public int deleteOrderAddr(int address_id) {
		return orderAddrMapper.deleteOrderAddr(address_id);
	} 
	
}
