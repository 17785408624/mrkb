package com.mrkb.dao.modle.invoice;

public class InvoiceGainEntity {
	private int invoice_gain_id;//主键
	private Integer gain_status;//索取信息的状态，1显示中。2 已寄出。3删除
	private Long add_date;//提交索取发票信息的时间
	private Long edit_date;//修改时间
	private Integer edit_user_id;//修改人id
	private Integer invoice_id;//发票收取信息id

	public int getInvoice_gain_id() {
		return invoice_gain_id;
	}
	public void setInvoice_gain_id(int invoice_gain_id) {
		this.invoice_gain_id = invoice_gain_id;
	}
	public Integer getGain_status() {
		return gain_status;
	}
	public void setGain_status(Integer gain_status) {
		this.gain_status = gain_status;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	public Long getEdit_date() {
		return edit_date;
	}
	public void setEdit_date(Long edit_date) {
		this.edit_date = edit_date;
	}
	public Integer getEdit_user_id() {
		return edit_user_id;
	}
	public void setEdit_user_id(Integer edit_user_id) {
		this.edit_user_id = edit_user_id;
	}
	public Integer getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(Integer invoice_id) {
		this.invoice_id = invoice_id;
	}

	@Override
	public String toString() {
		return "InvoiceGainEntity{" +
				"invoice_gain_id=" + invoice_gain_id +
				", gain_status=" + gain_status +
				", add_date=" + add_date +
				", edit_date=" + edit_date +
				", edit_user_id=" + edit_user_id +
				", invoice_id=" + invoice_id +
				'}';
	}
}
