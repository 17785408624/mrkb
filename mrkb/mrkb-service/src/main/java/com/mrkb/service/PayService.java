package com.mrkb.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PayService {
	String rePay(HashMap<String,Object> map,HttpServletRequest request, HttpServletResponse response);
    

}
