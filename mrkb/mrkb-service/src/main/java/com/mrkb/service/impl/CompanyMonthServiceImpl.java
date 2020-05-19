package com.mrkb.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.common.utils.globalStatic.GlobalStatic;
import com.mrkb.common.utils.messages.PrivateMessages;
import com.mrkb.dao.dao.BasicUserMapper;
import com.mrkb.dao.dao.CapitalAccountMapper;
import com.mrkb.dao.dao.CoFounderMonSaleMapper;
import com.mrkb.dao.dao.CompanyBasicsMapper;
import com.mrkb.dao.dao.CompanyMonthMapper;
import com.mrkb.dao.dao.GoldPoolShareMapper;
import com.mrkb.dao.dao.IntegralMapper;
import com.mrkb.dao.dao.UserAchievementMapper;
import com.mrkb.dao.dao.UserInformationMapper;
import com.mrkb.dao.dao.UserIntegralMapper;
import com.mrkb.dao.dao.UserMessageMapper;
import com.mrkb.dao.dao.UserRecommendMapper;
import com.mrkb.dao.modle.account.CapitalAccount;
import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.company.CoFounderMonSale;
import com.mrkb.dao.modle.company.CompanyBasicsEntity;
import com.mrkb.dao.modle.company.CompanyMonthSales;
import com.mrkb.dao.modle.company.GoldPoolShare;
import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.dao.modle.user.UserAchievement;
import com.mrkb.dao.modle.user.UserInformationEntity;
import com.mrkb.dao.modle.user.UserIntegral;
import com.mrkb.dao.modle.user.UserMessage;
import com.mrkb.service.CompanyMonthService;


@Transactional(rollbackFor = Exception.class)
@Service("CompanyMonthServiceImpl")
public class CompanyMonthServiceImpl implements CompanyMonthService {
	@Resource
	private UserIntegralMapper userIntegralMapper;
	@Resource
	private UserAchievementMapper userAchievementMapper;
	@Resource
	private IntegralMapper integralMapper;
	@Resource
	private UserRecommendMapper userRecommendMapper;
	@Autowired
	private UserMessageMapper userMessageMapper;
	@Resource
	private BasicUserMapper basicUserMapper;
	@Resource
	private UserInformationMapper userInformationMapper;
	@Resource
	private CompanyMonthMapper companyMonthMapper;
	@Resource
	private CoFounderMonSaleMapper coFounderMonSaleMapper;
	@Resource
	private CompanyBasicsMapper companyBasicsMapper;
	@Resource
	private CapitalAccountMapper capitalAccountMapper;
	@Resource
	private GoldPoolShareMapper goldPoolShareMapper;

	@Override
	public List<CompanyMonthSales> selectCompanyMonth() {
		return companyMonthMapper.selectCompanyMonth();
	}

