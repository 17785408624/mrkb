package com.mrkb.dao.modle.company;

public class GoldPoolShare {
	private Integer gold_pool_share_id;//分红编号
	private Integer user_basics_id;//用户编号
	private Double share_money;//分红金额
	private String month_date;//分红月份
	private Long add_date;//添加时间
	private Integer gold_pool;//所在奖金池
	public Integer getGold_pool_share_id() {
		return gold_pool_share_id;
	}
	public void setGold_pool_share_id(Integer gold_pool_share_id) {
		this.gold_pool_share_id = gold_pool_share_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Double getShare_money() {
		return share_money;
	}
	public void setShare_money(Double share_money) {
		this.share_money = share_money;
	}
	public String getMonth_date() {
		return month_date;
	}
	public void setMonth_date(String month_date) {
		this.month_date = month_date;
	}
	public Integer getGold_pool() {
		return gold_pool;
	}
	public void setGold_pool(Integer gold_pool) {
		this.gold_pool = gold_pool;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	@Override
	public String toString() {
		return "GoldPoolShare [gold_pool_share_id=" + gold_pool_share_id
				+ ", user_basics_id=" + user_basics_id + ", share_money="
				+ share_money + ", month_date=" + month_date + ", add_date="
				+ add_date + ", gold_pool=" + gold_pool + "]";
	}
	

}
