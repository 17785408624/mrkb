package com.mrkb.web.controller.pay;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.util.ResponseData;
import com.mrkb.service.PayService;




@Controller("rePayController")
@RequestMapping("rePayController")
public class RePayController {
	
	@Autowired
	private PayService payService;
	/**
	 * 公众支付给个人账户 提现打款
	 * @throws IOException 
	 * @throws ServletException 
	 * */
	//@RequestMapping("toRePay")
  public @ResponseBody ResponseData toPay(HttpServletRequest request, HttpServletResponse response,
		  @RequestBody Map<String,Object>jsonData){
	  	ResponseData rs = new ResponseData();
		String desc="提现打款";
		try {
			desc = request.getParameter("desc");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer withdrawal_apply_id=Integer.valueOf(String.valueOf(jsonData.get("withdrawal_apply_id")));//申请提现编号
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("withdrawal_apply_id", withdrawal_apply_id);
		map.put("desc", desc);
		String message=payService.rePay(map,request,response);
		rs.setIsSuccess(true);
		rs.setMessage("打款成功");
		return rs;
	}
	
}
