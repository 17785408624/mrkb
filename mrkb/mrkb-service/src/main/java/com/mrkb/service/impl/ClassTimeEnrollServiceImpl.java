package com.mrkb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.BasicStoreMapper;
import com.mrkb.dao.dao.ClassTimeEnrollMapper;
import com.mrkb.dao.dao.ClassTimeNodesMapper;
import com.mrkb.dao.dao.OrderMapper;
import com.mrkb.dao.dao.UserDutyMapper;
import com.mrkb.dao.dao.UserWeixinMapper;
import com.mrkb.dao.modle.nodes.ClassTimeEnroll;
import com.mrkb.dao.modle.nodes.ClassTimeNodes;
import com.mrkb.dao.modle.order.OrderBasics;
import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.dao.modle.store.UserDuty;
import com.mrkb.dao.modle.user.UserWeixin;
import com.mrkb.service.ClassTimeEnrollService;


@Service
@Transactional(rollbackFor = Exception.class)
public class ClassTimeEnrollServiceImpl implements ClassTimeEnrollService {
	
	
	@Autowired
	private ClassTimeEnrollMapper mapper;

	@Autowired
	private UserWeixinMapper userWeixinMapper;
	
	@Autowired
	private ClassTimeNodesMapper timemapper;
	
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private BasicStoreMapper basicStoreMapper;
	@Resource
	private UserDutyMapper userDutyMapper;
	
	//log4j日志（级别，error,info,debug）
    private final static Logger log = LoggerFactory.getLogger(ClassTimeNodeServiceImpl .class);
	
    
	/**
	 * 报名
	 */
	public OrderBasics sign_up(ClassTimeEnroll time_enroll) {
		Integer num=0;
		//获取用户微信ID
		UserWeixin uw = userWeixinMapper.findUserWeixinUserBasicsOne(time_enroll.getUser_basics_id());// 购买人微信信息,包含姓名
		time_enroll.setWx_openid(uw.getWeixin_id());
		time_enroll.setEnroll_time(System.currentTimeMillis());
		try {
			num = mapper.insert(time_enroll);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("时间节点课程报名异常");
			return null;
		}
		StoreBasics sbs=basicStoreMapper.findStoreBasics(time_enroll.getStore_id());
		ClassTimeNodes nodes=timemapper.get(time_enroll.getClass_node_id());
		if(num>0){
			num=mapper.update(time_enroll.getClass_node_id());
		}
		OrderBasics sb = new OrderBasics();
		sb.setStore_picture(sbs.getStore_picture());
		sb.setOrder_addr(nodes.getAddress());
		sb.setStore_id(time_enroll.getStore_id());
		sb.setOrder_add_date(System.currentTimeMillis());
		sb.setOrder_status(2);
		sb.setOrder_edit_date(System.currentTimeMillis());
		sb.setUser_basics_id(time_enroll.getUser_basics_id());
		sb.setAll_price(nodes.getRetraining_price());
		sb.setOrder_type(2);
		sb.setPayment_date(0l);
		int update=orderMapper.addOrder(sb);
		UserDuty userDuty = new UserDuty();
		userDuty.setUser_basics_id(time_enroll.getUser_basics_id());
		userDuty.setIf_duty(0);
		userDuty.setAdd_date(System.currentTimeMillis());
		userDuty.setSource_type(3);
		userDuty.setStore_id(time_enroll.getStore_id());
		userDutyMapper.addUserDuty(userDuty);
		return sb;
	}
	
	

	/**
	 * 课程时间节点
	 */
	public List<ClassTimeNodes> list(Map<String, Object> param) {
		List<ClassTimeNodes> list = new ArrayList<ClassTimeNodes>();
		try {
			list = mapper.nodes_list(param);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("微信端查询课程时间节点异常");
			return new ArrayList<ClassTimeNodes>();
			
		}
		return list;
	}
	
	
}
