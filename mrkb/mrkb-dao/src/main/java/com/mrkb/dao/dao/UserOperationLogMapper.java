/**
 * FileName:         UserOperationLogMapper.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-3-9     下午7:28:27
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-3-9     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.privilege.UserOperationLog;



/**
 * @param
 * @return
 * @author moerka-1
 * 
 */
@Mapper
public interface UserOperationLogMapper {
	/**
	 * 
	 * @Title:             addUserOperationLog
	 * @Description:     TODO 添加用户操作日志
	 * @param:             @param UserOperationLog
	 * @param:             @return   
	 * @return:         int   返回删除的条数
	 * @throws
	 */
	int addUserOperationLog(UserOperationLog userOperationLog);//添加用户操作日志
	List<UserOperationLog> findAllOperationLog(UserOperationLog userOperationLog);//查询所有操作日志
	
}
