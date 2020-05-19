package com.mrkb.dao.modle.stock;

import java.io.Serializable;

public class StoreStock implements Serializable{

	 /**  
	  * @Fields serialVersionUID :            TODO
	  */ 
	
	private static final long serialVersionUID = 1L;
	private Integer stock_id;//入库编号
	//货品物编号
	private Integer goods_id;
	//入存数量
	private Integer store_num;
	//入库时间
	private Integer user_basics_id;//入库人
	private Long add_date;//入库时间
	public Integer getStock_id() {
		return stock_id;
	}
	public void setStock_id(Integer stock_id) {
		this.stock_id = stock_id;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getStore_num() {
		return store_num;
	}
	public void setStore_num(Integer store_num) {
		this.store_num = store_num;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "StoreStock [stock_id=" + stock_id + ", goods_id=" + goods_id
				+ ", store_num=" + store_num + ", user_basics_id="
				+ user_basics_id + ", add_date=" + add_date + "]";
	}

}
