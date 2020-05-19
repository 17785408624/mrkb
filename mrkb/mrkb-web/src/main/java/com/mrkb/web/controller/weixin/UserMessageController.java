package com.mrkb.web.controller.weixin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.user.UserMessage;
import com.mrkb.service.UserMessageService;
import com.mrkb.shiro.cookieutil.SessionEntity;


@Controller("weixin/UserMessage")
@RequestMapping("/weixin/UserMessage")
public class UserMessageController {
	@Autowired
	private UserMessageService userMessageService;
	
/**
 * 
 * @Title:             findUserMessage
 * @Description:     TODO 查询用户消息
 * @param:             @param response
 * @param:             @param request
 * @param:             @return   
 * @return:            vbm 
 * @throws
*/
@RequestMapping("findUserMessage")
public @ResponseBody ResponseData findUserMessage(HttpServletResponse response,HttpServletRequest request){
	ResponseData rs = new ResponseData();
	Integer user_basics_id =-1;
	SessionEntity se = null;
	try {
		se = new SessionEntity(request);
		user_basics_id =se.getUser_basics_id();
	} catch (SessionException e) {
		e.printStackTrace();
		rs.setIsSuccess(false);
		rs.setMessage("获取cookie信息失败！");
		return rs;
	}
	UserMessage userMessage=new UserMessage();
	userMessage.setUser_basics_id(user_basics_id);
	List<UserMessage> um=userMessageService.findUserMessage(userMessage);
	userMessage.setIf_read(1);
	userMessageService.updateMessage(userMessage);
	rs.setData(um);
	rs.setMessage("查询成功!");
	rs.setIsSuccess(true);
	return rs;
}

/**
 * 
 * @Title:             findUserCount
 * @Description:     TODO 查询用户未读消息
 * @param:             @param response
 * @param:             @param request
 * @param:             @return   
 * @return:            vbm 
 * @throws
*/
@RequestMapping("findUserCount")
public @ResponseBody ResponseData findUserCount(HttpServletResponse response,HttpServletRequest request){
	ResponseData rs = new ResponseData();
	Integer user_basics_id =-1;
	SessionEntity se = null;
	try {
		se = new SessionEntity(request);
		user_basics_id =se.getUser_basics_id();
	} catch (SessionException e) {
		e.printStackTrace();
		rs.setIsSuccess(false);
		rs.setMessage("获取cookie信息失败！");
		return rs;
	}
	UserMessage userMessage=new UserMessage();
	userMessage.setUser_basics_id(user_basics_id);
	userMessage.setIf_read(0);
	int um=userMessageService.findUserCount(userMessage);
	rs.setData(um);
	rs.setMessage("查询成功!");
	rs.setIsSuccess(true);
	return rs;
}

}
