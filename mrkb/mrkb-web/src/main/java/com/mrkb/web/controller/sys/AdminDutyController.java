package com.mrkb.web.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.order.OrderBasics;
import com.mrkb.dao.modle.store.UserDuty;
import com.mrkb.service.UserDutyService;
import com.mrkb.shiro.cookieutil.SessionEntity;

@Controller
@RequestMapping("/admin_duty")
public class AdminDutyController {
	@Autowired
	private UserDutyService userDutyService;
	
	
	/**
	 * 跳转查询当班页面
	 * @return
	 */
	@RequestMapping("/duty")
	public String showLogisticsOrder(){
		return "sys/order/adminUserDudy";
	}
	@ResponseBody
	@RequestMapping("findUserDuty")
	public ResponseData findUserDuty(HttpServletResponse response,
			HttpServletRequest request,@RequestParam("pageSize") Integer pageSize,@RequestParam("pageIndex") Integer pageIndex){
		ResponseData rs=new ResponseData();
		PageHelper.startPage(pageIndex, pageSize);
		int if_duty=2;
		try {
			if_duty=Integer.valueOf(request.getParameter("if_duty"));//是否当班
		} catch (Exception e) {
		}
		UserDuty ud=new UserDuty();
		if(if_duty!=2){
			ud.setIf_duty(if_duty);
		}
		List<UserDuty> lud=userDutyService.findUserDuty(ud);
		PageInfo<UserDuty> PageInfo = new PageInfo<>(lud);
		rs.setData(PageInfo);
		rs.setIsSuccess(true);
		return rs;
	}
	/**
	 * 当班
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dutyuser")
	public ResponseData shoukuan(HttpServletResponse response,
			HttpServletRequest request){
		ResponseData R = new ResponseData();
		long time = System.currentTimeMillis();
		UserDuty ud=new UserDuty();
		int duty_id=Integer.valueOf(request.getParameter("duty_id"));
		int user_basics_id=Integer.valueOf(request.getParameter("user_basics_id"));
		int order_id=Integer.valueOf(request.getParameter("order_id"));
		ud.setDuty_id(duty_id);
		ud.setDuty_date(time);
		ud.setOrder_id(order_id);
		ud.setUser_basics_id(user_basics_id);
		int update=userDutyService.duty(ud);
		if(update>0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			R.setIsSuccess(false);
			R.setMessage("当班失败!");
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		R.setIsSuccess(true);
		R.setData(update);
		R.setMessage("当班成功!");
		return R;
	}
}
