package com.mrkb.dao.modle.stock;

import java.io.Serializable;

public class GoodsStock implements Serializable{

	 /**  
	  * @Fields serialVersionUID :            TODO
	  */ 
	
	private static final long serialVersionUID = 1L;
	
	//货品物编号
	private Integer goods_id;
	//货物库存数量
	private Integer goods_num;
	//货物名称
	private String goods_name;
	//添加时间
	private Long add_date;
	//审核状态(0通过，1待审核，2拒绝，3删除)
	private Integer status_state;
	private Integer user_basics_id;//添加人
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(Integer goods_num) {
		this.goods_num = goods_num;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	public Integer getStatus_state() {
		return status_state;
	}
	public void setStatus_state(Integer status_state) {
		this.status_state = status_state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	@Override
	public String toString() {
		return "GoodsStock [goods_id=" + goods_id + ", goods_num=" + goods_num
				+ ", goods_name=" + goods_name + ", add_date=" + add_date
				+ ", status_state=" + status_state + ", user_basics_id="
				+ user_basics_id + "]";
	}
	
	

}
