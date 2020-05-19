package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.stock.GoodsStock;
import com.mrkb.dao.modle.stock.StoreStock;

@Mapper
public interface GoodStockMapper {

	//查询所有库存
	List<GoodsStock> findAllGoodsStock(GoodsStock stock);
	//库存录入
	Integer addGoodsStock(GoodsStock stock);
	//删除库存
	Integer updateGoodsStock(GoodsStock stock);
	//产品入库
	Integer addStoreStock(StoreStock ss);

}
