/**
 * FileName:         IntegraServiceImpl.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-9     上午11:50:08
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-9     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.service.impl;

import com.mrkb.dao.dao.BusinessMapper;
import com.mrkb.dao.modle.store.Business;
import com.mrkb.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Service
public class BusinessServiceImpl implements BusinessService {

	@Resource
	private BusinessMapper businessMapper;


    @Override
    public int add(Business business) {
        return businessMapper.add(business);
    }

    @Override
    public List<Business> findAll(Business business) {
        return businessMapper.findAll(business);
    }

    @Override
    public Business findById(Business business) {
        return businessMapper.findById(business);
    }

    @Override
    public int update(Business business) {
        return businessMapper.update(business);
    }

    @Override
    public int delete(Business business) {
        return businessMapper.delete(business);
    }
}
