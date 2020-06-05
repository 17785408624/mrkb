package com.mrkb.service;

import java.util.HashMap;
import java.util.List;

import com.mrkb.dao.modle.order.*;
import org.apache.ibatis.annotations.Param;
import org.dom4j.DocumentException;

import com.mrkb.dao.modle.store.StoreBasics;


public interface OrderService {
	
	int[] updateFinishOrder(int order_id) throws DocumentException;//完成订单
	int updateReStore(HashMap<String,Object> ormap,HashMap<String,Object> remap);//同意退款货
	int updateReMoney(HashMap<String,Object> ormap,HashMap<String,Object> remap);//同意退款
	OrderRestore addRestore(OrderRestore or,HashMap<String,Object> map);//申请退货
	OrderSupplement findOrderSup(int order_id);//查询订单补充信息
	OrderBasics addOrder(OrderBasics ob,HashMap<String,Object> map);//添加订单
	List<HashMap<String, Object>> findOrderAll(HashMap<String,Object> map);//查看某人所有订单
	List<HashMap<String, Object>> findOrder(HashMap<String,Object> map);//查看订单
	int deleteOrder(HashMap<String,Integer> map);//删除单个订单
	int updateOrderOne(HashMap<String,Object> map);//修改单个订单
	OrderBasics findOrderOne(HashMap<String,Object> map);//查询单个订单
	StoreBasics findStoreBasics(int store_id);//查询单个订单
	int findOrderTiyan(HashMap<String,Object> map);//查询某用户是否已购买体验会员装
	OrderRefund refund(HashMap<String,Object> map,OrderRefund orderRefund);//申请退款
	OrderRefund findRefundOne(HashMap<String,Object> map);//查看申请退款
	OrderRestore findReStoreOne(HashMap<String,Object> map);//查看申请退货
	List<HashMap<String,Object>> adminFindAllStoreBasicsByPage(int a);//后台查询所有订单
	StoreBasics selectStoreBasicsId(int store_id);//根据商品ID查询详细信息
	
	/**
	 * 
	 * @Title:             CheckOrderTime
	 * @Description:     查询超过收货时间还未确认收货的订单的订单
	 * @param:   pointInTime     
	 * @return:         OrderBasics   
	 * @throws
	 */
	List<OrderBasics> CheckOrderTime();
	/**
	 * 
	 * @Title:             datedOrderReceive
	 * @Description:     超过时间未点收货的订单改为已收货，并添加资金流水记录
	 * @param:             @return   
	 * @return:         int 添加的流水数量  
	 * @throws
	 */
	int getMoney(OrderBasics ob);//确认收款
	int datedOrderReceive();
	/**
	 * 
	 * @Title:             sendStore 发货
	 * @Description:     TODO 
	 * @param:             @param map  发货时间，已发送状态，order_id
	 * @param:             @return   
	 * @return:         int   修改条数
	 * @throws
	 */
	int sendStore(HashMap<String,Object> map1,HashMap<String,Object> map2);
	/**
	 * 
	 * @Title:             adminFindOrderStatus
	 * @Description:     TODO 后台根据订单状态查询订单
	 * @param:             @param order_status
	 * @param:             @return   
	 * @return:         List<HashMap<String,Object>>   
	 * @throws
	 */
	List<HashMap<String,Object>> adminFindOrderStatusByPage(HashMap<String,Object> map);//后台查询所有订单

    int addOrderStores(@Param("emps") List<OrderStore> emps);
}
