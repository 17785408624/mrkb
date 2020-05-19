package com.mrkb.dao.modle.sale;

public class UserSale {
	private String table_name;//表名
	private Integer user_sale_id;//销售编号
	private Integer user_basics_id;//用户编号
	private Integer sale_date;//销售时间精确到日
	private Double sale_volume0=0.00;//自己购买
	private Double sale_volume1=0.00;//第1代销售
	private Double sale_volume2=0.00;//第2代销售
	private Double sale_volume3=0.00;//第3代销售
	private Double sale_money=0.00;//销售总金额
	
	private String information_compellation;//真实姓名
	private String weixin_nickname;//微信昵称
	
	//sql查询条件
	private String begain_date;
	private String end_date;
	
	public Integer getUser_sale_id() {
		return user_sale_id;
	}
	public void setUser_sale_id(Integer user_sale_id) {
		this.user_sale_id = user_sale_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getSale_date() {
		return sale_date;
	}
	public void setSale_date(Integer sale_date) {
		this.sale_date = sale_date;
	}
	public Double getSale_volume0() {
		return sale_volume0;
	}
	public void setSale_volume0(Double sale_volume0) {
		this.sale_volume0 = sale_volume0;
	}
	public Double getSale_volume1() {
		return sale_volume1;
	}
	public void setSale_volume1(Double sale_volume1) {
		this.sale_volume1 = sale_volume1;
	}
	public Double getSale_volume2() {
		return sale_volume2;
	}
	public void setSale_volume2(Double sale_volume2) {
		this.sale_volume2 = sale_volume2;
	}
	public Double getSale_volume3() {
		return sale_volume3;
	}
	public void setSale_volume3(Double sale_volume3) {
		this.sale_volume3 = sale_volume3;
	}
	public Double getSale_money() {
		return sale_money;
	}
	public void setSale_money(Double sale_money) {
		this.sale_money = sale_money;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getInformation_compellation() {
		return information_compellation;
	}
	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}
	public String getWeixin_nickname() {
		return weixin_nickname;
	}
	public void setWeixin_nickname(String weixin_nickname) {
		this.weixin_nickname = weixin_nickname;
	}
	
	public String getBegain_date() {
		return begain_date;
	}
	public void setBegain_date(String begain_date) {
		this.begain_date = begain_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	@Override
	public String toString() {
		return "UserSale [table_name=" + table_name + ", user_sale_id="
				+ user_sale_id + ", user_basics_id=" + user_basics_id
				+ ", sale_date=" + sale_date + ", sale_volume0=" + sale_volume0
				+ ", sale_volume1=" + sale_volume1 + ", sale_volume2="
				+ sale_volume2 + ", sale_volume3=" + sale_volume3
				+ ", sale_money=" + sale_money + "]";
	}
	

}
