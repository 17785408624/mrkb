package com.mrkb.dao.modle.apply;

public class WithdrawalApplyEntity {//提现申请实体类
	private int withdrawal_apply_id;//数据主键
	private Integer user_basics_id;//用户id
	private Long apply_add_date;//申请时间
	private Integer edit_user_basics_id;//修改人id
	private Double apply_value;//申请金额
	private Integer apply_receipt_type;//收款方式(1:微信零钱,2用户银行卡)
	private Integer apply_receipt_supplement;//收款补充:(如银行卡信息id)
	private Integer apply_status;//申请状态（1审核中，2已通过，3已拒绝，4已删除）
	private Long apply_edit_date;//修改时间
	private Integer apply_type;//提现方式（1通过余额提现）
	private String apply_explain;//申请说明
	private String edit_notes;//修改备注
	
	private String information_compellation;//真实姓名
	public int getWithdrawal_apply_id() {
		return withdrawal_apply_id;
	}
	public void setWithdrawal_apply_id(int withdrawal_apply_id) {
		this.withdrawal_apply_id = withdrawal_apply_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Long getApply_add_date() {
		return apply_add_date;
	}
	public void setApply_add_date(Long apply_add_date) {
		this.apply_add_date = apply_add_date;
	}
	public Integer getEdit_user_basics_id() {
		return edit_user_basics_id;
	}
	public void setEdit_user_basics_id(Integer edit_user_basics_id) {
		this.edit_user_basics_id = edit_user_basics_id;
	}
	public Double getApply_value() {
		return apply_value;
	}
	public void setApply_value(Double apply_value) {
		this.apply_value = apply_value;
	}
	public Integer getApply_receipt_type() {
		return apply_receipt_type;
	}
	public void setApply_receipt_type(Integer apply_receipt_type) {
		this.apply_receipt_type = apply_receipt_type;
	}
	public Integer getApply_receipt_supplement() {
		return apply_receipt_supplement;
	}
	public void setApply_receipt_supplement(Integer apply_receipt_supplement) {
		this.apply_receipt_supplement = apply_receipt_supplement;
	}
	public Integer getApply_status() {
		return apply_status;
	}
	public void setApply_status(Integer apply_status) {
		this.apply_status = apply_status;
	}
	public Long getApply_edit_date() {
		return apply_edit_date;
	}
	public void setApply_edit_date(Long apply_edit_date) {
		this.apply_edit_date = apply_edit_date;
	}
	public Integer getApply_type() {
		return apply_type;
	}
	public void setApply_type(Integer apply_type) {
		this.apply_type = apply_type;
	}
	public String getApply_explain() {
		return apply_explain;
	}
	public void setApply_explain(String apply_explain) {
		this.apply_explain = apply_explain;
	}
	public String getEdit_notes() {
		return edit_notes;
	}
	public void setEdit_notes(String edit_notes) {
		this.edit_notes = edit_notes;
	}
	public String getInformation_compellation() {
		return information_compellation;
	}
	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}
	@Override
	public String toString() {
		return "WithdrawalApplyEntity [withdrawal_apply_id="
				+ withdrawal_apply_id + ", user_basics_id=" + user_basics_id
				+ ", apply_add_date=" + apply_add_date
				+ ", edit_user_basics_id=" + edit_user_basics_id
				+ ", apply_value=" + apply_value + ", apply_receipt_type="
				+ apply_receipt_type + ", apply_receipt_supplement="
				+ apply_receipt_supplement + ", apply_status=" + apply_status
				+ ", apply_edit_date=" + apply_edit_date + ", apply_type="
				+ apply_type + ", apply_explain=" + apply_explain
				+ ", edit_notes=" + edit_notes + ", information_compellation="
				+ information_compellation + "]";
	}

}
