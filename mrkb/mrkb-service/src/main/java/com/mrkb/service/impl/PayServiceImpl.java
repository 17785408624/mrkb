package com.mrkb.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.common.utils.paycomme.Certs;
import com.mrkb.common.utils.paycomme.RequestHandler;
import com.mrkb.common.utils.paycomme.TenpayUtil;
import com.mrkb.common.utils.weixinservice.WxCustomerServiceMessageUtil;
import com.mrkb.dao.dao.BonusExtractApplyMapper;
import com.mrkb.dao.dao.UserInformationMapper;
import com.mrkb.dao.dao.UserWeixinMapper;
import com.mrkb.dao.dao.WithdrawalApplyMapper;
import com.mrkb.dao.modle.apply.WithdrawalApplyEntity;
import com.mrkb.dao.modle.user.UserInformationEntity;
import com.mrkb.dao.modle.user.UserWeixin;
import com.mrkb.dao.modle.weixin.often.WeiXinConfig;
import com.mrkb.service.PayService;



@Transactional(rollbackFor = Exception.class)
@Service
public class PayServiceImpl implements PayService{
	@Resource
	private UserInformationMapper userInformationMapper;
	@Resource
	private BonusExtractApplyMapper bonusExtractApplyMapper;
	@Resource
	private UserWeixinMapper userWeixinMapper;
	@Resource
	private WithdrawalApplyMapper withdrawalApplyMapper;
	
	@Override
	public String rePay(HashMap<String,Object> map,HttpServletRequest request, HttpServletResponse response) {
		String desc=String.valueOf(map.get("desc"));//描述
		Integer withdrawal_apply_id=Integer.valueOf(String.valueOf(map.get("withdrawal_apply_id")));//申请提现编号
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmss");    
		String datetime = tempDate.format(new java.util.Date());  
		String partner_trade_no="mekb"+withdrawal_apply_id;//商户对个人用户订单号
		WithdrawalApplyEntity beae=withdrawalApplyMapper.selectWithdrawalApplyToId(withdrawal_apply_id);
		Integer user_basics_id=beae.getUser_basics_id();
		UserWeixin uw=userWeixinMapper.findUserWeixinUserBasicsId(user_basics_id);
		String openid=uw.getWeixin_id();
		String mch_appid=WeiXinConfig.AppID;//微信公众号号 APPid
		String mchid=WeiXinConfig.mchId;//商户号
		String device_info="设备号";
		String appsecret =WeiXinConfig.AppSecret ;//应用秘钥
		String partnerkey = WeiXinConfig.partnerkey;//初始秘钥
		String currTime = TenpayUtil.getCurrTime();
		String nonce_str=currTime.substring(8, currTime.length())+TenpayUtil.buildRandom(4) + "";//随机字符串
		String check_name="FORCE_CHECK";//强制实名认证
		UserInformationEntity uie=userInformationMapper.selectUserInformationEntityToUserId(user_basics_id);//查询用户补充信息
		String re_user_name=uie.getInformation_compellation();//用户真实姓名
		String spbill_create_ip=WeiXinConfig.spbill_create_ip;//ip可以是服务器IP，也可以是客户端IP
		int amount=(int) (beae.getApply_value()*100);
		String amounts=String.valueOf(amount);
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("mch_appid", mch_appid);  
		packageParams.put("mchid", mchid);  
		packageParams.put("nonce_str", nonce_str);  
		packageParams.put("partner_trade_no", partner_trade_no);  
		packageParams.put("openid", openid); 
		packageParams.put("check_name", check_name); 
		packageParams.put("re_user_name", re_user_name); 
		packageParams.put("amount", amounts); 
		packageParams.put("desc", desc); 
		packageParams.put("spbill_create_ip", spbill_create_ip); 
		
		RequestHandler reqHandler = new RequestHandler(request, response);
		reqHandler.init(mch_appid, appsecret, partnerkey);
		
		String sign = reqHandler.createSign(packageParams);
		
		
		String xml="<xml>"
					+"<mch_appid>"+mch_appid+"</mch_appid>"
					+"<mchid>"+mchid+"</mchid>"
					+"<nonce_str>"+nonce_str+"</nonce_str>"
					+"<partner_trade_no>"+partner_trade_no+"</partner_trade_no>"
					+"<openid>"+openid+"</openid>"
					+"<check_name>"+check_name+"</check_name>"
					+"<re_user_name>"+re_user_name+"</re_user_name>"
					+"<amount>"+amount+"</amount>"
					+"<desc>"+desc+"</desc>"
					+"<spbill_create_ip>"+spbill_create_ip+"</spbill_create_ip>"
					+"<sign>"+sign+"</sign>"
					+"</xml>";
		System.out.println(xml);
		String url="https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
		Map<String,Object> map2=null;
		String result=null;
		try {
			map2= Certs.getcerts(url, xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(map2.get("result_code")!="FAIL"&&!map2.get("result_code").equals("FAIL")){
			result=String.valueOf(map2.get("result_code"));
			WithdrawalApplyEntity wae=new WithdrawalApplyEntity();
			wae.setApply_status(2);
			wae.setWithdrawal_apply_id(withdrawal_apply_id);
			wae.setUser_basics_id(user_basics_id);
			int s=withdrawalApplyMapper.updateWithdrawalApply(wae);
			JSONObject jsonObject = null;
			try {
				StringBuffer buffer = new StringBuffer();  
				jsonObject=new WxCustomerServiceMessageUtil().sendTextMessage(buffer.toString(), openid);
				jsonObject=new WxCustomerServiceMessageUtil().sendTextMessage("您好，您申请提现的\""+amount/100+"元，\"已到账。", openid);
				jsonObject=new WxCustomerServiceMessageUtil().sendTextMessage("感谢您的支持！", openid);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return String.valueOf(s);
		}else{
			
			result=String.valueOf(map2.get("err_code_des"));//错误原因
		}
		return result;
	}

}
