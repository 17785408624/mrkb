/**
 * FileName:         searchUser.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-28     下午3:06:18
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-28     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.search.SearchConditionUser;
import com.mrkb.dao.modle.user.UserBasicsAndWxAndInformationEntity;
import com.mrkb.dao.modle.user.UserEntity;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Mapper
public interface SearchUserMapper {
	  /**
     * 
     * @Title:             selectLikeUserToUserEntity
     * @Description:     TODO 根据实体类中设置的值为条件模糊查询满足条件的数据 
     * @param:             @param userEntity 实体类包含用户基本信息、微信信息、详细信息、成就信息、推荐信息、积分信息、
     * 成就信息。
     * @param:             @return   
     * @return:         List<UserEntity>   
     * @throws
     */
    List<UserEntity>selectLikeUserToUser(UserEntity userEntity);//根据实体类中设置的值为条件模糊查询满足条件的数据
    /**
     * 
     * @Title:             selectUserBasicsAndWxAndInformationToUserEntity
     * @Description:     TODO 根据实体类中设置的值为条件模糊查询管理组id不为传入administrative_id的数据
     * @param:             @param userBasicsAndWxAndInformationEntity
     * @param:             @param administrative_id
     * @param:             @return   
     * @return:         List<UserEntity>   
     * @throws
     */
    List<UserBasicsAndWxAndInformationEntity>selectLikeUserBasicsAndWxAndInformationToUser(
    		@Param("userEntity")UserEntity userEntity,
    		@Param("administrative_id")int administrative_id);//根据实体类中设置的值为条件模糊查询管理组id不为传入administrative_id的数据
    
    List<UserBasicsAndWxAndInformationEntity>selectUserBasicsAndWxAndInformationToOr(
    		SearchConditionUser searchConditionUser);//根据实体类中设置的值查询满足条件的数据 每个条件之间以or链接
    List<UserBasicsAndWxAndInformationEntity>selectUserBasicsAndWxAndInformationToAnd(
    		SearchConditionUser searchConditionUser);//根据实体类中设置的值查询满足条件的数据 每个条件之间以and链接
}
