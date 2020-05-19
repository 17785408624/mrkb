/**
 * FileName:         CompanyController.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-3     上午10:18:28
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-3     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.web.controller.weixin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.session.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.util.ResponseData;
import com.mrkb.common.utils.JsonUtils;
import com.mrkb.common.utils.globalStatic.GlobalStatic;
import com.mrkb.dao.modle.account.CapitalAccount;
import com.mrkb.dao.modle.company.CompanyMonthSales;
import com.mrkb.service.AccountService;
import com.mrkb.service.CoFounderService;
import com.mrkb.service.CompanyMonthService;
import com.mrkb.service.UserService;
import com.mrkb.shiro.cookieutil.SessionEntity;


/**
 * @param
 * @return
 * @author liangyi
 * 
 */
@Controller("weixin/wexin_company")
@RequestMapping("/weixin/weixin_company")
public class CompanyController {
	@Autowired
	private CompanyMonthService companyMonthService;
	@Autowired
	private CoFounderService coFounderService;
	@Autowired
	private UserService userService;
	@Autowired
	AccountService accountService;
	
	/**
	 * 
	 * @Title: findCompanyMonthByMonth
	 * @Description: 根据月份及总公司id查询各个奖金池收入情况 TODO
	 * @param: @param response
	 * @param: @param request
	 * @param: @return
	 * @return: VisitConsequenceParent
	 * @throws
	 */
	@RequestMapping("findCompanyMonthByMonth")
	public @ResponseBody ResponseData findCompanyMonthByMonth(
			HttpServletResponse response, HttpServletRequest request) {
		ResponseData rs = new ResponseData();
		Map<String, Object> map = new HashMap<String, Object>();
		SessionEntity sessionEntity = null;
		CompanyMonthSales comSales = new CompanyMonthSales();
		/*会员达到领取各个奖金池奖励的最低积分线*/
		Integer  useGreenKabaIntegra  =GlobalStatic.useGreen_kaba;
		Integer useIndigoKabaIntegra = GlobalStatic.useIndigo_kaba;	
		Integer useBlueKabaIntegra = GlobalStatic.useBlue_violet_kaba;
		Integer usePurpleKabaIntegra = GlobalStatic.usePurple_kaba;
		/* 总公司id */
		Integer company_id = 1;
		/* 各个奖金池人数参数初始化 */
		Integer greenKabaCount = 0;
		Integer indigoKabaCount = 0;
		Integer blueVioletKabaCount = 0;
		Integer purpleKabaCount = 0;
		/* 获取用户id */
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rs.setMessage("数据异常");
			rs.setIsSuccess(false);
			// return "error/error";
			return rs;
		}
		String month_date = request.getParameter("month_date");
		if(month_date.equals("")||month_date==null){
			rs.setMessage("请求参数异常");
			rs.setIsSuccess(false);
			return rs;
		}
		
		comSales.setCompany_id(company_id);
		comSales.setMonth_date(month_date);
		/* 查询各个奖金池收入数据 */
		CompanyMonthSales comMonthSales = companyMonthService
				.selectCompanyMonthByMonth(comSales);
	     /* 统计各个奖金池分红人数 */
		greenKabaCount  = userService.selectUserGradeIdCount(3,useGreenKabaIntegra);
		indigoKabaCount = userService.selectUserGradeIdCount(4,useIndigoKabaIntegra);
		blueVioletKabaCount = userService.selectUserGradeIdCount(5,useBlueKabaIntegra);
		purpleKabaCount = userService.selectUserGradeIdCount(6,usePurpleKabaIntegra);
		
		if (comMonthSales != null) {
			/* 将各个奖金池人数注入到实体对象中 */
			comMonthSales.setGreenKabaCount(greenKabaCount);
			comMonthSales.setIndigoKabaCount(indigoKabaCount);
			comMonthSales.setBlueVioletKabaCount(blueVioletKabaCount);
			comMonthSales.setPurpleKabaCount(purpleKabaCount);
		}

