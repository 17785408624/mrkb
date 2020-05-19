package com.mrkb.service;

import java.util.List;

import com.mrkb.dao.modle.user.UserMessage;


public interface UserMessageService {
	UserMessage addMessage(UserMessage userMessage);//添加用户消息
	UserMessage updateMessage(UserMessage userMessage);//修改用户消息
	List<UserMessage> findUserMessage(UserMessage userMessage);//查询用户消息
	int findUserCount(UserMessage userMessage);//查询为读条数
}
