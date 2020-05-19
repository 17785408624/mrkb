package com.mrkb.dao.modle.order;

public class OrderAddr {
	private Integer address_id;
	private Integer user_basics_id;
	private String tel_phone;
	private String user_name;
	private String order_addr;
	private String addr_head;
	private Integer priority_level;
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getTel_phone() {
		return tel_phone;
	}
	public void setTel_phone(String tel_phone) {
		this.tel_phone = tel_phone;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getOrder_addr() {
		return order_addr;
	}
	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}
	public String getAddr_head() {
		return addr_head;
	}
	public void setAddr_head(String addr_head) {
		this.addr_head = addr_head;
	}
	public Integer getPriority_level() {
		return priority_level;
	}
	public void setPriority_level(Integer priority_level) {
		this.priority_level = priority_level;
	}
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	@Override
	public String toString() {
		return "OrderAddr [address_id=" + address_id + ", user_basics_id="
				+ user_basics_id + ", tel_phone=" + tel_phone + ", user_name="
				+ user_name + ", order_addr=" + order_addr + ", addr_head="
				+ addr_head + ", priority_level=" + priority_level + "]";
	}
	
	


	
}
