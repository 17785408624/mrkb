package com.mrkb.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.PrivilegeMapper;
import com.mrkb.dao.dao.UserOperationLogMapper;
import com.mrkb.dao.modle.privilege.UserOperationLog;
import com.mrkb.service.OperationLogService;

@Service
@Transactional
public class OperationLogServiceImpl implements OperationLogService{
	@Resource
	private UserOperationLogMapper userOperationLogMapper;//
	@Resource
	private PrivilegeMapper privilegeMapper;//

	@Override
	public int updatePrivilegeVerifyToPrivilegeId(int[] is_operation_logs,
			int is_operation_log, int operation_type) {
		return privilegeMapper.updateOperationLog(is_operation_logs,is_operation_log,operation_type);
	}

	@Override
	public List<UserOperationLog> findAllOperationLog(
			UserOperationLog userOperationLog) {
		return userOperationLogMapper.findAllOperationLog(userOperationLog);
	}
	
	
}
