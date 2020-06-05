package com.mrkb.service.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.mrkb.common.utils.messages.PrivateMessages;
import com.mrkb.dao.dao.*;
import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.account.UserMoneyAccountEntity;
import com.mrkb.dao.modle.order.*;
import com.mrkb.dao.modle.user.UserMessage;
import net.sf.json.JSONObject;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.mrkb.common.utils.weixinservice.WxCustomerServiceMessageUtil;
import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.dao.modle.user.UserInformationEntity;
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
    @Autowired
    private UserMoneyAccountMapper userMoneyAccountMapper;

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
    public int addOrderStores(List<OrderStore> emps) {
        return basicOrderMapper.addOrderStores(emps);
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
		}
		basicOrderMapper.updateFinishOrder(map);// 将订单状态修改为已完成
        List<OrderStore> los=basicOrderMapper.findOrderStore(orderBasics.getOrder_id());
        double amountPrice=0.00;
        //addIntergral(Integer user_basics_id,Integer order_id,Double amountPrice,Double integral,Integer series)
        for(int i=0;i<los.size();i++){

            // 根据商品id查询商品类型
            StoreBasics storeBasics = basicStoreMapper.findStoreBasics(los.get(i).getStore_id());
            storeBasics.getProfit_monry();
            amountPrice+=storeBasics.getProfit_monry()*los.get(i).getStore_num()*0.1;

        }

		// 根据商品id查询商品类型
		StoreBasics storeBasics = basicStoreMapper.findStoreBasics(orderBasics.getStore_id());
		if (storeBasics.getStore_type() == 1) { // 商品类型为1则说明该商品能进行升级返利
			// 获取用户信息
			BasicsUser basicsUser = basicUserMapper.findUserBasics(orderBasics.getUser_basics_id());
			int user_basics_id=basicsUser.getUser_basics_id();//购买人用户编号
			// 查询该用户上级(推荐人)信息
			BasicsUser commendUsers = userRecommendMapper.selectRecommendById(user_basics_id);
			int supgrade=commendUsers.getUser_grade_id();//推荐人等级
			int storeNum = orderBasics.getStore_amount();// 获取购买数量
			int commenduserId = commendUsers.getUser_basics_id();// 一级上级用户id
			double profitMonry = (storeBasics.getProfit_monry() + storeBasics.getOther_price()) * storeNum;// 算出已商品可分配利润


			if(commendUsers.getUser_basics_id()==1){//过滤上级为游客的 及摩尔卡巴
				return OrderIds;
			}
           // addIntergral(Integer user_basics_id,Integer order_id,Double amountPrice,Double integral,Integer series)
            addIntergral(user_basics_id,order_id,profitMonry);//自己添加奖金

            //一级上级添加奖金
            BasicsUser commendUsers1 = userRecommendMapper.selectRecommendById(user_basics_id);
            if(commendUsers1!=null&&commendUsers1.getUser_basics_id()!=1){
                addIntergral(commendUsers1.getUser_basics_id(),order_id,profitMonry);//一级添加奖金
                //二级上级添加奖金
                BasicsUser commendUsers2 = userRecommendMapper.selectRecommendById(commendUsers1.getUser_basics_id());
                if(commendUsers2!=null&&commendUsers2.getUser_basics_id()!=1){
                    addIntergral(commendUsers2.getUser_basics_id(),order_id,profitMonry);//二级添加奖金
                    //三级上级添加奖金
                    BasicsUser commendUsers3= userRecommendMapper.selectRecommendById(commendUsers2.getUser_basics_id());
                    if(commendUsers3!=null&&commendUsers3.getUser_basics_id()!=1){
                        addIntergral(commendUsers3.getUser_basics_id(),order_id,profitMonry);//三级添加奖金
                    }
                }
            }

		}

		return OrderIds;

	}

	public void addIntergral(Integer user_basics_id,Integer order_id,Double amountPrice){
        // 添加积分
        HashMap<String, Object> bonusMap = new HashMap<String, Object>();// 加积分
        bonusMap.put("user_basics_id", user_basics_id);
        bonusMap.put("integral_bonus",(double)amountPrice);
        bonusMap.put("conver_num",(double)amountPrice*0.01);// 加积分
        userIntegralMapper.updateIntegralBonus1(bonusMap);
        userAchievementMapper.updateArchivement1(bonusMap);
        UserWeixin uw3 = userWeixinMapper
                .findUserWeixinUserBasicsOne(user_basics_id);// 购买人微信信息,包含姓名

        // 上级添加积分快乐豆
        HashMap<String, Object> bonusMap1 = new HashMap<String, Object>();// 加积分
        bonusMap1.put("user_basics_id", user_basics_id);
        bonusMap.put("integral_bonus",amountPrice);
        bonusMap.put("integral_basics",amountPrice);
        bonusMap1.put("conver_num",amountPrice);// 加积分
        userIntegralMapper.updateIntegralBonus1(bonusMap1);
        bonusMap1.put("records_integral", amountPrice);// 加快乐豆
        bonusMap1.put("conver_num",(double) amountPrice*0.01);// 减积分
        userAchievementMapper.updateArchivement1(bonusMap1);// 加历史积分,减去未激活快乐豆
        //上级钱包加钱流水
        UserMoneyAccountEntity um=new UserMoneyAccountEntity();
        um.setUser_basics_id(user_basics_id);
        um.setAccount_value(amountPrice);
        um.setAccount_add_date(System.currentTimeMillis());
        um.setAccount_explain("团队购买返利");
        um.setAccount_reason(3);
        um.setAccount_correlation_id(order_id);
        userMoneyAccountMapper.insertUserMoneyAccount(um);
        //钱包加钱
        basicUserMapper.updateUserMoneyPlus(amountPrice,user_basics_id);
        //流水
        IntegralAccount ilt = new IntegralAccount();
        ilt.setAccount_option("integral_bonus");
        ilt.setUser_basics_id(user_basics_id);// 用户编号
        ilt.setAccount_option_name("奖金");
        ilt.setAccount_add_date(System.currentTimeMillis());
        ilt.setIntegral_account_num(String.valueOf(amountPrice));// 提成
        ilt.setIntegral_account_explain(uw3.getWeixin_nickname()
                + "购买获取快乐豆奖励");
        ilt.setIntegral_account_type(1);
        ilt.setIntegral_trigger(order_id);// 订单编号
        integralMapper.addIntegralAccount(ilt);
        // 添加消息提示
        UserMessage ume = new UserMessage();
        ume.setUser_basics_id(user_basics_id);
        ume.setTb_id(order_id);
        ume.setTb_name("order_basics");
        ume.setMessage_type(2);
        ume.setAdd_date(System.currentTimeMillis());
        ume.setIf_read(0);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date dt = new Date();
        String update2 = sdf2.format(dt);
        BasicsUser bus1 = basicUserMapper.findUserBasics(user_basics_id);
        String message = "您好，您的会员\"" + uw3.getWeixin_nickname() + "\"已完成订单,获取推广奖励:" + amountPrice + "奖金。";


        String message_content = PrivateMessages.getPushMessage(update2, message);
        ume.setMessage_content(message_content);
        userMessageMapper.addMessage(ume);
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
