package com.mrkb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrkb.common.utils.weixinservice.WxCustomerServiceMessageUtil;
import com.mrkb.dao.dao.ClassTimeEnrollMapper;
import com.mrkb.dao.dao.ClassTimeNodesMapper;
import com.mrkb.dao.modle.nodes.ClassTimeEnroll;
import com.mrkb.dao.modle.nodes.ClassTimeNodes;
import com.mrkb.service.ClassTimeNodeService;

import net.sf.json.JSONObject;
@Service
public class ClassTimeNodeServiceImpl implements ClassTimeNodeService {
	
	
	@Autowired
	private ClassTimeNodesMapper mapper;
	@Autowired
	private ClassTimeEnrollMapper enrollmapper;
	//log4j日志（级别，error,info,debug）
    private final static Logger log = LoggerFactory.getLogger(ClassTimeNodeServiceImpl .class);
    
    

	/**
	 * 查询列表集合
	 */
	@Override
	public List<ClassTimeNodes> list(Map<String, Object> param) {
		List<ClassTimeNodes> list = new ArrayList<ClassTimeNodes>();
		try {
			list = mapper.findList(param);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("类[ClassTimeNodeServiceImpl-list]—[查询课程时间节点列表集合]方法异常");
			return new ArrayList<ClassTimeNodes>();
		}
		return list;
	}

	
	/**
	 * 根据ID查询课程时间节点
	 */
	@Override
	public ClassTimeNodes get(Integer class_node_id) {
		ClassTimeNodes node = new ClassTimeNodes();
		try {
			node = mapper.get(class_node_id);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("类[ClassTimeNodeServiceImpl-get]—[根据ID查询课程时间节点]方法异常");
			return new ClassTimeNodes();
		}
		return node;
	}

	
	
		/**
	 * 删除课程时间节点
	 */
	@Override
	public Integer delete(Integer class_node_id) {
		Integer num = 0;
		try {
			num = mapper.delete(class_node_id);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("类[ClassTimeNodeServiceImpl-delete]—[删除课程时间节点]方法异常");
			return 0;
		}
		return num;
	}

	
	
	
	/**
	 * 修改课程时间节点
	 */
	@Override
	public Integer update(ClassTimeNodes timeNodes) {
		Integer result=0;
		try {
			result = mapper.update(timeNodes);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("类[ClassTimeNodeServiceImpl-update]—[修改课程时间节点]方法异常");
			return 0;
		}
		return result;
	}


	
	/**
	 * 新增课程节点 
	 */
	@Override
	public Integer insert(ClassTimeNodes nodes) {
		Integer result=0;
		try {
			result = mapper.insert(nodes);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("类[ClassTimeNodeServiceImpl-insert]—[新增课程时间节点]方法异常");
			return 0;
		}
		return result;
	}

	
	
	
	/**
	 * 向报名节点课程的人发送上课通知
	 */
	public Integer notice(Integer class_node_id){
		//获取需要通知的微信ID
		ArrayList<String> list_openId = new ArrayList<String>();
		List<ClassTimeEnroll> list = new ArrayList<ClassTimeEnroll>();
		list = enrollmapper.getWxOpenIdByNodeId(class_node_id);
		if(list.size()>0){
			for(ClassTimeEnroll enroll : list){
				list_openId.add(enroll.getWx_openid());
			}
		}
		String[] openid = new String[list_openId.size()];
		for(int i=0;i<list_openId.size();i++){
			openid[i]=list_openId.get(i);
		}
		
		//时间节点表课程ID关联课程表ID查出课程名称
		String k="测试课程";
		
		//推送消息
		StringBuffer buffer = new StringBuffer();
		JSONObject jsonObject = new JSONObject();
		jsonObject = new WxCustomerServiceMessageUtil().messTextMessage("您好，您的"+k+"即将开课",openid);
		System.out.println(openid);
		return 0;
	}
	
}
