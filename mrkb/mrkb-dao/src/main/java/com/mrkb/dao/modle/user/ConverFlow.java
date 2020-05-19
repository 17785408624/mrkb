package com.mrkb.dao.modle.user;

public class ConverFlow {
	private Integer conver_id;//卡巴积分流水记录
	private Integer user_basics_id;//用户编号
	private Integer conver_type;//流水类型(1,签到 2分享,3评论 4兑换商品)
	private Integer conver_num;//流水积分量
	private String conver_describe;//描述
	private Long conver_date;//添加时间
	private String conver_table;//对应表名
	private Integer table_id;//对应ID
	public Integer getConver_id() {
		return conver_id;
	}
	public void setConver_id(Integer conver_id) {
		this.conver_id = conver_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getConver_type() {
		return conver_type;
	}
	public void setConver_type(Integer conver_type) {
		this.conver_type = conver_type;
	}
	public Integer getConver_num() {
		return conver_num;
	}
	public void setConver_num(Integer conver_num) {
		this.conver_num = conver_num;
	}
	public String getConver_describe() {
		return conver_describe;
	}
	public void setConver_describe(String conver_describe) {
		this.conver_describe = conver_describe;
	}
	public Long getConver_date() {
		return conver_date;
	}
	public void setConver_date(Long conver_date) {
		this.conver_date = conver_date;
	}
	public String getConver_table() {
		return conver_table;
	}
	public void setConver_table(String conver_table) {
		this.conver_table = conver_table;
	}
	public Integer getTable_id() {
		return table_id;
	}
	public void setTable_id(Integer table_id) {
		this.table_id = table_id;
	}
	@Override
	public String toString() {
		return "ConverFlow [conver_id=" + conver_id + ", user_basics_id="
				+ user_basics_id + ", conver_type=" + conver_type
				+ ", conver_num=" + conver_num + ", conver_describe="
				+ conver_describe + ", conver_date=" + conver_date
				+ ", conver_table=" + conver_table + ", table_id=" + table_id
				+ "]";
	}

}
