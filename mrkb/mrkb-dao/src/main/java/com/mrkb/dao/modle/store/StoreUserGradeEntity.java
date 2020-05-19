package com.mrkb.dao.modle.store;

/**
 * 
 * @author liangyi 创建课程实体与会员等级实体 中间类 StoreUserGradeEntity table store_user_grade
 */
public class StoreUserGradeEntity {
	private Integer store_id;// 课程id
	private Integer user_grade_id;// 会员等级id

	public Integer getStore_id() {
		return store_id;
	}

	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	public Integer getUser_grade_id() {
		return user_grade_id;
	}

	public void setUser_grade_id(Integer user_grade_id) {
		this.user_grade_id = user_grade_id;
	}

	@Override
	public String toString() {
		return "StoreUserGradeEntity [store_id=" + store_id + ", user_grade_id=" + user_grade_id + "]";
	}
    
}
