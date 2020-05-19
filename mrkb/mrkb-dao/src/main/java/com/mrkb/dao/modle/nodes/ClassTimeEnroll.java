package com.mrkb.dao.modle.nodes;

import java.io.Serializable;

/**
 * 课程时间节点报名表
 * @author Administrator
 *
 */
public class ClassTimeEnroll implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键ID
	 */
	private Integer enroll_id;
	
	
	/**
	 * 微信open_id
	 */
	private String wx_openid;
	
	
	
	/**
	 * 报名时间
	 */
	private Long enroll_time;
	
	
	
	/**
	 * 课程时间节点外键ID
	 */
	private Integer class_node_id;

	/**
	 * 用户ID
	 */
	private Integer user_basics_id;
	/**
	 * 商品ID
	 */
	private Integer store_id;
	/**
	 * 开课地址
	 */
	private Integer address;

	public Integer getEnroll_id() {
		return enroll_id;
	}



	public void setEnroll_id(Integer enroll_id) {
		this.enroll_id = enroll_id;
	}



	public String getWx_openid() {
		return wx_openid;
	}



	public void setWx_openid(String wx_openid) {
		this.wx_openid = wx_openid;
	}



	public Long getEnroll_time() {
		return enroll_time;
	}



	public void setEnroll_time(Long enroll_time) {
		this.enroll_time = enroll_time;
	}



	public Integer getClass_node_id() {
		return class_node_id;
	}



	public void setClass_node_id(Integer class_node_id) {
		this.class_node_id = class_node_id;
	}



	public Integer getUser_basics_id() {
		return user_basics_id;
	}

	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}

	public Integer getStore_id() {
		return store_id;
	}

	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	public Integer getAddress() {
		return address;
	}

	public void setAddress(Integer address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ClassTimeEnroll [enroll_id=" + enroll_id + ", wx_openid=" + wx_openid + ", enroll_time=" + enroll_time
				+ ", class_node_id=" + class_node_id + ", user_basics_id=" + user_basics_id + ", store_id=" + store_id
				+ ", address=" + address + "]";
	}

}
