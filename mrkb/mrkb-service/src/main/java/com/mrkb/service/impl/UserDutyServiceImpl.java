package com.mrkb.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.mrkb.dao.dao.*;
import com.mrkb.dao.modle.account.UserMoneyAccountEntity;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.common.utils.DateUtil;
import com.mrkb.common.utils.publicUtil;
import com.mrkb.common.utils.globalStatic.GlobalStatic;
import com.mrkb.common.utils.messages.PrivateMessages;
import com.mrkb.common.utils.weixinservice.WxCustomerServiceMessageUtil;
import com.mrkb.dao.modle.account.CapitalAccount;
import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.company.CoFounderMonSale;
import com.mrkb.dao.modle.company.CompanyMonthSales;
import com.mrkb.dao.modle.news.News;
import com.mrkb.dao.modle.order.OrderBasics;
import com.mrkb.dao.modle.sale.UserSale;
import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.dao.modle.store.StoreGift;
import com.mrkb.dao.modle.store.StoreGiftMemberChangEntity;
import com.mrkb.dao.modle.store.StoreGiftRecordEntity;
import com.mrkb.dao.modle.store.UserDuty;
import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.dao.modle.user.UserInformationEntity;
import com.mrkb.dao.modle.user.UserMessage;
import com.mrkb.dao.modle.user.UserWeixin;
import com.mrkb.service.UserDutyService;

import net.sf.json.JSONObject;

@Service
@Transactional
public class UserDutyServiceImpl implements UserDutyService {

	@Autowired
	private UserDutyMapper userDutyMapper;
	@Autowired
	private OrderMapper basicOrderMapper;
	@Autowired
	private BasicUserMapper basicUserMapper;
	@Autowired
	private UserRecommendMapper userRecommendMapper;
	@Autowired
	private UserIntegralMapper userIntegralMapper;
	@Autowired
	private UserAchievementMapper userAchievementMapper;
	@Autowired
	private CapitalAccountMapper capitalAccountMapper;
	@Autowired
	private BasicStoreMapper basicStoreMapper;
	@Autowired
	private NewsMapper newsMapper;
	@Autowired
	private UserInformationMapper userInformationMapper;
	@Autowired
	private CompanyMonthMapper companyMonthMapper;
	@Autowired
	private UserSaleMapper userSaleMapper;
	@Autowired
	private UserWeixinMapper userWeixinMapper;
	@Autowired
	private UserMessageMapper userMessageMapper;
	@Autowired
	private StoreGiftRecordMapper storeGiftRecordMapper;
	@Autowired
	private StoreGiftMemberChangeMapper storeGiftMemberChangeMapper;
	@Autowired
	private IntegralMapper integralMapper;
	@Autowired
	private CoFounderMonSaleMapper coFounderMonSaleMapper;
	@Autowired
	private UserMoneyAccountMapper userMoneyAccountMapper;
	@Override
	public List<UserDuty> findUserDuty(UserDuty userDuty) {
		return userDutyMapper.findUserDuty(userDuty);
	}
	
