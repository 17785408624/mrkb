package com.mrkb.web.controller.weixinEvent;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.util.ResponseData;
import com.mrkb.common.utils.publicUtil;
import com.mrkb.common.utils.weixinservice.QRcodeService;
import com.mrkb.common.utils.weixinutils.CommonUtil;
import com.mrkb.common.utils.weixinutils.TimeComparison;
import com.mrkb.dao.modle.user.UserWeixin;
import com.mrkb.dao.modle.weixin.oauth.SNSUserInfo;
import com.mrkb.dao.modle.weixin.often.QRcodeModel;
import com.mrkb.service.UserService;
import com.mrkb.web.controller.weixin.UserController;


/**
 * 控制器名: QRcodeController  
 * 描述: 生成二维码对象，将该对象存入数据库中  
 * 开发人员： 万祖权 
 * 创建时间：2018-1-5 
 */
@Controller("/weixin/QRcodeController")
@RequestMapping("/weixin/QRcodeController")
public class QRcodeController {
	@Autowired
	private UserController userController;
	@Autowired
	private UserService userService;
	/**
	 * 描述: 得到二维码对象的方法，将该对象存入数据库中
	 * 开发人员： 万祖权 
	 * 创建时间：2018-1-8 
	 * @throws ParseException 
	 * @throws DocumentException 
	 */
	@RequestMapping(value = "getQRcode", method = RequestMethod.GET)
	 public String getQRcode(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException, DocumentException, ParseException {
		
		
		  // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		SNSUserInfo SNSUserInfo=new SNSUserInfo();

		   
	String openid =request.getParameter("openid");
	SNSUserInfo.setOpenId(openid);
		    	
		    
	
	Map<String,Object> map=new HashMap<String,Object>();
	map.put("weixin_id",SNSUserInfo.getOpenId());         
		    //查询
	request.setAttribute("weixin_id",openid);
//	ResponseData vui=  userController.findUserWeixinWinxinId(request);
	UserWeixin uw = userService.findUserWeixin(openid);
	
     QRcodeService QRcodeServiceObject=new QRcodeService();
     QRcodeModel QRcodeModel=new QRcodeModel();
     QRcodeModel.setOpenid(openid);
 	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 	//判断数据有二维码过期时间吗？没有就写入
 	UserWeixin userWeixin=new UserWeixin();
 	int update = 0;
		if(uw.getShare_img_dated()==null||uw.getShare_img_dated().equals("")){
			//写入
			 QRcodeModel=QRcodeServiceObject.ticket(openid);			 
			 map.put("share_img",QRcodeModel.getimageUrl());    //用户分享二维码
			 map.put("share_img_dated",publicUtil.dataTransform(QRcodeModel.getexpiresInDataTimeImageUrl(), sdf));   //用户分享二维码过期日期 
			//生成二维码、写入数据库
			 request.setAttribute("share_img", QRcodeModel.getimageUrl());
			 request.setAttribute("share_img_dated", publicUtil.dataTransform(QRcodeModel.getexpiresInDataTimeImageUrl(), sdf));
			 userWeixin.setWeixin_id(uw.getWeixin_id());//微信openid
			 userWeixin.setShare_img(QRcodeModel.getimageUrl());//分享的二维码
			 userWeixin.setShare_img_dated(Long.valueOf((String.valueOf(publicUtil.dataTransform(QRcodeModel.getexpiresInDataTimeImageUrl(), sdf)))));
			 update = userService.editUserWeixin(userWeixin);
		}//判断数据有二维码过期了吗？
		else if(uw.getShare_img_dated()!=null||!(uw.getShare_img_dated().equals(""))){
			//时间比较		
			TimeComparison TimeComparison=new TimeComparison();
			//时间比较，大于当前时间不做任何操作，不过期
			if(TimeComparison.compare_date(CommonUtil.formatTime(uw.getShare_img_dated()), sdf.format(new Date()))){
				QRcodeModel.setimageUrl(uw.getShare_img())	;
				
			}else{
				//二维码过期写入
				//写入
				 QRcodeModel=QRcodeServiceObject.ticket(openid);			 
				 map.put("share_img",QRcodeModel.getimageUrl());    //用户分享二维码
				 map.put("share_img_dated",publicUtil.dataTransform(QRcodeModel.getexpiresInDataTimeImageUrl(), sdf));   //用户分享二维码过期日期 
				//生成二维码、写入数据库
				 request.setAttribute("share_img", QRcodeModel.getimageUrl());
				 request.setAttribute("share_img_dated", publicUtil.dataTransform(QRcodeModel.getexpiresInDataTimeImageUrl(), sdf));
				 userWeixin.setWeixin_id(uw.getWeixin_id());//微信openid
				 userWeixin.setShare_img(QRcodeModel.getimageUrl());//分享的二维码
				 userWeixin.setShare_img_dated(Long.valueOf((String.valueOf(publicUtil.dataTransform(QRcodeModel.getexpiresInDataTimeImageUrl(), sdf)))));
				 update = userService.editUserWeixin(userWeixin);
			}
		}else{
			
			String data = "服务器繁忙请稍后再试...";  
			PrintWriter out = response.getWriter();  
			out.write(data);
			}
	

		 request.setAttribute("QRcodeModel", QRcodeModel);
		 return "weixin/QRcode/QRcode";
	        // 跳转到QRcode.jsp，展示二维码，用户分享即可
//	    request.getRequestDispatcher("/weixin/QRcode/QRcode.html").forward(request, response);
	    }
	
	
}
