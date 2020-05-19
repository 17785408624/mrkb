package com.mrkb.web.controller.weixinEvent;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.utils.spring.SpringTool;
import com.mrkb.common.utils.weixinutils.MessageUtil;
import com.mrkb.common.utils.weixinutils.SignUtil;
import com.mrkb.common.utils.weixinutils.TimeJudgment;
import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.dao.modle.user.UserWeixin;
import com.mrkb.dao.modle.weixin.message.resp.Article;
import com.mrkb.dao.modle.weixin.message.resp.NewsMessage;
import com.mrkb.dao.modle.weixin.message.resp.TextMessage;
import com.mrkb.dao.modle.weixin.often.WeiXinConfig;
import com.mrkb.service.UserService;
import com.mrkb.service.WeiXinTemplateService;

import net.sf.json.JSONObject;







/**
 * 控制器名: weixinEventController  
 * 描述: 来接收微信服务器传来信息  
 * 开发人员： 万祖权 
 * 创建时间：2017-12-20  
 */
@Controller("/weixin/weixinEventController")
@RequestMapping("/weixin/weixinEventController")
public class weixinEventController {
	@Autowired
	private static WeiXinTemplateService weiXinTemplateService;
	@Resource
	private  UserService userService;
	/**
     * 处理微信服务器发来的消息,是用xml传递参数的、根据“事件”的不同，传的参数则不同，参数有变化,具体参数见官方文档https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140453
     *  开发人员： 万祖权 
	 * 创建时间：2017-12-20  
	 * 这里可以实现获取二维码的推荐人
	 *    String EventKey = requestMap.get("EventKey");
                   	  respContent ="推荐人是" +EventKey;
            由我这里调取各种加积分的方法，然后我传入推荐的openid
     */
	@ResponseBody
	@RequestMapping(value = "/weixinEvent")
	 public void weixinEvent(HttpServletRequest request, HttpServletResponse response)
	            {
		String method = request.getMethod();//得到访问方式（get或者post）
		if(method.equals("GET")){//为get请求方式
			   String signature = request.getParameter("signature");
		       
		        String timestamp = request.getParameter("timestamp");
		       
		        String nonce = request.getParameter("nonce");
		       
		        String echostr = request.getParameter("echostr");
		        
		        PrintWriter out = null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					e.printStackTrace();
				}
		        
		        
		        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
		            out.print(echostr);
		        }
		        
