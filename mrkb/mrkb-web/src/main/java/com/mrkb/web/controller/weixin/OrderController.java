package com.mrkb.web.controller.weixin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.SessionException;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.order.OrderAddr;
import com.mrkb.dao.modle.order.OrderBasics;
import com.mrkb.dao.modle.order.OrderRefund;
import com.mrkb.dao.modle.order.OrderRestore;
import com.mrkb.dao.modle.order.OrderSupplement;
import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.dao.modle.store.UserDuty;
import com.mrkb.service.AccountService;
import com.mrkb.service.OrderAddrService;
import com.mrkb.service.OrderService;
import com.mrkb.service.StoreService;
import com.mrkb.service.UserDutyService;
import com.mrkb.service.UserService;
import com.mrkb.shiro.cookieutil.SessionEntity;

@Controller("weixin/order_weixin")
@RequestMapping("/weixin/order_weixin")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private OrderAddrService orderAddrService;
	@Autowired
	private UserDutyService userDutyService;
	@Autowired
	private UserService userService;



	/**
	 * 添加单个订单
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addOrder")
	@ResponseBody
	public ResponseData addStore(HttpServletResponse response, HttpServletRequest request) {// 添加订单
		ResponseData rs = new ResponseData();
		System.out.println("进入添加单个订单");
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
			rs.setIsSuccess(false);
			return rs;
		}

		OrderBasics sb = new OrderBasics();
		long time = System.currentTimeMillis();
		Long order_add_date = time;
		int order_status = 2;
		Long order_edit_date = time;

		int store_id = Integer.valueOf(request.getParameter("store_id"));
		// 查询商品名称
		StoreBasics sbs = new StoreBasics();
		sbs.setStore_id(store_id);
		StoreBasics returnsb = orderService.findStoreBasics(store_id);

		String order_addr = request.getParameter("order_addr");
		String store_picture = returnsb.getStore_picture();
		double store_price = returnsb.getStore_price();
		int store_amount = Integer.valueOf(request.getParameter("store_amount"));
		double all_price = store_price * store_amount;
		sb.setOrder_addr(order_addr);
		sb.setStore_picture(store_picture);
		sb.setOrder_add_date(order_add_date);
		sb.setOrder_status(order_status);
		sb.setOrder_edit_date(order_edit_date);
		sb.setUser_basics_id(user_basics_id);
		sb.setStore_id(store_id);
		sb.setStore_amount(store_amount);
		sb.setAll_price(all_price);
		sb.setOrder_type(returnsb.getStore_type());
		sb.setPayment_date(0l);

		// 查询商品名称
		sbs.setStore_id(store_id);

		String user_name = request.getParameter("user_name");
		String tel_phone = request.getParameter("tel_phone");

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_name", user_name);
		map.put("tel_phone", tel_phone);
		map.put("order_addr", order_addr);
		map.put("store_picture", store_picture);
		map.put("send_date", time);
		

		OrderBasics obs = orderService.addOrder(sb, map);
		rs.setData(obs);
		rs.setIsSuccess(true);
		rs.setMessage("添加成功");
		return rs;

	}

	/**
	 * 查询单个订单
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@RequestMapping("findOrderOne")
	@ResponseBody
	public ResponseData findOrderOne(HttpServletResponse response, HttpServletRequest request) {// 查询单个订单
		ResponseData rs = new ResponseData();
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
			rs.setIsSuccess(false);
			return rs;
		}
		int order_id = Integer.valueOf(request.getParameter("order_id"));
		OrderSupplement ost = orderService.findOrderSup(order_id);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_basics_id",user_basics_id);
		map.put("order_id", order_id);
		OrderBasics orderBasics = orderService.findOrderOne(map);
		StoreBasics sb = new StoreBasics();
		sb.setStore_id(Integer.valueOf(orderBasics.getStore_id()));
		StoreBasics returnsb = storeService.findStoreBasics(sb);// 查询出商品信息
		String store_name = returnsb.getStore_name();
		String store_picture = returnsb.getStore_picture();
		Integer store_id = returnsb.getStore_id();
		Integer is_gift = returnsb.getIs_gift();
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("store_name", store_name);
		map2.put("store_picture", store_picture);
		map2.put("store_id", store_id);
		map2.put("is_gift", is_gift);
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("map", map2);
		map3.put("ost", ost);
		map3.put("orderBasics", orderBasics);
		rs.setData(map3);
		rs.setIsSuccess(true);
		rs.setMessage("查询成功");
		return rs;

	}

	/**
	 * 查询个人所有订单
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@RequestMapping("findOrder")
	@ResponseBody
	public ResponseData findOrder(HttpServletResponse response, HttpServletRequest request) {// 查询个人所有订单
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		ResponseData rs = new ResponseData();
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			rs.setIsSuccess(false);
			return rs;
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		String order_statusStr=request.getParameter("order_status");
		int order_status=0;
		if(order_statusStr!=null){
			order_status= Integer.valueOf(request.getParameter("order_status"));
			
		}
		String order_typeStr=request.getParameter("order_type");
		int order_type=0;
		if(order_typeStr != null){
			order_type= Integer.valueOf(order_typeStr);
			map.put("order_type", order_type);
		}
		map.put("user_basics_id", user_basics_id);
		System.out.println("order_status::::::::::状态:::::::" + order_status);
		List<HashMap<String, Object>> listorderBasics = null;
		if (order_status == 0) {
			listorderBasics = orderService.findOrderAll(map);
		} else {
			map.put("order_status", order_status);
			listorderBasics = orderService.findOrder(map);
		}
		// 如果查询待发货需要加上状态为1的
		List<HashMap<String, Object>> listorderBasic = null;
		if (order_status == 3) {
			map.put("order_status", 1);
			listorderBasic = orderService.findOrder(map);
			listorderBasics.addAll(listorderBasic);
		}
		rs.setData(listorderBasics);
		rs.setMessage("查询成功");
		rs.setIsSuccess(true);
		return rs;

	}

	/**
	 * 删除单个订单
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteOrder")
	public ResponseData deleteOrder(HttpServletResponse response, HttpServletRequest request) {// 删除单个订单
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		ResponseData rs = new ResponseData();
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			rs.setIsSuccess(false);
			return rs;
		}
		int order_id = Integer.valueOf(request.getParameter("order_id"));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("user_basics_id", user_basics_id);
		map.put("order_id", order_id);
		int deleteod = orderService.deleteOrder(map);
		if (deleteod > 0) {
			System.out.println("删除条数：：：：" + deleteod);
			rs.setMessage("删除一条成功");
			rs.setIsSuccess(true);
			return rs;
		} else {
			rs.setMessage("删除失败");
			rs.setIsSuccess(false);
			return rs;
		}

	}

	/**
	 * 修改单个订单
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateOrder")
	public ResponseData updateOrder(HttpServletResponse response, HttpServletRequest request) {// 修改单个订单
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		ResponseData rs = new ResponseData();
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			rs.setIsSuccess(false);
			return rs;
		}
		long time = System.currentTimeMillis();
		HashMap<String, Object> map = new HashMap<String, Object>();
		// user_basics_id =
		// Integer.valueOf(String.valueOf(jsonData.get("user_basics_id")));
		int order_status = Integer.valueOf(request.getParameter("order_status"));
		int order_id = Integer.valueOf(request.getParameter("order_id"));
		map.put("order_id", order_id);
		map.put("order_status", order_status);
		map.put("order_edit_date", time);
		int update = orderService.updateOrderOne(map);
		if (update > 0) {
			rs.setMessage("收货成功！");
			rs.setIsSuccess(true);
			return rs;
		} else {
			rs.setMessage("收货失败！");
			rs.setIsSuccess(false);
			return rs;
		}

	}

	/**
	 * 添加收货地址
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addOrderAddr")
	public @ResponseBody ResponseData addOrderAddr(HttpServletResponse response, HttpServletRequest request) {// 添加收货地址
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		ResponseData rs = new ResponseData();
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			rs.setIsSuccess(false);
			return rs;
		}
		OrderAddr oa = new OrderAddr();
		oa.setUser_basics_id(user_basics_id);
		oa.setTel_phone(request.getParameter("tel_phone"));
		oa.setUser_name(request.getParameter("user_name"));
		oa.setOrder_addr(request.getParameter("order_addr"));
		// oa.setAddr_head(String.valueOf(jsonData.get("addr_head")));
		oa.setPriority_level(2);
		OrderAddr oar = orderAddrService.addOrderAddr(oa);
		rs.setData(oar);
		rs.setMessage("添加成功");
		rs.setIsSuccess(true);
		return rs;
	}

	/**
	 * 申请退款
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("refund")
	public ResponseData refund(HttpServletResponse response, HttpServletRequest request) {
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		ResponseData rs = new ResponseData();
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			rs.setIsSuccess(false);
			return rs;
		}
		long time = System.currentTimeMillis();
		String refund_reason = String.valueOf(request.getParameter("refund_reason"));
		String reason_detail = String.valueOf(request.getParameter("reason_detail"));
		// Double reason_detail =
		// Double.valueOf(String.valueOf(jsonData.get("reason_detail")));
		HashMap<String, Object> map = new HashMap<String, Object>();
		int order_id = Integer.valueOf(request.getParameter("order_id"));
		int order_status = 6;
		map.put("user_basics_id", user_basics_id);
		map.put("order_id", order_id);
		map.put("order_status", order_status);
		map.put("order_edit_date", time);
		OrderRefund orf = new OrderRefund();
		orf.setOrder_id(order_id);
		orf.setRefund_reason(refund_reason);
		// orf.setRefund_money(refund_money);
		orf.setApply_date(time);
		orf.setReason_detail(reason_detail);
		orf.setUser_basics_id(user_basics_id);

		OrderRefund of = orderService.refund(map, orf);
		rs.setData(of);
		rs.setMessage("修改一条成功");
		rs.setIsSuccess(true);
		return rs;

	}

	/**
	 * 查询收货地址
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("findOrderAddr")
	@ResponseBody
	public ResponseData findOrderAddr(HttpServletResponse response, HttpServletRequest request) {// 添加收货地址
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		ResponseData rs = new ResponseData();
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			rs.setIsSuccess(false);
			return rs;
		}
		List<OrderAddr> oar = orderAddrService.findOrderAddr(user_basics_id);
		rs.setData(oar);
		
		System.out.println("查询的地址" + oar);
		rs.setMessage("查询成功");
		rs.setIsSuccess(true);
		return rs;
	}

	/**
	 * 查询默认收货地址
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("findOrderAddrDef")
	public @ResponseBody ResponseData findOrderAddrDef(HttpServletResponse response,
			HttpServletRequest request) {// 添加收货地址
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		ResponseData rs = new ResponseData();
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			rs.setIsSuccess(false);
			return rs;
		}
		OrderAddr oar = orderAddrService.findOrderAddrDef(user_basics_id);
		rs.setData(oar);
		rs.setMessage("查询成功");
		rs.setIsSuccess(true);
		return rs;
	}

	/**
	 * 查询单个收货地址
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("findOrderAddrOne")
	@ResponseBody
	public ResponseData findOrderAddrOne(HttpServletResponse response,
			HttpServletRequest request) {// 添加收货地址
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		ResponseData rs = new ResponseData();
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			rs.setIsSuccess(false);
			return rs;
		}
		Integer address_id = Integer.valueOf(request.getParameter("address_id"));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_basics_id", user_basics_id);
		map.put("address_id", address_id);
		OrderAddr oar = orderAddrService.findOrderAddrOne(map);
		rs.setData(oar);
		rs.setMessage("查询成功");
		rs.setIsSuccess(true);
		return rs;
	}

	/**
	 * 设置收货默认地址
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateLevel")
	public @ResponseBody ResponseData updateLevel(HttpServletResponse response, HttpServletRequest request) {// 修改默认收货地址
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		ResponseData rs = new ResponseData();
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			rs.setIsSuccess(false);
			return rs;
		}
		int address_id = Integer.valueOf(request.getParameter("address_id"));
		OrderAddr orderAddr = new OrderAddr();
		orderAddr.setUser_basics_id(user_basics_id);
		orderAddr.setAddress_id(address_id);
		OrderAddr oaddr = orderAddrService.updateLevel(orderAddr);
		System.out.println("修改的条数：：" + oaddr);
		rs.setData(oaddr);
		rs.setMessage("设置成功");
		rs.setIsSuccess(true);
		return rs;
	}

	/**
	 * 修改收货地址
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateAddressOne")
	public @ResponseBody ResponseData updateAddressOne(HttpServletResponse response,
			HttpServletRequest request) {// 修改收货地址
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		ResponseData rs = new ResponseData();
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			rs.setIsSuccess(false);
			return rs;
		}
		Integer address_id = Integer.valueOf(request.getParameter("address_id"));
		String user_name = request.getParameter("user_name");
		String tel_phone = request.getParameter("tel_phone");
		String order_addr = request.getParameter("order_addr");
		OrderAddr orderAddr = new OrderAddr();
		orderAddr.setAddress_id(address_id);
		orderAddr.setUser_basics_id(user_basics_id);
		orderAddr.setUser_name(user_name);
		orderAddr.setTel_phone(tel_phone);
		orderAddr.setOrder_addr(order_addr);
		OrderAddr oaAddr = orderAddrService.updateAddress(orderAddr);
		System.out.println("修改的地址：：" + oaAddr);
		rs.setData(oaAddr);
		rs.setMessage("修改成功");
		rs.setIsSuccess(true);
		return rs;
	}

	/**
	 * 删除收货地址
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deleteOrderAddr")
	public @ResponseBody ResponseData deleteOrderAddr(HttpServletResponse response,
			HttpServletRequest request) {// 删除收货地址
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		ResponseData rs = new ResponseData();
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			rs.setIsSuccess(false);
			return rs;
		}
		Integer address_id = Integer.valueOf(request.getParameter("address_id"));
		int delete = orderAddrService.deleteOrderAddr(address_id);
		System.out.println("删除的地址数量：" + delete);
		rs.setMessage("删除成功");
		rs.setIsSuccess(true);
		return rs;
	}

	/**
	 * 申请退款
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("refundOrder")
	public ResponseData refundOrder(HttpServletResponse response, HttpServletRequest request) {
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		ResponseData rs = new ResponseData();
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			rs.setIsSuccess(false);
			return rs;
		}
		long time = System.currentTimeMillis();
		HashMap<String, Object> map = new HashMap<String, Object>();
		int order_status = 6;
		int order_id = Integer.valueOf(request.getParameter("order_id"));
		map.put("order_id", order_id);
		map.put("order_status", order_status);
		map.put("order_edit_date", time);
		map.put("user_basics_id", user_basics_id);
		int update = orderService.updateOrderOne(map);
		rs.setMessage("修改一条成功");
		rs.setIsSuccess(true);
		return rs;

	}

	/**
	 * 申请退货
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addOrderSales")
	public ResponseData addOrderSales(HttpServletResponse response, HttpServletRequest request) {
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			e.printStackTrace();
		}
		Integer user_basics_id = 0;
		ResponseData rs = new ResponseData();
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			rs.setIsSuccess(false);
			return rs;
		}
		long time = System.currentTimeMillis();
		HashMap<String, Object> map = new HashMap<String, Object>();
		// user_basics_id =
		// Integer.valueOf(String.valueOf(jsonData.get("user_basics_id")));
		int order_status = 10;
		int order_id = Integer.valueOf(request.getParameter("order_id"));
		String re_addr = request.getParameter("re_addr");
		String reason_detail = request.getParameter("reason_detail");
		String waybill_num = request.getParameter("waybill_num");
		String re_reason = request.getParameter("re_reason");
		Double restore_money = Double.valueOf(request.getParameter("restore_money"));
		map.put("order_id", order_id);
		map.put("order_status", order_status);
		map.put("order_edit_date", time);
		map.put("user_basics_id", user_basics_id);
		OrderRestore or = new OrderRestore();
		or.setAdd_date(time);
		or.setOrder_id(order_id);
		or.setUser_basics_id(user_basics_id);
		or.setRe_addr(re_addr);
		or.setRe_reason(re_reason);
		or.setWaybill_num(waybill_num);
		or.setReason_detail(reason_detail);
		OrderRestore addor = orderService.addRestore(or, map);
		System.out.println("修改条数：：：：" + addor);
		rs.setMessage("修改一条成功");
		if (addor.getRestore_id() != null) {
			rs.setIsSuccess(true);
		}else{
			rs.setIsSuccess(false);
		}

		return rs;
	}
	
	/**
	 * 当班
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("duty")
	public ResponseData duty(HttpServletResponse response, HttpServletRequest request) {
		ResponseData rs = new ResponseData();
		SessionEntity se = null;
		Integer user_basics_id = 0;
		try {
			se = new SessionEntity(request);
			user_basics_id = se.getUser_basics_id();
		} catch (SessionException e) {
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		
		int duty_id = Integer.valueOf(request.getParameter("duty_id"));
		UserDuty userDuty=new UserDuty();
		userDuty.setDuty_id(duty_id);
		userDuty.setUser_basics_id(user_basics_id);
		int update=userDutyService.duty(userDuty);
		
		rs.setMessage("修改一条成功");
		rs.setIsSuccess(true);
		return rs;

	}
	
	@RequestMapping("myOrderDetail")
	public String myOrderDetail(HttpServletResponse response,HttpServletRequest request) {
		int order_id=Integer.valueOf(String.valueOf(request.getParameter("order_id")));
		System.out.println("order_id:::::::::"+order_id);
		request.setAttribute("order_id", order_id);
		return "weixin/wx_ltone/mine/myOrderDetail";
			
	}

}
