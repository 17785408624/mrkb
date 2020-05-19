/**
 * FileName:         SearchUserSerivice.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-28     下午3:24:20
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-28     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.user.UserBasicsAndWxAndInformationEntity;
import com.mrkb.dao.modle.user.UserEntity;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public interface SearchUserSerivice {//用户信息搜索业务
	/**
	 * 
	 * @Title:             findLikeUserToSearchTerms
	 * @Description:     TODO 根据一个搜索词模糊查询用户信息
	 * @param:             @param searchTerms 搜索的词
	 * @param:             @return   
	 * @return:         List<UserEntity>  用户信息实体类集合 
	 * @throws 
	 */
	List<UserEntity> searchLikeUserToSearchTerms(String searchTerms);//根据一个搜索词模糊查询用户信息
	/**
	 * 
	 * @Title:             selectUserBasicsAndWxAndInformationToUserEntity
	 * @Description:     TODO  根据实体类中设置的值为条件模糊查询管理组id不为传入administrative_id的数据
	 * @param:             @param searchTerms 搜索词
	 * @param:             @param administrative_id 管理组id
	 * @param:             @return   用户信息，包含详细信息与微信信息 
	 * @return:         List<UserBasicsAndWxAndInformationEntity>  用户信息实体类集合
	 * @throws
	 */
	List<UserBasicsAndWxAndInformationEntity>searchUserBasicsAndWxAndIfToSearchTerms(
			String searchTerms,int administrative_id);//根据实体类中设置的值为条件模糊查询管理组id不为传入administrative_id的数据

}
