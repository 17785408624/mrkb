package com.mrkb.dao.modle.store;


public class UserDuty {//当班情况
	private Integer duty_id;//当班编号
	private Integer user_basics_id;//用户编号
	private Integer order_id;//订单编号
	private Integer if_duty;//是否当班(0未当班,1已当班)
	private Long add_date;//添加时间
	private Long duty_date;//当班时间
	private int source_type;//课程来源类型(1.购买课程，2.赠送课程)
	
	//商品表
	private Integer store_id;//商品编号
	private String store_name;//商品名称
	//用户
	private String information_compellation;//用户姓名
	public Integer getDuty_id() {
		return duty_id;
	}
	public void setDuty_id(Integer duty_id) {
		this.duty_id = duty_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getIf_duty() {
		return if_duty;
	}
	public void setIf_duty(Integer if_duty) {
		this.if_duty = if_duty;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	public Long getDuty_date() {
		return duty_date;
	}
	public void setDuty_date(Long duty_date) {
		this.duty_date = duty_date;
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
	
	public int getSource_type() {
		return source_type;
	}
	public void setSource_type(int source_type) {
		this.source_type = source_type;
	}

	public String getInformation_compellation() {
		return information_compellation;
	}

	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}


	@Override
	public String toString() {
		return "UserDuty{" +
				"duty_id=" + duty_id +
				", user_basics_id=" + user_basics_id +
				", order_id=" + order_id +
				", if_duty=" + if_duty +
				", add_date=" + add_date +
				", duty_date=" + duty_date +
				", source_type=" + source_type +
				", store_id=" + store_id +
				", store_name='" + store_name + '\'' +
				", information_compellation='" + information_compellation + '\'' +
				'}';
	}
}
