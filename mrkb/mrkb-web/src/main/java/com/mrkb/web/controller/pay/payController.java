package com.mrkb.web.controller.pay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.sf.json.JSONObject;

import org.apache.shiro.session.SessionException;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.mrkb.common.utils.SDK.WXPayUtil;
import com.mrkb.common.utils.paycomme.GetWxOrderno;
import com.mrkb.common.utils.paycomme.RequestHandler;
import com.mrkb.common.utils.paycomme.Sha1Util;
import com.mrkb.common.utils.paycomme.TenpayUtil;
import com.mrkb.common.utils.weixinservice.WxCustomerServiceMessageUtil;
import com.mrkb.dao.modle.order.OrderBasics;
import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.dao.modle.weixin.often.WeiXinConfig;
import com.mrkb.service.OrderService;
import com.mrkb.service.StoreService;
import com.mrkb.shiro.cookieutil.SessionEntity;


@Controller("weixin/payController")
@RequestMapping("/weixin/payController")
public class payController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private StoreService storeService;

	/**
	 * 去支付 微信支付
	 * 
	 * @throws IOException
	 * @throws ServletException
	 * */
	@RequestMapping("toPay")
	public void toPay(HttpServletRequest request, HttpServletResponse response) {

		String orderNo = request.getParameter("orderNo");

		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				response.sendRedirect(WeiXinConfig.morekaba
						+ "/weixin/HomeController/home");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		Integer user_basics_id = se.getUser_basics_id();
		int order_id = Integer.valueOf(String.valueOf(orderNo));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_basics_id", user_basics_id);
		map.put("order_id", order_id);
		OrderBasics orderBasics = orderService.findOrderOne(map);
		StoreBasics sb = new StoreBasics();
		sb.setStore_id(Integer.valueOf(orderBasics.getStore_id()));
		StoreBasics returnsb = storeService.findStoreBasics(sb);// 查询出商品信息
		String store_name = returnsb.getStore_name();
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("store_name", store_name);

		String userId = se.getUser_basics_id().toString();
		String money = orderBasics.getAll_price().toString(); // request.getParameter("money");
		String openId = se.getWeixin_id();
		String body = returnsb.getStore_name();// request.getParameter("body");//new
												// String(.getBytes("iso-8859-1"));//
												// java.net.URLDecoder.decode(request.getParameter("body"),"GB2312");
												// //new
												// String(request.getParameter("body").getBytes("iso-8859-1"));//request.getParameter("body");//商品描述

		// 金额转化为分为单位
		float sessionmoney = Float.parseFloat(money);
		String finalmoney = String.format("%.2f", sessionmoney);
		finalmoney = finalmoney.replace(".", "");

		String appid = WeiXinConfig.AppID;// 微信公众号 APPid
		String appsecret = WeiXinConfig.AppSecret;// 应用秘钥
		String partner = WeiXinConfig.mchId;// 商户号
		String partnerkey = WeiXinConfig.partnerkey;// 初始秘钥

		// 获取openId后调用统一支付接口https://api.mch.weixin.qq.com/pay/unifiedorder
		String currTime = TenpayUtil.getCurrTime();
		// 8位日期
		String strTime = currTime.substring(8, currTime.length());
		// 四位随机数
		String strRandom = TenpayUtil.buildRandom(4) + "";
		// 10位序列号,可以自行调整。
		String strReq = strTime + strRandom;

		// 商户号
		String mch_id = partner;
		// 子商户号 非必输
		// String sub_mch_id="";
		// 设备号 非必输
		String device_info = "设备号";
		// 随机数
		String nonce_str = strReq;
		// 商品描述
		// String body = describe;

		// 商品描述根据情况修改
		// 附加数据
		String attach = userId;
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmss");
		String datetime = tempDate.format(new java.util.Date());
		// 商户订单号
		String orderID = "moerkaba" + orderNo;
		System.out.println(orderID);
		String out_trade_no = orderID;// wkdfksdfj6fp wanzuquanksf25ljs
		int intMoney = Integer.parseInt(finalmoney);

		// 总金额以分为单位，不带小数点
		int total_fee = intMoney;
		// 订单生成的机器 IP
		String spbill_create_ip = request.getRemoteAddr();
		// 订 单 生 成 时 间 非必输
		// String time_start ="";
		// 订单失效时间 非必输
		// String time_expire = "";
		// 商品标记 非必输
		// String goods_tag = "";

		// 这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
		String notify_url = WeiXinConfig.morekaba + "/payController/notify";

		String trade_type = "JSAPI";
		String openid = openId;
		// 非必输
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("body", body);
		packageParams.put("attach", attach);
		packageParams.put("out_trade_no", out_trade_no);

		packageParams.put("total_fee", total_fee + "");
		packageParams.put("spbill_create_ip", spbill_create_ip);
		packageParams.put("notify_url", notify_url);

		packageParams.put("trade_type", trade_type);
		packageParams.put("openid", openid);

		RequestHandler reqHandler = new RequestHandler(request, response);
		reqHandler.init(appid, appsecret, partnerkey);

		String sign = reqHandler.createSign(packageParams);
		String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>"
				+ mch_id + "</mch_id>" + "<nonce_str>" + nonce_str
				+ "</nonce_str>" + "<sign>" + sign + "</sign>"
				+ "<body><![CDATA[" + body + "]]></body>" + "<attach>" + attach
				+ "</attach>" + "<out_trade_no>" + out_trade_no
				+ "</out_trade_no>" +

				"<total_fee>" + total_fee + "</total_fee>"
				+ "<spbill_create_ip>" + spbill_create_ip
				+ "</spbill_create_ip>" + "<notify_url>" + notify_url
				+ "</notify_url>" + "<trade_type>" + trade_type
				+ "</trade_type>" + "<openid>" + openid + "</openid>"
				+ "</xml>";
		System.out.println(xml);
		String allParameters = "";
		try {
			allParameters = reqHandler.genPackage(packageParams);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String prepay_id = "";
		try {
			prepay_id = new GetWxOrderno().getPayNo(createOrderURL, xml);
			if (prepay_id.equals("")) {

				response.sendRedirect("../weixin/HomeController/weixinError");

				// System.out.println("统一支付接口获取预支付订单出错统一支付接口获取预支付订单出错统一支付接口获取预支付订单出错统一支付接口获取预支付订单出错");
				// request.setAttribute("ErrorMsg", "统一支付接口获取预支付订单出错");

			} else {

				SortedMap<String, String> finalpackage = new TreeMap<String, String>();
				String appid2 = appid;
				String timestamp = Sha1Util.getTimeStamp();
				String nonceStr2 = nonce_str;
				String prepay_id2 = "prepay_id=" + prepay_id;
				String packages = prepay_id2;
				finalpackage.put("appId", appid2);
				finalpackage.put("timeStamp", timestamp);
				finalpackage.put("nonceStr", nonceStr2);
				finalpackage.put("package", packages);
				finalpackage.put("signType", "MD5");
				String finalsign = reqHandler.createSign(finalpackage);

				System.out.println("toPayFinal?appid=" + appid2 + "&timeStamp="
						+ timestamp + "&nonceStr=" + nonceStr2 + "&package="
						+ packages + "&sign=" + finalsign + "&userId=" + userId
						+ "&money=" + money + "&openId=" + openId + "&orderNo="
						+ orderNo + "&body="
						+ URLEncoder.encode(body, "gb2312"));
				response.sendRedirect("toPayFinal?appid=" + appid2
						+ "&timeStamp=" + timestamp + "&nonceStr=" + nonceStr2
						+ "&package=" + packages + "&sign=" + finalsign
						+ "&userId=" + userId + "&money=" + money + "&openId="
						+ openId + "&orderNo=" + orderNo + "&body="
						+ URLEncoder.encode(body, "gb2312") + "&store_id="
						+ orderBasics.getStore_id());

			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@RequestMapping("toPayFinal")
	public String toPayFinal(HttpServletRequest request,
			HttpServletResponse response) {
		String orderNo=request.getParameter("orderNo");
		String appId=WeiXinConfig.AppID;
		String timeStamp = request.getParameter("timeStamp");
		String nonceStr = request.getParameter("nonceStr");
		String packageValue = request.getParameter("package");
		String paySign = request.getParameter("sign");
		String userId = request.getParameter("userId");
		String money = request.getParameter("money");
		String openId = request.getParameter("openId");
		request.setAttribute("appId", appId);
		request.setAttribute("orderNo", orderNo);
		request.setAttribute("nonceStr", nonceStr);
		request.setAttribute("packageValue", packageValue);
		request.setAttribute("paySign", paySign);
		request.setAttribute("userId", userId);
		request.setAttribute("money", money);
		request.setAttribute("openId", openId);
		request.setAttribute("timeStamp", timeStamp);
		return "weixin/wx_ltone/pay";

	}

	@RequestMapping("toPaydier")
	public String toPaydier(HttpServletRequest request,
			HttpServletResponse response) {
		return "pay/toPaydier";

	}

	@RequestMapping("notify")
	public synchronized void notify(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(ServletInputStream) request.getInputStream()));
		
		String line = null;
		// sb为微信返回的xml
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		String strXml=sb.toString();
		Map<String, String> requestMap=WXPayUtil.xmlToMap(strXml);
		
		
//		Map<String, String> requestMap = MessageUtil.parseXmlpay(sb);
		

		String return_code = requestMap.get("return_code");// SUCCESS/FAIL
															// 此字段是通信标识，非交易
															// 标识，交易是否成功需要查
		String openid = requestMap.get("openid");
		String out_trade_no = requestMap.get("out_trade_no");// 商户系统的订单号，与请求 一致。
		String out_trade_no11 = out_trade_no
				.substring(8, out_trade_no.length());
		String attach = requestMap.get("attach");// 自定义数据包

		// 查询订单信息
		Integer user_basics_id = Integer.valueOf(String.valueOf(attach));
		int order_id = Integer.valueOf(out_trade_no11).intValue();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_basics_id", user_basics_id);
		map.put("order_id", order_id);
		OrderBasics orderBasics = orderService.findOrderOne(map);
		StoreBasics sb1 = new StoreBasics();
		sb1.setStore_id(Integer.valueOf(orderBasics.getStore_id()));
		StoreBasics returnsb = storeService.findStoreBasics(sb1);// 查询出商品信息
		String store_name = returnsb.getStore_name();
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("store_name", store_name);

		// 做判断大于3的则不做任何操作

		if (orderBasics.getOrder_status() > 3
				|| orderBasics.getOrder_status().toString().equals("3")
				|| orderBasics.getOrder_status() == 1) {

			// 微信多次请求，不做任何操作，一次就够了

		} else {

			HashMap<String, Object> map1 = new HashMap<String, Object>();

			if (return_code.equals("SUCCESS")) {
				int order_status = 4;
				map1.put("order_status", order_status);
				System.out.println("out:  order_status" + order_status + "支付成功"
						+ attach);
			}
			long time = System.currentTimeMillis();

			map1.put("user_basics_id", user_basics_id);
			map1.put("order_id", order_id);
			map1.put("payment_date", time);
			int update = orderService.updateOrderOne(map1);
			if (update > 0) {
				int[] updateOrderIDs=orderService.updateFinishOrder(order_id);//给用户升级，加积分
				JSONObject jsonObject = null;
				// {"errcode":0,"errmsg":"ok"}
				/*
				 * JSONObject jsonObject= JSON.parseObject(res); String data =
				 * jsonObject.getString("data"); JSONObject jsondata=
				 * JSON.parseObject(data); String token =
				 * jsondata.getString("access_token");
				 */
				try {

					// jsonObject=new
					// WxCustomerServiceMessageUtil().sendNewsMessage(openid,
					// "我是标题", "我是内容",
					// "baidu.com","https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1519109168&di=7ac7c13e5ec6d9655a62de065e01d171&src=http://imgsrc.baidu.com/imgad/pic/item/4a36acaf2edda3cc0f76770d0ae93901213f9209.jpg");
					StringBuffer buffer = new StringBuffer();
					// buffer.append("您好，我是小q，请回复数字选择服务：").append("\n\n");
					// buffer.append("1  活动服务").append("\n");
					// buffer.append("2  在线管家").append("\n\n");
					//
					// buffer.append("回复“?”显示此帮助菜单");

					jsonObject = new WxCustomerServiceMessageUtil().sendTextMessage(buffer.toString(), openid);
					jsonObject = new WxCustomerServiceMessageUtil().sendTextMessage("您好，编号为\"" + order_id + "\"付款成功。",openid);
					jsonObject = new WxCustomerServiceMessageUtil().sendTextMessage("感谢您的支持！", openid);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// System.out.println("修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功修改订单成功");
			}
		}
	}

}
