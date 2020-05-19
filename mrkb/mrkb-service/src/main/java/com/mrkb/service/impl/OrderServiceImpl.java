package com.mrkb.service.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.common.utils.DateUtil;
import com.mrkb.common.utils.globalStatic.GlobalStatic;
import com.mrkb.common.utils.messages.PrivateMessages;
import com.mrkb.common.utils.weixinservice.WxCustomerServiceMessageUtil;
import com.mrkb.dao.dao.BasicStoreMapper;
import com.mrkb.dao.dao.BasicUserMapper;
import com.mrkb.dao.dao.CapitalAccountMapper;
import com.mrkb.dao.dao.CoFounderMonSaleMapper;
import com.mrkb.dao.dao.CompanyBasicsMapper;
import com.mrkb.dao.dao.CompanyMapper;
import com.mrkb.dao.dao.CompanyMonthMapper;
import com.mrkb.dao.dao.IntegralMapper;
import com.mrkb.dao.dao.NewsMapper;
import com.mrkb.dao.dao.OrderAddrMapper;
import com.mrkb.dao.dao.OrderMapper;
import com.mrkb.dao.dao.UserAchievementMapper;
import com.mrkb.dao.dao.UserDutyMapper;
import com.mrkb.dao.dao.UserInformationMapper;
import com.mrkb.dao.dao.UserIntegralMapper;
import com.mrkb.dao.dao.UserMessageMapper;
import com.mrkb.dao.dao.UserRecommendMapper;
import com.mrkb.dao.dao.UserSaleMapper;
import com.mrkb.dao.dao.UserWeixinMapper;
import com.mrkb.dao.modle.account.CapitalAccount;
import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.company.CoFounderMonSale;
import com.mrkb.dao.modle.company.CompanyBasicsEntity;
import com.mrkb.dao.modle.company.CompanyMonthSales;
import com.mrkb.dao.modle.core.AwardOperationEntityAll;
import com.mrkb.dao.modle.news.News;
import com.mrkb.dao.modle.order.OrderBasics;
import com.mrkb.dao.modle.order.OrderRefund;
import com.mrkb.dao.modle.order.OrderRestore;
import com.mrkb.dao.modle.order.OrderSupplement;
import com.mrkb.dao.modle.sale.UserSale;
import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.dao.modle.store.UserDuty;
import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.dao.modle.user.UserAchievement;
import com.mrkb.dao.modle.user.UserInformationEntity;
import com.mrkb.dao.modle.user.UserMessage;
import com.mrkb.dao.modle.user.UserWeixin;
import com.mrkb.service.CoreService;
import com.mrkb.service.OrderService;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {
	@Autowired
	private CoreService coreService;
	@Autowired
	private UserMessageMapper userMessageMapper;
	@Autowired
	private CoFounderMonSaleMapper coFounderMonSaleMapper;
	@Autowired
	private CompanyBasicsMapper companyBasicsMapper;
	@Autowired
	private UserRecommendMapper userRecommendMapper;
	@Autowired
	private BasicUserMapper basicUserMapper;
	@Autowired
	private UserInformationMapper userInformationMapper;
	@Autowired
	private CompanyMonthMapper companyMonthMapper;
	@Resource
	private OrderMapper basicOrderMapper;
	@Resource
	private UserWeixinMapper userWeixinMapper;
	@Resource
	private CapitalAccountMapper capitalAccountMapper;
	@Resource
	private BasicStoreMapper basicStoreMapper;
	@Resource
	private OrderAddrMapper orderAddrMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private IntegralMapper integralMapper;
	@Resource
	private NewsMapper newsMapper;
	@Resource
	private UserIntegralMapper userIntegralMapper;
	@Resource
	private UserAchievementMapper userAchievementMapper;
	@Resource
	private UserSaleMapper userSaleMapper;
	@Resource
	private UserDutyMapper userDutyMapper;

	public OrderBasics addOrder(OrderBasics ob, HashMap<String, Object> map) {
		basicOrderMapper.addOrder(ob);
		map.put("order_id", ob.getOrder_id());
		basicOrderMapper.addOrderSup(map);
		return ob;
	}

	@Override
	public List<HashMap<String, Object>> findOrder(HashMap<String, Object> map) {
		return basicOrderMapper.findOrder(map);
	}

	@Override
	public int updateOrderOne(HashMap<String, Object> map) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("order_id", map.get("order_id"));
		OrderBasics os = basicOrderMapper.findOrderOne(map1);
		int order_status = os.getOrder_status();
		int update;
		if (order_status == 2) {
			int order_status1 = Integer.valueOf(String.valueOf(map.get("order_status")));
			return basicOrderMapper.updateOrderOne(map);
		} else {
			return 0;
		}

	}

	@Override
	public OrderBasics findOrderOne(HashMap<String, Object> map) {
		return basicOrderMapper.findOrderOne(map);
	}

	@Override
	public StoreBasics findStoreBasics(int store_id) {
		return basicOrderMapper.findStoreBasics(store_id);
	}

	@Override
	public int deleteOrder(HashMap<String, Integer> map) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("user_basics_id", map.get("user_basics_id"));
		map1.put("order_id", map.get("order_id"));
		OrderBasics ob = basicOrderMapper.findOrderOne(map1);
		if (ob.getOrder_status() > 2) {
			return 0;
		} else {
			return basicOrderMapper.deleteOrder(map);
		}
	}

	@Override
	public List<HashMap<String, Object>> findOrderAll(HashMap<String, Object> map) {
		return basicOrderMapper.findOrderAll(map);
	}

	@Override
	public List<HashMap<String, Object>> adminFindAllStoreBasicsByPage(int a) {
		return basicOrderMapper.adminFindAllStoreBasicsByPage(1);
	}

	/**
	 * <p>
	 * Title: CheckOrderTime
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<OrderBasics> CheckOrderTime() {// 检查已超过确认收货时间的订单
		Date date = new Date();
		Integer datedDate = 15;// 订单确认收货过期时间，单位为天
		Long pointInTime = date.getTime() - (datedDate * 24 * 60 * 60 * 1000);// 算出过期的时间
		return basicOrderMapper.findOrderAffirm(pointInTime);
	}

	/**
	 * <p>
	 * Title: datedOrderReceive
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public int datedOrderReceive() {// 将已经过期的订单修改状态为5一收货，添加流水记录
		Date date = new Date();
		int insertNum = 0;// 添加的资金记录数
		Integer datedDate = 15;// 订单确认收货过期时间，单位为天
		Long pointInTime = date.getTime() - (datedDate * 24 * 60 * 60 * 1000);// 算出过期的时间
		List<OrderBasics> orderBasicsList = basicOrderMapper.findOrderAffirm(pointInTime);// 超过收货未确认收货时间的订单
		if (orderBasicsList.size() != 0) {// 未确认的订单不为零
			basicOrderMapper.BatchUpdateOrderStatus(orderBasicsList);
			// for (OrderBasics orderBasics : orderBasicsList) {
			// CapitalAccount capitalAccount=new CapitalAccount();
			// capitalAccount.setAccount_explain("购买商品订单号:"+orderBasics.getOrder_id());//流水说明
			// capitalAccount.setCapital_trigger(orderBasics.getOrder_id());//关联触发数据的id
			// capitalAccount.setAdd_account_date(date.getTime());//添加时间
			// capitalAccount.setCapital_account_type(1);//流水类型（1购买商品）
			// capitalAccount.setCapital_number(orderBasics.getAll_price());//资金数量
			// /**
			// * 商品贩卖人id,这里需要获取此id，暂时默认为1（系统）
			// */
			// Integer Fo_user_basics_id=1;
			// capitalAccount.setFo_user_basics_id(Fo_user_basics_id);//接收人id（商品贩卖人）
			// capitalAccount.setTo_user_basics_id(orderBasics.getUser_basics_id());//发起人id（购买人）
			// capitalAccountList.add(capitalAccount);
			// insertNum=capitalAccountMapper.batchInsertCapitalAccount(capitalAccountList);
			// }

		}
		return insertNum;
	}

	@Override
	public int sendStore(HashMap<String, Object> map1, HashMap<String, Object> map2) {
		String courier_services_company = String.valueOf(map2.get("courier_services_company"));
		String waybill_number = String.valueOf(map2.get("waybill_number"));
		OrderBasics ob = basicOrderMapper.findOrderOne(map1);
		int order_status = ob.getOrder_status();
		int send = 0;
		if (order_status == 3) {
			send = basicOrderMapper.sendStore(map1);
			basicOrderMapper.sendStoreAddr(map2);
		}
		if (send > 0) {
			UserWeixin uw2 = userWeixinMapper.findUserWeixinUserBasicsId(ob.getUser_basics_id());
			JSONObject jsonObject = new JSONObject();
			String openid = uw2.getWeixin_id();
			StringBuffer buffer = new StringBuffer();
			try {
				jsonObject = new WxCustomerServiceMessageUtil().sendTextMessage(buffer.toString(), openid);
				jsonObject = new WxCustomerServiceMessageUtil().sendTextMessage("您好，您所订购的商品,订单编号为:\"" + ob.getOrder_id()
						+ "\"已发货:\r\n快递公司:" + courier_services_company + "\r\n运单号:" + waybill_number, openid);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return send;
	}

	@Override
	public List<HashMap<String, Object>> adminFindOrderStatusByPage(HashMap<String, Object> map) {
		return basicOrderMapper.adminFindOrderStatusByPage(map);
	}

	@Override
	public OrderRefund refund(HashMap<String, Object> map, OrderRefund orderRefund) {
		OrderBasics orderBasics = basicOrderMapper.findOrderOne(map);
		Double refund_money = orderBasics.getAll_price();
		basicOrderMapper.updateOrderOne(map);
		orderRefund.setRefund_money(refund_money);
		basicOrderMapper.addRefund(orderRefund);
		return orderRefund;
	}

	@Override
	public OrderSupplement findOrderSup(int order_id) {
		return basicOrderMapper.findOrderSup(order_id);
	}

	@Override
	public OrderRestore addRestore(OrderRestore or, HashMap<String, Object> map) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("order_id", map.get("order_id"));
		map1.put("user_basics_id", map.get("user_basics_id"));
		OrderBasics os = basicOrderMapper.findOrderOne(map1);
		or.setRestore_money(os.getAll_price());
		int order_status = os.getOrder_status();
		if (order_status == 5 || order_status == 9) {
			basicOrderMapper.updateOrderOne(map);
			basicOrderMapper.addRestore(or);
		}
		return or;
	}

	@Override
	public OrderRefund findRefundOne(HashMap<String, Object> map) {
		return basicOrderMapper.findRefundOne(map);
	}

	@Override
	// 退款
	public int updateReMoney(HashMap<String, Object> ormap, HashMap<String, Object> remap) {
		basicOrderMapper.updateOrderOne(ormap);
		int i = basicOrderMapper.updateReMoney(remap);
		return i;
	}

	@Override
	public int updateReStore(HashMap<String, Object> ormap, HashMap<String, Object> remap) {
		basicOrderMapper.updateOrderOne(ormap);
		int i = basicOrderMapper.updateReStore(remap);
		return i;
	}

	@Override
	public OrderRestore findReStoreOne(HashMap<String, Object> map) {
		return basicOrderMapper.findReStoreOne(map);
	}

	/**
	 * 用户订单完成 后给用户及推荐人加积分user_achivement，并将用户id信息,及订单id信息保存到当班表user_duty中
	 */
	@Override
	public synchronized int[] updateFinishOrder(int order_id) throws DocumentException {
		int[] OrderIds = null;
		Date date = new Date();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("order_id", order_id);


		OrderBasics orderBasics = basicOrderMapper.findOrderOne(map);// 根据订单id查询订单
		if(orderBasics.getOrder_type()==1||orderBasics.getOrder_type()==2){
			map.put("order_status",4);
		}else{
			map.put("order_status",3);
		}
		basicOrderMapper.updateFinishOrder(map);// 将订单状态修改为已完成
		// 根据商品id查询商品类型
		StoreBasics storeBasics = basicStoreMapper.findStoreBasics(orderBasics.getStore_id());
		if (storeBasics.getStore_type() == 1) { // 商品类型为1则说明该商品能进行升级返利
			// 获取用户信息
			BasicsUser basicsUser = basicUserMapper.findUserBasics(orderBasics.getUser_basics_id());
			int user_basics_id=basicsUser.getUser_basics_id();//购买人用户编号
			// 查询该用户上级(推荐人)信息
			BasicsUser commendUsers = userRecommendMapper.selectRecommendById(basicsUser.getUser_basics_id());
			int supgrade=commendUsers.getUser_grade_id();//推荐人等级
			int storeNum = orderBasics.getStore_amount();// 获取购买数量
			int commenduserId = commendUsers.getUser_basics_id();// （推荐人）上级用户id
			double amountPrice = (storeBasics.getStore_price() + storeBasics.getOther_price()) * storeNum;// 算出已商品价格为准的总价
			
			//将用户购买课程获得的用户信息及订单信息插入当班表中
			UserDuty userDuty  = new UserDuty();
		    userDuty.setUser_basics_id(basicsUser.getUser_basics_id());
			userDuty.setOrder_id(order_id);
			userDuty.setIf_duty(0);
			userDuty.setAdd_date(System.currentTimeMillis());
			userDuty.setSource_type(1);
			if(orderBasics.getOrder_type()==2){
				userDuty.setSource_type(3);
			}
			userDuty.setStore_id(storeBasics.getStore_id());
			int userDutys =userDutyMapper.addUserDuty(userDuty);
			if(supgrade<2||commendUsers.getUser_basics_id()==1){//过滤上级为游客的 及摩尔卡巴
				return OrderIds;
			}
			
			Double store_price = Double.valueOf(orderBasics.getAll_price());// 订单价格
			String share = "share" + supgrade + storeBasics.getCourse_type();//
			String shares = String.valueOf(GlobalStatic.json.get(share));
			double commendIntegral = 0.00;// 上级获取的积分
			double userIntegral = 0.00;// 用户获取积分
			int sharePrice = 0;// 用户获取的（未激活）快乐豆初始化参数
			try {
				int sharess = Integer.valueOf(shares);
				sharePrice = sharess;
			} catch (Exception e) {
				double sharess = Double.valueOf(shares);
				sharePrice = new Double(amountPrice * sharess).intValue();
			}
			if (shares == null || shares.equals("")) {// 当前商品无购买奖励
				return OrderIds;
			}
			//判断推荐用户是否为总公司会员
			UserInformationEntity ufe1 = userInformationMapper
					.selectUserInformationEntityToUserId(user_basics_id);
			if (ufe1.getCompany_id() == 1) {
				// 给推荐用户加积分,快乐豆（积分为未激活状态）
				HashMap<String, Object> commendUserAchievementMap = new HashMap<String, Object>();// 未激活积分map
				commendUserAchievementMap.put("integrals_no_active", amountPrice);// 推荐人未激活积分
				commendUserAchievementMap.put("user_basics_id", commenduserId);
				commendUserAchievementMap.put("integral_no_active", sharePrice);// 用户未激活快乐豆
				userAchievementMapper.updateArchivement1(commendUserAchievementMap);// 修改未激活积分
			}

			// 添加用户积分快乐豆
			UserInformationEntity ufe2 = userInformationMapper
					.selectUserInformationEntityToUserId(basicsUser.getUser_basics_id());
			if (ufe2.getCompany_id() == 1) {
				// 给用户加积分（积分和快乐豆均未激活）
				HashMap<String, Object> userAchievementMap = new HashMap<String, Object>();// 未激活积分map
				userAchievementMap.put("integrals_no_active", amountPrice);// 用户未激活积分
				userAchievementMap.put("user_basics_id", basicsUser.getUser_basics_id());// 用户未激活快乐豆
				//UserAchievement userAchievement1 = userAchievementMapper.findUserAchievementAll(basicsUser.getUser_basics_id());
				userAchievementMapper.updateArchivement1(userAchievementMap);// 修改未激活积分

				
			}

		}

		return OrderIds;

	}

	@Override
	public StoreBasics selectStoreBasicsId(int store_id) {
		// 根据商品ID查看商品详情信息
		return orderAddrMapper.selectStoreBasicsId(store_id);
	}

	@Override
	public int findOrderTiyan(HashMap<String, Object> map) {
		return basicOrderMapper.findOrderTiyan(map);
	}

	@Override
	public int getMoney(OrderBasics ob) {
		if(ob.getOrder_type()==1||ob.getOrder_type()==2){
			ob.setOrder_status(4);
		}else {
			ob.setOrder_status(3);
		}
		return basicOrderMapper.getMoney(ob);
	}

}
