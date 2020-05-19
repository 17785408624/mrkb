package com.mrkb.dao.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.protocol.ProtocolEntity;


@Mapper
public interface ProtocolMapper {
	int addProtocol(ProtocolEntity protocolEntity);//添加协议
	List<ProtocolEntity> findAllProtocol(ProtocolEntity protocolEntity);//查询协议
	ProtocolEntity findProtocolById(ProtocolEntity protocolEntity);//查询协议通过protocol_id
	int updateProtocol(ProtocolEntity protocolEntity);//修改协议
	int deleteProtocol(ProtocolEntity protocolEntity);//删除协议（逻辑删除）
	int deleteProtocols(ProtocolEntity protocolEntity);//删除协议(物理删除)
	int updateProtocolState(ProtocolEntity protocolEntity);//审核协议
	

}