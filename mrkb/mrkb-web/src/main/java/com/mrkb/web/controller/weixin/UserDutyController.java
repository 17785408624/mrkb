package com.mrkb.web.controller.weixin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.store.UserDuty;
import com.mrkb.service.UserDutyService;
import com.mrkb.shiro.cookieutil.SessionEntity;

@Controller
@RequestMapping("/weixin/userDuty")
public class UserDutyController {
	@Autowired
	private UserDutyService userDutyService;
	@ResponseBody
	@RequestMapping("findUserDuty")
	public ResponseData findUserDuty(HttpServletResponse response,
			HttpServletRequest request){
		ResponseData rs=new ResponseData();
		UserDuty ud=new UserDuty();
		try {
			int if_duty=Integer.valueOf(request.getParameter("if_duty"));//是否当班
			ud.setIf_duty(if_duty);
		} catch (Exception e) {
			// TODO: handle exception
		}
		SessionEntity se = null;
		int user_basics_id;
		try {
			se = new SessionEntity(request);
			user_basics_id=se.getUser_basics_id();
		} catch (SessionException e) {
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		
		ud.setUser_basics_id(user_basics_id);
		
		List<UserDuty> lud=userDutyService.findUserDuty(ud);
		rs.setData(lud);
		rs.setIsSuccess(true);
		return rs;
	}
	/**
	 * 当班
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dutyUser")
	public ResponseData dutyUser(HttpServletResponse response,
			HttpServletRequest request){
		ResponseData R = new ResponseData();
		long time = System.currentTimeMillis();
		
		SessionEntity se = null;
		int user_basics_id;
		try {
			se = new SessionEntity(request);
			user_basics_id=se.getUser_basics_id();
		} catch (SessionException e) {
			e.printStackTrace();
			R.setIsSuccess(false);
			return R;
		}
		UserDuty ud=new UserDuty();
		int duty_id=Integer.valueOf(request.getParameter("duty_id"));
		int order_id=Integer.valueOf(request.getParameter("order_id"));
		ud.setDuty_id(duty_id);
		ud.setDuty_date(time);
		ud.setOrder_id(order_id);
		ud.setUser_basics_id(user_basics_id);
		int update=userDutyService.duty(ud);
		if(update>0){
			R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
			R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
			R.setIsSuccess(false);
			R.setMessage("当班失败!");
			return R;
		}
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		R.setIsSuccess(true);
		R.setData(update);
		R.setMessage("当班成功!");
		return R;
	}
}
