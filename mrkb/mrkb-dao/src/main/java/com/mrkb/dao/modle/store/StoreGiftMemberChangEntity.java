package com.mrkb.dao.modle.store;
/**
 * 赠送课程名额变更实体
 * @author ly
 *
 */
public class StoreGiftMemberChangEntity {
	private Integer gift_member_id;//赠送课程名额变更表编号id
	private Integer user_basics_id;//赠送者编号id
	private Integer gift_id;//套餐赠送内容编号id
	private Integer surplus_num;//赠送课程剩余名额
	private Integer send_num;//已赠送课程名额
	private Integer store_id;//课程编号id
	private Long add_date;//赠送名额变更新增日期
	private Long update_date;//赠送名额变更修改日期
	public Integer getGift_member_id() {
		return gift_member_id;
	}
	public void setGift_member_id(Integer gift_member_id) {
		this.gift_member_id = gift_member_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getGift_id() {
		return gift_id;
	}
	public void setGift_id(Integer gift_id) {
		this.gift_id = gift_id;
	}
	public Integer getSurplus_num() {
		return surplus_num;
	}
	public void setSurplus_num(Integer surplus_num) {
		this.surplus_num = surplus_num;
	}
	public Integer getSend_num() {
		return send_num;
	}
	public void setSend_num(Integer send_num) {
		this.send_num = send_num;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	public Long getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Long update_date) {
		this.update_date = update_date;
	}
	@Override
	public String toString() {
		return "StoreGiftMemberChangEntity [gift_member_id=" + gift_member_id + ", user_basics_id=" + user_basics_id
				+ ", gift_id=" + gift_id + ", surplus_num=" + surplus_num + ", send_num=" + send_num + ", store_id="
				+ store_id + ", add_date=" + add_date + ", update_date=" + update_date + "]";
	}
	

}
