package com.mrkb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.ProtocolMapper;
import com.mrkb.dao.modle.protocol.ProtocolEntity;
import com.mrkb.service.ProtocolService;

@Service
@Transactional
public class ProtocolServiceImpl implements ProtocolService{
	@Resource
	private ProtocolMapper protocolMapper;

	@Override
	public ProtocolEntity addProtocol(ProtocolEntity protocolEntity) {
		protocolMapper.addProtocol(protocolEntity);
		return protocolEntity;
	}

	@Override
	public List<ProtocolEntity> findAllProtocol(ProtocolEntity protocolEntity) {
		
		return  protocolMapper.findAllProtocol(protocolEntity);
	}

	@Override
	public ProtocolEntity findProtocolById(ProtocolEntity protocolEntity) {
		 
		return protocolMapper.findProtocolById( protocolEntity);
	}

	@Override
	public int updateProtocol(ProtocolEntity protocolEntity) {
		
		return protocolMapper.updateProtocol(protocolEntity);
	}

	@Override
	public int deleteProtocol(ProtocolEntity protocolEntity) {
		return protocolMapper.deleteProtocol(protocolEntity);
	}

	@Override
	public int deleteProtocols(ProtocolEntity protocolEntity) {
		return protocolMapper.deleteProtocols(protocolEntity);
	}

	@Override
	public int updateProtocolState(ProtocolEntity protocolEntity) {
		return protocolMapper.updateProtocolState(protocolEntity);
	}

}