	@Override
	public int duty(UserDuty userDuty) {
		UserDuty ud=userDutyMapper.findOne(userDuty.getDuty_id());
		if(ud==null||ud.getIf_duty()==1){
			new Error("不存在或已当班！");
		}
		//复训当班
		if(userDuty.getSource_type() == 3){
			int update = userDutyMapper.duty(userDuty);
			if (update < 1) {
				return update;
			}
			return update;
		}
		// 该情况当班为赠送课程当班的 ，其上级没有分销奖励，该用户也只能升级
		if (userDuty.getSource_type() == 2) {
			int user_basics_id  = userDuty.getUser_basics_id();
			BasicsUser bur = new BasicsUser();//初始化实体类
			//获取商品基本信息
			StoreBasics storeBasics = basicStoreMapper.findStoreBasics(userDuty.getStore_id());
			//获取用户基本信息
			BasicsUser bus = basicUserMapper.findUserBasics(userDuty.getUser_basics_id());
			
			// 升级
			// 1.直接升级
			int go_user_grade_id = storeBasics.getUser_grade_id();// 可以升到的等级
			int user_grade_id = bus.getUser_grade_id();// 用户当前等级
			bur.setUser_basics_id(user_basics_id);
			if (user_grade_id < go_user_grade_id) {
				bur.setUser_grade_id(go_user_grade_id);
				basicUserMapper.updateUserBasics(bur);
			}
			// 2.满足条件升级紫罗兰之家
			/*if (user_grade_id < 4) {// 低于紫罗兰之家
				StoreBasics ss = new StoreBasics();
				ss.setIs_letang(1);
				int letnum = basicStoreMapper.findLetang(ss);// 乐唐课程总量
				int isduty = userDutyMapper.isduty(user_basics_id);// 已当班的乐唐大学数量
				if (isduty >= letnum) {
					bur.setUser_grade_id(4);
					basicUserMapper.updateUserBasics(bur);
				}
			}*/
			int update = userDutyMapper.duty(userDuty);
			if (update < 1) {
				return update;
			}
			return update;
		}
		int update = userDutyMapper.duty(userDuty);
		if (update < 1) {
			return update;
		}
		// 当班
		Integer user_basics_id = userDuty.getUser_basics_id();
		// 查询该用户上级(推荐人)信息
		BasicsUser commendUsers = userRecommendMapper.selectRecommendById(user_basics_id);

		int order_id = userDuty.getOrder_id();
		Date date = new Date();
		List<CapitalAccount> capitalAccountList = new ArrayList<CapitalAccount>();// 流水记录集合
		long time = System.currentTimeMillis();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("order_id", order_id);

		OrderBasics orderBasics = basicOrderMapper.findOrderOne(map);// 根据订单id查询订单
		map.put("order_status",5);
		map.put("user_basics_id",orderBasics.getUser_basics_id());
		basicOrderMapper.updateOrderOne(map);//将订单改为已收货（已上课）
		int year = DateUtil.yearNowInt();// 当前年
		int mon = DateUtil.monthNowInt();// 当前年月
		int day = DateUtil.dayNowInt();// 当前年月日
		if (orderBasics.getOrder_type() == 1) {
			BasicsUser bus = basicUserMapper.findUserBasics(userDuty.getUser_basics_id());
			BasicsUser basicsUsers = userRecommendMapper.selectRecommendById(bus.getUser_basics_id());
			int userGradeId = basicsUsers.getUser_grade_id();// 上级用户等级
			CapitalAccount capitalAccount = new CapitalAccount();// 流水实体
			capitalAccount.setCapital_trigger(orderBasics.getOrder_id());// 关联触发数据的id
			capitalAccount.setAdd_account_date(date.getTime());// 添加时间
			capitalAccount.setCapital_account_type(1);// 流水类型（1购买商品）
			capitalAccount.setCapital_number(orderBasics.getAll_price());// 资金数量
			capitalAccount.setTo_user_basics_id(orderBasics.getUser_basics_id());// 发起人id（购买人）
			// //////////////////////////////////////////////////
			int storeNum = orderBasics.getStore_amount();// 获取购买数量
			StoreBasics storeBasics = basicStoreMapper.findStoreBasics(orderBasics.getStore_id());// 获取订单的商品信息
			capitalAccount.setAccount_explain(storeBasics.getStore_name());// 流水说明
			double amountPrice = (storeBasics.getStore_price() + storeBasics.getOther_price()) * storeNum;// 算出已商品价格为准的总价
			Double store_price = Double.valueOf(orderBasics.getAll_price());// 订单价格

			UserInformationEntity ufe = userInformationMapper.selectUserInformationEntityToUserId(user_basics_id);
			// 加积分快乐豆
			if (userGradeId > 1) {
				String share = "share" + userGradeId + storeBasics.getCourse_type();
				String shares = String.valueOf(GlobalStatic.json.get(share));
				int sharePrice = 0;// 上级获取的快乐豆
				try {
					int sharess = Integer.valueOf(shares);
					sharePrice = sharess;
				} catch (Exception e) {
					double sharess = Double.valueOf(shares);
					sharePrice =(int) (amountPrice * sharess);
				}
				if (shares == null || shares.equals("")) {// 当前商品无购买奖励
					return 0;
				}
				// 自己添加积分
				HashMap<String, Object> bonusMap = new HashMap<String, Object>();// 加积分,减去未激活积分
				bonusMap.put("user_basics_id", user_basics_id);
				bonusMap.put("conver_num",(int)amountPrice);// 加积分
				userIntegralMapper.updateIntegralBonus1(bonusMap);
				bonusMap.put("integrals_no_active",(int)( amountPrice - amountPrice - amountPrice));// 减积分
				userAchievementMapper.updateArchivement1(bonusMap);// 加历史积分,减去未激活快乐豆
				UserWeixin uw3 = userWeixinMapper
						.findUserWeixinUserBasicsOne(orderBasics
								.getUser_basics_id());// 购买人微信信息,包含姓名
				// 上级添加积分快乐豆
				if (commendUsers.getUser_grade_id() > 1) {// 上级为三星紫罗兰以上
					if (ufe.getCompany_id() == 1) {
						HashMap<String, Object> bonusMap1 = new HashMap<String, Object>();// 加积分,减去未激活积分
						bonusMap1.put("user_basics_id", commendUsers.getUser_basics_id());

						bonusMap1.put("conver_num",(int)amountPrice);// 加积分
						userIntegralMapper.updateIntegralBonus1(bonusMap1);
						bonusMap1.put("records_integral", sharePrice);// 加快乐豆
						bonusMap1.put("integral_no_active",sharePrice - sharePrice - sharePrice);
						bonusMap1.put("integrals_no_active",(int) (amountPrice - amountPrice - amountPrice));// 减积分
						userAchievementMapper.updateArchivement1(bonusMap1);// 加历史积分,减去未激活快乐豆
						//上级钱包加钱流水
						UserMoneyAccountEntity um=new UserMoneyAccountEntity();
						um.setUser_basics_id(commendUsers.getUser_basics_id());
						um.setAccount_value(Double.valueOf(sharePrice));
						um.setAccount_add_date(System.currentTimeMillis());
						um.setAccount_explain("下级购买返利");
						um.setAccount_reason(3);
						um.setAccount_correlation_id(order_id);
						userMoneyAccountMapper.insertUserMoneyAccount(um);
						//上级钱包加钱
						basicUserMapper.updateUserMoneyPlus(Double.valueOf(sharePrice),commendUsers.getUser_basics_id());
						//上级流水
						IntegralAccount ilt = new IntegralAccount();
						ilt.setAccount_option("integral_bonus");
						ilt.setUser_basics_id(commendUsers.getUser_basics_id());// 用户编号
						ilt.setAccount_option_name("奖金");
						ilt.setAccount_add_date(System.currentTimeMillis());
						ilt.setIntegral_account_num(String.valueOf(sharePrice));// 提成
						ilt.setIntegral_account_explain(uw3.getWeixin_nickname()
								+ "购买获取快乐豆奖励");
						ilt.setIntegral_account_type(1);
						ilt.setIntegral_trigger(userDuty.getOrder_id());// 订单编号
						integralMapper.addIntegralAccount(ilt);
					}
				}
				// 联合创办人添加奖励
				IntegralAccount ila = new IntegralAccount();
				if (ufe.getCo_user_basics_id() != null
						&& !ufe.getCo_user_basics_id().equals("")
						&& !ufe.getCo_user_basics_id().equals("null")
						&& ufe.getCo_user_basics_id() != 1
						&& ufe.getCo_user_basics_id() != 0
						&& ufe.getCo_user_basics_id() != -1) {
					Integer co_user_basics_id = ufe.getCo_user_basics_id();// 联合创办人编号
					
					// 品牌大使 员工 销售
					CoFounderMonSale cf = new CoFounderMonSale();
					cf.setUser_basics_id(co_user_basics_id);
					cf.setMonth_date(DateUtil.monthNowInt()+"");
					CoFounderMonSale cfm = coFounderMonSaleMapper
							.findCoFounderOne(cf);
					if (cfm != null) {
						cf.setMon_sale_timely(store_price);
						coFounderMonSaleMapper.updateCoFounderMonSale(cf);
					} else if (cfm == null) {
						cf.setMon_sale_timely(orderBasics.getAll_price());
						cf.setStart_time(DateUtil.getMonStart());
						cf.setEnd_time(DateUtil.getNextMonStart());
						cf.setAchievement_bonus(0.00);
						cf.setMon_sale_untimely(0.00);
						cf.setTeam_bonus(0.00);
						cf.setAvg_bonus(0.00);
						cf.setFounder_bonus(store_price);
						cf.setIf_settlement(0);// 未结算标志
						coFounderMonSaleMapper.insertCoFounderMonSale(cf);
					}
				}
				// 微信消息推送开始
				// 第一代
				if (uw3.getInformation_compellation() != null && !uw3.getInformation_compellation().equals("null")
						&& !uw3.getInformation_compellation().equals("")) {
					uw3.setWeixin_nickname(uw3.getInformation_compellation());
				}
				String nick_name = uw3.getWeixin_nickname();
				UserWeixin uw2 = userRecommendMapper.selectOlderUserWx(orderBasics.getUser_basics_id());
				if (uw2 == null) {

				} else {
					JSONObject jsonObject = new JSONObject();
					String openid = uw2.getWeixin_id();
					StringBuffer buffer = new StringBuffer();
					try {
						jsonObject = new WxCustomerServiceMessageUtil().sendTextMessage(
								"您好，您的直推会员\"" + nick_name + "\"已完成订单,交纳:" + orderBasics.getAll_price() + "元。", openid);
						jsonObject = new WxCustomerServiceMessageUtil().sendTextMessage(buffer.toString(), openid);
					} catch (DocumentException e) {
						e.printStackTrace();
					}

					// 添加消息提示
					UserMessage um = new UserMessage();
					um.setUser_basics_id(uw2.getUser_basics_id());
					um.setTb_id(orderBasics.getOrder_id());
					um.setTb_name("order_basics");
					um.setMessage_type(2);
					um.setAdd_date(time);
					um.setIf_read(0);
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					java.util.Date dt = new Date();
					String update2 = sdf2.format(dt);
					BasicsUser bus1 = basicUserMapper.findUserBasics(uw2.getUser_basics_id());
					String message = "";
					if (bus1.getUser_grade_id() >= 2) {
						message = "您好，您的直推会员\"" + nick_name + "\"已完成订单,获取推广奖励:" + sharePrice + "快乐豆。";
					} else {
						message = "您好，您的直推会员\"" + nick_name + "\"已完成订单,非正式会员-无法获取奖励:" + sharePrice + "快乐豆。";
					}

					String message_content = PrivateMessages.getPushMessage(update2, message);
					um.setMessage_content(message_content);
					userMessageMapper.addMessage(um);

				}
			}

			// 升级
			// 1.直接升级
			int go_user_grade_id = storeBasics.getUser_grade_id();// 可以升到的等级
			int user_grade_id = bus.getUser_grade_id();// 用户当前等级
			BasicsUser bur = new BasicsUser();
			bur.setUser_basics_id(user_basics_id);
			if (user_grade_id < go_user_grade_id) {
				bur.setUser_grade_id(go_user_grade_id);
				basicUserMapper.updateUserBasics(bur);
			}
			// 2.满足条件升级紫罗兰之家
			/*if (user_grade_id < 4) {// 低于紫罗兰之家
				StoreBasics ss = new StoreBasics();
				ss.setIs_letang(1);
				int letnum = basicStoreMapper.findLetang(ss);// 乐唐课程总量
				int isduty = userDutyMapper.isduty(user_basics_id);// 已当班的乐唐大学数量
				if (isduty >= letnum) {
					bur.setUser_grade_id(4);
					basicUserMapper.updateUserBasics(bur);
				}
			}*/
			// 本月第一天
			Long start_time = DateUtil.getMonStart();
			Long end_time = DateUtil.getNextMonStart();
			// 添加基金
			News news = new News();
			news.setNews_type(3);
			news.setFund_money(store_price * GlobalStatic.fund_money);
			newsMapper.addMoney(news);
			// 添加公司总销售量
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
			Date date2 = date;
			CompanyMonthSales cms = new CompanyMonthSales();
			cms.setMonth_date(sdf.format(date2));// 销售月份
			cms.setCompany_id(ufe.getCompany_id());// 所属公司
			capitalAccount.setCompany_id(ufe.getCompany_id());
			// 添加公司流水
			CompanyMonthSales cms1 = companyMonthMapper.findMonthSalesOne(cms);// 查询当月流水是否存在
			if (cms1 != null) {
				cms.setMonth_money_timely(store_price);//
				cms.setCompany_id(ufe.getCompany_id());// 购买人所属公司
				cms.setStart_time(start_time);// 开始时间
				cms.setEnd_time(end_time);// 结束时间
				companyMonthMapper.updateCompanyMonth(cms);
			} else {
				cms.setIf_settlement(0);
				cms.setCompany_id(ufe.getCompany_id());// 购买人所属公司
				cms.setMonth_money_timely(store_price);// 第一次购买金额
				cms.setStart_time(start_time);// 开始时间
				cms.setEnd_time(end_time);// 结束时间
				companyMonthMapper.insertCompanyMonth(cms);
			}
			capitalAccountList.add(capitalAccount);
			// 添加自己业绩

			/*UserSale us0 = new UserSale();
			us0.setTable_name("user_sale_mon_" + mon);
			us0.setUser_basics_id(orderBasics.getUser_basics_id());
			us0.setSale_date(day);
			us0.setSale_volume0(orderBasics.getAll_price());
			us0.setSale_money(orderBasics.getAll_price());
			int updates = userSaleMapper.updateUserSale(us0);
			if (updates < 1) {
				userSaleMapper.addUserSale(us0);
			}
			us0.setTable_name("user_sale_mon_" + year);
			us0.setSale_date(mon);
			int updates7 = userSaleMapper.updateUserSale(us0);
			if (updates7 < 1) {
				userSaleMapper.addUserSale(us0);
			}*/

		}
		int insertNum = capitalAccountMapper.batchInsertCapitalAccount(capitalAccountList);// 批量添加流水记录
		// ////////////////
		return update;
	}

