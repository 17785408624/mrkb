package com.mrkb.common.utils.weixinutils;
	

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
 
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.util.ResourceUtils;

import com.mrkb.dao.modle.weixin.often.Token;

 
/**
 * 读取下xml文档,获得document对象
 *  开发人员： 万祖权 
 * 创建时间：2017-12-20  
 */
public class xmll {
  public  Token Getaccess_token_expiresInDataTime() throws DocumentException
  {
    SAXReader reader = new SAXReader();
    //String projectPath=System.getProperty("user.dir");//项目根目录
    String projectPath=System.getProperty("catalina.home");  
    File path = null ;
    try {
		path = new File(ResourceUtils.getURL("classpath:").getPath());
		System.out.println(path.toString());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    Document document = reader.read(new File(path+"/static/access_token.xml"));
    /**
     * 节点对象的操作方法
     */
     
    //获取文档根节点
    Element root = document.getRootElement();
    //输出根标签的名字
  //  System.out.println(root.getName());
    //获得指定节点下面的子节点
    Element access_token = root.element("access_token");//首先要知道自己要操作的节点。 
  //  System.out.println("access_token: "+access_token.getText());
    Element expires_in = root.element("expires_in");//首先要知道自己要操作的节点。 
   // System.out.println("expires_in: "+expires_in.getText());
     
    Token Tokenn=new Token();
    Tokenn.setAccessToken(access_token.getText());
    Tokenn.setexpiresInDataTime(expires_in.getText());
    return Tokenn;
  }
   
   
}
