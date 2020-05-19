package com.mrkb.dao.modle.invoice;

public class InvoiceEntity {
	private int invoice_id;//主键
	private Integer invoice_type;//发票类型1个人 2公司
	private String invoice_num;//税号
	private String invoice_name;//接收方名称
	private String invoice_address;//接收地址
	private String invoice_mobile;//接收方手机号
	private String invoice_openbank;//开户行
	private String invoice_banknum;//银行卡号
	private Integer user_basics_id;//提交索取信息的用户
	private Integer invoice_status;//索取信息的状态，1显示中。2默认收票信息。3删除
	private Double all_price;//总价
	private Integer order_id; //订单id
	private Integer invoice_way_type;//发票领取方式（1:自取，2邮件（货到付款））
	private String courier_services_company;//快递公司
	private String waybill_number;//运单号
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public Integer getInvoice_type() {
		return invoice_type;
	}
	public void setInvoice_type(Integer invoice_type) {
		this.invoice_type = invoice_type;
	}
	public String getInvoice_num() {
		return invoice_num;
	}
	public void setInvoice_num(String invoice_num) {
		this.invoice_num = invoice_num;
	}
	public String getInvoice_name() {
		return invoice_name;
	}
	public void setInvoice_name(String invoice_name) {
		this.invoice_name = invoice_name;
	}
	public String getInvoice_address() {
		return invoice_address;
	}
	public void setInvoice_address(String invoice_address) {
		this.invoice_address = invoice_address;
	}
	public String getInvoice_mobile() {
		return invoice_mobile;
	}
	public void setInvoice_mobile(String invoice_mobile) {
		this.invoice_mobile = invoice_mobile;
	}
	public String getInvoice_openbank() {
		return invoice_openbank;
	}
	public void setInvoice_openbank(String invoice_openbank) {
		this.invoice_openbank = invoice_openbank;
	}
	public String getInvoice_banknum() {
		return invoice_banknum;
	}
	public void setInvoice_banknum(String invoice_banknum) {
		this.invoice_banknum = invoice_banknum;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getInvoice_status() {
		return invoice_status;
	}
	public void setInvoice_status(Integer invoice_status) {
		this.invoice_status = invoice_status;
	}
	
	public Double getAll_price() {
		return all_price;
	}
	public void setAll_price(Double all_price) {
		this.all_price = all_price;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	
	public Integer getInvoice_way_type() {
		return invoice_way_type;
	}
	public void setInvoice_way_type(Integer invoice_way_type) {
		this.invoice_way_type = invoice_way_type;
	}

	public String getCourier_services_company() {
		return courier_services_company;
	}

	public String getWaybill_number() {
		return waybill_number;
	}

	public void setCourier_services_company(String courier_services_company) {
		this.courier_services_company = courier_services_company;
	}

	public void setWaybill_number(String waybill_number) {
		this.waybill_number = waybill_number;
	}

	@Override
	public String toString() {
		return "InvoiceEntity{" +
				"invoice_id=" + invoice_id +
				", invoice_type=" + invoice_type +
				", invoice_num='" + invoice_num + '\'' +
				", invoice_name='" + invoice_name + '\'' +
				", invoice_address='" + invoice_address + '\'' +
				", invoice_mobile='" + invoice_mobile + '\'' +
				", invoice_openbank='" + invoice_openbank + '\'' +
				", invoice_banknum='" + invoice_banknum + '\'' +
				", user_basics_id=" + user_basics_id +
				", invoice_status=" + invoice_status +
				", all_price=" + all_price +
				", order_id=" + order_id +
				", invoice_way_type=" + invoice_way_type +
				", courier_services_company='" + courier_services_company + '\'' +
				", waybill_number='" + waybill_number + '\'' +
				'}';
	}
}