	/**
	 * 赠送课程接口
	 * 
	 * @Param gift_id 赠送课程内容编号id
	 * @Param gift_user_id 被赠送者用户id
	 * @Param store_id 赠送课程id
	 */
	@Override
	public int giftCourse(int gift_id, int store_id, int user_basics_id, int gift_user_id) {
		/**
		 * 
		 * 根据赠送者id，查询赠送者大礼包课程,依据每个课程所限定的名额，赠送给被赠送者。 赠送的流程:赠送者点击赠送按钮，将自己所获得的名额的
		 * 课程赠送给所需之人，点击确定赠送后，
		 */
		StoreGiftMemberChangEntity beans0 = new StoreGiftMemberChangEntity();// 课程可赠送数量变更实体初始化
		StoreGiftMemberChangEntity beans1 = new StoreGiftMemberChangEntity();// 课程可赠送数量变更实体初始化
		StoreGiftMemberChangEntity beans2 = new StoreGiftMemberChangEntity();// 课程可赠送数量变更实体初始化
		StoreGiftRecordEntity storeGiftRecordBeans = new StoreGiftRecordEntity();// 创建课程赠送记录实体
		UserDuty userDuty = new UserDuty();
		StoreGift storeGiftbean  =  new StoreGift();
		int ids_num = 0;// 课程可赠送数量初始化
		StoreGiftMemberChangEntity seEntity = null; //初始化赠送课程变更对象
		//通过store_id 查询该课程是否为大礼包课程 ，is_gift是否为大礼包(1,不是 2是)
		 //StoreBasics storeBasics  = basicStoreMapper.findStoreBasics(store_id);
		 //Integer isGift = storeBasics.getIs_gift();
		  
		// 通过gift_id 查询该套餐课程可赠送的数量（即赠送数量的上限值，也为最大值）
		storeGiftbean.setGift_id(gift_id);
		StoreGift storeGift = basicStoreMapper.findStoreGiftById(storeGiftbean);
		// 获取ids_num 即课程可赠送名额
		ids_num = storeGift.getIds_num();
		String[] storeIdArray = storeGift.getStore_ids().split(";");
		int[] idsArray = new int[storeIdArray.length];
		for (int i = 0; i < storeIdArray.length; i++) {
			idsArray[i] = Integer.parseInt(storeIdArray[i]);// String[]转成int[]
		}
		List<StoreBasics> list = basicStoreMapper.findStoreByArrayIds(idsArray);
		int storeId = 0;
		// 1.赠送名额变更 store_gift_member_change
		beans0.setGift_id(gift_id);
		seEntity= storeGiftMemberChangeMapper.findStoreGiftMemberChangeById(beans0);
		if (seEntity == null) {
			beans1.setGift_id(gift_id);
			beans1.setUser_basics_id(user_basics_id);
			beans1.setStore_id(store_id);
			beans1.setSurplus_num(ids_num);
			beans1.setSend_num(0);
			beans1.setAdd_date(System.currentTimeMillis());
			storeGiftMemberChangeMapper.addStoreGiftMemberChange(beans1);

			beans2.setSend_num(1);
			beans2.setSurplus_num(-1);
			beans2.setGift_member_id(beans1.getGift_member_id());
			storeGiftMemberChangeMapper.updateStoreGiftMemberChange(beans2);
		} else {
			/* 若可赠送名额为0，则返回-1，说明他该课程没有可赠送名额 */
			if (seEntity.getSurplus_num() == 0) {
				return -1;
			}
			beans2.setSend_num(1);
			beans2.setSurplus_num(-1);
			beans2.setGift_member_id(seEntity.getGift_member_id());
			storeGiftMemberChangeMapper.updateStoreGiftMemberChange(beans2);
		}
		 for(int j = 0  ; j<list.size() ; j++){
			 storeId = list.get(j).getStore_id();
			 //StoreBasics storeBasics = basicStoreMapper.findStoreBasics(storeId);
				// 2.记录赠送者赠送信息 store_gift_record
				storeGiftRecordBeans.setGift_user_id(gift_user_id);
				storeGiftRecordBeans.setUser_basics_id(user_basics_id);
				storeGiftRecordBeans.setStore_id(storeId);
				storeGiftRecordBeans.setGift_date(System.currentTimeMillis());
				storeGiftRecordMapper.addStoreGiftRecord(storeGiftRecordBeans);
				// 3.赠送完成后 将其赠送课程记录到当班表中 user_duty
				userDuty.setUser_basics_id(gift_user_id);
				// userDuty.setOrder_id(0);
				userDuty.setIf_duty(0);
				userDuty.setAdd_date(System.currentTimeMillis());
				userDuty.setSource_type(2);
				userDuty.setStore_id(storeId);
				userDutyMapper.addUserDuty(userDuty);
				
		 }
		 return 0;
		
	}

