package com.mrkb.dao.modle.bankManage;


public class BankManageEntity {//银行卡信息
	
	private Integer bank_id;//银行id
	private String	area;//银行所在区域
	private String bank_name;//银行名称
	private Integer bank_type;//银行卡种类型(1.储蓄卡，2信用卡)
	private String limit_money;//限额
	private Integer user_basics_id;//添加用户id
	private Long add_date;//添加日期
	private Integer status_state;//审核状态(0.通过，1.待审核，2拒绝，3.删除)
	private Long examine_date;//审核日期
	public Integer getBank_id() {
		return bank_id;
	}
	public void setBank_id(Integer bank_id) {
		this.bank_id = bank_id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public Integer getBank_type() {
		return bank_type;
	}
	public void setBank_type(Integer bank_type) {
		this.bank_type = bank_type;
	}
	public String getLimit_money() {
		return limit_money;
	}
	public void setLimit_money(String limit_money) {
		this.limit_money = limit_money;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	
	public Integer getStatus_state() {
		return status_state;
	}
	public void setStatus_state(Integer status_state) {
		this.status_state = status_state;
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
	@Override
	public String toString() {
		return "BankManageEntity [bank_id=" + bank_id + ", area=" + area
				+ ", bank_name=" + bank_name + ", bank_type=" + bank_type
				+ ", limit_money=" + limit_money + ", user_basics_id="
				+ user_basics_id + ", add_date=" + add_date + ", status_state="
				+ status_state + ", examine_date=" + examine_date + "]";
	}
	

	
	
	
	
	
}
