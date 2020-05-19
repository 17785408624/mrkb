package com.mrkb.common.utils.weixinutils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.springframework.util.ResourceUtils;

import com.mrkb.dao.modle.weixin.often.Token;
import com.mrkb.dao.modle.weixin.often.WeiXinConfig;

import org.dom4j.Document;  
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;  
import org.dom4j.Element;  
import org.dom4j.io.OutputFormat;  
import org.dom4j.io.XMLWriter;  


/**
* 类名: access_token 
* 描述: 获取getaccess_token，只要得到Token这个实体对象，就可以获取 
* 开发人员： 万祖权 
* 创建时间：  2017-12-26 
 */

public class access_token {

    public Token GetAccess_Token() throws UnsupportedEncodingException, IOException, DocumentException {
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 //读取xml文件
    	xmll Getaccess_token_expiresInDataTime=new xmll();
    	Token token_Object=new Token();
    	token_Object=Getaccess_token_expiresInDataTime.Getaccess_token_expiresInDataTime();
    	//时间对比
    	TimeComparison TimeCompar=new TimeComparison();
    	
    	CommonUtil CommonUti=new CommonUtil();
    	//判断，过期时间大于当前时间，返回true
   	if(TimeCompar.compare_date(token_Object.expiresInDataTime, sdf.format(new Date()))){
    		
    	return token_Object;
    		
    	}else{
    		WeiXinConfig WeiXinConfigObject=new WeiXinConfig();
    		token_Object =CommonUti.getToken(WeiXinConfigObject.AppID,WeiXinConfigObject.AppSecret);
    		
//    		 System.out.println("access_token:"+token.getAccessToken());
            // System.out.println("expires_in:"+token.getExpiresIn());
             
             //1.第一种 创建文档及设置根元素节点的方式  
             
             //创建文档的根节点  
//           Document document = DocumentHelper.createDocument();  
//           //创建文档的 根元素节点  
//           Element root = DocumentHelper.createElement("Person");  
//             document.setRootElement(root);  
               
             //2.第二种 创建文档及设置根元素节点的方式  
             Element root = DocumentHelper.createElement("token");  
             Document document = DocumentHelper.createDocument(root);  
             //给根节点添加属性  
            // root.addAttribute("学校", "南大").addAttribute("位置", "江西");  
               
             //给根节点添加子节点  
             Element element1 = root.addElement("access_token");  
             element1.addText(token_Object.getAccessToken());  
             //获取当前时间+2小时
             Calendar now=Calendar.getInstance();             
             now.add(Calendar.MINUTE,(int)(token_Object.expiresIn/60)-5);
          //   now.add(Calendar.MINUTE,110);
            
             
            
             String dateStr=sdf.format(now.getTimeInMillis());
            
           //  System.out.println(dateStr);
             token_Object.expiresInDataTime=dateStr;
             
             Element element2 = root.addElement("expires_in");  
          
             element2.addText(dateStr);    
             
            
               
             //把生成的xml文档存放在硬盘上  true代表是否换行  
             OutputFormat format = new OutputFormat("",true);  
             format.setEncoding("UTF-8");//设置编码格式 
             String projectPath=System.getProperty("catalina.home");;//项目根目录
             File path = null ;
             try {
         		path = new File(ResourceUtils.getURL("classpath:").getPath());
         		System.out.println(path.toString());
         	} catch (FileNotFoundException e) {
         		// TODO Auto-generated catch block
         		e.printStackTrace();
         	}
             XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path+"/static/access_token.xml"),format);
           
             xmlWriter.write(document);  
             xmlWriter.close(); 
             
             return token_Object;
   	}
    	
    	
    	
   
     
    }
    
  /* @Test
    public   void GetAccess_To11ken() throws UnsupportedEncodingException, IOException, DocumentException {
    	Token jh=new Token();
    	jh= GetAccess_Token();
    	System.out.println(jh.accessToken);
    	System.out.println(jh.expiresInDataTime);
    }*/
 
}