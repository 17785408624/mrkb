package com.mrkb.web.controller.weixinEvent;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.utils.weixinservice.WeixinMenuService;
import com.mrkb.common.utils.weixinutils.access_token;
import com.mrkb.dao.modle.weixin.often.Token;





/**
 * 控制器名: MenuManagerController  
 * 描述: 处理微信菜单的控制器  
 * 开发人员： 万祖权 
 * 创建时间：2017-12-20  
 */
@Controller("/weixin/MenuManagerController")
@RequestMapping("/weixin/MenuManagerController")
public class MenuManagerController {
	/**
	 * 创建菜单
	 */
	private static Logger log = LoggerFactory.getLogger(MenuManagerController.class);
	@ResponseBody
	@RequestMapping("CreateMenu")
    public int CreateMenu() throws UnsupportedEncodingException, IOException, DocumentException {
		int result=1;
    	access_token access_tokenObject=new access_token();
        // 调用接口获取access_token
       Token at = access_tokenObject.GetAccess_Token();
        if (null != at) {
            // 调用接口创建菜单,可以将菜单存入数据库，然后使用这个方法getMenu()拼接 
             result = WeixinMenuService.createMenu(at.getAccessToken());

            // 判断菜单创建结果
            if (0 == result)
               // log.info("菜单创建成功！");
            	result=0;
          //  else
              //  log.info("菜单创建失败，错误码：" + result);
        }
        return result;
	}
	
	
	@RequestMapping("test")
	public String test(HttpServletRequest request ){
		//new Thread(userThread,"新线程1").start();
		return "weixinMenu/CreateMenu";
	}

}
