package com.mrkb.service.impl;

import com.mrkb.dao.dao.BizUserDao;
import com.mrkb.dao.modle.BizUser;
import com.mrkb.service.BizUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BizUserServiceImpl implements BizUserService {

    @Autowired
    private BizUserDao userDao;

    //log4j日志（级别，error,info,debug）
    private final static Logger logger = LoggerFactory.getLogger(BizUserService .class);

    
    
    public int save(BizUser users) {
        return 0;
    }

    
    
    public List<Map<String, Object>> getObject() {
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		try {
			list = userDao.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取所有用户信息异常");
		}
        return list;
    }
    
    

    public int update(Map<String, String> map) {
        return 0;
    }

    
    
    public int delete(Map<String, String> map) {
        return 0;
    }
}
