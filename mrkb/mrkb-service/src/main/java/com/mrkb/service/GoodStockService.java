package com.mrkb.service;

import java.util.List;

import com.mrkb.dao.modle.stock.GoodsStock;
import com.mrkb.dao.modle.stock.StoreStock;


public interface GoodStockService {

	//查询所有库存
	List<GoodsStock> findAllGoodsStock(GoodsStock stock);
	//库存录入
	Integer addGoodsStock(GoodsStock stock);
	//删除库存
	Integer removeStock(GoodsStock stock);
	int addStoreStock(GoodsStock stock, StoreStock ss);//入库产品

}