		        out.close();
		        out = null;
		}else{
			 // 消息的接收、处理、响应
	        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
	        try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	        response.setCharacterEncoding("UTF-8");

	        // 调用核心业务类接收消息、处理消息
	        String respXml = processRequest(request,response);

	        // 响应消息
	        PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        out.print(respXml);
	        out.close();
		}
		
	
	    }
	/**
     * 处理微信发来的请求
     * @param request
     * @return xml
     */

    public String processRequest(HttpServletRequest request,HttpServletResponse response ) {
        //xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent = "未知的消息类型！";
        try {
            // 调用parseXml方法解析请求消息
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            // 发送方帐号
            String fromUserName = requestMap.get("FromUserName");
            // 开发者微信号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
           
            
           
            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//            ImageMessage ImageMessage = new ImageMessage();
//            String Content11="";
//            String clickk="";
            
            
        	HashMap<String,Object> HashMap=new HashMap<String,Object>();
        	List<HashMap<String, Object>> listmap=null;

    		
            // 文本消息
            if ( msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            	// 接收用户发送的文本消息内容
				String content = requestMap.get("Content");

				// 创建图文消息
				NewsMessage newsMessage = new NewsMessage();
				newsMessage.setToUserName(fromUserName);
				newsMessage.setFromUserName(toUserName);
				newsMessage.setCreateTime(new Date().getTime());
				newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
			    List<Article> articleList = new ArrayList<Article>();
				// 单图文消息
				if ("".equals(content)) {//if ("1".equals(content)) {
					/*Article article = new Article();
					article.setTitle("开发测试");
					article.setDescription("开发测试，可以更改改消息的发送，可编辑啊！");
					article.setPicUrl("http://uploads.sundxs.com/allimg/1706/19-1F621003141-50.jpg");
					article.setUrl("http://baidu.com");
					articleList.add(article);*/
					HashMap.put("article_type", 1);
					List<HashMap<String,Object>> map22=null;
					HashMap<String,Object> map=new HashMap<String,Object>();
					map=(HashMap<String, Object>) HashMap;
					listmap=weiXinTemplateService.TopSelectArticleList(map);
					
					
					for (Map<String, Object> m : listmap)
				    {
						Article article1 = new Article();
						article1.setTitle(m.get("title").toString()+"\n"+m.get("content_introduction").toString());
						article1.setDescription("");
						article1.setPicUrl((String) m.get("pictures_url"));
						article1.setUrl(WeiXinConfig.morekaba+"/UEditorTemplateController/SelectArticleDatail?article_id="+m.get("article_id").toString());

						articleList.add(article1);
			     	
				    }
					// 设置图文消息个数
					newsMessage.setArticleCount(articleList.size());
					// 设置图文消息包含的图文集合
					newsMessage.setArticles(articleList);
					// 将图文消息对象转换成xml字符串
					respXml = MessageUtil.messageToXml(newsMessage);
				}
				// 单图文消息---不含图片
//				else if ("2".equals(content)) {
//					
//					HashMap.put("article_type", 2);
//					listmap=WeiXinTemplateService.TopSelectArticleList(response, request, HashMap);
//					
//					for (Map<String, Object> m : listmap)
//				    {
//						Article article1 = new Article();
//						article1.setTitle(m.get("title").toString()+"\n"+m.get("content_introduction").toString());
//						article1.setDescription("");
//						article1.setPicUrl((String) m.get("pictures_url"));
//						article1.setUrl("http://www.shmedifood.com/medicinefood/UEditorTemplateController/SelectArticleDatail?article_id="+m.get("article_id").toString());
//
//						articleList.add(article1);
//			     	
//				    }
//					newsMessage.setArticleCount(articleList.size());
//					newsMessage.setArticles(articleList);
//					respXml = MessageUtil.messageToXml(newsMessage);
//				}
				// 多图文消息
//				else if ("3".equals(content)) {
//					
//					HashMap.put("article_type", 3);
//					listmap=WeiXinTemplateService.TopSelectArticleList(response, request, HashMap);
//					
//					for (Map<String, Object> m : listmap)
//				    {
//						Article article1 = new Article();
//						article1.setTitle(m.get("title").toString()+"\n"+m.get("content_introduction").toString());
//						article1.setDescription("");
//						article1.setPicUrl((String) m.get("pictures_url"));
//						article1.setUrl("http://www.shmedifood.com/medicinefood/UEditorTemplateController/SelectArticleDatail?article_id="+m.get("article_id").toString());
//
//						articleList.add(article1);
//			     	
//				    }
//					
//					newsMessage.setArticleCount(articleList.size());
//					newsMessage.setArticles(articleList);
//					respXml = MessageUtil.messageToXml(newsMessage);
//				}
				// 多图文消息---首条消息不含图片
//				else if ("4".equals(content)) {
//					
//					HashMap.put("article_type", 4);
//					listmap=WeiXinTemplateService.TopSelectArticleList(response, request, HashMap);
//					
//					for (Map<String, Object> m : listmap)
//				    {
//						Article article1 = new Article();
//						article1.setTitle(m.get("title").toString()+"\n"+m.get("content_introduction").toString());
//						article1.setDescription("");
//						article1.setPicUrl((String) m.get("pictures_url"));
//						article1.setUrl("http://www.shmedifood.com/medicinefood/UEditorTemplateController/SelectArticleDatail?article_id="+m.get("article_id").toString());
//
//						articleList.add(article1);
//			     	
//				    }
//					newsMessage.setArticleCount(articleList.size());
//					newsMessage.setArticles(articleList);
//					respXml = MessageUtil.messageToXml(newsMessage);
//				}
				// 多图文消息---最后一条消息不含图片
//				else if ("5".equals(content)) {
//					/*Article article1 = new Article();
//					article1.setTitle("第7篇\n开发测试行符的使用");
//					article1.setDescription("");
//					article1.setPicUrl("http://uploads.sundxs.com/allimg/1706/19-1F621003141-50.jpg");
//					article1.setUrl("http://baidu.com");
//
//					Article article2 = new Article();
//					article2.setTitle("第8篇\n文本消息中使用网页超链接");
//					article2.setDescription("");
//					article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
//					article2.setUrl("http://baidu.com");
//
//					Article article3 = new Article();
//					article3.setTitle("如果觉得文章对你有所帮助，请通过博客留言或关注微信公众帐号xiaoqrobot来支持万祖权！");
//					article3.setDescription("");
//					// 将图片置为空
//					article3.setPicUrl("");
//					article3.setUrl("http://baidu.com");
//
//					articleList.add(article1);
//					articleList.add(article2);
//					articleList.add(article3);*/
//					HashMap.put("article_type", 5);
//					listmap=WeiXinTemplateService.TopSelectArticleList(response, request, HashMap);
//					
//					for (Map<String, Object> m : listmap)
//				    {
//						Article article1 = new Article();
//						article1.setTitle(m.get("title").toString()+"\n"+m.get("content_introduction").toString());
//						article1.setDescription("");
//						article1.setPicUrl((String) m.get("pictures_url"));
//						article1.setUrl("http://www.shmedifood.com/medicinefood/UEditorTemplateController/SelectArticleDatail?article_id="+m.get("article_id").toString());
//
//						articleList.add(article1);
//			     	
//				    }
//					newsMessage.setArticleCount(articleList.size());
//					newsMessage.setArticles(articleList);
//					respXml = MessageUtil.messageToXml(newsMessage);
//				}
//				else if ("？".equals(content)||"?".equals(content)) {
//					
//					    StringBuffer buffer = new StringBuffer();  
//					    buffer.append("您好，我是小q，请回复数字选择对应服务：").append("\n\n");  
//					    buffer.append("1  活动服务").append("\n");
//					    buffer.append("2  在线管家").append("\n\n");  
//					     
//					    buffer.append("回复“?”显示此帮助菜单"); 
//					
//					    respContent=buffer.toString();
//					    textMessage.setContent(respContent);
//		            	 respXml = MessageUtil.messageToXml(textMessage);
//				}
//				else if ("2".equals(content)){
//					
//					JSONObject jsonObject = null;
//            		
//            		try {
//            			TimeJudgment TimeJud=new TimeJudgment();           			
//            			if(TimeJud.isInDate(new Date(), "09:00:00", "17:30:00")){
//            				jsonObject=new WxCustomerServiceMessageUtil().sendTextMessage("您好，客服将为您服务，请稍后", fromUserName);
//               			 String CreateTime =requestMap.get("CreateTime"); //formatTime(longTime);       
//    					    respXml=" <xml>"+
//    					    		" <ToUserName><![CDATA["+fromUserName+"]]></ToUserName>"+
//    					    "<FromUserName><![CDATA["+toUserName+"]]></FromUserName>"+
//    					   " <CreateTime>"+CreateTime+"</CreateTime>"+
//    					   " <MsgType><![CDATA[transfer_customer_service]]></MsgType>"+
//    					"</xml>";            				
//            				
//            			}else{
//            				jsonObject=new WxCustomerServiceMessageUtil().sendTextMessage("您好，客服下班啦，请在9:00-17:30来电咨询！！请看下面的自助服务能否帮到你", fromUserName);
//            				  StringBuffer buffer = new StringBuffer();  
//      					    buffer.append("您好，我是小q，请回复数字选择对应服务：").append("\n\n");  
//      					  buffer.append("1  活动服务").append("\n"); 
//  					    buffer.append("2  在线管家").append("\n\n");  
//      					     
//      					    buffer.append("回复“?”显示此帮助菜单"); 
//      					
//      					    respContent=buffer.toString();
//      					    textMessage.setContent(respContent);
//      		            	 respXml = MessageUtil.messageToXml(textMessage);
//            			}
//            			
//            			
//            		} catch (DocumentException e) {
//            			// TODO Auto-generated catch block
//            			e.printStackTrace();
//            		}
//                	
//					
//				}
				
				
				else{				
					
					 StringBuffer buffer = new StringBuffer();  
//					    buffer.append("您好，我是小q，请回复数字选择对应服务：").append("\n\n");  
//					    buffer.append("1  活动服务").append("\n");
//					    buffer.append("2  在线管家").append("\n\n");  
//					    buffer.append("回复“?”显示此帮助菜单"); 
					 	buffer.append("您好，欢迎关注乐唐公众号！");
					    respContent=buffer.toString();
					    textMessage.setContent(respContent);
		            	 respXml = MessageUtil.messageToXml(textMessage);//fromUserName toUserName
					   
					
				}
                //respContent = "您发送的是文本消息！";
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
                textMessage.setContent(respContent);
           	 respXml = MessageUtil.messageToXml(textMessage);
            }
            // 语音消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是语音消息！";
                textMessage.setContent(respContent);
           	 respXml = MessageUtil.messageToXml(textMessage);
            }
            // 视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "您发送的是视频消息！";
                textMessage.setContent(respContent);
           	 respXml = MessageUtil.messageToXml(textMessage);
            }
            // 视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
                respContent = "您发送的是小视频消息！";
                textMessage.setContent(respContent);
           	 respXml = MessageUtil.messageToXml(textMessage);
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
                textMessage.setContent(respContent);
           	 respXml = MessageUtil.messageToXml(textMessage);
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
                textMessage.setContent(respContent);
           	 respXml = MessageUtil.messageToXml(textMessage);
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
             
                // 关注
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                	
//                	
//                	ToUserName	开发者微信号
//                	FromUserName	发送方帐号（一个OpenID）
//                	CreateTime	消息创建时间 （整型）
//                	MsgType	消息类型，event
//                	Event	事件类型，subscribe
//                	EventKey	事件KEY值，qrscene_为前缀，后面为二维码的参数值
//                	Ticket	二维码的ticket，可用来换取二维码图片
//                	
                	//long longTime = Long.parseLong(requestMap.get("CreateTime")); 
                    
                    String CreateTime =requestMap.get("CreateTime"); //formatTime(longTime); //关注时间                	
               	    String EventKey = requestMap.get("EventKey");              
                	
