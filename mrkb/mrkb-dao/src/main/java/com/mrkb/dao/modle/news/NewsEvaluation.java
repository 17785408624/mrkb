package com.mrkb.dao.modle.news;

public class NewsEvaluation {
	private Integer news_evaluation_id;//评论自增ID
	private Integer news_id;//ID
	private Integer news_type;//类型
	private String weixin_nickname;//微信昵称
	private String weixin_portrait;//微信头像
	private Long add_date;//评论时间
	private String evaluation_value;//评论内容
	private Integer super_evaluation_id;//回复对象
	private Integer read_num;//阅读量
	private Integer user_basics_id;//评论人编号
	private Integer status_state;//状态
	public Integer getNews_evaluation_id() {
		return news_evaluation_id;
	}
	public void setNews_evaluation_id(Integer news_evaluation_id) {
		this.news_evaluation_id = news_evaluation_id;
	}
	public Integer getNews_id() {
		return news_id;
	}
	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}
	public Integer getNews_type() {
		return news_type;
	}
	public void setNews_type(Integer news_type) {
		this.news_type = news_type;
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
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
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
		return "NewsEvaluation [news_evaluation_id=" + news_evaluation_id
				+ ", news_id=" + news_id + ", news_type=" + news_type
				+ ", weixin_nickname=" + weixin_nickname + ", weixin_portrait="
				+ weixin_portrait + ", add_date=" + add_date
				+ ", evaluation_value=" + evaluation_value
				+ ", super_evaluation_id=" + super_evaluation_id
				+ ", read_num=" + read_num + ", user_basics_id="
				+ user_basics_id + ", status_state=" + status_state + "]";
	}
	
}
