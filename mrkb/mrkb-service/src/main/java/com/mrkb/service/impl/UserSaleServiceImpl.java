package com.mrkb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.UserSaleMapper;
import com.mrkb.dao.modle.sale.UserSale;
import com.mrkb.service.UserSaleService;


@Transactional(rollbackFor = Exception.class)
@Service("UserSaleServiceImpl")
public class UserSaleServiceImpl implements UserSaleService{
	@Resource
	private UserSaleMapper userSaleMapper;
	
	@Override
	public UserSale addUserSale(UserSale us) {
		userSaleMapper.addUserSale(us);
		return us;
	}
	
	//根据日期查询个人销售信息
	@Override
	public List<UserSale> findAllUserSalsesByMonth(UserSale userSale) {
		return userSaleMapper.findAllUserSalsesByMonth(userSale);
	}

}
