/**
 * FileName:         SearchUserSeriviceImpl.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-28     下午3:24:43
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-28     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.common.utils.serviceutil.serviceutilimpl.SearchUserUtilSeriviceImpl;
import com.mrkb.dao.dao.SearchUserMapper;
import com.mrkb.dao.modle.user.UserBasicsAndWxAndInformationEntity;
import com.mrkb.dao.modle.user.UserEntity;
import com.mrkb.service.SearchUserSerivice;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service("searchUserSeriviceImpl")
public class SearchUserSeriviceImpl implements SearchUserSerivice{
     @Resource
     SearchUserMapper searchUserMapper;
	/**
	 * <p>Title: findLikeUserToSearchTerms</p>
	 * <p>Description: </p>根据一个搜索词模糊查询用户信息
	 * @param searchTerms
	 * @return
	 * @see com.medicinefood.service.UserService#findLikeUserToSearchTerms(java.lang.String)
	 */ 
	@Override
	public List<UserEntity> searchLikeUserToSearchTerms(String searchTerms) {//根据一个搜索词模糊查询用户信息
		// TODO Auto-generated method stub
		UserEntity userEntity=SearchUserUtilSeriviceImpl.assembleSearchConditionUserEntity(searchTerms);//组装搜索条件
		return searchUserMapper.selectLikeUserToUser(userEntity);
	}
	/**
	 * <p>Title: selectUserBasicsAndWxAndInformationToUserEntity</p>
	 * <p>Description: </p>
	 * @param searchTerms 根据实体类中设置的值为条件搜索管理组id不为传入administrative_id的数据
	 * @param administrative_id
	 * @return
	 * @see com.medicinefood.service.SearchUserSerivice#selectUserBasicsAndWxAndInformationToUserEntity(java.lang.String, int)
	 */ 
	@Override
	public List<UserBasicsAndWxAndInformationEntity> searchUserBasicsAndWxAndIfToSearchTerms(
			String searchTerms, int administrative_id) {//根据实体类中设置的值为条件搜索管理组id不为传入administrative_id的数据
		// TODO Auto-generated method stub
		UserEntity userEntity=SearchUserUtilSeriviceImpl.assembleSearchConditionUserEntity(searchTerms);//组装搜索条件
		
		return searchUserMapper.selectLikeUserBasicsAndWxAndInformationToUser(userEntity, administrative_id);
	}

}
