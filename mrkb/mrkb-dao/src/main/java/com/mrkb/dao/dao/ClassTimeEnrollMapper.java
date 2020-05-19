package com.mrkb.dao.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.nodes.ClassTimeEnroll;
import com.mrkb.dao.modle.nodes.ClassTimeNodes;

/**
 * 课程时间节点报名
 * @author Administrator
 *
 */
@Mapper
public interface ClassTimeEnrollMapper {

	//查询课程时间节点
	List<ClassTimeNodes> nodes_list(Map<String, Object> param);

	
	//时间节点课程报名
	Integer insert(ClassTimeEnroll time_enroll);
	
	
	//更新上课人数
	Integer update(Integer class_node_id);
	
	
	//根据节点课程ID查询报名人微信ID
	public List<ClassTimeEnroll> getWxOpenIdByNodeId(Integer class_node_id);
}
