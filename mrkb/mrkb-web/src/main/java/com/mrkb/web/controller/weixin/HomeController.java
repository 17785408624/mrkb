package com.mrkb.web.controller.weixin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.dao.modle.user.UserGrade;
import com.mrkb.service.UserService;
import com.mrkb.service.WeiXinTemplateService;
import com.mrkb.shiro.cookieutil.SessionEntity;


@Controller("weixin/HomeController")
@RequestMapping("/weixin/HomeController")
public class HomeController {
	@Autowired
	private UserService userService;
	@Autowired
	private WeiXinTemplateService WeiXinTemplateService;
//	@Autowired
//	private StoreService storeService;
	//登录
	@RequestMapping("home")
	public String Home(HttpServletRequest request,HttpServletResponse response ){	
		return "weixin/wx_ltone/home";
	}
	//调查问卷
	@RequestMapping("questionnaire")
	public String Questionnaire(HttpServletRequest request,HttpServletResponse response ){	
		return "weixin/wx_ltone/questionnaire";
	}
	//操作手册
	@RequestMapping("user_manuall")
	public String user_manuall(HttpServletRequest request,HttpServletResponse response ){	
		return "weixin/wx_ltone/user_manuall";
	}
	//公司简介
	@RequestMapping("company")
	public String company(HttpServletRequest request,HttpServletResponse response ){	
		return "weixin/wx_ltone/company";
	}
	@RequestMapping("bigFoison")
	public String bigFoison(HttpServletRequest request,HttpServletResponse response ){	
		return "weixin/wx_ltone/bigFoison";
	}
	@RequestMapping("bigGrowUp")
	public String bigGrowUp(HttpServletRequest request,HttpServletResponse response  ){
		List<HashMap<String,Object>> map22=null;
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("article_type",8);
		map22=WeiXinTemplateService.TopSelectArticleList(map);
		request.setAttribute("listMap", map22);
		return "weixin/wx_ltone/bigGrowUp";
	}
	@RequestMapping("mine")
	public String mine(HttpServletRequest request,HttpServletResponse response  ) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     response.setCharacterEncoding("UTF-8");
		Integer user_grade_id=null;
		try {
			SessionEntity sessionEntity=new SessionEntity(request);
			user_grade_id=sessionEntity.getUser_grade_id();
			UserGrade userGrade= userService.findUserGrade(user_grade_id);
			BasicsUser bu=userService.finduserBasics(sessionEntity.getUser_basics_id());
			request.setAttribute("bu", bu);
			request.setAttribute("userGrade", userGrade);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/error";
		}
		return "weixin/wx_ltone/mine";
	}
	@RequestMapping("productDetails")
	public String productDetails(HttpServletRequest request,HttpServletResponse response  ){	
//		Integer store_id=Integer.valueOf(request.getParameter("store_id"));
//		System.out.println(store_id);
//		StoreBasics sbs=new StoreBasics();
//		sbs.setStore_id(store_id);
//		StoreBasics sb=storeService.findStoreBasics(sbs);
//		int store_type=sb.getStore_type();
//		String store_service=sb.getStore_service();
//		if(store_type==0){
//			return "store_product_details";
//		}else if(store_type==1){
//			request.setAttribute("store_id", store_id);
//			request.setAttribute("store_service", store_service);
//			return "customize_product_details";
//		}else{
			return "weixin/wx_ltone/productDetails";
//		}
		
	}
	
	
	
	@RequestMapping("productPay")
	public String productPay(HttpServletRequest request,HttpServletResponse response  ){
		Integer store_id=Integer.valueOf(request.getParameter("store_id"));
		request.setAttribute("store_id", store_id);
		return "weixin/wx_ltone/productPay";
	}
	
	@RequestMapping("pay")
	public String pay(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/pay";
	}
	
	@RequestMapping("evaluationList")
	public String allevaluation(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/evaluationList";
	}
	
	@RequestMapping("myOrderDetailList")
	public String myOrderDetailList(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/mine/myOrderDetailList";
	}
	
	@RequestMapping("fund")
	public String fund(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/fund";
	}
	@RequestMapping("fundDetail")
	public String fundDetail(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/fundDetail";
	}
	
	@RequestMapping("knowledge")
	public String knowledge(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/knowledge";
	}
	@RequestMapping("knowledgeDetail")
	public String knowledgeDetail(HttpServletRequest request,HttpServletResponse response){		
		return "weixin/wx_ltone/knowledgeDetail";
	}
	
	@RequestMapping("intelligentAngel")
	public String intelligentAngel(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/intelligentAngel";
	}
	
	@RequestMapping("video")
	public String video(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/video";
	}
	
	@RequestMapping("videoDetail")
	public String videoDetail(HttpServletRequest request,HttpServletResponse response  ){		
		return "weixin/wx_ltone/videoDetail";
	}
	
	
	@RequestMapping("weixinError")
	public String weixinError(HttpServletRequest request,HttpServletResponse response  ){		
		return "error/weixinError";
	}
	/*跳转至积分商城*/
	@RequestMapping("integral")
	public String integral(HttpServletRequest request,HttpServletResponse response  ){		
		return "integral";
	}
	
	/*跳转至积分商城*/
	@RequestMapping("intelligent_angel")
	public String intelligentAngle(HttpServletRequest request,HttpServletResponse response  ){		
		return "intelligent_angel";
	}
	
	
	/*首页轮播图详情页面跳转*/
	@RequestMapping("/indexRollImgDetail")
	public String indexRollImgDetail(HttpServletRequest request){
		Object news_id = request.getParameter("news_id");
		request.setAttribute("news_id",news_id);
		return "weixin/wx_ltone/indexRollImgDetail";
	}
}
