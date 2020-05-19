package com.mrkb.web.controller.weixin;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mrkb.common.util.ResponseCode;
import com.mrkb.dao.dao.InvoiceMapper;
import com.mrkb.dao.modle.user.*;
import net.sf.json.JSONObject;

import org.apache.shiro.session.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.util.ResponseData;
import com.mrkb.common.utils.JsonUtils;
import com.mrkb.common.utils.LoadingEntityUtil;
import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.account.UserMoneyAccountEntity;
import com.mrkb.dao.modle.apply.WithdrawalApplyEntity;
import com.mrkb.dao.modle.core.TeamEntity;
import com.mrkb.dao.modle.exception.ApplyExceptionMedifood;
import com.mrkb.dao.modle.invoice.InvoiceEntity;
import com.mrkb.dao.modle.order.OrderBasics;
import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.service.AccountService;
import com.mrkb.service.ApplyService;
import com.mrkb.service.CoreService;
import com.mrkb.service.InvoiceService;
import com.mrkb.service.OrderService;
import com.mrkb.service.UserService;
import com.mrkb.shiro.cookieutil.SessionEntity;


@Controller("weixin/maidController")
@RequestMapping("/weixin/maid")
public class MaidController {
	@Autowired
	private UserService userService;
	@Autowired
	private CoreService coreService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private ApplyService applyService;
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private InvoiceMapper invoiceMapper;
	
	@RequestMapping("memberInfo")
	public String memberInfo(HttpServletRequest request ){//会员等级页面
		String requestUser_grade_id=String.valueOf(request.getAttribute("user_grade_id"));
		Integer user_basics_id= null;//用户id
		Integer user_grade_id = null;//用户等级id
		SessionEntity sessionEntity=null;
		try {
			sessionEntity=new SessionEntity(request);
			user_basics_id=sessionEntity.getUser_basics_id();
			user_grade_id=sessionEntity.getUser_grade_id();
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/error";
		}
//		try {
//			if(requestUser_grade_id.equals("null")||requestUser_grade_id==null){//未传入等级id默认从seesion取
//				user_grade_id=sessionEntity.getUser_grade_id();
//			}else{
//				user_grade_id=Integer.valueOf(requestUser_grade_id);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		Integer upgradeOrder=coreService.findUserUpgradeOrderGradeAchievement(user_grade_id);//得到用户的等级升级排序
//		if(upgradeOrder==null){//如果用户等级没有对应的排序默认为1
//			upgradeOrder=0;
//		}
//		int nextUpgradeOrder=upgradeOrder+1;//排序加1
//		int nextGradeId=coreService.findUserGradeUpgradeOrderAchievement(nextUpgradeOrder);//得到下一级的等级id
//		List<Map<String,Object>> upgradeConditionList =coreService.findUpgradeAchievementRule(nextGradeId);//升级条件集合
//		//查询出用户的自定义成就
//		List<UserAchievementAccount>achievementAccountList=userService.findUserAchievementAccount(Integer.valueOf(user_basics_id));//用户的自定义成就
//		UserAchievement userAchievement=userService.findUserAchievement(Integer.valueOf(user_basics_id));//用户基本成就
//		UserUpgrade userUpgrade=coreService.UpgradeProgressAchievement(userAchievement, achievementAccountList, upgradeConditionList);//查出以满足条件与未满足条件
//		if(userUpgrade.getConclude()==2){//已满足升级条件
//			BasicsUser basicsUser=new BasicsUser();
//			basicsUser.setUser_basics_id(user_basics_id);
//			basicsUser.setUser_grade_id(nextGradeId);
//			userService.updateUserBasics(basicsUser);//更改用户等级
//			Map<String,Object> user=new HashMap<String,Object>();
//			user.put("user_basics_id", user_basics_id);
//			user.put("user_grade_id", nextGradeId);
//			BasicsUser updateBasicsUser=new BasicsUser();
//			updateBasicsUser.setUser_basics_id(user_basics_id);
//			updateBasicsUser.setUser_grade_id(nextGradeId);
//			userService.updateUserBasics(updateBasicsUser);//更改用户等级，升至按照等级排序的下一级
//			request.setAttribute("user_grade_id", nextGradeId);
//			memberinto(request);
//		}
		UserGrade userGrade=userService.findUserGrade(user_grade_id);
		//userUpgrade.setUserGrade(userGrade);
		request.setAttribute("userGrade", userGrade);
		return "weixin/wx_ltone/mine/memberInfo";
	}
	@RequestMapping("fullEvaluation")
	public String fullEvaluation(HttpServletRequest request ){		
		return "weixin/wx_ltone/fullEvaluation";
	}
	@RequestMapping("myAdvisorDetail")
	public String myAdvisorDetail(HttpServletRequest request ){	
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer user_basics_id = se.getUser_basics_id();
        UserInformationEntity user2 = userService.findUserInformation(user_basics_id);
        UserInformationEntity user1 = userService.findUserInformation(user2.getCo_user_basics_id());
		request.setAttribute("consult_picture", user1.getConsult_picture());
		request.setAttribute("consult_view", user1.getConsult_view());
		return "weixin/wx_ltone/mine/myAdvisorDetail";
	}
	
