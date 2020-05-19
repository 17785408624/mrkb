package com.mrkb.service;

import java.util.List;
import java.util.Map;

import com.mrkb.dao.modle.nodes.ClassTimeNodes;

public interface ClassTimeNodeService {

	//查询列表集合
	List<ClassTimeNodes> list(Map<String, Object>param);
	
	//根据ID查询课程时间节点
	ClassTimeNodes get(Integer class_node_id);
	
	//删除课程时间节点
	Integer delete (Integer class_node_id);
	
	//修改课程时间节点
	Integer update(ClassTimeNodes timeNodes);

	//新增课程节点
	Integer insert(ClassTimeNodes nodes);
	
	//向报名节点课程的人发送上课通知
	Integer notice(Integer class_node_id);
	
}
