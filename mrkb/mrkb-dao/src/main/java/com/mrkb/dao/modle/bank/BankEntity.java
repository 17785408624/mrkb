package com.mrkb.dao.modle.bank;

public class BankEntity {//银行卡信息
	
	private Integer card_id;//银行卡编号
	private Integer user_basics_id;//用户编号
	private String bank_card;//银行卡号
	private String affiliated_bank;//所属银行
	private String tel;//预留手机号
	private Integer card_type;//卡种（0:储蓄卡，1:信用卡 ）
	private String  depositBank_info; //开户行信息
	private String  cardholder_name; //持卡人姓名
	public Integer getCard_id() {
		return card_id;
	}
	public void setCard_id(Integer card_id) {
		this.card_id = card_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getBank_card() {
		return bank_card;
	}
	public void setBank_card(String bank_card) {
		this.bank_card = bank_card;
	}
	public String getAffiliated_bank() {
		return affiliated_bank;
	}
	public void setAffiliated_bank(String affiliated_bank) {
		this.affiliated_bank = affiliated_bank;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Integer getCard_type() {
		return card_type;
	}
	public void setCard_type(Integer card_type) {
		this.card_type = card_type;
	}
	
	public String getDepositBank_info() {
		return depositBank_info;
	}
	public void setDepositBank_info(String depositBank_info) {
		this.depositBank_info = depositBank_info;
	}
	public String getCardholder_name() {
		return cardholder_name;
	}
	public void setCardholder_name(String cardholder_name) {
		this.cardholder_name = cardholder_name;
	}
	@Override
	public String toString() {
		return "BankEntity [card_id=" + card_id + ", user_basics_id="
				+ user_basics_id + ", bank_card=" + bank_card
				+ ", affiliated_bank=" + affiliated_bank + ", tel=" + tel
				+ ", card_type=" + card_type + ", depositBank_info="
				+ depositBank_info + ", cardholder_name=" + cardholder_name
				+ "]";
	}
	
}
