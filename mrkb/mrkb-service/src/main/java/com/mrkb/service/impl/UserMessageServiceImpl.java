package com.mrkb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.UserMessageMapper;
import com.mrkb.dao.modle.user.UserMessage;
import com.mrkb.service.UserMessageService;


@Service
@Transactional
public class UserMessageServiceImpl implements UserMessageService{
	
	@Resource
	UserMessageMapper  userMessageMapper;

	@Override
	public UserMessage addMessage(UserMessage userMessage) {
		userMessageMapper.addMessage(userMessage);
		return userMessage;
	}

	@Override
	public UserMessage updateMessage(UserMessage userMessage) {
		userMessageMapper.updateMessage(userMessage);
		return userMessage;
	}

	@Override
	public List<UserMessage> findUserMessage(UserMessage userMessage) {
		return userMessageMapper.findUserMessage(userMessage);
	}

	@Override
	public int findUserCount(UserMessage userMessage) {
		return userMessageMapper.findUserCount(userMessage);
	}

}
