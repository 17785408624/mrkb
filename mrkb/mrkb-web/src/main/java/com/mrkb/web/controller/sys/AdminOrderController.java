package com.mrkb.web.controller.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;
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
import com.mrkb.service.OrderService;

@Controller
@RequestMapping("/admin_order")
public class AdminOrderController {
	
	@Autowired
	private OrderService orderservice;
	
	/**
	 * 财务订单查询页面跳转
	 * @return
	 */
	@RequestMapping("/adminFinanceOrder")
	public String showFinanceOrderPage(){
		return "sys/order/adminFinanceOrder";
	}
	
	
	/**
	 * 物流订单查询跳转页面
	 * @return
	 */
	@RequestMapping("/adminLogisticsOrder")
	public String showLogisticsOrder(){
		return "sys/order/adminLogisticsOrder";
	}

	
	
	/**
	 * 后台管理订单查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/adminFindOrderStatusByPage")
	public ResponseData adminFindOrderStatusByPage(@RequestParam("pageSize") Integer pageSize,@RequestParam("pageIndex") Integer pageIndex,HttpServletRequest req){
		ResponseData R = new ResponseData();
		PageHelper.startPage(pageIndex, pageSize);
		List<HashMap<String,Object>>list = new ArrayList<HashMap<String,Object>>();
		String order_status=req.getParameter("order_status");
		HashMap<String,Object> param = new HashMap<String, Object>();
 		param.put("order_status", order_status);
		list=orderservice.adminFindOrderStatusByPage(param);
		PageInfo<HashMap<String,Object>> PageInfo = new PageInfo<>(list);
		R.setData(PageInfo);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		return R;
	}
	
	
	
	/**
	 * 收款
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/shoukuan/{order_id}")
	public ResponseData shoukuan(@PathVariable("order_id")Integer order_id) throws DocumentException {
		ResponseData R = new ResponseData();
		long time = System.currentTimeMillis();
		OrderBasics ob = new OrderBasics();
		ob.setOrder_id(order_id);
		ob.setOrder_edit_date(time);
		int[] update = orderservice.updateFinishOrder(order_id);
		if(update.length>0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	/**
	 * 收款
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/xianxiashoukuan/{order_id}")
	public ResponseData xianxiashoukuan(@PathVariable("order_id")Integer order_id){
		ResponseData R = new ResponseData();
		long time = System.currentTimeMillis();
		OrderBasics ob = new OrderBasics();
		ob.setOrder_id(order_id);
		ob.setOrder_edit_date(time);
		
		try {
			int[] update = orderservice.updateFinishOrder(order_id);
			if(update.length>0){
				R.setErrorCode(ResponseCode.SUCC_DO.getCode());
				R.setMessage(ResponseCode.SUCC_DO.getMsg());
				return R;
			}
		} catch (Exception e) {
		}
		
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	
	/**
	 * 发货
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/sendStore")
	public ResponseData sendStore(@RequestBody Map<String, Object> jsonData) {// 发货
		long time = System.currentTimeMillis();
		ResponseData R = new ResponseData();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		int order_id = Integer.valueOf(String.valueOf(jsonData.get("order_id")));
		map1.put("order_id", order_id);
		map1.put("order_edit_date", time);
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("order_id", order_id);
		map2.put("send_date", time);
		try {
			String courier_services_company = String.valueOf(jsonData.get("courier_services_company"));
			String waybill_number = String.valueOf(jsonData.get("waybill_number"));
			map2.put("courier_services_company", courier_services_company);
			map2.put("waybill_number", waybill_number);
		} catch (Exception e) {
			// TODO: handle exception
		}
		int update = orderservice.sendStore(map1, map2);
		if(update>0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
		}else{
			R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
			R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		}
		return R;
	}
	
}
