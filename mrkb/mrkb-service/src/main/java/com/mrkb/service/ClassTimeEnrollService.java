package com.mrkb.service;

import java.util.List;
import java.util.Map;

import com.mrkb.dao.modle.nodes.ClassTimeEnroll;
import com.mrkb.dao.modle.nodes.ClassTimeNodes;
import com.mrkb.dao.modle.order.OrderBasics;

public interface ClassTimeEnrollService {

	//报名
	OrderBasics sign_up(ClassTimeEnroll time_enroll);

	//课程时间节点
	List<ClassTimeNodes> list(Map<String, Object> param);

}
