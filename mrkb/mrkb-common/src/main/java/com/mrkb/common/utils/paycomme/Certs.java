package com.mrkb.common.utils.paycomme;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.mrkb.dao.modle.weixin.often.WeiXinConfig;




public class Certs {
	
	public static Map<String,Object> getcerts(String url,String xml) {
		Map<String,Object> map2 = new HashMap<String,Object>();
        CloseableHttpResponse response=null;
        
        String mchId=WeiXinConfig.mchId;
        try {
            KeyStore keyStore  = KeyStore.getInstance("PKCS12");
            FileInputStream instream = new FileInputStream(new File("C:/cert/apiclient_cert.p12"));
            keyStore.load(instream, mchId.toCharArray());
         // Trust own CA and all self-signed certs
            SSLContext sslcontext = SSLContexts.custom()
                    .loadKeyMaterial(keyStore, mchId.toCharArray())
                    .build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,  
                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            
            
            CloseableHttpClient httpclient = 
            		HttpClients.custom().
            		setSSLSocketFactory(sslsf).
            		build();
            HttpPost httpost = new HttpPost(url);

            httpost.addHeader("Connection", "keep-alive");
            httpost.addHeader("Accept", "*/*");
            httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpost.addHeader("Host", "api.mch.weixin.qq.com");
            httpost.addHeader("X-Requested-With", "XMLHttpRequest");
            httpost.addHeader("Cache-Control", "max-age=0");
            httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
            httpost.setEntity(new StringEntity(xml, "UTF-8"));
            System.out.println("发送的请求：：：：" + httpost.getRequestLine());
            
            response = httpclient.execute(httpost);
            try {
                HttpEntity entity = response.getEntity();

                String jsonStr;
                jsonStr = EntityUtils.toString(entity,"UTF8");
                
                
        		try {
        		     System.out.println("json是:"+jsonStr);
        		     int s=jsonStr.indexOf("FAIL");
//        		     if(jsonStr.indexOf("FAIL")!=-1){
//        			    	return "";
//        			  }
        		     String return_msg=null;
        		     String err_code_des=null;
        		     try {
        				Map map=doXMLParse(jsonStr);
        				 String return_code  = String.valueOf(map.get("return_code"));
        				 return_msg = String.valueOf(map.get("return_msg"));
        				 String result_code = String.valueOf(map.get("result_code"));
        				 try {
        					 err_code_des = String.valueOf(map.get("err_code_des"));
						} catch (Exception e) {
							// TODO: handle exception
						}
        				
        				 if(return_code.equals("FAIL")){
        					 map2.put("return_code", return_code);
        					 map2.put("return_msg", return_msg);
        					 map2.put("return_msg", return_msg);
        					 map2.put("result_code", result_code);
        					 EntityUtils.consume(entity);
        					 response.close();
        					 return map2;
        				 }else{
        					 map2.put("return_code", return_code);
        					 map2.put("return_msg", return_msg);
        					 map2.put("err_code_des", err_code_des);
        					 map2.put("result_code", result_code);
        					 EntityUtils.consume(entity);
        					 response.close();
        					 return map2;
        				 }
        			} catch (Exception e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        		} catch (ParseException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        	EntityUtils.consume(entity);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                response.close();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } 
        
	     
        return map2;
    }
	
	  /**
		 * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
		 * @param strxml
		 * @return
		 * @throws JDOMException
		 * @throws IOException
		 */
		public static Map doXMLParse(String strxml) throws Exception {
			if(null == strxml || "".equals(strxml)) {
				return null;
			}
			
			Map m = new HashMap();
			InputStream in = String2Inputstream(strxml);
			SAXBuilder builder = new SAXBuilder();
			InputStreamReader isr=new InputStreamReader(in,"gb2312");
			Document doc = builder.build(isr,"gb2312");
			Element root = doc.getRootElement();
			List list = root.getChildren();
			Iterator it = list.iterator();
			while(it.hasNext()) {
				Element e = (Element) it.next();
				String k = e.getName();
				String v = "";
				List children = e.getChildren();
				if(children.isEmpty()) {
					v = e.getTextNormalize();
				} else {
					v = getChildrenText(children);
				}
				
				m.put(k, v);
			}
			
			//关闭流
			in.close();
			
			return m;
		}
		/**
		 * 获取子结点的xml
		 * @param children
		 * @return String
		 */
		public static String getChildrenText(List children) {
			StringBuffer sb = new StringBuffer();
			if(!children.isEmpty()) {
				Iterator it = children.iterator();
				while(it.hasNext()) {
					Element e = (Element) it.next();
					String name = e.getName();
					String value = e.getTextNormalize();
					List list = e.getChildren();
					sb.append("<" + name + ">");
					if(!list.isEmpty()) {
						sb.append(getChildrenText(list));
					}
					sb.append(value);
					sb.append("</" + name + ">");
				}
			}
			
			return sb.toString();
		}
		
		public static InputStream String2Inputstream(String str) {
			return new ByteArrayInputStream(str.getBytes());
		}
		
		
}
