package com.mrkb.common.utils.weixinutils;



import com.mrkb.dao.modle.weixin.menu.ClickButton;
import com.mrkb.dao.modle.weixin.menu.ViewButton;
import com.mrkb.dao.modle.weixin.often.WeiXinConfig;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class CrateJson {

	 public   JSONObject getMenu() {
//	    	ClickButton btn11 = new ClickButton();
//	        btn11.setName("事件");
//	        btn11.setType("click");
//	        btn11.setKey("11");



	        //创建一个菜单





	        ClickButton btnZXGJ= new ClickButton();
	        btnZXGJ.setName("在线管家");
	        btnZXGJ.setType("click");
	        btnZXGJ.setKey("zxgj");

//	        ViewButton btnSRZS= new ViewButton();
//	        btnSRZS.setName("私人助手");
//	        btnSRZS.setType("view");
//	        btnSRZS.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx03f4449dfce3e919&redirect_uri=http://www.shmedifood.com/medicinefood/user_weixin/weixindoGet?zdy=home&response_type=code&scope=snsapi_userinfo&state=home#wechat_redirect");

	        ViewButton btnSRRWM= new ViewButton();
	        btnSRRWM.setName("私人二维码");
	        btnSRRWM.setType("view");
	        btnSRRWM.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WeiXinConfig.AppID+"&redirect_uri=http://www.szltvip.cn/morekaba/weixin/user_weixin/weixindoGet&response_type=code&scope=snsapi_userinfo&state=qrcod#wechat_redirect");

	       /* ViewButton btnXZAPP= new ViewButton();
	        btnXZAPP.setName("下载App");
	        btnXZAPP.setType("view");
	        btnXZAPP.setUrl("http://www.shmedifood.com/medicinefood/HomeController/home");*/
//	        ClickButton btnXZAPP= new ClickButton();
//	        btnXZAPP.setName("下载App");
//	        btnXZAPP.setType("click");
//	        btnXZAPP.setKey("xzapp");



	        ViewButton btnMEKB= new ViewButton();
	        btnMEKB.setName("乐唐介绍");
	        btnMEKB.setType("view");
	        btnMEKB.setUrl("http://www.szltvip.cn/morekaba/weixin/HomeController/company");

	        ViewButton btnKBZX= new ViewButton();
	        btnKBZX.setName("操作手册");
	        btnKBZX.setType("view");
	        btnKBZX.setUrl("http://www.szltvip.cn/morekaba/weixin/HomeController/user_manuall");


	        JSONArray sub_button2=new JSONArray();
	        sub_button2.put(btnZXGJ);
	        //sub_button2.put(btnSRZS);
	        sub_button2.put(btnSRRWM);
//	        sub_button2.put(btnXZAPP);
	        sub_button2.put(btnMEKB);
	        sub_button2.put(btnKBZX);


	        JSONObject buttWDZL=new JSONObject();
	        buttWDZL.put("name", "我的助理");
	        buttWDZL.put("sub_button",sub_button2 );




	        //创建第二个个菜单

	        ViewButton btnSRZX= new ViewButton();
	        btnSRZX.setName("会员中心");
	        btnSRZX.setType("view");
	        btnSRZX.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WeiXinConfig.AppID+"&redirect_uri=http://www.szltvip.cn/morekaba/weixin/user_weixin/weixindoGet?zdy=home&response_type=code&scope=snsapi_userinfo&state=home#wechat_redirect");
	        //大的
	        JSONArray button=new JSONArray();
	        button.put(btnSRZX);
	        button.put(buttWDZL);


	        JSONObject menujson=new JSONObject();
	        menujson.put("button", button);
	        return menujson;
	        /*
	        ViewButton btnJPSC= new ViewButton();
	        btnJPSC.setName("精品商城");
	        btnJPSC.setType("view");
	        btnJPSC.setUrl("http://www.shmedifood.com/medicinefood/HomeController/home");

	        ViewButton btnSRDZ= new ViewButton();
	        btnSRDZ.setName("私人定制");
	        btnSRDZ.setType("view");
	        btnSRDZ.setUrl("http://www.shmedifood.com/medicinefood/HomeController/home");

	        ViewButton btnSRGJ= new ViewButton();
	        btnSRGJ.setName("私人管家");
	        btnSRGJ.setType("view");
	        btnSRGJ.setUrl("http://www.shmedifood.com/medicinefood/HomeController/home");


	        JSONArray sub_button1=new JSONArray();
	        sub_button1.put(btnSY);
	        sub_button1.put(btnJPSC);
	        sub_button1.put(btnSRDZ);
	        sub_button1.put(btnSRGJ);

	        JSONObject buttSRZX=new JSONObject();
	        buttSRZX.put("name", "私人中心");
	        buttSRZX.put("sub_button",sub_button1 );


	        */
//	        ViewButton btn13 = new ViewButton();
//	        btn13.setName("获取用户");
//	        btn13.setType("view");
//	        btn13.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx03f4449dfce3e919&redirect_uri=http://www.shmedifood.com/medicinefood/user_weixin/weixindoGet&response_type=code&scope=snsapi_userinfo&state=home#wechat_redirect");
//
	        //菜单添加的

//	        JSONArray sub_button=new JSONArray();
//	        sub_button.add(btn11);
//	        sub_button.add(btn12);
//

//	        JSONObject buttonOne=new JSONObject();
//	        buttonOne.put("name", "菜单");
//	        buttonOne.put("sub_button", sub_button);
	        /**
	         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
	         */
	    }



}
