package com.mrkb.dao.modle.store;

public class StoreEvaluation {
	private Integer evaluation_id;//评论ID
	private Integer store_id;//商品ID
	private String store_name;//
	private String weixin_nickname;//微信昵称
	private String weixin_portrait;//微信头像
	private Long evaluation_date;//评论时间
	private String evaluation_value;//评论内容
	private Integer super_evaluation_id;//
	private Integer read_num;//阅读量
	private Integer user_basics_id;//评论人
	private Integer status_state;
	public Integer getEvaluation_id() {
		return evaluation_id;
	}
	public void setEvaluation_id(Integer evaluation_id) {
		this.evaluation_id = evaluation_id;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getWeixin_nickname() {
		return weixin_nickname;
	}
	public void setWeixin_nickname(String weixin_nickname) {
		this.weixin_nickname = weixin_nickname;
	}
	public String getWeixin_portrait() {
		return weixin_portrait;
	}
	public void setWeixin_portrait(String weixin_portrait) {
		this.weixin_portrait = weixin_portrait;
	}
	public Long getEvaluation_date() {
		return evaluation_date;
	}
	public void setEvaluation_date(Long evaluation_date) {
		this.evaluation_date = evaluation_date;
	}
	public String getEvaluation_value() {
		return evaluation_value;
	}
	public void setEvaluation_value(String evaluation_value) {
		this.evaluation_value = evaluation_value;
	}
	public Integer getSuper_evaluation_id() {
		return super_evaluation_id;
	}
	public void setSuper_evaluation_id(Integer super_evaluation_id) {
		this.super_evaluation_id = super_evaluation_id;
	}
	public Integer getRead_num() {
		return read_num;
	}
	public void setRead_num(Integer read_num) {
		this.read_num = read_num;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getStatus_state() {
		return status_state;
	}
	public void setStatus_state(Integer status_state) {
		this.status_state = status_state;
	}
	@Override
	public String toString() {
		return "StoreEvaluation [evaluation_id=" + evaluation_id
				+ ", store_id=" + store_id + ", store_name=" + store_name
				+ ", weixin_nickname=" + weixin_nickname + ", weixin_portrait="
				+ weixin_portrait + ", evaluation_date=" + evaluation_date
				+ ", evaluation_value=" + evaluation_value
				+ ", super_evaluation_id=" + super_evaluation_id
				+ ", read_num=" + read_num + ", user_basics_id="
				+ user_basics_id + ", status_state=" + status_state + "]";
	}
	
}