//               	    UserController userController=(UserController) SpringTool.getBean("user_weixin");
            		HttpSession httpSession = null;
            		
            		String recommend_superior_winxin=null;//推荐人微信id
            		//EventKey=String.valueOf(EventKey);
            		
            			
            			if(EventKey!=null&&!EventKey.equals("null")&&!EventKey.equals("")){//二维码所带数据不为空。（推荐人）
            				recommend_superior_winxin=EventKey.replace("qrscene_","");
            				
            			}
            		    //注册用户
//            			UserService userService=(UserService) SpringTool.getBeanClass(UserService.class);
            			BasicsUser bu=new BasicsUser ();//用户基本信息
            			UserWeixin uw=new UserWeixin ();//用户微信消息
            			UserWeixin ewrew=userService.findUserWeixin(fromUserName);
            			if(ewrew==null){
            				uw.setWeixin_id(fromUserName);//用户id
                			uw.setWeixin_follow_data_yes(Long.valueOf(CreateTime));//用户关注时间
                			userService.addUserWeixin(bu, uw, recommend_superior_winxin);//微信端添加用户
            			};
            		if(1==1){
            			
            			
            			StringBuffer buffer = new StringBuffer();  
            		    buffer.append("您好，欢迎关注乐唐公众号！");
// 					    buffer.append("您好，我是小q，请回复数字选择对应服务：").append("\n\n");  
// 					    buffer.append("1  活动服务").append("\n"); 
//					    buffer.append("2  在线管家").append("\n\n");  
// 					    buffer.append("回复“?”显示此帮助菜单"); 
 					
 					    respContent=buffer.toString();
 					   textMessage.setContent(respContent);
 		            	 respXml = MessageUtil.messageToXml(textMessage);
            		}else{
            			StringBuffer buffer = new StringBuffer();  
            		    buffer.append("您好，欢迎关注乐唐公众号！");
// 					    buffer.append("您好，我是小q，请回复数字选择对应服务：").append("\n\n");  
// 					   buffer.append("1  活动服务").append("\n");
//					    buffer.append("2  在线管家").append("\n\n");  
// 					    buffer.append("回复“?”显示此帮助菜单"); 
 					
 					    respContent=buffer.toString();
            			
 					   textMessage.setContent(respContent);
 		            	 respXml = MessageUtil.messageToXml(textMessage);
 					  
            			
            		}
                	  	 
                	 
                   	  
                }
                // 取消关注
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
                }
                // 扫描带参数二维码
                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                    // TODO 处理扫描带参数二维码事件
                	 String EventKey111 = requestMap.get("EventKey");
                	 
                	 StringBuffer buffer = new StringBuffer();  
         		    buffer.append("您好，已经关注该公众号").append("\n\n");  