	/* 获取赠送课程套餐 */
	@Override
	public HashMap<String, Object> storeGiftList(int user_basics_id, int order_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, Object> maps = new HashMap<String, Object>();
		List<StoreGift> storeGiftList = null;
		StoreGift storeGiftBean = new StoreGift();// 赠送课程实体
		/* 根据用户id 查询赠送者订单 */
		map.put("user_basics_id", user_basics_id);
		List<HashMap<String, Object>> orderBasics = basicOrderMapper.findOrder(map);// 根据赠送者id查询订单信息
		for (int k = 0; k < orderBasics.size(); k++) {
			maps = orderBasics.get(k);// 获取某一个对象的值
			if (Integer.valueOf(maps.get("order_id").toString()).equals(order_id)) {
				// 查询商品信息，获取参数id
				StoreBasics storeBasics = basicStoreMapper
						.findStoreBasics(Integer.valueOf(maps.get("store_id").toString()));
				// 查询大礼包套餐
				storeGiftBean.setStore_id(storeBasics.getStore_id());
				// 获取商品id， 即套餐id
				storeGiftList = basicStoreMapper.findStoreGift(storeGiftBean);// 查询课程套餐包含哪些套餐

				resultMap.put("storeGiftList", storeGiftList);// 返回该用户所购买的所有套餐
				break;// 查询出来的订单编号与我们指定的订单编号一致，则执行
			} else {
				continue;// 查询出来的订单编号与我们指定的订单编号不一致，则执行
			}
		}
		/* 判断返回数据是否为空 */
		if (storeGiftList.size() > 0) {
			return resultMap;
		}

		return null;
	}

