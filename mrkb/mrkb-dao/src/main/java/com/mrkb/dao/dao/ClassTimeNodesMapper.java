package com.mrkb.dao.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.nodes.ClassTimeNodes;
@Mapper
public interface ClassTimeNodesMapper{
	
	public List<ClassTimeNodes> findList(Map<String, Object> param); 
	
	
	public ClassTimeNodes get(Integer class_node_id);
	
	
	public Integer delete(Integer class_node_id);
	
	
	public Integer update(ClassTimeNodes timeNodes);


	public Integer insert(ClassTimeNodes nodes);

}
