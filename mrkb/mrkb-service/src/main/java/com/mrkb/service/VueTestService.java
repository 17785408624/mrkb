package com.mrkb.service;

import java.util.List;

import com.mrkb.dao.modle.VueTest;

public interface VueTestService {
	
	
	Integer del(Integer id);
	
	Integer add(VueTest vueTest);
	
	Integer edit(VueTest vueTest);
	
	List<VueTest>list(VueTest test);

}
