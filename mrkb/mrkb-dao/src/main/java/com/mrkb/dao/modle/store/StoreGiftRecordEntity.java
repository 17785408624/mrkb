package com.mrkb.dao.modle.store;

public class StoreGiftRecordEntity {
	private Integer gift_record_id;
	private Integer user_basics_id;
	private Integer gift_user_id;
	private Long gift_date;
	private Integer store_id;
	private String user_nickname;//用户昵称
	private String gift_user_nickname;//被赠送者昵称
	private String store_name;//课程名

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public Integer getGift_record_id() {
		return gift_record_id;
	}

	public void setGift_record_id(Integer gift_record_id) {
		this.gift_record_id = gift_record_id;
	}

	public Integer getUser_basics_id() {
		return user_basics_id;
	}

	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}

	public Integer getGift_user_id() {
		return gift_user_id;
	}

	public void setGift_user_id(Integer gift_user_id) {
		this.gift_user_id = gift_user_id;
	}

	public Long getGift_date() {
		return gift_date;
	}

	public void setGift_date(Long gift_date) {
		this.gift_date = gift_date;
	}

	public Integer getStore_id() {
		return store_id;
	}

	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getGift_user_nickname() {
		return gift_user_nickname;
	}

	public void setGift_user_nickname(String gift_user_nickname) {
		this.gift_user_nickname = gift_user_nickname;
	}

	@Override
	public String toString() {
		return "StoreGiftRecordEntity [gift_record_id=" + gift_record_id + ", user_basics_id=" + user_basics_id
				+ ", gift_user_id=" + gift_user_id + ", gift_date=" + gift_date + ", store_id=" + store_id
				+ ", user_nickname=" + user_nickname + ", gift_user_nickname=" + gift_user_nickname + ", store_name="
				+ store_name + "]";
	}
}
