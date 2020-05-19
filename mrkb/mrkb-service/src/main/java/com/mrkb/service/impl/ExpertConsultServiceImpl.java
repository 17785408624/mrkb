package com.mrkb.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.ExpertConsultMapper;
import com.mrkb.dao.dao.UserMessageMapper;
import com.mrkb.dao.modle.expertConsult.ExpertConsultEntity;
import com.mrkb.dao.modle.user.UserMessage;
import com.mrkb.service.ExpertConsultService;

@Service
@Transactional
public class ExpertConsultServiceImpl implements ExpertConsultService{
	@Resource
	private ExpertConsultMapper expertConsultMapper;
	@Resource
	private UserMessageMapper userMessageMapper;

	@Override
	public List<ExpertConsultEntity> findAllExpertConsult(
			ExpertConsultEntity expertConsultEntity) {
		return expertConsultMapper.findAllExpertConsult(expertConsultEntity);
	}

	@Override
	public ExpertConsultEntity findExpertConsultById(
			ExpertConsultEntity expertConsultEntity) {
		return expertConsultMapper.findExpertConsultById(expertConsultEntity);
	}

	@Override
	public int deleteExpertConsultById(ExpertConsultEntity expertConsultEntity) {
		
		return expertConsultMapper.deleteExpertConsultById(expertConsultEntity);
	}

	@Override
	public ExpertConsultEntity addExpertConsult(ExpertConsultEntity expertConsultEntity) {
		expertConsultMapper.addExpertConsult(expertConsultEntity);
		return  expertConsultEntity ;
	}

	@Override
	public int updateExpertConsult(ExpertConsultEntity expertConsultEntity) {
		if(expertConsultEntity.getStatus_state()!=null&&expertConsultEntity.getConsult_id()!=null){
			 if(expertConsultEntity.getStatus_state()==0){
				 Long time=System.currentTimeMillis();
				 ExpertConsultEntity ece=expertConsultMapper.findExpertConsultById(expertConsultEntity);
				 UserMessage um=new UserMessage();
				 um.setUser_basics_id(ece.getUser_basics_id());
				 um.setTb_id(ece.getConsult_id());
				 um.setTb_name("user_consult_expert");
				 um.setMessage_type(1);
				 um.setAdd_date(time);
				 um.setIf_read(0);
				 SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
				 java.util.Date dt = new Date();
				 java.util.Date dt1 = new Date(ece.getAdd_date());//用户提问时间
				 String update=sdf.format(dt);
				 String update1=sdf.format(dt1);//用户提问时间
				 String message_content="<div style='margin-top:20px;'>"+
						 "<div class='center_div'>"+
						 "<div class='center_div_img'>"+
						 "<img alt='' src='images/zhuanjia.png'>"+
						 "</div>"+
						 "<div class='center_div_name'>"+
						 "<p style='font-size: 14px;color: #333333;'>健康助理</p>"+
						 "<p style='font-size: 12px;color: #666666;'>"+update+"</p>"+
						 "</div>"+
						 "</div>"+
						 "<div class='center_div_tit'>"+
						 "<p>" +ece.getExpert_message()+"</p>"+
						 "</div>"+
						 "<div class='center_div_zjjs'>"+
						 "<div class='center_div_nr'>"+
						 "<div class='demo'>" +ece.getUser_message()+"</div>"+
						 "</div>"+
						 "</div>"+
						 "<p class='center_div_nr_sj'>"+update1+"</p>"+
						 "</div>";
				 um.setMessage_content(message_content);
				 userMessageMapper.addMessage(um);
			 }
		 }
		return expertConsultMapper.updateExpertConsult(expertConsultEntity);
	}

	@Override
	public int thumbs_up(ExpertConsultEntity expertConsultEntity) {
		return expertConsultMapper.thumbs_up(expertConsultEntity);
	}

	
 
	
	
	

}

