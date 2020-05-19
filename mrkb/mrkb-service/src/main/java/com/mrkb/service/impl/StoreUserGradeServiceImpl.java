package com.mrkb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mrkb.dao.dao.StoreUserGradeMapper;
import com.mrkb.dao.modle.store.StoreUserGradeEntity;
import com.mrkb.service.StoreUserGradeService;
@Service("storeUserGradeServiceImpl")
/**
 * 
 * @author liangyi
 *课程与会员等级关联信息接口实现
 */
public class StoreUserGradeServiceImpl implements StoreUserGradeService {
	@Resource
	private StoreUserGradeMapper storeUserGradeMapper;
	@Override
	public int addStoreUserGrade(StoreUserGradeEntity storeUserGradeEntity) {
		return storeUserGradeMapper.addStoreUserGrade(storeUserGradeEntity);
	}

}
