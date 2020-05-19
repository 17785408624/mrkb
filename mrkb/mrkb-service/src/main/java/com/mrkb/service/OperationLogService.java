package com.mrkb.service;

import java.util.List;

import com.mrkb.dao.modle.privilege.UserOperationLog;


public interface OperationLogService {
	/**
	 * 
	 * @Title:             updatePrivilegeVerifyToPrivilegeId
	 * @Description:     TODO 根据权限的id修改是否需要加入操作日志
	 * @param:             @param privilegeIds 权限id数组
	 * @param:             @param privilege_verify 修改的状态值 （1为需要加入操作日志）
	 * @param:             @return   
	 * @return:         int   修改数
	 * @throws
	 */
	int updatePrivilegeVerifyToPrivilegeId(int[]is_operation_logs,int is_operation_log,int operation_type);//根据权限的id修改是否需要加入操作日志
	List<UserOperationLog> findAllOperationLog(UserOperationLog userOperationLog);//查询所有操作日志
	
}
