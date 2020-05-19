/**
 * FileName:         ExpertConsultEntity.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-7-4     下午2:20:26
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-7-4     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.expertConsult;

/**
 * @param
 * @return
 * @author liangyi
 * @desc 专家咨询实体类
 */
public class ExpertConsultEntity {

	private Integer consult_id; // 咨询id
	private Integer user_basics_id;// 用户id
	private Integer expert_id; // 专家id
	private Integer status_state; // 审核状态(0:通过，1:待审核,2.删除)
	private Integer expert_state;// 专家查看消息状态(0::已读,1:未读)
	private Integer user_state;// 专家回复用户信息状态(0:已读,1:未读)
	private Long add_date;// 用户提交问题日期
	private Long update_date;// 专家回复问题日期
	private String user_message;// 用户提交问题内容
	private String expert_message; // 专家回复用户问题内容
	private String info_dialog; // 消息对话框
	private Integer star_rate; // 星级评价
	private Integer expert_reply_state;// 专家回复状态(0:已回复，1:未回复)
	private Integer thumbs_up;//点赞量
	private String user_nickname;//用户昵称
	private String weixin_portrait;//微信头像
	private String weixin_nickname;//用户微信昵称
	public Integer getConsult_id() {
		return consult_id;
	}

	public void setConsult_id(Integer consult_id) {
		this.consult_id = consult_id;
	}

	public Integer getUser_basics_id() {
		return user_basics_id;
	}

	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}

	public Integer getExpert_id() {
		return expert_id;
	}

	public void setExpert_id(Integer expert_id) {
		this.expert_id = expert_id;
	}

	public Integer getStatus_state() {
		return status_state;
	}

	public void setStatus_state(Integer status_state) {
		this.status_state = status_state;
	}

	public Integer getExpert_state() {
		return expert_state;
	}

	public void setExpert_state(Integer expert_state) {
		this.expert_state = expert_state;
	}

	public Integer getUser_state() {
		return user_state;
	}

	public void setUser_state(Integer user_state) {
		this.user_state = user_state;
	}

	public Long getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}

	public Long getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Long update_date) {
		this.update_date = update_date;
	}

	public String getUser_message() {
		return user_message;
	}

	public void setUser_message(String user_message) {
		this.user_message = user_message;
	}

	public String getExpert_message() {
		return expert_message;
	}

	public void setExpert_message(String expert_message) {
		this.expert_message = expert_message;
	}

	public String getInfo_dialog() {
		return info_dialog;
	}

	public void setInfo_dialog(String info_dialog) {
		this.info_dialog = info_dialog;
	}

	public Integer getStar_rate() {
		return star_rate;
	}

	public void setStar_rate(Integer star_rate) {
		this.star_rate = star_rate;
	}

	public Integer getExpert_reply_state() {
		return expert_reply_state;
	}

	public void setExpert_reply_state(Integer expert_reply_state) {
		this.expert_reply_state = expert_reply_state;
	}

	public Integer getThumbs_up() {
		return thumbs_up;
	}

	public void setThumbs_up(Integer thumbs_up) {
		this.thumbs_up = thumbs_up;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getWeixin_portrait() {
		return weixin_portrait;
	}

	public void setWeixin_portrait(String weixin_portrait) {
		this.weixin_portrait = weixin_portrait;
	}

	public String getWeixin_nickname() {
		return weixin_nickname;
	}

	public void setWeixin_nickname(String weixin_nickname) {
		this.weixin_nickname = weixin_nickname;
	}

	@Override
	public String toString() {
		return "ExpertConsultEntity [consult_id=" + consult_id
				+ ", user_basics_id=" + user_basics_id + ", expert_id="
				+ expert_id + ", status_state=" + status_state
				+ ", expert_state=" + expert_state + ", user_state="
				+ user_state + ", add_date=" + add_date + ", update_date="
				+ update_date + ", user_message=" + user_message
				+ ", expert_message=" + expert_message + ", info_dialog="
				+ info_dialog + ", star_rate=" + star_rate
				+ ", expert_reply_state=" + expert_reply_state + ", thumbs_up="
				+ thumbs_up + ", user_nickname=" + user_nickname
				+ ", weixin_portrait=" + weixin_portrait + ", weixin_nickname="
				+ weixin_nickname + "]";
	}
	
	
	
}
