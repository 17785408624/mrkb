package com.mrkb.dao.modle.order;

public class OrderRefund {
	private Integer refund_id;
	private Integer order_id;
	private String refund_reason;
	private Double refund_money;
	private Long apply_date;
	private Long examine_date;
	private String reason_detail;
	private Integer user_basics_id;
	public Integer getRefund_id() {
		return refund_id;
	}
	public void setRefund_id(Integer refund_id) {
		this.refund_id = refund_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getRefund_reason() {
		return refund_reason;
	}
	public void setRefund_reason(String refund_reason) {
		this.refund_reason = refund_reason;
	}
	public Double getRefund_money() {
		return refund_money;
	}
	public void setRefund_money(Double refund_money) {
		this.refund_money = refund_money;
	}
	public Long getApply_date() {
		return apply_date;
	}
	public void setApply_date(Long apply_date) {
		this.apply_date = apply_date;
	}
	public Long getExamine_date() {
		return examine_date;
	}
	public void setExamine_date(Long examine_date) {
		this.examine_date = examine_date;
	}
	public String getReason_detail() {
		return reason_detail;
	}
	public void setReason_detail(String reason_detail) {
		this.reason_detail = reason_detail;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	@Override
	public String toString() {
		return "OrderRefund [refund_id=" + refund_id + ", order_id=" + order_id
				+ ", refund_reason=" + refund_reason + ", refund_money="
				+ refund_money + ", apply_date=" + apply_date
				+ ", examine_date=" + examine_date + ", reason_detail="
				+ reason_detail + ", user_basics_id=" + user_basics_id + "]";
	}

}