		/* map封装各个奖金池数据，积分奖励 */
		map.put("comMonthSales", comMonthSales);

		if (map.size() != 0) {
			rs.setMessage("查询成功");
			rs.setData(map);
			rs.setIsSuccess(true);

		} else {
			rs.setMessage("查询失败");
			rs.setIsSuccess(false);
		}
		return rs;

	}
	/**
	 * 
	 * @Title: findUserSubordinateInculdeOrderBasics
	 * @Description: TODO 查询用户的下2级品牌大使信息(包括自己)
	 * @param: @param response
	 * @param: @param request
	 * @param: @return
	 * @return: VisitConsequenceParent
	 * @throws
	 */
//	@ResponseBody
//	@RequestMapping("find2SubordinateCo")
//	public VisitConsequenceParent find2SubordinateCo(
//			HttpServletResponse response, HttpServletRequest request,
//			@RequestBody Map<String, Object> jsonData) {
//		VisitConsequenceParent vc = new VisitConsequenceParentImpl();
//		String month_date = String.valueOf(jsonData.get("month_date"));
//		SessionEntity sessionEntity = null;
//		try {
//			sessionEntity = new SessionEntity(request);// 获取用户session
//		} catch (SessionException e) {
//			e.printStackTrace();
//			vc.setState(3);
//			return vc;
//		}
//		Map<String, List<CoFounderMonSale>> subordinateMap = coFounderService
//				.find2SubordinateCo(2,sessionEntity.getUser_basics_id(),month_date);// 查询下级品牌大使2级(包括自己)
//		
//		vc.setMessage("返回成功");
//		vc.setState(0);
//		vc.setObject(subordinateMap);
//		return vc;
//
//	}
	/**
	 * 
	 * @Title:             findCapitalCompany
	 * @Description:       品牌大使销售订单
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@RequestMapping("findCapitalCompany")
	@ResponseBody
	public ResponseData findCapitalCompany(HttpServletResponse response,
			HttpServletRequest request){
		int user_basics_id=0;
		
		ResponseData rs = new ResponseData();
		SessionEntity sessionEntity = null;//用户session
		try {
			sessionEntity = new SessionEntity(request);//传入HttpServletRequest对象初始化session
			user_basics_id=sessionEntity.getUser_basics_id();
		} catch (SessionException e) {
			e.printStackTrace();
			rs.setMessage("登陆超时！");
			rs.setIsSuccess(false);
			return rs;
		}
		String jsonStr=JsonUtils.getJsonStr(request);//获取前端提交的json数据 并转换为json字符串
		JSONObject json=JSONObject.fromString(jsonStr);//将字符串转换为JSONObject对象
		String month_date=String.valueOf(json.get("month_date"));
//		int user_basics_id=Integer.valueOf(String.valueOf(json.get("user_basics_id")));
		int company_id=1;
		int year=Integer.valueOf(month_date.substring(0,4));
		int month=Integer.valueOf(month_date.substring(4,6));
		Calendar cal = Calendar.getInstance();   
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份 
        cal.set(Calendar.MONTH, month-1); 
        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数 
        cal.set(Calendar.DAY_OF_MONTH,firstDay);
        
        Date begin=cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String begintime = sdf.format(begin);
        Date begindate = null;
        try {
        	begindate =  sdf.parse(begintime);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
        long start_date=begindate.getTime();//该月第一天0点
        
        //设置月份 
        cal.set(Calendar.MONTH, month); 
        
        Date end=cal.getTime();
        String endtime = sdf.format(end);
        Date enddate = null;
        try {
        	enddate =  sdf.parse(endtime);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
        long end_date=enddate.getTime();//该月第一天0点
        
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("company_id", company_id);
		map.put("co_user_basics_id", user_basics_id);
		map.put("start_date", start_date);
		map.put("end_date", end_date);
		
		List<CapitalAccount> lca=accountService.findCapitalCompany(map);
		System.out.println(lca);
		rs.setMessage("查询成功!");
		rs.setData(lca);
		rs.setIsSuccess(true);
		return rs;
		
	}
}