	@RequestMapping("historyGift")
	public String historyGift(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/historyGift";
	}
	@RequestMapping("historyGiftDetail")
	public String historyGiftDetail(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/historyGiftDetail";
	}
	@RequestMapping("historyOrderGiftDetail")
	public String historyGiftOrderDetail(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/historyOrderGiftDetail";
	}
	@RequestMapping("myCourse")
	public String myCourse(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/myCourse";
	}
	@RequestMapping("myAccount")
	public String myAccount(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/myAccount";
	}
	
	@RequestMapping("myAdvisor")
	public String myAdvisor(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/myAdvisor";
	}
	
	@RequestMapping("personInfo")
	public String personInfo(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/personInfo";
	}
	
	@RequestMapping("personIdentityCard")
	public String personIdentityCard(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/personIdentityCard";
	}
	@RequestMapping("personAddIdentityCard")
	public String personAddIdentityCard(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/personAddIdentityCard";
	}
	
	@RequestMapping("personBankCard")
	public String personBankCard(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/mine/personBankCard";
	}
	
	@RequestMapping("personAddBankCard")
	public String personAddBankCard(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/mine/personAddBankCard";
	}
	
	@RequestMapping("myOrder")
	public String myOrder(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/myOrder";
	}
	
	@RequestMapping("refreshment")
	public String refreshment(HttpServletRequest request ){		
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int order_id=Integer.valueOf(request.getParameter("order_id"));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_basics_id",user_basics_id);
		map.put("order_id", order_id);
		OrderBasics ob = orderService.findOrderOne(map);
		StoreBasics sb = orderService.findStoreBasics(ob.getStore_id());
		System.out.println(order_id);
		request.setAttribute("store_id", sb.getStore_id());
		request.setAttribute("store_name", sb.getStore_name());
		request.setAttribute("store_intro", sb.getStore_intro());
		return "weixin/wx_ltone/mine/refreshment";
	}
	
	@RequestMapping("address")
	public String address(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/address";
	}
	@RequestMapping("addressNew")
	public String addressNew(HttpServletRequest request ){	
		return "weixin/wx_ltone/mine/addressNew";
	}
	@RequestMapping("addressEdit")
	public String addressEdit(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/mine/addressEdit";
	}
	
	
	@RequestMapping("myTeam")
	public String myTeam(HttpServletRequest request ){//团队页面
		Integer user_basics_id=null;
		try {
			SessionEntity sessionEntity =new SessionEntity(request);
			user_basics_id=sessionEntity.getUser_basics_id();
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/error";
		}
			return "weixin/wx_ltone/mine/myTeam";
	}
	
	@RequestMapping("brandAmbassador")
	public String brandAmbassador(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/mine/brandAmbassador";
	}
	
	@RequestMapping("myNews")
	public String myNews(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/mine/myNews";
	}
	
	
	
	@RequestMapping("myWallet")
	public String myWallet(HttpServletRequest request ){
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double money=userService.findUserMoney(sessionEntity.getUser_basics_id());
		double money1=money==null?0.00:money;
		request.setAttribute("money", money1);
		return "weixin/wx_ltone/mine/myWallet";
	}
	// 钱包充值
	@RequestMapping("myWalletRecharge")
	public String myWalletRecharge(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/myWalletRecharge";
	}
	
	// 钱包提现
	@RequestMapping("myWalletWithdraw")
	public String myWalletWithdraw(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/myWalletWithdraw";
	}
	

