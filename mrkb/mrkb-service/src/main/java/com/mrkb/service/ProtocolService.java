package com.mrkb.service;


import java.util.List;

import com.mrkb.dao.modle.protocol.ProtocolEntity;


public interface ProtocolService {
	/**
	 * 
	 * @Title:             addProtocol
	 * @Description:     TODO 添加协议
	 * @param:             @param protocolEntity 协议基本数据实体类
	 * @param:             @return   
	 * @return:            ProtocolEntity   
	 * @throws
	 */
	ProtocolEntity addProtocol(ProtocolEntity protocolEntity);//添加协议
	/**
	 * 
	 * @Title:             findAllProtocol
	 * @Description:     TODO 查询所有协议数据
	 * @param:             @param  protocolEntity 协议基本数据实体类
	 * @param:             @return   
	 * @return:            List<ProtocolEntity>    
	 * @throws
	 */
	List<ProtocolEntity> findAllProtocol(ProtocolEntity protocolEntity);//查询协议
	
	
	
	/**
	 * 
	 * @Title:             updateProtocol
	 * @Description:     TODO 修改协议
	 * @param:             @param protocolEntity 协议基本数据实体类
	 * @param:             @return   
	 * @return:             ProtocolEntity  
	 * @throws
	 */
	int updateProtocol(ProtocolEntity protocolEntity);//修改协议
	/**
	 * 
	 * @Title:             deleteProtocol
	 * @Description:     TODO 删除协议（逻辑删除）
	 * @param:             @param protocolEntity 协议基本数据实体类
	 * @param:             @return   
	 * @return:             int  
	 * @throws
	 */
	int deleteProtocol(ProtocolEntity protocolEntity);//删除协议(逻辑删除)
	
	/**
	 * 
	 * @Title:             deleteProtocol
	 * @Description:     TODO 删除协议（逻辑删除）
	 * @param:             @param protocolEntity 协议基本数据实体类
	 * @param:             @return   
	 * @return:             int  
	 * @throws
	 */
	int deleteProtocols(ProtocolEntity protocolEntity);//删除协议（物理删除）
	/**
	 * 
	 * @Title:             findProtocolById
	 * @Description:     TODO 查询单个协议
	 * @param:             @param protocolEntity 协议基本数据实体类
	 * @param:             @return   
	 * @return:            ProtocolEntity
	 */
	ProtocolEntity findProtocolById(ProtocolEntity protocolEntity);//查询单个协议
	/**
	 * 
	 * @Title:             updateProtocolState
	 * @Description:     TODO 审核协议
	 * @param:             @param protocolEntity 协议基本数据实体类
	 * @param:             @return   
	 * @return:            ProtocolEntity
	 */
	int updateProtocolState(ProtocolEntity protocolEntity);//审核协议
	
}
