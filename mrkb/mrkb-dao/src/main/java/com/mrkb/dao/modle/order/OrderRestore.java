package com.mrkb.dao.modle.order;

public class OrderRestore {
	private Integer restore_id;
	private Integer order_id;
	private Integer user_basics_id;
	private Long add_date;
	private Long examine_date;
	private String re_addr;
	private String re_reason;
	private String waybill_num;
	private String reason_detail;
	private Double restore_money;
	public Integer getRestore_id() {
		return restore_id;
	}
	public void setRestore_id(Integer restore_id) {
		this.restore_id = restore_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	public Long getExamine_date() {
		return examine_date;
	}
	public void setExamine_date(Long examine_date) {
		this.examine_date = examine_date;
	}
	public String getRe_addr() {
		return re_addr;
	}
	public void setRe_addr(String re_addr) {
		this.re_addr = re_addr;
	}
	public String getRe_reason() {
		return re_reason;
	}
	public void setRe_reason(String re_reason) {
		this.re_reason = re_reason;
	}
	public String getWaybill_num() {
		return waybill_num;
	}
	public void setWaybill_num(String waybill_num) {
		this.waybill_num = waybill_num;
	}
	public String getReason_detail() {
		return reason_detail;
	}
	public void setReason_detail(String reason_detail) {
		this.reason_detail = reason_detail;
	}
	public Double getRestore_money() {
		return restore_money;
	}
	public void setRestore_money(Double restore_money) {
		this.restore_money = restore_money;
	}
	@Override
	public String toString() {
		return "OrderRestore [restore_id=" + restore_id + ", order_id="
				+ order_id + ", user_basics_id=" + user_basics_id
				+ ", add_date=" + add_date + ", examine_date=" + examine_date
				+ ", re_addr=" + re_addr + ", re_reason=" + re_reason
				+ ", waybill_num=" + waybill_num + ", reason_detail="
				+ reason_detail + ", restore_money=" + restore_money + "]";
	}
	
	
	
}
