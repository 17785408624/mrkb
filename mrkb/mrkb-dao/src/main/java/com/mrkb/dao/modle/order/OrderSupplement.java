package com.mrkb.dao.modle.order;

public class OrderSupplement {
	private Integer supplement_id;
	private Integer order_id;
	private String user_name;
	private String tel_phone;
	private String order_addr;
	private Long send_date;
	private String courier_services_company;//快递公司
	private String waybill_number;//运单号
	
	//订单完成时需要
	private Integer order_status;//订单状态
	public Integer getSupplement_id() {
		return supplement_id;
	}
	public void setSupplement_id(Integer supplement_id) {
		this.supplement_id = supplement_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getTel_phone() {
		return tel_phone;
	}
	public void setTel_phone(String tel_phone) {
		this.tel_phone = tel_phone;
	}
	public String getOrder_addr() {
		return order_addr;
	}
	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}
	public Long getSend_date() {
		return send_date;
	}
	public void setSend_date(Long send_date) {
		this.send_date = send_date;
	}
	public String getCourier_services_company() {
		return courier_services_company;
	}
	public void setCourier_services_company(String courier_services_company) {
		this.courier_services_company = courier_services_company;
	}
	public String getWaybill_number() {
		return waybill_number;
	}
	public void setWaybill_number(String waybill_number) {
		this.waybill_number = waybill_number;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	@Override
	public String toString() {
		return "OrderSupplement [supplement_id=" + supplement_id
				+ ", order_id=" + order_id + ", user_name=" + user_name
				+ ", tel_phone=" + tel_phone + ", order_addr=" + order_addr
				+ ", send_date=" + send_date + ", courier_services_company="
				+ courier_services_company + ", waybill_number="
				+ waybill_number + ", order_status=" + order_status + "]";
	}
	
}