	@RequestMapping("member_detail")
	public String member_detail(HttpServletRequest request ){//下级列表页面
		String str=request.getParameter("exam");
		int series=0;//查询的级数
		int type=0;//访问类型（已购或未购）0为已购买会员
		if(str.equals("第一代已购会员")){
			series=1;
		}else if(str.equals("第二代已购会员")){
			series=2;
		}else if(str.equals("第三代已购会员")){
			series=3;
		}else if(str.equals("第四代已购会员")){
			series=4;
		}else if(str.equals("第五代已购会员")){
			series=5;
		}else if(str.equals("第一代未购会员")){
			series=1;
			type=1;
		}else if(str.equals("第二代未购会员")){
			series=2;
			type=1;
		}else if(str.equals("第三代未购会员")){
			series=3;
			type=1;
		}else if(str.equals("第四代未购会员")){
			series=4;
			type=1;
		}else if(str.equals("第五代未购会员")){
			series=5;
			type=1;
		}
		Integer user_basics_id=null;
		try {
			SessionEntity sessionEntity =new SessionEntity(request);
			user_basics_id=sessionEntity.getUser_basics_id();
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/error";
		}
		request.setAttribute("series", series);
		request.setAttribute("type", type);
			return "maid/member_detail";
	}
	
	/**
	 * 
	 * @Title:             bonusDetail
	 * @Description: 奖金明细接口    TODO
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @param jsonData
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@RequestMapping("bonusDetail")
	public @ResponseBody ResponseData bonusDetail(HttpServletResponse response,HttpServletRequest request ,@RequestBody Map<String,Object>jsonData){//奖金页
		SessionEntity sessionEntity = null;
		ResponseData rs = new ResponseData();
		//累计积分初始化参数
		int integral_bonus = 0;
		String records_bonus = null;
		try {
			sessionEntity=new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rs.setIsSuccess(false);
			//return "error/error";
			return rs;
		}
		UserAchievement userAchievement = userService.findUserAchievement(sessionEntity.getUser_basics_id(),"records_bonus");//查出历史奖金
		 records_bonus = userAchievement.getRecords_bonus();//历史奖金
		UserIntegral userIntegral=userService.findUserIntegral(sessionEntity.getUser_basics_id(), "integral_bonus");//查询奖金
		if(userIntegral != null){//用户奖金积分不为空
			 integral_bonus=userIntegral.getIntegral_bonus();//奖金积分
			//request.setAttribute("integral_bonus", integral_bonus);
		}
		List<IntegralAccount> accountList = accountService.findIntegraAccount(sessionEntity.getUser_basics_id(), "integral_bonus");//查询奖金积分流水
		/*map封装历史奖金，积分流水，累计积分*/
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("integral_bonus", integral_bonus);
		map.put("records_bonus", records_bonus);
		map.put("accountList", accountList);
		
