package com.mrkb.web.controller.weixin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.store.StoreEvaluation;
import com.mrkb.service.StoreService;



@Controller("weixin/evaluation")
@RequestMapping("/weixin/evaluation")
public class StoreEvaluationController {
	@Autowired
	private StoreService storeService;
	
	
	/**
	 * 添加评论
	 * @param request
	 * @param response
	 * @param jsonData
	 * @return
	 */
	@RequestMapping("addEvaluation")
	public @ResponseBody ResponseData AddEvaluation(HttpServletRequest request,HttpServletResponse response){	
		ResponseData rs = new ResponseData();
		StoreEvaluation sel=new StoreEvaluation();
		
		sel.setStore_id(Integer.valueOf(Integer.valueOf(request.getParameter("store_id"))));
		sel.setStore_name(String.valueOf(request.getParameter("store_name")));
		sel.setWeixin_nickname(String.valueOf(request.getParameter("weixin_nickname")));
		sel.setWeixin_portrait(String.valueOf(request.getParameter("weixin_portrait")));
		sel.setEvaluation_date(Long.valueOf(String.valueOf(request.getParameter("evaluation_date"))));
		sel.setEvaluation_value(String.valueOf(request.getParameter("evaluation_value")));
		sel.setRead_num(0);
		try {
			sel.setSuper_evaluation_id(Integer.valueOf(String.valueOf(request.getParameter("super_evaluation_id"))));
			
		} catch (Exception e) {
			sel.setStore_id(0);
		}
		StoreEvaluation sen=storeService.addEvaluation(sel);
		System.out.println("存入的数据："+sen);
		rs.setData(sen);
		rs.setMessage("添加成功");
		rs.setIsSuccess(true);
		return rs;
	}
	
	/**
	 * 查看最新评论
	 * @param request
	 * @param response
	 * @param jsonData
	 * @return
	 */
	@RequestMapping("findEvaluationNew")
	public @ResponseBody ResponseData findEvaluationNew(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String, Object> jsonData){	
		ResponseData rs = new ResponseData();
		Integer store_id=Integer.valueOf(String.valueOf(jsonData.get("store_id")));
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("store_id", store_id);
		StoreEvaluation se=storeService.findEvaluationNew(map);
		rs.setData(se);
		System.out.println("查询出来的结果："+se);
		rs.setMessage("查询成功");
		rs.setIsSuccess(true);
		return rs;
	}
	
}
