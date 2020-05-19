package com.mrkb.web.controller.weixin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.session.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.nodes.ClassTimeEnroll;
import com.mrkb.dao.modle.nodes.ClassTimeNodes;
import com.mrkb.dao.modle.order.OrderBasics;
import com.mrkb.service.ClassTimeEnrollService;
import com.mrkb.shiro.cookieutil.SessionEntity;

/**
 * 课程时间节点报名
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/weixin/class_time_enroll")
public class ClassTimeEnrollController {
	
	
	@Autowired
	private ClassTimeEnrollService service;
	
	
	
	
	/**
	 * 报名
	 * @return
	 */
	@ResponseBody 
	@RequestMapping("/sign_up")
	public ResponseData signUp(HttpServletRequest request){
		ResponseData R = new ResponseData();
		Integer num=0;
		//获取用户ID
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
			R.setIsSuccess(false);
			return R;
		}
		//class_node_id
		ClassTimeEnroll time_enroll=new ClassTimeEnroll();
		time_enroll.setClass_node_id(Integer.valueOf(request.getParameter("class_node_id")));
		time_enroll.setStore_id(Integer.valueOf(request.getParameter("store_id")));
		time_enroll.setUser_basics_id(user_basics_id);
		
		OrderBasics orderBasics = service.sign_up(time_enroll);
		R.setIsSuccess(true);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		R.setData(orderBasics);
		return R;
	}
	
	
	
	
	
	/**
	 * 获取课程时间节点
	 * @return
	 */
	@ResponseBody 
	@RequestMapping("/get_node_class_list")
	public ResponseData getNodeClasslist(HttpServletRequest request){
		ResponseData R = new ResponseData();
		Map<String, Object>param = new HashMap<String, Object>();
		String str_time=request.getParameter("class_beagain_time");
		int store_id=Integer.valueOf(request.getParameter("store_id"));
		param.put("store_id", store_id);
		if(str_time != null && !str_time.equals("")){
			Long class_beagain_time = Long.parseLong(str_time);
			param.put("class_beagain_time", class_beagain_time);
		}
		List<ClassTimeNodes> list = new ArrayList<ClassTimeNodes>();
		list = service.list(param);
	    R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        R.setMessage(ResponseCode.SUCC_DO.getMsg());
        R.setData(list);
		return R;
	}

}
