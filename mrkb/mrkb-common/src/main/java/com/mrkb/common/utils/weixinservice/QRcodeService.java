package com.mrkb.common.utils.weixinservice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

import org.dom4j.DocumentException;

import com.mrkb.common.utils.weixinutils.CommonUtil;
import com.mrkb.common.utils.weixinutils.DayAdd;
import com.mrkb.common.utils.weixinutils.access_token;
import com.mrkb.dao.modle.weixin.often.QRcodeModel;


public class QRcodeService {
	public  QRcodeModel ticket(String openid) throws UnsupportedEncodingException, IOException, DocumentException, ParseException{
	access_token access_token1=new access_token();
	String urlPost="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+access_token1.GetAccess_Token().getAccessToken().toString(); 
	
	String jsonStr="{\"expire_seconds\": 2592000, \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \""+openid+"\"}}}";
	CommonUtil CommonTool=new CommonUtil();
	  JSONObject jsonObject = CommonTool.httpsRequest(urlPost,"POST",jsonStr);
	  
	  QRcodeModel QRcodeModel=new QRcodeModel();
	  
	  String ticket=jsonObject.getString("ticket");
	  String   ticketURLEncoder = java.net.URLEncoder.encode(ticket,"utf-8");   
	  QRcodeModel.imageUrl="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticketURLEncoder;
	  QRcodeModel.expiresInImageUrl=2592000;//30天
	  
	  DayAdd DayAdd=new DayAdd();
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  //原本是30天，使用29天就行
	  QRcodeModel.expiresInDataTimeImageUrl=DayAdd.plusDay(29, sdf.format(new Date()));
	  
	 return QRcodeModel;
	}
}
