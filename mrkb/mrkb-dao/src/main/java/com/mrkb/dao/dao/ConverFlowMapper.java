package com.mrkb.dao.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.user.ConverFlow;
@Mapper
public interface ConverFlowMapper {
	int addConverFlow(ConverFlow cf);
}
