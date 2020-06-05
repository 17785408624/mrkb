package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;

import com.mrkb.dao.modle.order.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.store.StoreBasics;

@Mapper
public interface OrderMapper {
	List<OrderSupplement> findFinishOrder(int order_id);//查询可以完成的订单
	int updateFinishOrder(HashMap<String,Object> map);//完成订单
	int updateReStore(HashMap<String,Object> reStoremap);//同意退款货
	int updateReMoney(HashMap<String,Object> remap);//同意退款
	int addRestore(OrderRestore or);//添加退货
	int addRefund(OrderRefund orderRefund);//申请退款流程开始
	OrderRefund findRefundOne(HashMap<String,Object> map);//查看申请退款
	OrderRestore findReStoreOne(HashMap<String,Object> map);//查看申请退货
	int addOrder(OrderBasics ob);//添加订单
	List<HashMap<String, Object>> findOrderAll(HashMap<String,Object> map);//查看某人所有订单
	List<HashMap<String, Object>> findOrder(HashMap<String, Object> map);//查看订单
	int deleteOrder(HashMap<String,Integer> map);//删除单个订单
	int updateOrderOne(HashMap<String,Object> map);//修改单个订单
	OrderBasics findOrderOne(HashMap<String, Object> map);//查询单个订
	StoreBasics findStoreBasics(int store_id);
	int addOrderSup(HashMap<String,Object> map);//添加订单补充信息
	List<HashMap<String,Object>> adminFindAllStoreBasicsByPage(int a);//后台查询所有订单
	List<OrderBasics> findOrderAffirm(Long pointInTime);//查询小于当前时间状态值为4的订单
	List<HashMap<String,Object>> adminFindOrderStatusByPage(HashMap<String,Object> map);//后台查询所有订单
	/**
	 * 
	 * @Title:             BatchUpdateOrderStatus
	 * @Description:     订单状态修改为5
	 * @param:             @param orderBasicsList 订单实体类集合
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int BatchUpdateOrderStatus(List<OrderBasics> orderBasicsList);//批量修改订单状态为5
	int sendStore(HashMap<String,Object> map1);//发货
	int getMoney(OrderBasics ob);//确认收款
	int findOrderTiyan(HashMap<String,Object> map);//查询某用户是否已购买体验会员装
	int sendStoreAddr(HashMap<String,Object> map2);
	OrderSupplement findOrderSup(int order_id);//查询订单补充信息
    /**
     * 	
     * @Title:             selectOrderBasicsToUserbasicsidToOrderstatus
     * @Description:     TODO 根据多个用户id查询状态值为传入orderstatus的数据
     * @param:             @param user_basics_ids 包含多个用户id
     * @param:             @param orderstatus 订单状态
     * @param:             @return   
     * @return:         OrderBasics   订单实体类
     * @throws
     */
	OrderBasics selectOrderBasicsToUserbasicsidToOrderstatus
	(@Param("user_basics_ids")int[]user_basics_ids,@Param("orderstatus")int orderstatus);//根据多个用户id查询状态值为传入orderstatus的数据
	/**
	 * 
	 * @Title:             selectOrderBasicsToUserbasicsid
	 * @Description:     TODO 根据一个或者多个用户id查询订单信息
	 * @param:             @param user_basics_ids 用户id
	 * @param:             @return   
	 * @return:         OrderBasics   订单实体类
	 * @throws
	 */
	OrderBasics selectOrderBasicsToUserbasicsid(@Param("user_basics_ids")int[]user_basics_ids);//根据一个或者多个用户id查询订单信息
	/**
	 * 
	 * @Title:             findOrderBasicsToAll
	 * @Description:     TODO
	 * @param:             @param orderBasics 查询条件，设置的值为条件，多个值条件以and拼接
	 * @param:             @return   
	 * @return:         OrderBasics   
	 * @throws
	 */
	List<OrderBasics> selectOrderBasicsToAnd(OrderBasics orderBasics);

    List<OrderStore> findOrderStore(int order_id);

    int addOrderStores(@Param("emps") List<OrderStore> emps);
	
}