//					    buffer.append("您好，我是小q，请回复数字选择对应服务：").append("\n\n");  
//					    buffer.append("1  活动服务").append("\n"); 
//					    buffer.append("2  在线管家").append("\n\n");  
//					    buffer.append("回复“?”显示此帮助菜单"); 
					
					    respContent=buffer.toString();
					    textMessage.setContent(respContent);
		            	 respXml = MessageUtil.messageToXml(textMessage);
                	
                
                }
                // 上报地理位置
                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                    // TODO 处理上报地理位置事件
                }
                // 自定义菜单
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // TODO 处理菜单点击事件
                	
                	 // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                    String eventKey = requestMap.get("EventKey"); 
                    if(eventKey.equals("zxgj")){
                    	
                    	JSONObject jsonObject = null;
                		
//                		try {
                			TimeJudgment TimeJud=new TimeJudgment();           			
//                			if(TimeJud.isInDate(new Date(), "09:00:00", "17:30:00")){
//                				jsonObject=new WxCustomerServiceMessageUtil().sendTextMessage("您好，客服将为您服务，请稍后", fromUserName);
//                   			 String CreateTime =requestMap.get("CreateTime"); //formatTime(longTime);       
//        					    respXml=" <xml>"+
//        					    		" <ToUserName><![CDATA["+fromUserName+"]]></ToUserName>"+
//        					    "<FromUserName><![CDATA["+toUserName+"]]></FromUserName>"+
//        					   " <CreateTime>"+CreateTime+"</CreateTime>"+
//        					   " <MsgType><![CDATA[transfer_customer_service]]></MsgType>"+
//        					"</xml>";            				
//                				
//                			}else{
//                				jsonObject=new WxCustomerServiceMessageUtil().sendTextMessage("您好，客服下班啦，请在9:00-17:30来电咨询！！请看下面的自助服务能否帮到您！", fromUserName);
                				StringBuffer buffer = new StringBuffer();  
//          					    buffer.append("您好，我是小q，请回复数字选择对应服务：").append("\n\n");  
//          					    buffer.append("1  活动服务").append("\n"); 
//          					    buffer.append("2  在线管家").append("\n\n");  
//          					    buffer.append("回复“?”显示此帮助菜单"); 
          					  buffer.append("您好，欢迎关注乐唐公众号！");
          					    respContent=buffer.toString();
          					    textMessage.setContent(respContent);
          		            	respXml = MessageUtil.messageToXml(textMessage);
//                			}
                			
                			
//                		} catch (DocumentException e) {
//                			// TODO Auto-generated catch block
//                			e.printStackTrace();
//                		}
                    	
                    }else if(eventKey.equals("xzapp")){
                    	
                    	respContent="开发中...";
                    	 textMessage.setContent(respContent);
  		            	 respXml = MessageUtil.messageToXml(textMessage);
                    	
                    }
                    
                 
                }
            }
         
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }

}
