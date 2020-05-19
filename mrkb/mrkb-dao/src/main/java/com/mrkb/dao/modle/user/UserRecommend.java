package com.mrkb.dao.modle.user;

public class UserRecommend {//用户推荐信息
	 private Integer recommend_id;//自增唯一标识
	 private Integer recommend_superior;//推荐人id
	 private Integer recommend_type;//推荐方式 (1:微信推荐)
	 private Integer user_basics_id;//用户id
	public Integer getRecommend_id() {
		return recommend_id;
	}
	public void setRecommend_id(Integer recommend_id) {
		this.recommend_id = recommend_id;
	}
	public Integer getRecommend_superior() {
		return recommend_superior;
	}
	public void setRecommend_superior(Integer recommend_superior) {
		this.recommend_superior = recommend_superior;
	}
	public Integer getRecommend_type() {
		return recommend_type;
	}
	public void setRecommend_type(Integer recommend_type) {
		this.recommend_type = recommend_type;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	@Override
	public String toString() {
		return "UserRecommend [recommend_id=" + recommend_id
				+ ", recommend_superior=" + recommend_superior
				+ ", recommend_type=" + recommend_type + ", user_basics_id="
				+ user_basics_id + "]";
	}
	 
}
