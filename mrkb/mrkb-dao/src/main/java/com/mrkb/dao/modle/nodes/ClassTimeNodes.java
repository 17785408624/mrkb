package com.mrkb.dao.modle.nodes;

import java.io.Serializable;

/**
 * 课程时间节点
 * @author Administrator
 *
 */
public class ClassTimeNodes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//主键ID
	private Integer class_node_id;
	
	//课程开始时间
	private Long class_beagain_time;
	
	//截止报名时间
	private Long enroll_end_time;
	
	///课程信息外检
	private Integer store_id;
	
	//开课地址
	private String address;
	
	//开课次数（单位届）
	private Integer times;
	
	//创建时间
	private Long creat_time;

	//上课人数
	private Integer person_num;
	
	//课程名称
	private String store_name;
	
	//导师姓名
	private String tutor_name;
	
	//复训名额
	private Integer retraining_num;
	
	//复训价格
	private Double retraining_price;
	
	public Integer getClass_node_id() {
		return class_node_id;
	}

	public void setClass_node_id(Integer class_node_id) {
		this.class_node_id = class_node_id;
	}

	public Long getClass_beagain_time() {
		return class_beagain_time;
	}

	public void setClass_beagain_time(Long class_beagain_time) {
		this.class_beagain_time = class_beagain_time;
	}

	public Long getEnroll_end_time() {
		return enroll_end_time;
	}

	public void setEnroll_end_time(Long enroll_end_time) {
		this.enroll_end_time = enroll_end_time;
	}

	public Integer getStore_id() {
		return store_id;
	}

	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Long getCreat_time() {
		return System.currentTimeMillis();
	}

	public void setCreat_time(Long creat_time) {
		this.creat_time = creat_time;
	}

	
	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	
	

	public String getTutor_name() {
		return tutor_name;
	}

	public void setTutor_name(String tutor_name) {
		this.tutor_name = tutor_name;
	}

	
	public Integer getPerson_num() {
		return person_num;
	}

	public void setPerson_num(Integer person_num) {
		this.person_num = person_num;
	}

	public Integer getRetraining_num() {
		return retraining_num;
	}

	public void setRetraining_num(Integer retraining_num) {
		this.retraining_num = retraining_num;
	}

	public Double getRetraining_price() {
		return retraining_price;
	}

	public void setRetraining_price(Double retraining_price) {
		this.retraining_price = retraining_price;
	}

	@Override
	public String toString() {
		return "ClassTimeNodes [class_node_id=" + class_node_id + ", class_beagain_time=" + class_beagain_time
				+ ", enroll_end_time=" + enroll_end_time + ", store_id=" + store_id + ", address=" + address
				+ ", times=" + times + ", creat_time=" + creat_time + ", person_num=" + person_num + ", store_name="
				+ store_name + ", tutor_name=" + tutor_name + ", retraining_num=" + retraining_num
				+ ", retraining_price=" + retraining_price + "]";
	}

	
	
	
}
