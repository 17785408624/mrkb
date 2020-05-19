package com.mrkb.common.utils.weixinservice;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mrkb.common.utils.weixinutils.access_token;
import com.mrkb.dao.modle.weixin.menu.ClickButton;
import com.mrkb.dao.modle.weixin.menu.ViewButton;
import com.mrkb.dao.modle.weixin.often.Token;



/**
* 类名: MenuManager 
* 描述:菜单管理器类 
* 开发人员： 万祖权 
* 创建时间：  2017-12-28 
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    public static void main(String[] args) throws UnsupportedEncodingException, IOException, DocumentException {
    	access_token access_tokenObject=new access_token();
        // 调用接口获取access_token
       Token at = access_tokenObject.GetAccess_Token();

        if (null != at) {
            // 调用接口创建菜单
            int result = WeixinMenuService.createMenu( at.getAccessToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }

    /**
     * 组装菜单数据
     * 
     * @return
     */
    private static JSONObject getMenu() {
    	ClickButton btn11 = new ClickButton();
        btn11.setName("事件");
        btn11.setType("click");
        btn11.setKey("11");
        

        ViewButton btn12 = new ViewButton();
        btn12.setName("测试网站");
        btn12.setType("view");
//        btn12.setUrl("http://www.dymsgc.cn/");

        ViewButton btn13 = new ViewButton();
        btn13.setName("获取用户");
        btn13.setType("view");
//        btn13.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx03f4449dfce3e919&redirect_uri=http://miaoling.51vip.biz/OAuthRedirectUrl.aspx&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
        
        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */
        
        JSONArray sub_button=new JSONArray();
        sub_button.put(btn11);
        sub_button.put(btn12);
          
          
        JSONObject buttonOne=new JSONObject();
        buttonOne.put("name", "菜单");
        buttonOne.put("sub_button", sub_button);
          
        JSONArray button=new JSONArray();
        button.put(btn11);
        button.put(buttonOne);
        button.put(btn13);
          
        JSONObject menujson=new JSONObject();
        menujson.put("button", button);


        return menujson;
    }
}