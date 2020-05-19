package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.user.UserMessage;

@Mapper
public interface UserMessageMapper {
	int addMessage(UserMessage userMessage);//添加用户消息
	int updateMessage(UserMessage userMessage);//修改用户消息
	List<UserMessage> findUserMessage(UserMessage userMessage);//查询用户消息
	int findUserCount(UserMessage userMessage);//查询为读条数

}