		if(map.size() != 0){
			rs.setData(map);
			rs.setIsSuccess(true);
		}else{
			rs.setIsSuccess(false);
			
		}
		//request.setAttribute("records_bonus", records_bonus);
		//request.setAttribute("accountList", accountList);
		//return "maid/bonus";
		return rs;
	}
	/**
	 * 
	 * @Title:             bonus
	 * @Description: 奖金页面   TODO
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @param jsonData
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@RequestMapping("bonus")
	public String bonus(HttpServletRequest request ){//奖金页
		SessionEntity sessionEntity = null;
		try {
			sessionEntity=new SessionEntity(request);
		} catch (SessionException e) {
			e.printStackTrace();
			return "error/error";
		}
		UserAchievement userAchievement=userService.findUserAchievement(sessionEntity.getUser_basics_id(),"records_bonus");//查出历史奖金
		String records_bonus=userAchievement.getRecords_bonus();//历史奖金
		UserIntegral userIntegral=userService.findUserIntegral(sessionEntity.getUser_basics_id(), "integral_bonus");//查询奖金
		int integral_bonus = 0;
		if(userIntegral!=null){//用户奖金积分不为空
			 integral_bonus=userIntegral.getIntegral_bonus();//奖金积分
 		}
		
		List<IntegralAccount>accountList=accountService.findIntegraAccount(sessionEntity.getUser_basics_id(), "integral_bonus");//查询奖金积分流水
		request.setAttribute("records_bonus", records_bonus);
		request.setAttribute("accountList", accountList);
		request.setAttribute("integral_bonus", integral_bonus);
		return "maid/bonus";
	}
	
	/**
	 * 
	 * @Title:             reward
	 * @Description:     TODO 返回晋升积分页面
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         String   
	 * @throws
	 */
	@RequestMapping("reward")
	public String reward(HttpServletRequest request ){//返回晋升积分页面
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			e.printStackTrace();
			return "error/error";
		}
		
		return "maid/reward";
	}
	/**
	 * 
	 * @Title:             findIntegralBasics
	 * @Description:     TODO 用户查询自己的晋升积分
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findIntegralBasics")
	public ResponseData findIntegralBasics(HttpServletRequest request){//查询奖金
		ResponseData rs = new ResponseData();
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		UserIntegral userIntegral=userService.
				findUserIntegral(sessionEntity.getUser_basics_id(), "integral_basics");//查询奖金
		rs.setData(userIntegral.getIntegral_basics());
		rs.setIsSuccess(true);
		return rs;//查询奖金
		
	}
	/**
	 * 
	 * @Title:             findIntegralBasics
	 * @Description:     TODO 用户查询自己的历史奖金
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findRecordsBonus")
	public ResponseData findRecordsBonus(HttpServletRequest request){//查询历史奖金
		ResponseData rs = new ResponseData();
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		UserAchievement userAchievement=userService.findUserAchievement(sessionEntity.getUser_basics_id(),"records_bonus");//查出历史奖金
		String records_bonus=userAchievement.getRecords_bonus();//历史奖金
		rs.setIsSuccess(true);
		rs.setData(records_bonus);
		
		return rs;//查询历史奖金
		
	}
	/**
	 * 
	 * @Title:             findConverNum
	 * @Description:     TODO 用户查询自己的卡巴积分
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findConverNum")
	public ResponseData findConverNum(HttpServletRequest request){//查询卡巴积分
		ResponseData rs = new ResponseData();
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		UserIntegral userIntegral=userService.
				findUserIntegral(sessionEntity.getUser_basics_id(), "conver_num");//查询卡巴积分
		rs.setData(userIntegral.getConver_num());
		rs.setIsSuccess(true);
		return rs;
		
	}
	/**
	 * 
	 * @Title:             findIntegralBasics
	 * @Description:     TODO 用户查询自己的历史晋升积分
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findRecordsIntegral")
	public ResponseData findRecordsIntegral(HttpServletRequest request){//查询晋升积分
		ResponseData rs = new ResponseData();
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		UserAchievement userAchievement=userService.
				findUserAchievement(sessionEntity.getUser_basics_id(), "records_integral");//查询晋升积分
		rs.setIsSuccess(true);
		rs.setData(userAchievement.getRecords_integral());
		return rs;//查询历史晋升积分
		
	}
	/**
	 * 
	 * @Title:             findUserAchievementAll
	 * @Description:     TODO 用户查询自己的所有历史
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findUserAchievementAll")
	public ResponseData findUserAchievementAll(HttpServletRequest request){//用户查询自己的所有历史
		ResponseData rs = new ResponseData();
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		UserAchievement userAchievement=userService.
				findUserAchievementAll(sessionEntity.getUser_basics_id());//用户查询自己的所有历史
		rs.setIsSuccess(true);
		rs.setData(userAchievement);
		return rs;//查询历史晋升积分
		
	}
	/**
	 * 
	 * @Title:             findIntegralBasics
	 * @Description:     TODO 用户查询自己的历史晋升积分
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findCoTotalSale")
	public ResponseData findCoTotalSale(HttpServletRequest request){//查询晋升积分
		ResponseData rs = new ResponseData();
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		UserAchievement userAchievement=userService.
				findUserAchievement(sessionEntity.getUser_basics_id(), "co_total_sale");//查询品牌大使累计销售
		rs.setIsSuccess(true);
		rs.setData(userAchievement.getCo_total_sale());
		return rs;//查询旅品牌大使累计销售
		
	}
	/**
	 * 
	 * @Title:             findIntegralBasicsAccount
	 * @Description:     TODO 用户查询自己的晋升积分流水
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findIntegralBasicsAccount")
	public ResponseData findIntegralBasicsAccount
	(HttpServletRequest request){//用户查询自己的晋升积分流水
		SessionEntity sessionEntity = null;
		ResponseData rs = new ResponseData();
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		List<IntegralAccount>accountList=accountService.
				findIntegraAccount(sessionEntity.getUser_basics_id(), "integral_basics");//查询旅游积分流水
		
		rs.setIsSuccess(true);
		rs.setData(accountList);
		return rs;
		
		
	}
	/**
	 * 
	 * @Title:             tourism
	 * @Description:     TODO
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         String   
	 * @throws
	 */
	@RequestMapping("tourism")
	public String tourism(HttpServletRequest request ){//返回旅游积分页面
		return "maid/tourism";
	}
	/**
	 * 
	 * @Title:             findIntegralTravel
	 * @Description:     TODO 查询旅游积分流水
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findIntegralTravelAccount")
	public ResponseData findIntegralTravelAccount(HttpServletRequest request){//查询旅游积分流水
		SessionEntity sessionEntity = null;
		ResponseData rs = new ResponseData();
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		List<IntegralAccount>accountList=accountService.
				findIntegraAccount(sessionEntity.getUser_basics_id(), "integral_travel");//查询旅游积分流水
		
		rs.setIsSuccess(true);
		rs.setData(accountList);
		return rs;
		
	}
	/**
	 * 
	 * @Title:             findIntegralTravel
	 * @Description:     TODO 查询旅游积分的值
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findIntegralTravel")
	public ResponseData findIntegralTravel(HttpServletRequest request){//查询旅游积分的值
		SessionEntity sessionEntity = null;
		ResponseData rs = new ResponseData();
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		UserIntegral userIntegral=userService.
				findUserIntegral(sessionEntity.getUser_basics_id(), "integral_travel");//查询旅游积分
		
		rs.setIsSuccess(true);
		rs.setData(userIntegral);
		return rs;
		
	}
	
	@RequestMapping("allevaluation")
	public String allevaluation(HttpServletRequest request ){		
		return "maid/allevaluation";
	}
	
	
	@RequestMapping("addWithdrawalApply")
	@ResponseBody
	public ResponseData addWithdrawalApply(
			HttpServletRequest request,HttpServletResponse response){//用户余额提现申请
		ResponseData rs = new ResponseData();
		WithdrawalApplyEntity withdrawalApplyEntity=new WithdrawalApplyEntity();
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		withdrawalApplyEntity.setUser_basics_id(sessionEntity.getUser_basics_id());//申请用户的id
		withdrawalApplyEntity.setApply_add_date(new Date().getTime());//添加申请的时间
		withdrawalApplyEntity.setApply_value(Double.valueOf(request.getParameter("apply_value")));//申请金额的值
		withdrawalApplyEntity.setApply_receipt_type(Integer.valueOf(request.getParameter("apply_receipt_type")));//收款方式(1:微信零钱,2用户银行卡)
		withdrawalApplyEntity.setApply_status(1);//申请状态（1审核中，2已通过，3已拒绝，4已删除）
		withdrawalApplyEntity.setApply_type(1);//提现方式（1通过余额提现）
		withdrawalApplyEntity.setApply_explain("用户通过微信公众号余额提现");//申请说明
		if((int) Integer.valueOf(request.getParameter("apply_receipt_type"))==2){
			withdrawalApplyEntity.setApply_receipt_supplement(
					Integer.valueOf(request.getParameter("apply_receipt_supplement")));//收款补充:(如银行卡信息id)
		}
		int withdrawal_apply_id=0;
		try {
			withdrawal_apply_id=applyService.addWithdrawalApply(
					withdrawalApplyEntity, sessionEntity.getUser_basics_id());//添加一条申请记录
		} catch (ApplyExceptionMedifood e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rs.setIsSuccess(false);
			rs.setMessage("发现恶意操作，已记录：");
			return rs;
		}
		rs.setIsSuccess(true);
		rs.setMessage("已提出申请，申请编号："+withdrawal_apply_id);
		return rs;
	}
	
	@RequestMapping("findUserMoneyAccount")
	@ResponseBody
	public ResponseData  findUserMoneyAccount(
			HttpServletRequest request,HttpServletResponse response){
		ResponseData rs = new ResponseData();
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<UserMoneyAccountEntity> listU=accountService.findUserMoneyAccount(sessionEntity.getUser_basics_id());//查询用户余额流水
		rs.setData(listU);
		rs.setIsSuccess(true);
		return rs;//查询用户余额流水
		
	}
	/**
	 * 
	 * @Title:             toInvoicing
	 * @Description:     TODO 新增用户收取发票的信息
	 * @param:             @param request
	 * @param:             @param response
	 * @param:             @return   
	 * @return:         String   
	 * @throws
	 */
	@RequestMapping("toInvoicing")
	public String  toInvoicing(
			HttpServletRequest request,HttpServletResponse response){
				return "weixin/wx_ltone/mine/invoicing";
		
	}
	/**
	 * 
	 * @Title:             invoicingInfo
	 * @Description:     TODO 用户收取发票信息列表
	 * @param:             @param request
	 * @param:             @param response
	 * @param:             @return   
	 * @return:         String   
	 * @throws
	 */
	@RequestMapping("invoicingInfo")
	public String invoicingInfo(HttpServletRequest request ){		
		return "weixin/wx_ltone/mine/invoicingInfo";
	}
	/**
	 * 
	 * @Title:             addInvoice
	 * @Description:     TODO 添加索取发票的信息
	 * @param:             @param request
	 * @param:             @param response
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("addInvoice")
	public ResponseData addInvoice(
			HttpServletRequest request,HttpServletResponse response){//添加索取发票的信息
		ResponseData rs = new ResponseData();
		InvoiceEntity invoiceEntity = null;
		try {
			invoiceEntity = (InvoiceEntity) LoadingEntityUtil.fromJson(request,InvoiceEntity.class);
		} catch (SecurityException | IllegalArgumentException
				| NoSuchMethodException | ClassNotFoundException
				| IllegalAccessException | InvocationTargetException
				| InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		invoiceEntity.setUser_basics_id(sessionEntity.getUser_basics_id());
		 HashMap<String,Object> map = new HashMap<String,Object>();
         List<InvoiceEntity>  list =invoiceMapper.pageListInfo(map);
           if(list.size()>0){
			   for(int i=0 ;i<list.size();i++){
			   	  System.out.print(invoiceEntity.getOrder_id()+","+list.get(i).getOrder_id());
				   System.out.print(invoiceEntity.getOrder_id().equals(list.get(i).getOrder_id()));
					if(invoiceEntity.getOrder_id().equals(list.get(i).getOrder_id())){
						rs.setIsSuccess(false);
						rs.setMessage("同一订单号，不能重复索取发票!");
						return rs;
					}
			   }
		   }
		 int   invoice_id = invoiceService.addInvoice(invoiceEntity);

           if( invoice_id >0){
			   rs.setMessage("成功保存信息，请耐心等待回复");
			   rs.setIsSuccess(true);
			   rs.setData(invoice_id);
			   return rs;
		   }
		rs.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		rs.setMessage("索取发票失败！");
		return rs;
	}
	/**
	 * 
	 * @Title:             findInvoiceToUid
	 * @Description:     TODO 查询用户索取发票的收取信息
	 * @param:             @param request
	 * @param:             @param response
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("findInvoiceToUid")
	public ResponseData findInvoiceToUid(
			HttpServletRequest request,HttpServletResponse response){//查询用户索取发票的收取信息
		ResponseData rs = new ResponseData();
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<InvoiceEntity> list=invoiceService.findInvoiceToUid(sessionEntity.getUser_basics_id(),3);
		rs.setData(list);
		rs.setIsSuccess(true);
		return rs;//添加索取发票的信息
	}
	/**
	 * 
	 * @Title:             delInvoiceToInvoice_id
	 * @Description:     TODO 通过收取发票信息id删除一条信息
	 * @param:             @param request
	 * @param:             @param response
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("delInvoiceToInvoice_id")
	public ResponseData delInvoiceToInvoice_id(
			HttpServletRequest request,HttpServletResponse response){//通过收取发票信息id删除一条信息
		ResponseData rs = new ResponseData();
		Object invoice_idObj=request.getParameter("invoice_id");
		int invoice_id=Integer.valueOf(invoice_idObj.toString());
		invoiceService.delInvoiceToInvoice_id(invoice_id);
		rs.setIsSuccess(true);
		rs.setMessage("成功删除一条数据");
		return rs;
	}
	/**
	 * 
	 * @Title:             addInvoiceGain
	 * @Description:     TODO 添加一条用户索取发票的信息
	 * @param:             @param request
	 * @param:             @param response
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("addInvoiceGain")
	public ResponseData addInvoiceGain(
			HttpServletRequest request,HttpServletResponse response){//通过收取发票信息id删除一条信息
		ResponseData rs = new ResponseData();
		String invoice_idObj=request.getParameter("invoice_id");//收取发票的信息id
		int invoice_id=Integer.valueOf(invoice_idObj.toString());//将id转换成int类型
		int invoice_gain_id=invoiceService.addInvoiceGain(invoice_id);//添加一条索取发票的信息
		rs.setIsSuccess(true);
		rs.setMessage("已成功索取发票，编号："+invoice_gain_id);
		return rs;
	}
}
