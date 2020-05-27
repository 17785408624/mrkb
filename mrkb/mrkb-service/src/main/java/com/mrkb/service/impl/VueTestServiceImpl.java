package com.mrkb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrkb.dao.dao.VueTestDao;
import com.mrkb.dao.modle.VueTest;
import com.mrkb.service.VueTestService;

@Service
public class VueTestServiceImpl implements VueTestService {
	
	@Autowired
	private VueTestDao dao;
	
	
	//得到log对象 操作日志 可以通过log去打印日志信息
    private static final transient Logger log = LoggerFactory.getLogger(VueTestServiceImpl.class);

    
    /**
     * 删除
     */
	@Override
	public Integer del(Integer id) {
		Integer r=0;
		try {
			r = dao.del(id);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("删除异常");
		}
		return r;
	}

	
	
	
	/**
	 * 新增
	 */
	@Override
	public Integer add(VueTest vueTest) {
		Integer r=0;
		try {
			r = dao.add(vueTest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("新增异常");
		}
		return r;
	}

	
	
	
	/**
	 * 修改
	 */
	@Override
	public Integer edit(VueTest vueTest) {
		Integer r=0;
		try {
			r = dao.edit(vueTest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("修改异常");
		}
		return r;
	}

	
	
	
	
	/**
	 * 查询
	 */
	@Override
	public List<VueTest> list(VueTest test) {
		List<VueTest>list = new ArrayList<VueTest>();
		try {
			list = dao.list(test);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("查询列表集合异常");
		}
		return list;
	}

}
