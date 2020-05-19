package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.VueTest;

@Mapper
public interface VueTestDao {
	
	Integer del(Integer id) throws Exception;
	
	Integer add(VueTest vueTest)throws Exception;
	
	Integer edit(VueTest vueTest)throws Exception;
	
	List<VueTest>list(VueTest test)throws Exception;

}
