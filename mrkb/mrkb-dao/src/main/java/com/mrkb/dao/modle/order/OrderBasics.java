package com.mrkb.dao.modle.order;

public class OrderBasics {
	private Integer order_id;//订单id
	private Long order_add_date;//订单添加时间
	private Integer order_status;//订单状态
	private Long order_edit_date;//订单修改时间
	private Integer user_basics_id;//用户id
	private Integer add_user_basics_id;//添加订单的用户id
	private Integer store_id;//商品id
	private Integer store_amount;//商品数量
	private String order_addr;//订单地址
	private String store_picture;//商品图片
	private Double all_price;//订单总价
	private Integer order_type;//订单类型
	private Long payment_date;//付款时间
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Long getOrder_add_date() {
		return order_add_date;
	}
	public void setOrder_add_date(Long order_add_date) {
		this.order_add_date = order_add_date;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public Long getOrder_edit_date() {
		return order_edit_date;
	}
	public void setOrder_edit_date(Long order_edit_date) {
		this.order_edit_date = order_edit_date;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getAdd_user_basics_id() {
		return add_user_basics_id;
	}
	public void setAdd_user_basics_id(Integer add_user_basics_id) {
		this.add_user_basics_id = add_user_basics_id;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public Integer getStore_amount() {
		return store_amount;
	}
	public void setStore_amount(Integer store_amount) {
		this.store_amount = store_amount;
	}
	public String getOrder_addr() {
		return order_addr;
	}
	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}
	public String getStore_picture() {
		return store_picture;
	}
	public void setStore_picture(String store_picture) {
		this.store_picture = store_picture;
	}
	public Double getAll_price() {
		return all_price;
	}
	public void setAll_price(Double all_price) {
		this.all_price = all_price;
	}
	public Integer getOrder_type() {
		return order_type;
	}
	public void setOrder_type(Integer order_type) {
		this.order_type = order_type;
	}
	public Long getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Long payment_date) {
		this.payment_date = payment_date;
	}
	@Override
	public String toString() {
		return "OrderBasics [order_id=" + order_id + ", order_add_date="
				+ order_add_date + ", order_status=" + order_status
				+ ", order_edit_date=" + order_edit_date + ", user_basics_id="
				+ user_basics_id + ", add_user_basics_id=" + add_user_basics_id
				+ ", store_id=" + store_id + ", store_amount=" + store_amount
				+ ", order_addr=" + order_addr + ", store_picture="
				+ store_picture + ", all_price=" + all_price + ", order_type="
				+ order_type + ", payment_date=" + payment_date + "]";
	}
	

	
}
