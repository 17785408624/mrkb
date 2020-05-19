package com.mrkb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.GoodStockMapper;
import com.mrkb.dao.modle.stock.GoodsStock;
import com.mrkb.dao.modle.stock.StoreStock;
import com.mrkb.service.GoodStockService;



@Service
@Transactional(rollbackFor = Exception.class)
public class GoodStockServiceImpl implements GoodStockService {
	
	@Resource
	private GoodStockMapper stockMapper;

	
	//查询所有库存
	@Override
	public List<GoodsStock> findAllGoodsStock(GoodsStock stock) {
	return stockMapper.findAllGoodsStock(stock);
	}

	//库存录入
	@Override
	public Integer addGoodsStock(GoodsStock stock) {
		return stockMapper.addGoodsStock(stock);
	}

	//删除库存
	@Override
	public Integer removeStock(GoodsStock stock) {
		return stockMapper.updateGoodsStock(stock);
	}

	@Override
	public int addStoreStock(GoodsStock stock, StoreStock ss) {
		stockMapper.updateGoodsStock(stock);
		int update=stockMapper.addStoreStock(ss);
		return update;
	}

}
