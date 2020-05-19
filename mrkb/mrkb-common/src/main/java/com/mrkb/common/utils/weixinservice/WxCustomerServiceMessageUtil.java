package com.mrkb.common.utils.weixinservice;

import net.sf.json.JSONObject;

import org.dom4j.DocumentException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mrkb.common.utils.weixinutils.CommonUtil;
import com.mrkb.common.utils.weixinutils.MessageUtil;
import com.mrkb.common.utils.weixinutils.access_token;
import com.mrkb.dao.modle.weixin.message.kfreq.ArticleVo;
import com.mrkb.dao.modle.weixin.message.kfreq.CustomerServiceNewsMessageVo;
import com.mrkb.dao.modle.weixin.message.kfreq.CustomerServiceTextMessageVo;
import com.mrkb.dao.modle.weixin.message.kfreq.NewsVo;
import com.mrkb.dao.modle.weixin.message.kfreq.TextContentVo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信客服消息工具类
 */
public class WxCustomerServiceMessageUtil {
    private static final Logger logger = LoggerFactory.getLogger(WxCustomerServiceMessageUtil.class);
    private static final String REQUEST_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

    /**
     * 推送客服图文消息
     * @param touser 图文消息接受对象 opendId
     * @param title 图文消息标题
     * @param description 图文消息描述
     * @param url 图文消息跳转链接
     * @param picurl 图文消息封面图片
     * @return
     */
    static access_token getAcctoken=new access_token();
    public JSONObject sendNewsMessage(String touser, String title, String description, String url, String picurl) throws DocumentException{
        try {
            if(1==2){
                logger.error("推送客服图文消息异常，touser：" + touser + ",title:" + title  + ",description:" + description);
                return null;
            }else{
                String accessToken = getAcctoken.GetAccess_Token().getAccessToken();
                if(accessToken.equals("")||accessToken.equals("null")||accessToken.equals(null)){
                    logger.error("accessToken：" + accessToken);                   
                   //accessToken为空语句
                }else{
                	Map<String, String> paramMap = new HashMap<String, String>();
                    paramMap.put("access_token", accessToken);

                    ArticleVo articleVo = new ArticleVo();
                    articleVo.setDescription(description);
                    articleVo.setTitle(title);
                 
                        articleVo.setUrl(url);
               
                        articleVo.setPicurl(picurl);
                  
                    List<ArticleVo> articles = new ArrayList<ArticleVo>();
                    articles.add(articleVo);

                    NewsVo newsVo = new NewsVo();
                    newsVo.setArticles(articles);

                    CustomerServiceNewsMessageVo customerServiceNewsMessageVo = new CustomerServiceNewsMessageVo();
                    customerServiceNewsMessageVo.setNews(newsVo);
                    customerServiceNewsMessageVo.setMsgtype(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                    customerServiceNewsMessageVo.setTouser(touser);
                  
                    JSONObject jsonObject = JSONObject.fromObject(customerServiceNewsMessageVo);
                  String  jsonStr = jsonObject.toString();
                    System.out.println(jsonStr);
                    String postUrl = REQUEST_URL.replace("ACCESS_TOKEN", accessToken);
                    JSONObject resultStr = CommonUtil.httpsRequest(postUrl, "POST",jsonStr);
          
                    return resultStr;
                   
                  
                }
            }
        }catch (IOException e) {
            logger.error("推送客服图文消息失败");
          
        }
		return null;
    }

    /**
     * 推送客服文本消息
     * @param msg 文本消息内容
     * @param touser 文本消息接受对象 opendId
     * @return
     * @throws DocumentException 
     */
    public static JSONObject sendTextMessage(String msg, String touser) throws DocumentException {
        try {
        	 if(1==2){
           
                 return null;
             }else{
                 String accessToken = getAcctoken.GetAccess_Token().getAccessToken();
                 if(accessToken.equals("")||accessToken.equals("null")||accessToken.equals(null)){
                     logger.error("accessToken：" + accessToken);                   
                    //accessToken为空语句
                 }else{
                    Map<String, String> paramMap = new HashMap<String, String>();
                    paramMap.put("access_token", accessToken);

                    TextContentVo textContentVo = new TextContentVo();
                    textContentVo.setContent(msg);
                    CustomerServiceTextMessageVo customerServiceTextMessageVo = new CustomerServiceTextMessageVo();
                    customerServiceTextMessageVo.setMsgtype(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                    customerServiceTextMessageVo.settext(textContentVo);
                    customerServiceTextMessageVo.setTouser(touser);
                
                    JSONObject jsonObject = JSONObject.fromObject(customerServiceTextMessageVo);
                    String  jsonStr = jsonObject.toString();
                      System.out.println(jsonStr);
                      String postUrl = REQUEST_URL.replace("ACCESS_TOKEN", accessToken);
                      
                      JSONObject resultStr = CommonUtil.httpsRequest(postUrl, "POST",jsonStr);
            
                      return resultStr;
                }
            }
        }catch (IOException e) {
            logger.error("推送客服文本消息失败");
          //  throw new BusinessException(ResGlobal.ERRORS_USER_DEFINED, new String[]{e.getMessage()});
        }
		return null;
    }
    
    
    
    /**
     * 群发文本消息
     * @param openId
     * @param text
     * @return
     */
    public JSONObject messTextMessage(String text,String[] openId) {
    	String accessToken = null;
		try {
			accessToken = getAcctoken.GetAccess_Token().getAccessToken();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
        if(accessToken.equals("")||accessToken.equals("null")||accessToken.equals(null)){
            logger.error("accessToken：" + accessToken);                   
           //accessToken为空语句
        }else{
           Map<String, String> paramMap = new HashMap<String, String>();
           paramMap.put("access_token", accessToken);
           Map<String, Object> param = new HashMap<String, Object>();
           param.put("touser", openId);
           param.put("msgtype", "text");
           Map<String, Object> content =  new HashMap<String, Object>();
           content.put("content", text);
           param.put("text",content);
           
           JSONObject jsonObject = JSONObject.fromObject(param);
           String  jsonStr = jsonObject.toString();
           System.out.println(jsonStr);
           String postUrl = REQUEST_URL.replace("ACCESS_TOKEN", accessToken);
           JSONObject resultStr = CommonUtil.httpsRequest(postUrl, "POST",jsonStr);
           return resultStr;
       }
		return null;
    }

}