	/**
	 * 查询课程套餐单个 对应具体课程id
	 */
	@Override
	public List<StoreBasics> getStoreBasics(int gift_id ,int gift_user_id) {
		String[] storeIdArray = null; // 定义具体课程字符串数组
		//根据gift_id查询store_gift_member_change 大礼包变更表user_basics_id
		StoreGiftMemberChangEntity  sgmcEntity   = new StoreGiftMemberChangEntity();
		sgmcEntity.setGift_id(gift_id);
		StoreGiftMemberChangEntity  sgmcEntitys  =  storeGiftMemberChangeMapper.findStoreGiftMemberChangeById(sgmcEntity);
		Integer giftUserId = gift_user_id;
		UserWeixin user  = userWeixinMapper.findUserWeixinUserBasicsId(giftUserId);
		
		// 获取单个课程套餐的内容
		StoreGift storeGiftsGift  = new StoreGift();
		storeGiftsGift.setGift_id(gift_id);
		StoreGift storeGift = basicStoreMapper.findStoreGiftById(storeGiftsGift);
		storeIdArray = storeGift.getStore_ids().split(";");
		int[] idsArray = new int[storeIdArray.length];
		for (int i = 0; i < storeIdArray.length; i++) {
			idsArray[i] = Integer.parseInt(storeIdArray[i]);// String[]转成int[]
		}
		List<StoreBasics> list = basicStoreMapper.findStoreByArrayIds(idsArray);
		 for(int j= 0 ;j<list.size();j++){
			 list.get(j).setBusiness_date(System.currentTimeMillis());
			 list.get(j).setGift_user_basics_id(giftUserId);//会员编号
			 list.get(j).setGift_user_name(publicUtil.emojiRecovery(user.getWeixin_nickname()));//会员昵称
		 }
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public int countDuty(int user_basics_id) {
		return userDutyMapper.countDuty(user_basics_id);
	}
	/*赠送记录查询 （包含被赠送的和赠送别人的）*/
	@Override
	public HashMap<String, Object> storeGiftRecordList(int user_basics_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		//1.根据会员编号user_basics_id查询自己得赠送记录
		StoreGiftRecordEntity sGrEntity  =new StoreGiftRecordEntity();
		sGrEntity.setUser_basics_id(user_basics_id);
		List<StoreGiftRecordEntity> storeGiftRecordList = storeGiftRecordMapper.findStoreGiftRecord(sGrEntity);
		for(int i= 0 ; i<storeGiftRecordList.size(); i++){
			//查询赠送者昵称,根据赠送者id查
			storeGiftRecordList.get(i).setUser_nickname(publicUtil.emojiRecovery(userWeixinMapper.findUserWeixinUserBasicsId
					(storeGiftRecordList.get(i).getUser_basics_id()).getWeixin_nickname()));
			//查询被赠送者昵称,根据被赠送者id查询
			storeGiftRecordList.get(i).setGift_user_nickname(publicUtil.emojiRecovery(userWeixinMapper.findUserWeixinUserBasicsId
					(storeGiftRecordList.get(i).getGift_user_id()).getWeixin_nickname()));
			//根据课程id 查询课程名称
			storeGiftRecordList.get(i).setStore_name(basicStoreMapper.
					findStoreBasics(storeGiftRecordList.get(i).getStore_id()).getStore_name());
					
		}
		//2.根据被赠送编号user_gift_id查询自己被赠送的记录
		StoreGiftRecordEntity sGrEntitys  =new StoreGiftRecordEntity();
		sGrEntitys.setGift_user_id(user_basics_id);
		List<StoreGiftRecordEntity> storeGiftRecordLists = storeGiftRecordMapper.findStoreGiftRecord(sGrEntitys);
		for(int j= 0 ; j<storeGiftRecordLists.size(); j++){
			//查询被赠送者昵称,根据被赠送者id查
			storeGiftRecordLists.get(j).setUser_nickname(publicUtil.emojiRecovery(userWeixinMapper.findUserWeixinUserBasicsId
					(storeGiftRecordLists.get(j).getGift_user_id()).getWeixin_nickname()));
			//查询赠送者昵称,根据赠送者id查询
			storeGiftRecordLists.get(j).setGift_user_nickname(publicUtil.emojiRecovery(userWeixinMapper.findUserWeixinUserBasicsId
					(storeGiftRecordLists.get(j).getUser_basics_id()).getWeixin_nickname()));
			//根据课程id 查询课程名称
			storeGiftRecordLists.get(j).setStore_name(basicStoreMapper.
					findStoreBasics(storeGiftRecordLists.get(j).getStore_id()).getStore_name());
					
		}
		 map1.put("storeGiftRecordList",storeGiftRecordList);
		 map1.put("type",1);//type=1表示赠送记录
		 map2.put("storeGiftRecordLists",storeGiftRecordLists);
		 map2.put("type",2);//type =2 表示被赠送记录
		 map.put("map1",map1);
		 map.put("map2",map2);
		return map;
		
	}
	/*查询单个课程赠送记录*/

	@Override
	public StoreGiftRecordEntity findStoreGiftRecordById(StoreGiftRecordEntity storeGiftRecordEntity) {
		//根据gift_record_id 查询storeGiftRecordEntity对象
		StoreGiftRecordEntity entity= storeGiftRecordMapper.findStoreGiftRecordById(storeGiftRecordEntity);
		//1.查询用户昵称
		 UserWeixin user  = userWeixinMapper.findUserWeixinUserBasicsId(entity.getGift_user_id());
		 entity.setUser_nickname(publicUtil.emojiRecovery(user.getWeixin_nickname()));//注入storeGiftRecordEntity实体对象中
		//2.查询赠送课程名称
		 StoreBasics store = basicStoreMapper.findStoreBasics(entity.getStore_id());
		 entity.setStore_name(store.getStore_name());
		return entity;
	}
	
}
