package com.mrkb.web.controller.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.nodes.ClassTimeNodes;
import com.mrkb.service.ClassTimeNodeService;
import com.mrkb.shiro.model.User;

/**
 * 课程时间节点
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin_time_nodes")
public class ClassTimeNodeController {
	
	
	@Autowired
	private ClassTimeNodeService service;
	
	
	
	/**
	 * 课程时间节点页面跳转
	 * @return
	 */
	@RequestMapping("/page_time_nodes")
	public String page_time_nodes(){
		return "sys/store/class_time_nodes";
	}
	
	
	
	/*
	 * 分页查询
	 */
	@ResponseBody
	@RequestMapping("/getlist")
	public ResponseData getlist(@RequestParam("pageSize") Integer pageSize,@RequestParam("pageIndex") Integer pageIndex,HttpServletRequest req){
		ResponseData R = new ResponseData();
		Map<String, Object>param = new HashMap<String, Object>();
		List<ClassTimeNodes> list = new ArrayList<ClassTimeNodes>();
		PageHelper.startPage(pageIndex, pageSize);
		list = service.list(param);
		PageInfo<ClassTimeNodes> PageInfo = new PageInfo<>(list);
	    R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        R.setMessage(ResponseCode.SUCC_DO.getMsg());
        R.setData(PageInfo);
		return R;
	}
	
	
	
	
	
	/**
	 * 查询课程时间节点对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getObject/{class_node_id}")
	public ResponseData getObject(@PathVariable("class_node_id") Integer class_node_id){
		ResponseData R = new ResponseData();
		ClassTimeNodes nodes = new ClassTimeNodes();
		nodes = service.get(class_node_id);
		R.setData(nodes);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		return R;
	}
	
	
	
	
	/**
	 * 删除
	 * @param class_node_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete/{class_node_id}")
	public ResponseData delete(@PathVariable("class_node_id") Integer class_node_id){
		ResponseData R = new ResponseData();
		Integer num=0;
		num = service.delete(class_node_id);
		if(num>0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	
	
	
	
	/**
	 * 修改
	 * @param nodes
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public ResponseData update(@RequestBody ClassTimeNodes nodes){
		ResponseData R = new ResponseData();
		Integer num = service.update(nodes);
		if(num > 0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	
	
	/**
	 * 新增课程节点
	 * @param nodes
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/node_add")
	public ResponseData insert(@RequestBody ClassTimeNodes nodes){
		ResponseData R = new ResponseData();
		Integer num = service.insert(nodes);
		if(num > 0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	
	
	/*
	 * 查询课程时间节点
	 */
	@ResponseBody
	@RequestMapping("/gettimeline")
	public ResponseData gettimeline(){
		ResponseData R = new ResponseData();
		Map<String, Object>param = new HashMap<String, Object>();
		List<ClassTimeNodes> list = new ArrayList<ClassTimeNodes>();
		list = service.list(param);
	    R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        R.setMessage(ResponseCode.SUCC_DO.getMsg());
        R.setData(list);
		return R;
	}
	
	
	
	/**
	 * 发送消息通知
	 * @param class_node_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/send_notice/{class_node_id}")
	public ResponseData send_notice(@PathVariable("class_node_id") Integer class_node_id){
		ResponseData R = new ResponseData();
		Integer num=service.notice(class_node_id);
		if(num>0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
	        R.setMessage(ResponseCode.SUCC_DO.getMsg());
	        return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
}
