package com.mrkb.dao.modle.store;

public class StoreGift {
	private Integer gift_id;//赠品编号
	private Integer store_id;//套餐编号
	private String gift_name;//赠品名称
	private String store_ids;//赠品包含的课程
	private Integer ids_num;//可赠送数量
	public Integer getGift_id() {
		return gift_id;
	}
	public void setGift_id(Integer gift_id) {
		this.gift_id = gift_id;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public String getGift_name() {
		return gift_name;
	}
	public void setGift_name(String gift_name) {
		this.gift_name = gift_name;
	}
	public String getStore_ids() {
		return store_ids;
	}
	public void setStore_ids(String store_ids) {
		this.store_ids = store_ids;
	}
	public Integer getIds_num() {
		return ids_num;
	}
	public void setIds_num(Integer ids_num) {
		this.ids_num = ids_num;
	}
	@Override
	public String toString() {
		return "StoreGift [gift_id=" + gift_id + ", store_id=" + store_id + ", gift_name=" + gift_name + ", store_ids="
				+ store_ids + ", ids_num=" + ids_num + "]";
	}

}
