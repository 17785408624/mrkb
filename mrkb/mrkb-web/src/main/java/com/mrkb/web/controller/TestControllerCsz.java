package com.mrkb.web.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;




@Controller
@RequestMapping("/weixin/testCsz")
public class TestControllerCsz {

	@RequestMapping("test1")
	public String test1(HttpServletRequest request, HttpSession httpSession) {
		
		Map map = new HashMap();
		map.put("1", 1);
		map.put("2", "2");
		map.put("3", "");
		map.put("4", null);

		System.out.println(String.valueOf(map.get("4")).equals("null"));
		System.out.println(String.valueOf(map.get("5")) == null);
		System.out.println(String.valueOf(map.get("5")).equals("null"));
		return "weixin/wx_ltone/testlogin";
	}

	

	public WebApplicationContext getWebApplicationContext(ServletContext sc) {
		return WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
	}
	@RequestMapping("test2")
	public String test2(HttpServletRequest request, HttpSession httpSession) {
		
		return "test/index";
	}
	
}