	// 每月结算
//	@Override
//	public int settlement(HashMap<String, Object> map) {
//		List<CompanyBasicsEntity> listcbe = companyBasicsMapper
//				.findCompanyBasicsmp(map);
//		CompanyBasicsEntity cbe = null;
//		// 获取前一个月
//		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
//		cal_1.add(Calendar.MONTH, -1);// 获取上月日历
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
//		String date = sdf.format(cal_1.getTime());
//		CompanyMonthSales cms = new CompanyMonthSales();
//		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//		// 获取本月的月份
//		Date dt = new Date();
//		String date2 = sdf.format(dt);
//
//		// 获取前一个月第一天
//		Calendar calendar1 = Calendar.getInstance();
//		calendar1.add(Calendar.MONTH, -1);// 月
//		calendar1.set(Calendar.DAY_OF_MONTH, 1);// 日
//		calendar1.set(Calendar.HOUR_OF_DAY, 0);// 时
//		calendar1.set(Calendar.MINUTE, 0);// 分
//		calendar1.set(Calendar.SECOND, 0);// 秒
//		String firstDay = sdf1.format(calendar1.getTime());
//		Date dateStart = null;
//		try {
//			dateStart = sdf1.parse(firstDay);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		// try {//时间测试
//		// Date dateStart1 = sdf1.parse("2019-08-17 23:59:59");
//		// System.out.println(dateStart1);
//		// Long start_time1 = Long.valueOf(dateStart1.getTime());
//		// System.out.println(start_time1);
//		// } catch (ParseException e) {
//		// e.printStackTrace();
//		// }
//
//		Long start_time = Long.valueOf(dateStart.getTime());
//		// 获取本月第一天
//		Calendar calendar2 = Calendar.getInstance();
//		calendar2.add(Calendar.MONTH, 0);// 月
//		calendar2.set(Calendar.DAY_OF_MONTH, 1);// 日
//		calendar2.set(Calendar.HOUR_OF_DAY, 0);// 时
//		calendar2.set(Calendar.MINUTE, 0);// 分
//		calendar2.set(Calendar.SECOND, 0);// 秒
//		String lastDay = sdf1.format(calendar2.getTime());
//		Date lastdateStart = null;
//		try {
//			lastdateStart = sdf1.parse(lastDay);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		Long end_time = Long.valueOf(lastdateStart.getTime());
//		Long time = System.currentTimeMillis();// 系统当前时间戳
//		int update = 0;
//		for (int i = 0; i < listcbe.size(); i++) {
//			cbe = listcbe.get(i);
//			int company_id = cbe.getCompany_id();
//			cms.setCompany_id(company_id);
//			System.out.println("公司编号：：：：：：：" + company_id);
//			cms.setMonth_date(date);
//			CompanyMonthSales cmm = companyMonthMapper.findMonthSalesOne(cms);
//			if (cmm == null) {// 公司本月销售量为空
//				continue;
//			}
//			if (cmm.getIf_settlement() != 0) {// 忽略已结算
//				continue;
//			}
//			double month_money_timely = cmm.getMonth_money_timely();
//			if (month_money_timely < 0) {// 公司本月及时销售量为空
//				continue;
//			}
//			cbe = listcbe.get(i);
			/**
			 * zrm 给体验中心推荐人添加推荐奖
			 */
//			Integer user_basics_id_referee = cbe.getUser_basics_id_referee();
//			if (user_basics_id_referee != null && user_basics_id_referee != 0
//					&& !user_basics_id_referee.equals("")
//					&& !user_basics_id_referee.equals("null")
//					/*&&cmm.getMonth_money_timely()* GlobalStatic.referee_money>0*/) {
//				// 体验中心人加1奖金
//				double bonus = cmm.getMonth_money_timely()*GlobalStatic.referee_money;
//				//添加奖金
//				Map<String, Object> map4 = new HashMap<String, Object>();
//				map4.put("user_basics_id", cbe.getUser_basics_id_referee());
//				map4.put("integral_bonus", bonus);
//				userIntegralMapper.addBonus(map4);// 给领衔创办人添加15%及5%的奖金
//				// 添加历史奖金
//				UserAchievement ua = new UserAchievement();
//				ua.setRecords_bonus(String.valueOf(bonus));
//				ua.setUser_basics_id(cbe.getUser_basics_id_referee());
//				userAchievementMapper.augmentUserAchievement(ua);
//				// 体验中心推荐人添加奖金记录
//				IntegralAccount ila = new IntegralAccount();
//				long date3 = System.currentTimeMillis();
//				ila.setAccount_option("integral_bonus");
//				ila.setUser_basics_id(cbe.getUser_basics_id_referee());// 用户编号
//				ila.setAccount_option_name("奖金");
//				ila.setAccount_add_date(date3);
//				ila.setIntegral_account_num(String.valueOf(bonus));//
//				ila.setIntegral_account_explain("体验中心推荐奖");
//				ila.setIntegral_account_type(1);
//				integralMapper.addIntegralAccount(ila);// 推荐人添加奖金记录
//				// 添加消息提示
//				UserMessage um = new UserMessage();
//				um.setUser_basics_id(cbe.getUser_basics_id_referee());
//				um.setTb_id(cmm.getMonth_id());
//				um.setTb_name("company_month_sales");
//				um.setMessage_type(2);
//				um.setAdd_date(time);
//				um.setIf_read(0);
//				SimpleDateFormat sdf2 = new SimpleDateFormat(
//						"yyyy-MM-dd HH:mm:ss");
//				java.util.Date dt1 = new Date();
//				String update1 = sdf2.format(dt1);
//				String message = "您好，您推荐的体验中心“" + cbe.getCompany_name()
//						+ "”推荐奖已到账:" + bonus + "元。";
//				String message_content = PrivateMessages.getPushMessage(
//						update1, message);
//				um.setMessage_content(message_content);
//				userMessageMapper.addMessage(um);
//
//			}
			/**
			 * zrm 计算公司总销售量
			 */

//			double capital_number = 0.00;// 计算公司月销售总金额
//
//			HashMap<String, Object> map2 = new HashMap<String, Object>();
//			HashMap<String, Object> map3 = new HashMap<String, Object>();
//
//			map2.put("company_id", company_id);
//			map2.put("start_date", start_time);
//			map2.put("end_date", end_time);
//			List<CapitalAccount> listcap = capitalAccountMapper
//					.findCapitalCompany(map2);// 查询该公司上月购买流水
//			for (int j = 0; j < listcap.size(); j++) {
//				CapitalAccount cap = listcap.get(j);
//				capital_number += cap.getCapital_number();// 单笔金额
//			}
//			map3.put("month_date", date);// 销售月份
//			map3.put("month_money_untimely", capital_number);// 总销售金额
//			map3.put("company_id", company_id);// 公司编号
//			if (company_id != 1) {
//				map3.put("if_settlement", 1);
//			}
//			update += companyMonthMapper.updateCompanyCompany(map3);
//
//			// if(company_id<2){//略过总公司
//			// continue;
//			// }
//			/**
//			 * zrm 计算领衔创办人独享（第一个奖金池）
//			 */
//			int if_founder = cbe.getIf_founder();
//			if (if_founder == 1) {// 公司允许给领衔创办人分奖金
//				CoFounderMonSale cfm = new CoFounderMonSale();
//				cfm.setUser_basics_id(cbe.getUser_basics_id());
//				cfm.setMonth_date(date);
//				double bonus = 0.00;
//				CoFounderMonSale cf = coFounderMonSaleMapper
//						.findCoFounderOne(cfm);
//				if (cf != null&&cf.getFounder_bonus()>0) {
//					if (cf.getIf_settlement() == 0) {// 未结算
//						cfm.setIf_settlement(1);
//						coFounderMonSaleMapper.updateCoFounderMonSale(cfm);// 修改领衔创办人月销量为已结算
//						// 领衔创办人加15%及5%奖金
//						bonus = cf.getFounder_bonus();
//						Map<String, Object> map4 = new HashMap<String, Object>();
//						map4.put("user_basics_id", cbe.getUser_basics_id());
//						map4.put("integral_bonus", bonus);
//						userIntegralMapper.addBonus(map4);// 给领衔创办人添加15%及5%的奖金
//						// 添加历史奖金
//						UserAchievement ua = new UserAchievement();
//						ua.setRecords_bonus(String.valueOf(bonus));
//						ua.setUser_basics_id(cbe.getUser_basics_id());
//						userAchievementMapper.augmentUserAchievement(ua);
//						// 领衔创办人添加奖金记录
//						IntegralAccount ila = new IntegralAccount();
//						long date3 = System.currentTimeMillis();
//						ila.setAccount_option("integral_bonus");
//						ila.setUser_basics_id(cbe.getUser_basics_id());// 用户编号
//						ila.setAccount_option_name("奖金");
//						ila.setAccount_add_date(date3);
//						ila.setIntegral_account_num(String.valueOf(bonus));//
//						ila.setIntegral_account_explain("代理商管理奖");
//						ila.setIntegral_account_type(1);
//						integralMapper.addIntegralAccount(ila);// 领衔创办人添加奖金记录
//						// 添加消息提示
//						UserMessage um = new UserMessage();
//						um.setUser_basics_id(cbe.getUser_basics_id());
//						um.setTb_id(cf.getCo_founder_mon_sale_id());
//						um.setTb_name("co_founder_mon_sale");
//						um.setMessage_type(2);
//						um.setAdd_date(time);
//						um.setIf_read(0);
//						SimpleDateFormat sdf2 = new SimpleDateFormat(
//								"yyyy-MM-dd HH:mm:ss");
//						java.util.Date dt1 = new Date();
//						String update1 = sdf2.format(dt1);
//						String message = "您好，您上月体验中心管理奖已到账:" + bonus + "元。";
//						String message_content = PrivateMessages
//								.getPushMessage(update1, message);
//						um.setMessage_content(message_content);
//						userMessageMapper.addMessage(um);
//					}
//
//				}
//			}
			// 添加代理商对下级的管理奖
//			int company_lv = cbe.getCompany_lv();
//			if (company_lv < 4 && company_lv > 1) {// 地市和省级代理商拿下级2%的管理奖
//				double low_month_money_timely = cmm.getLow_month_money_timely();
//				if (low_month_money_timely > 1) {
//					// 地市和省级代理商拿下级2%奖金
//					double bonus = low_month_money_timely
//							* GlobalStatic.low_founder_bonus_low;
//					double bonus1 = cmm.getMonth_money_timely()
//							* GlobalStatic.low_founder_bonus;
//					bonus += bonus1;
//					Map<String, Object> mapLow = new HashMap<String, Object>();
//					mapLow.put("user_basics_id", cbe.getUser_basics_id());
//					mapLow.put("integral_bonus", bonus);
//					userIntegralMapper.addBonus(mapLow);// 地市和省级代理商拿下级2%奖金
//					// 添加历史奖金
//					UserAchievement ua = new UserAchievement();
//					ua.setRecords_bonus(String.valueOf(bonus));
//					ua.setUser_basics_id(cbe.getUser_basics_id());
//					userAchievementMapper.augmentUserAchievement(ua);
//					// 领衔创办人添加奖金记录
//					IntegralAccount ila = new IntegralAccount();
//					long date3 = System.currentTimeMillis();
//					ila.setAccount_option("integral_bonus");
//					ila.setUser_basics_id(cbe.getUser_basics_id());// 用户编号
//					ila.setAccount_option_name("奖金");
//					ila.setAccount_add_date(date3);
//					ila.setIntegral_account_num(String.valueOf(bonus));//
//					ila.setIntegral_account_explain("代理商对下级体验中心管理奖");
//					ila.setIntegral_account_type(1);
//					integralMapper.addIntegralAccount(ila);// 领衔创办人添加奖金记录
//					// 添加消息提示
//					UserMessage um = new UserMessage();
//					um.setUser_basics_id(cbe.getUser_basics_id());
//					um.setTb_id(cmm.getMonth_id());
//					um.setTb_name("company_month_sales");
//					um.setMessage_type(2);
//					um.setAdd_date(time);
//					um.setIf_read(0);
//					SimpleDateFormat sdf2 = new SimpleDateFormat(
//							"yyyy-MM-dd HH:mm:ss");
//					java.util.Date dt1 = new Date();
//					String update1 = sdf2.format(dt1);
//					String message = "您好，您的下级体验中心管理奖已到账:" + bonus + "元。";
//					String message_content = PrivateMessages.getPushMessage(
//							update1, message);
//					um.setMessage_content(message_content);
//					userMessageMapper.addMessage(um);
//				}
//			}

//			/**
//			 * zrm 按业绩分配奖金 （第二个奖金池） 联合创办人个人团队销售奖励 
//			 */
//			HashMap<String, Object> map4 = new HashMap<String, Object>();
//			map4.put("month_date", date);
//			map4.put("company_id", company_id);
//
//			List<CoFounderMonSale> listc = coFounderMonSaleMapper.findCompanyCo(map4);// 查询有业绩的联合创办人
//
//			CoFounderMonSale cof = new CoFounderMonSale();
//			for (int k = 0; k < listc.size(); k++) {
//				CoFounderMonSale cm = listc.get(k);
//				if (cm.getIf_settlement() == 0) {
//					//品牌大使团队奖金
//					UserInformationEntity ui=userInformationMapper.selectUserInformationEntityToUserId(cm.getUser_basics_id());
//					double team_bonus = cm.getMon_sale_timely();// 团队奖金等于业绩奖金
//					cof.setUser_basics_id(cm.getUser_basics_id());
//					cof.setMonth_date(date);
//					// cof.setTeam_bonus(team_bonus*0.04);//团队奖金
//					cof.setAchievement_bonus(team_bonus * GlobalStatic.co_user);// 业绩奖金5%
//					cof.setIf_settlement(1);// 状态改为已结算
//					HashMap<String, Object> map5 = new HashMap<String, Object>();
//					map5.put("company_id", company_id);
//					map5.put("start_date", start_time);
//					map5.put("end_date", end_time);
//					map5.put("co_user_basics_id", cm.getUser_basics_id());
//					List<CapitalAccount> listcap2 = capitalAccountMapper
//							.findCapitalCompany(map5);// 查询该联合创办人上月购买流水
//					double mon_sale_untimely = 0.00;
//					for (int l = 0; l < listcap2.size(); l++) {
//						mon_sale_untimely += listcap2.get(l)
//								.getCapital_number();
//					}
//					cof.setMon_sale_untimely(mon_sale_untimely);// 联合创办人月销售量(非及时)
//					coFounderMonSaleMapper.updateCoFounderMonSale(cof);
//
//					// 联合创办人加5%团队奖金
//					double teambonus=team_bonus * GlobalStatic.co_user;
//					int bonus =(int) teambonus;// 5%
//					Map<String, Object> map7 = new HashMap<String, Object>();
//					map7.put("user_basics_id", listc.get(k).getUser_basics_id());
//					map7.put("integral_bonus", bonus);
//					userIntegralMapper.addBonus(map7);// 给联合创办人添加10%的团队奖金
//					// 添加历史奖金
//					UserAchievement ua = new UserAchievement();
//					ua.setRecords_bonus(String.valueOf(bonus));
//					ua.setUser_basics_id(listc.get(k).getUser_basics_id());
//					ua.setCo_total_sale(bonus);
//					userAchievementMapper.augmentUserAchievement(ua);
//					// 给联合创办人添加5%的团队奖金记录
//					IntegralAccount ila = new IntegralAccount();
//					long date3 = System.currentTimeMillis();
//					ila.setAccount_option("integral_bonus");
//					ila.setUser_basics_id(listc.get(k).getUser_basics_id());// 用户编号
//					ila.setAccount_option_name("奖金");
//					ila.setAccount_add_date(date3);
//					ila.setIntegral_account_num(String.valueOf(bonus));// 10%
//					ila.setIntegral_account_explain("品牌大使团队奖金");
//					ila.setIntegral_account_type(1);
//					integralMapper.addIntegralAccount(ila);// 给联合创办人添加10%的团队奖金记录
//					// 添加消息提示
//					UserMessage um = new UserMessage();
//					um.setUser_basics_id(listc.get(k).getUser_basics_id());
//					um.setTb_id(cm.getCo_founder_mon_sale_id());
//					um.setTb_name("co_founder_mon_sale");
//					um.setMessage_type(2);
//					um.setAdd_date(time);
//					um.setIf_read(0);
//					SimpleDateFormat sdf2 = new SimpleDateFormat(
//							"yyyy-MM-dd HH:mm:ss");
//					java.util.Date dt1 = new Date();
//					String update1 = sdf2.format(dt1);
//					String message = "您好，您上月团队奖已到账:" + bonus + "元。";
//					String message_content = PrivateMessages.getPushMessage(
//							update1, message);
//					um.setMessage_content(message_content);
//					userMessageMapper.addMessage(um);
//					
//					//1级上级品牌大使添加奖金
//					UserInformationEntity uif1=userRecommendMapper.selectOlderUser(cm.getUser_basics_id());
//					if(uif1==null||uif1.getUser_basics_id()==1){
//						continue;
//					}
//					if(uif1.getCo_founder()==3){
//
//						// 1级上级品牌大使加6%团队奖金
//						double teambonus1=team_bonus * GlobalStatic.co1;// 6%
//						int bonus1 = (int) teambonus1;
//						map7.put("user_basics_id", uif1.getUser_basics_id());
//						map7.put("integral_bonus", bonus1);
//						userIntegralMapper.addBonus(map7);// 给1级上级品牌大使添加6%的团队奖金
//						// 添加历史奖金
//						ua.setRecords_bonus(String.valueOf(bonus1));
//						ua.setUser_basics_id(uif1.getUser_basics_id());
//						ua.setCo_total_sale(bonus1);
//						userAchievementMapper.augmentUserAchievement(ua);
//						// 给1级上级品牌大使添加6%的团队奖金记录
//						ila.setAccount_option("integral_bonus");
//						ila.setUser_basics_id(uif1.getUser_basics_id());// 用户编号
//						ila.setAccount_option_name("奖金");
//						ila.setAccount_add_date(date3);
//						ila.setIntegral_account_num(String.valueOf(bonus1));// 6%
//						ila.setIntegral_account_explain(ui.getInformation_compellation()+"团队奖金");
//						ila.setIntegral_account_type(1);
//						integralMapper.addIntegralAccount(ila);// 给1级上级添加6%的团队奖金记录
//						// 添加消息提示
//						um.setUser_basics_id(uif1.getUser_basics_id());
//						um.setTb_id(cm.getCo_founder_mon_sale_id());
//						um.setTb_name("co_founder_mon_sale");
//						um.setMessage_type(2);
//						um.setAdd_date(time);
//						um.setIf_read(0);
//						String message1 = "您好，您上月第一代"+ui.getInformation_compellation()+"团队奖已到账:" + bonus1 + "元。";
//						String message_content1 = PrivateMessages.getPushMessage(
//								update1, message1);
//						um.setMessage_content(message_content1);
//						userMessageMapper.addMessage(um);
//					}
//					//2级上级品牌大使添加奖金
//					UserInformationEntity uif2=userRecommendMapper.selectOlderUser(uif1.getUser_basics_id());
//					if(uif2==null||uif2.getUser_basics_id()==1){
//						continue;
//					}
//					if(uif2.getCo_founder()==3){
//						// 2级上级品牌大使加4%团队奖金
//						double teambonus2= team_bonus * GlobalStatic.co2;// 4%
//						int bonus2 = (int)teambonus2;
//						map7.put("user_basics_id", uif2.getUser_basics_id());
//						map7.put("integral_bonus", bonus2);
//						userIntegralMapper.addBonus(map7);// 给1级上级品牌大使添加4%的团队奖金
//						// 添加历史奖金
//						ua.setRecords_bonus(String.valueOf(bonus2));
//						ua.setUser_basics_id(uif2.getUser_basics_id());
//						ua.setCo_total_sale(bonus2);
//						userAchievementMapper.augmentUserAchievement(ua);
//						// 给2级上级品牌大使添加4%的团队奖金记录
//						ila.setAccount_option("integral_bonus");
//						ila.setUser_basics_id(uif2.getUser_basics_id());// 用户编号
//						ila.setAccount_option_name("奖金");
//						ila.setAccount_add_date(date3);
//						ila.setIntegral_account_num(String.valueOf(bonus2));// 4%
//						ila.setIntegral_account_explain(ui.getInformation_compellation()+"团队奖金");
//						ila.setIntegral_account_type(1);
//						integralMapper.addIntegralAccount(ila);// 给1级上级添加4%的团队奖金记录
//						// 添加消息提示
//						um.setUser_basics_id(uif2.getUser_basics_id());
//						um.setTb_id(cm.getCo_founder_mon_sale_id());
//						um.setTb_name("co_founder_mon_sale");
//						um.setMessage_type(2);
//						um.setAdd_date(time);
//						um.setIf_read(0);
//						String message2 = "您好，您上月第二代"+ui.getInformation_compellation()+"团队奖已到账:" + bonus2 + "元。";
//						String message_content2 = PrivateMessages.getPushMessage(
//								update1, message2);
//						um.setMessage_content(message_content2);
//						userMessageMapper.addMessage(um);
//					}
//				}
//
//			}
			/**
			 * zrm 团队平均分配奖励 (第三个奖金池)
			 */
			// HashMap<String,Object> map6 =new HashMap<String,Object>();
			// map6.put("company_id", company_id);
			// List<UserInformationEntity>
			// list=coFounderMonSaleMapper.findCompanyCountCountCo(map6);//查询所有联合创办人
			// int countCo=list.size();//查询所有联合创办人数量
			// CoFounderMonSale cofms=new CoFounderMonSale();
			// for(int c=0;c<list.size();c++){
			// cofms.setMonth_date(date);
			// cofms.setUser_basics_id(list.get(c).getUser_basics_id());
			// CoFounderMonSale
			// sd=coFounderMonSaleMapper.findCoFounderOne(cofms);
			// cofms.setAvg_bonus(month_money_timely/countCo*0.03);
			// if(sd!=null){
			// coFounderMonSaleMapper.updateCoFounderMonSale(cofms);
			// }else{
			// coFounderMonSaleMapper.insertCoFounderMonSale(cofms);
			// }
			// //联合创办人加3%平均奖金
			// UserIntegral
			// uil1=userIntegralMapper.findUserIntegralAll(list.get(c).getUser_basics_id());
			// double bonus2=month_money_timely/countCo*0.03;
			// if(uil1.getIntegral_bonus()!=null){
			// bonus2=bonus2+uil1.getIntegral_bonus();
			// }
			// Map<String, Object> map8=new HashMap<String, Object>();
			// map8.put("user_basics_id",list.get(c).getUser_basics_id());
			// map8.put("integral_bonus",bonus2);
			// userIntegralMapper.addBonus(map8);//给联合创办人平均奖金
			// //添加历史奖金
			// UserAchievement ua=new UserAchievement();
			// ua.setRecords_bonus(String.valueOf(month_money_timely/countCo*0.03));
			// ua.setUser_basics_id(list.get(c).getUser_basics_id());
			// userAchievementMapper.augmentUserAchievement(ua);
			// //给联合创办人添加平均奖金记录
			// IntegralAccount ila1=new IntegralAccount();
			// long date4=System.currentTimeMillis();
			// ila1.setAccount_option("integral_bonus");
			// ila1.setUser_basics_id(list.get(c).getUser_basics_id());//用户编号
			// ila1.setAccount_option_name("奖金");
			// ila1.setAccount_add_date(date4);
			// ila1.setIntegral_account_num(String.valueOf(month_money_timely/countCo*0.03));//
			// ila1.setIntegral_account_explain("联合创办人平均奖金");
			// ila1.setIntegral_account_type(1);
			// integralMapper.addIntegralAccount(ila1);//给联合创办人添加平均奖金记录
			// }

//		}
//		int useGreen_kaba = GlobalStatic.useGreen_kaba;// 绿卡巴兑换奖金池所需积分
//		int useIndigo_kaba = GlobalStatic.useIndigo_kaba;// 青卡巴兑换奖金池所需积分
//		int useBlue_violet_kaba = GlobalStatic.useBlue_violet_kaba;// 蓝卡巴兑换奖金池所需积分
//		int usePurple_kaba = GlobalStatic.usePurple_kaba;// 紫卡巴兑换奖金池所需积分
//		// 查询总公司奖金池
//		CompanyMonthSales cmm1 = new CompanyMonthSales();
//		cmm1.setCompany_id(1);
//		cmm1.setMonth_date(date);
//		CompanyMonthSales cmm2 = companyMonthMapper.findMonthSalesOne(cmm1);
//		if (cmm2 == null) {// 若总共公司奖金池为空,则不能分配
//			return update;
//		}
//		if (cmm2.getIf_settlement() == 1) {// 已分配过的不能再分配
//			return update;
//		}
//		double green_kaba = cmm2.getGreen_kaba();// 青卡巴奖金池上月
//		double indigo_kaba = cmm2.getIndigo_kaba();// 青卡巴奖金池上月
//		double blue_violet_kaba = cmm2.getBlue_violet_kaba();// 蓝卡巴奖金池上月
//		double purple_kaba = cmm2.getPurple_kaba();// 紫卡巴奖金池上月
//
//		// 将奖金池70%发放到下个月
//		HashMap<String, Object> vipmap = new HashMap<String, Object>();
//		// vipmap.put("company_id", 1);
//
//		vipmap.put("user_grade_id", 3);//绿卡巴会员
//		vipmap.put("integral_basics", useGreen_kaba);
//		List<BasicsUser> greenliset = basicUserMapper.findGrade(vipmap);// 公司青卡巴会员
//		vipmap.put("user_grade_id", 4);// 青卡巴会员
//		vipmap.put("integral_basics", useIndigo_kaba);
//		List<BasicsUser> indigoliset = basicUserMapper.findGrade(vipmap);// 公司青卡巴会员
//		vipmap.put("user_grade_id", 5);// 蓝卡巴会员
//		vipmap.put("integral_basics", useBlue_violet_kaba);
//		List<BasicsUser> blueliset = basicUserMapper.findGrade(vipmap);// 公司蓝卡巴会员
//		vipmap.put("user_grade_id", 6);// 紫卡巴会员
//		vipmap.put("integral_basics", usePurple_kaba);
//		List<BasicsUser> purpleliset = basicUserMapper.findGrade(vipmap);// 公司紫卡巴会员
//		cmm1.setMonth_date(date2);
//		CompanyMonthSales cms3 = companyMonthMapper.findMonthSalesOne(cmm1);// 查询总公司本月销售量
//		CompanyMonthSales cms1 = new CompanyMonthSales();
//		cms1.setMonth_date(date2);
//		cms1.setCompany_id(1);
//		cms1.setIf_settlement(0);
//		if (greenliset.size() > 0&&green_kaba*0.6>=200000) {
//			cms1.setGreen_kaba(green_kaba * GlobalStatic.last_month_balance);// 公司有绿卡巴会员0.4
//			cms1.setOld_green_kaba(green_kaba * GlobalStatic.last_month_balance);// 上月结余0.4
//		} else {
//			cms1.setGreen_kaba(green_kaba);// 公司无青卡巴会员
//			cms1.setOld_green_kaba(green_kaba);// 上月结余
//		}
//		if (indigoliset.size() > 0&&indigo_kaba*0.6>=200000) {
//			cms1.setIndigo_kaba(indigo_kaba * GlobalStatic.last_month_balance);// 公司有青卡巴会员0.4
//			cms1.setOld_indigo_kaba(indigo_kaba
//					* GlobalStatic.last_month_balance);// 上月结余0.4
//		} else {
//			cms1.setIndigo_kaba(indigo_kaba);// 公司无青卡巴会员
//			cms1.setOld_indigo_kaba(indigo_kaba);// 上月结余
//		}
//		if (blueliset.size() > 0&&blue_violet_kaba*0.6>=200000) {
//			cms1.setBlue_violet_kaba(blue_violet_kaba
//					* GlobalStatic.last_month_balance);// 有蓝卡巴会员 0.4
//			cms1.setOld_blue_violet_kaba(blue_violet_kaba
//					* GlobalStatic.last_month_balance);// 0.4
//		} else {
//			cms1.setBlue_violet_kaba(blue_violet_kaba);// 无蓝卡巴会员
//			cms1.setOld_blue_violet_kaba(blue_violet_kaba);
//		}
//		if (purpleliset.size() > 0&&purple_kaba*0.6>=200000) {
//			cms1.setPurple_kaba(purple_kaba * GlobalStatic.last_month_balance);// 公司有紫卡巴会员
//			cms1.setOld_purple_kaba(purple_kaba
//					* GlobalStatic.last_month_balance);
//		} else {
//			cms1.setPurple_kaba(purple_kaba);// 公司无紫卡巴会员
//			cms1.setOld_purple_kaba(purple_kaba);
//		}
//
//		if (cms3 == null) {
//			cms1.setStart_time(start_time);
//			cms1.setEnd_time(end_time);
//			cms1.setIf_settlement(0);
//			cms1.setMonth_money_timely(0.00);// 初始化销售量
//			cms1.setLow_month_money_timely(0.00);
//			cms1.setLow_month_money_untimely(0.00);
//			cms1.setMonth_money_untimely(0.00);
//			companyMonthMapper.insertCompanyMonth(cms1);
//		} else {
//			double green_kaba1 = cms1.getGreen_kaba();// 绿卡巴奖金池上月剩余的奖金
//			double indigo_kaba1 = cms1.getIndigo_kaba();// 青卡巴奖金池上月剩余的奖金
//			double blue_violet_kaba1 = cms1.getBlue_violet_kaba();// 蓝卡巴奖金池上月剩余的奖金
//			double purple_kaba1 = cms1.getPurple_kaba();// 紫卡巴奖金池上月剩余的奖金
//			if (cms3.getGreen_kaba() != null) {
//				cms1.setGreen_kaba(green_kaba1);
//			}
//			if (cms3.getIndigo_kaba() != null) {
//				cms1.setIndigo_kaba(indigo_kaba1);
//			}
//			if (cms3.getBlue_violet_kaba() != null) {
//				cms1.setBlue_violet_kaba(blue_violet_kaba1);
//			}
//			if (cms3.getPurple_kaba() != null) {
//				cms1.setPurple_kaba(purple_kaba1);
//			}
//			companyMonthMapper.updateCompanyMonth(cms1);
//		}
//		// 将公司绿卡巴奖金池分配给公司绿卡巴会员
//		HashMap<String, Object> map4 = new HashMap<String, Object>();// 减去积分
//		HashMap<String, Object> mapp = new HashMap<String, Object>();
//		mapp.put("user_grade_id", 3);
//		mapp.put("integral_basics", useGreen_kaba);
//		GoldPoolShare gps = new GoldPoolShare();// 奖金记录
//		long date3 = System.currentTimeMillis();
//		for (BasicsUser mapaaa : greenliset) {
//			if(green_kaba*0.6<200000){
//				continue;
//			}
//			
//			double num1 = green_kaba * (1-GlobalStatic.last_month_balance)/ greenliset.size();
//			int num=(int) num1;
//			if(num<=0){
//				continue;
//			}
//			int user_basics_id = mapaaa.getUser_basics_id();
//			//添加奖金
////			HashMap<String, Object> mapa2 = new HashMap<String, Object>();
////			mapa2.put("integral_bonus", num);
////			mapa2.put("user_basics_id", mapaaa.getUser_basics_id());
////			userIntegralMapper.addBonus(mapa2);
//			// 添加历史奖金
//			UserAchievement ua = new UserAchievement();
//			ua.setRecords_bonus(String.valueOf(num));
//			ua.setUser_basics_id(Integer.valueOf(String.valueOf(user_basics_id)));
//			userAchievementMapper.augmentUserAchievement(ua);
//			// 添加分红记录
//			gps.setUser_basics_id(Integer.valueOf(String
//					.valueOf(user_basics_id)));
//			gps.setAdd_date(date3);
//			gps.setMonth_date(date);
//			gps.setShare_money(Double.valueOf(String.valueOf(num)));
//			gps.setGold_pool(3);
//			int key = goldPoolShareMapper.addGoldPoolShare(gps);
//			// 绿卡巴会员添加奖金记录
//			IntegralAccount ila = new IntegralAccount();
//			ila.setAccount_option("integral_bonus");
//			ila.setUser_basics_id(Integer.valueOf(String
//					.valueOf(user_basics_id)));// 用户编号
//			ila.setAccount_option_name("奖金");
//			ila.setAccount_add_date(date3);
//			ila.setIntegral_account_num(String.valueOf(num));//
//			ila.setIntegral_account_explain("丽天使平分奖金池：");
//			ila.setIntegral_account_type(2);
//			ila.setIntegral_trigger(key);
//			integralMapper.addIntegralAccount(ila);// 绿卡巴会员添加奖金记录
//			// 减去兑换奖金池所需积分 添加奖金
//			map4.put("user_basics_id", user_basics_id);
//			map4.put("integral_basics", useGreen_kaba);
//			map4.put("integral_bonus", num);// 添加实时奖金
//			userIntegralMapper.useUserIntegral(map4);// 减去兑换奖金池所需积分
//			// 兑换奖金池使用积分记录
//			IntegralAccount ilaa = new IntegralAccount();
//			ilaa.setAccount_option("integral_basics");
//			ilaa.setUser_basics_id(user_basics_id);// 用户编号
//			ilaa.setAccount_option_name("积分");
//			ilaa.setAccount_add_date(date3);
//			ilaa.setIntegral_account_num(String.valueOf(useGreen_kaba
//					- useGreen_kaba - useGreen_kaba));//
//			ilaa.setIntegral_account_explain("丽天使兑换奖金池使用积分： ");
//			ilaa.setIntegral_account_type(2);
//			ilaa.setIntegral_trigger(key);
//			integralMapper.addIntegralAccount(ilaa);// 绿卡巴会员添加奖金记录
//			gps = new GoldPoolShare();
//			// 添加消息提示
//			UserMessage um = new UserMessage();
//			um.setUser_basics_id(user_basics_id);
//			um.setTb_id(cmm2.getMonth_id());
//			um.setTb_name("company_month_sales");
//			um.setMessage_type(2);
//			um.setAdd_date(time);
//			um.setIf_read(0);
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			java.util.Date dt1 = new Date();
//			String update1 = sdf2.format(dt1);
//			String message = "您好，您上月参与丽天使能量池分红:" + num + "元。";
//			String message_content = PrivateMessages.getPushMessage(update1,
//					message);
//			um.setMessage_content(message_content);
//			userMessageMapper.addMessage(um);
//		}
//		// 将公司青卡巴奖金池分配给公司青卡巴会员
//		mapp.put("user_grade_id", 4);
//		mapp.put("integral_basics", useIndigo_kaba);
//		for (BasicsUser mapaaa : indigoliset) {
//			if(indigo_kaba*0.6<200000){
//				continue;
//			}
//			double num1 = indigo_kaba * (1-GlobalStatic.last_month_balance) / indigoliset.size();
//			int num=(int) num1;
//			if(num<=0){
//				continue;
//			}
//			int user_basics_id = mapaaa.getUser_basics_id();
//			//添加奖金
////			HashMap<String, Object> mapa2 = new HashMap<String, Object>();
////			mapa2.put("integral_bonus", num);
////			mapa2.put("user_basics_id", mapaaa.getUser_basics_id());
////			userIntegralMapper.addBonus(mapa2);
//			// 添加历史奖金
//			UserAchievement ua = new UserAchievement();
//			ua.setRecords_bonus(String.valueOf(num));
//			ua.setUser_basics_id(Integer.valueOf(String.valueOf(user_basics_id)));
//			userAchievementMapper.augmentUserAchievement(ua);
//			// 添加分红记录
//			gps.setUser_basics_id(Integer.valueOf(String
//					.valueOf(user_basics_id)));
//			gps.setAdd_date(date3);
//			gps.setMonth_date(date);
//			gps.setShare_money(Double.valueOf(String.valueOf(num)));
//			gps.setGold_pool(4);
//			int key = goldPoolShareMapper.addGoldPoolShare(gps);
//			// 青卡巴会员添加奖金记录
//			IntegralAccount ila = new IntegralAccount();
//			ila.setAccount_option("integral_bonus");
//			ila.setUser_basics_id(Integer.valueOf(String
//					.valueOf(user_basics_id)));// 用户编号
//			ila.setAccount_option_name("奖金");
//			ila.setAccount_add_date(date3);
//			ila.setIntegral_account_num(String.valueOf(num));//
//			ila.setIntegral_account_explain("能天使平分奖金池：");
//			ila.setIntegral_account_type(2);
//			ila.setIntegral_trigger(key);
//			integralMapper.addIntegralAccount(ila);// 青卡巴会员添加奖金记录
//			// 减去兑换奖金池所需积分 添加奖金
//			map4.put("user_basics_id", user_basics_id);
//			map4.put("integral_basics", useIndigo_kaba);
//			map4.put("integral_bonus", num);// 添加实时奖金
//			userIntegralMapper.useUserIntegral(map4);// 减去兑换奖金池所需积分
//			// 兑换奖金池使用积分记录
//			IntegralAccount ilaa = new IntegralAccount();
//			ilaa.setAccount_option("integral_basics");
//			ilaa.setUser_basics_id(user_basics_id);// 用户编号
//			ilaa.setAccount_option_name("积分");
//			ilaa.setAccount_add_date(date3);
//			ilaa.setIntegral_account_num(String.valueOf(useIndigo_kaba
//					- useIndigo_kaba - useIndigo_kaba));//
//			ilaa.setIntegral_account_explain("能天使兑换奖金池使用积分：  ");
//			ilaa.setIntegral_account_type(2);
//			ilaa.setIntegral_trigger(key);
//			integralMapper.addIntegralAccount(ilaa);// 青卡巴会员添加奖金记录
//			gps = new GoldPoolShare();
//			// 添加消息提示
//			UserMessage um = new UserMessage();
//			um.setUser_basics_id(user_basics_id);
//			um.setTb_id(cmm2.getMonth_id());
//			um.setTb_name("company_month_sales");
//			um.setMessage_type(2);
//			um.setAdd_date(time);
//			um.setIf_read(0);
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			java.util.Date dt1 = new Date();
//			String update1 = sdf2.format(dt1);
//			String message = "您好，您上月参与能天使能量池分红:" + num + "元。";
//			String message_content = PrivateMessages.getPushMessage(update1,
//					message);
//			um.setMessage_content(message_content);
//			userMessageMapper.addMessage(um);
//		}
//		// 将公司蓝卡巴奖金池分配给公司蓝卡巴会员
//		mapp.put("user_grade_id", 5);
//		mapp.put("integral_basics", useBlue_violet_kaba);
//		for (BasicsUser mapaaaa : blueliset) {
//			if(blue_violet_kaba*0.6<200000){
//				continue;
//			}
//			double num1 = blue_violet_kaba * (1-GlobalStatic.last_month_balance) / blueliset.size();
//			int num=(int) num1;
//			if(num<=0){
//				continue;
//			}
//			int user_basics_id = mapaaaa.getUser_basics_id();
//			//添加奖金
////			HashMap<String, Object> mapa2 = new HashMap<String, Object>();
////			mapa2.put("integral_bonus", num);
////			mapa2.put("user_basics_id", user_basics_id);
////			userIntegralMapper.addBonus(mapa2);
//			// 添加历史奖金
//			UserAchievement ua = new UserAchievement();
//			ua.setRecords_bonus(String.valueOf(num));
//			ua.setUser_basics_id(Integer.valueOf(String.valueOf(user_basics_id)));
//			userAchievementMapper.augmentUserAchievement(ua);
//			// 添加分红记录
//			gps.setUser_basics_id(Integer.valueOf(String
//					.valueOf(user_basics_id)));
//			gps.setAdd_date(date3);
//			gps.setMonth_date(date);
//			gps.setShare_money(Double.valueOf(String.valueOf(num)));
//			gps.setGold_pool(5);
//			int key = goldPoolShareMapper.addGoldPoolShare(gps);
//			// 蓝卡巴会员添加奖金记录
//			IntegralAccount ila = new IntegralAccount();
//			ila.setAccount_option("integral_bonus");
//			ila.setUser_basics_id(Integer.valueOf(String
//					.valueOf(user_basics_id)));// 用户编号
//			ila.setAccount_option_name("奖金");
//			ila.setAccount_add_date(date3);
//			ila.setIntegral_account_num(String.valueOf(num));//
//			ila.setIntegral_account_explain("量天使平分奖金池：");
//			ila.setIntegral_account_type(2);
//			ila.setIntegral_trigger(key);
//			integralMapper.addIntegralAccount(ila);// 蓝紫卡巴会员添加奖金记录
//			// 减去兑换奖金池所需积分 添加实时奖金
//			map4.put("user_basics_id", user_basics_id);
//			map4.put("integral_basics", useBlue_violet_kaba);
//			map4.put("integral_bonus", num);// 添加实时奖金
//			userIntegralMapper.useUserIntegral(map4);// 减去兑换奖金池所需积分
//			// 兑换奖金池使用积分记录
//			IntegralAccount ilaa = new IntegralAccount();
//			ilaa.setAccount_option("integral_basics");
//			ilaa.setUser_basics_id(Integer.valueOf(String
//					.valueOf(user_basics_id)));// 用户编号
//			ilaa.setAccount_option_name("积分");
//			ilaa.setAccount_add_date(date3);
//			ilaa.setIntegral_account_num(String.valueOf(useBlue_violet_kaba
//					- useBlue_violet_kaba - useBlue_violet_kaba));//
//			ilaa.setIntegral_account_explain("量天使兑换奖金池使用积分： ");
//			ilaa.setIntegral_account_type(2);
//			ilaa.setIntegral_trigger(key);
//			integralMapper.addIntegralAccount(ilaa);// 紫卡巴会员添加奖金记录
//			gps = new GoldPoolShare();
//			// 添加消息提示
//			UserMessage um = new UserMessage();
//			um.setUser_basics_id(user_basics_id);
//			um.setTb_id(cmm2.getMonth_id());
//			um.setTb_name("company_month_sales");
//			um.setMessage_type(2);
//			um.setAdd_date(time);
//			um.setIf_read(0);
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			java.util.Date dt1 = new Date();
//			String update1 = sdf2.format(dt1);
//			String message = "您好，您上月参与量天使能量池分红:" + num + "元。";
//			String message_content = PrivateMessages.getPushMessage(update1,
//					message);
//			um.setMessage_content(message_content);
//			userMessageMapper.addMessage(um);
//		}
//		// 将公司紫卡巴奖金池分配给公司紫卡巴会员
//		mapp.put("user_grade_id", 6);
//		mapp.put("integral_basics", usePurple_kaba);
//		for (BasicsUser mapaa : purpleliset) {
//			if(purple_kaba*0.6<200000){
//				continue;
//			}
//			double num1 = purple_kaba * (1-GlobalStatic.last_month_balance) / purpleliset.size();
//			int num=(int) num1;
//			if(num<=0){
//				continue;
//			}
//			int user_basics_id = mapaa.getUser_basics_id();
//			//添加奖金
////			HashMap<String, Object> mapa2 = new HashMap<String, Object>();
////			mapa2.put("integral_bonus", num);
////			mapa2.put("user_basics_id", user_basics_id);
////			userIntegralMapper.addBonus(mapa2);
//			// 添加历史奖金
//			UserAchievement ua = new UserAchievement();
//			ua.setRecords_bonus(String.valueOf(num));
//			ua.setUser_basics_id(Integer.valueOf(String.valueOf(user_basics_id)));
//			userAchievementMapper.augmentUserAchievement(ua);
//			// 添加分红记录
//			gps.setUser_basics_id(Integer.valueOf(String
//					.valueOf(user_basics_id)));
//			gps.setAdd_date(date3);
//			gps.setMonth_date(date);
//			gps.setShare_money(Double.valueOf(String.valueOf(num)));
//			gps.setGold_pool(6);
//			int key = goldPoolShareMapper.addGoldPoolShare(gps);
//			// 紫卡巴会员添加奖金记录
//			IntegralAccount ila = new IntegralAccount();
//			ila.setAccount_option("integral_bonus");
//			ila.setUser_basics_id(Integer.valueOf(String
//					.valueOf(user_basics_id)));// 用户编号
//			ila.setAccount_option_name("奖金");
//			ila.setAccount_add_date(date3);
//			ila.setIntegral_account_num(String.valueOf(num));//
//			ila.setIntegral_account_explain("智天使平分奖金池：");
//			ila.setIntegral_account_type(2);
//			ila.setIntegral_trigger(key);
//			integralMapper.addIntegralAccount(ila);// 紫卡巴会员添加奖金记录
//			// 减去兑换奖金池所需积分 添加实时奖金
//			map4.put("user_basics_id", user_basics_id);
//			map4.put("integral_basics", usePurple_kaba);
//			map4.put("integral_bonus", num);// 添加实时奖金
//			userIntegralMapper.useUserIntegral(map4);// 减去兑换奖金池所需积分
//			// 兑换奖金池使用积分记录
//			IntegralAccount ilaa = new IntegralAccount();
//			ilaa.setAccount_option("integral_basics");
//			ilaa.setUser_basics_id(Integer.valueOf(String
//					.valueOf(user_basics_id)));// 用户编号
//			ilaa.setAccount_option_name("积分");
//			ilaa.setAccount_add_date(date3);
//			ilaa.setIntegral_account_num(String.valueOf(usePurple_kaba
//					- usePurple_kaba - usePurple_kaba));//
//			ilaa.setIntegral_account_explain("智天使兑换奖金池使用积分： ");
//			ilaa.setIntegral_account_type(2);
//			ilaa.setIntegral_trigger(key);
//			integralMapper.addIntegralAccount(ilaa);// 紫卡巴会员添加奖金记录
//			gps = new GoldPoolShare();
//			// 添加消息提示
//			UserMessage um = new UserMessage();
//			um.setUser_basics_id(user_basics_id);
//			um.setTb_id(cmm2.getMonth_id());
//			um.setTb_name("company_month_sales");
//			um.setMessage_type(2);
//			um.setAdd_date(time);
//			um.setIf_read(0);
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			java.util.Date dt1 = new Date();
//			String update1 = sdf2.format(dt1);
//			String message = "您好，您上月参与智天使能量池分红:" + num + "元。";
//			String message_content = PrivateMessages.getPushMessage(update1,
//					message);
//			um.setMessage_content(message_content);
//			userMessageMapper.addMessage(um);
//		}
//		// 修改为已结算
//		CompanyMonthSales cmm3 = new CompanyMonthSales();
//		cmm3.setCompany_id(cmm2.getCompany_id());
//		cmm3.setMonth_date(cmm2.getMonth_date());
//		cmm3.setIf_settlement(1);
//		cmm3.setIndigo_kaba_num(greenliset.size());// 绿卡巴人数
//		cmm3.setIndigo_kaba_num(indigoliset.size());// 青卡巴人数
//		cmm3.setBlue_violet_kaba_num(blueliset.size());// 蓝卡巴人数
//		cmm3.setPurple_kaba_num(purpleliset.size());// 紫卡巴人数
//		companyMonthMapper.updateCompanyMonth(cmm3);// 修改为已结算
//
//		if (update > 0) {
//			return update;
//		} else {
//			return -1;
//		}
//
//	}
//
//	public List<HashMap> addbouns(HashMap<String, Object> map,
//			double avg_month_money_timely) {
//		List<BasicsUser> liset = basicUserMapper.findGrade(map);
//		int countgrean = liset.size();
//		List<HashMap> listhash = new ArrayList<HashMap>();
//		HashMap<String, Object> map2 = new HashMap<String, Object>();
//		HashMap<String, Object> map3 = new HashMap<String, Object>();
//		map3.put("user_grade_id", map.get("user_grade_id"));
//		if (countgrean > 0) {
//			for (int p = 0; p < liset.size(); p++) {
//				BasicsUser bu = liset.get(p);
//				map3.put("user_basics_id", bu.getUser_basics_id());
//				map3.put("integral_basics", map.get("integral_basics"));
//				UserIntegral uil = userIntegralMapper.findUserIntegralAll(map3);
//				double bonus = avg_month_money_timely / countgrean;
//				if (uil.getIntegral_bonus() != null) {
//					bonus = bonus + uil.getIntegral_bonus();
//				}
//				map2.put("user_basics_id", bu.getUser_basics_id());
//				map2.put("integral_bonus", bonus);
//				map2.put("avg_bonus", avg_month_money_timely / countgrean);
//				listhash.add(map2);
//
//			}
//		}
//
//		return listhash;
//
//	}

	@Override
	public CompanyMonthSales selectCompanyMonthByMonth(
			CompanyMonthSales companyMonthSales) {
		return companyMonthMapper.selectCompanyMonthByMonth(companyMonthSales);
	}

}
