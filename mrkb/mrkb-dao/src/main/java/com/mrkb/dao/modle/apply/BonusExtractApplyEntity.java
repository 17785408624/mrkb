/**
 * FileName:         BonusExtractApply.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-12     下午9:57:46
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-12     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.apply;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class BonusExtractApplyEntity {
	private Integer bonus_extract_apply_id;//主键
	private Integer user_basics_id;//申请的用户
	private Long apply_add_date;//提现申请时间
	private Long apply_edit_date;//上次修改时间
	private Integer edit_user_basics_id;//修改人id
	private Integer apply_sum;//申请金额
	private Integer apply_status;//申请状态（1：审核中，  3：已通过，6：已删除，8：已拒绝）
	private String apply_postscript;//备注
	private Long receive_bank_card;//收款账户
	private String receive_name;//收款人姓名
	private String information_compellation;//用户真实姓名
	private String information_card;//用户身份证号码
	
	public String getInformation_compellation() {
		return information_compellation;
	}
	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}
	public String getInformation_card() {
		return information_card;
	}
	public void setInformation_card(String information_card) {
		this.information_card = information_card;
	}
	public Integer getBonus_extract_apply_id() {
		return bonus_extract_apply_id;
	}
	public void setBonus_extract_apply_id(Integer bonus_extract_apply_id) {
		this.bonus_extract_apply_id = bonus_extract_apply_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Long getApply_add_date() {
		return apply_add_date;
	}
	public void setApply_add_date(Long apply_add_date) {
		this.apply_add_date = apply_add_date;
	}
	public Long getApply_edit_date() {
		return apply_edit_date;
	}
	public void setApply_edit_date(Long apply_edit_date) {
		this.apply_edit_date = apply_edit_date;
	}
	public Integer getEdit_user_basics_id() {
		return edit_user_basics_id;
	}
	public void setEdit_user_basics_id(Integer edit_user_basics_id) {
		this.edit_user_basics_id = edit_user_basics_id;
	}
	public Integer getApply_sum() {
		return apply_sum;
	}
	public void setApply_sum(Integer apply_sum) {
		this.apply_sum = apply_sum;
	}
	public Integer getApply_status() {
		return apply_status;
	}
	public void setApply_status(Integer apply_status) {
		this.apply_status = apply_status;
	}
	public String getApply_postscript() {
		return apply_postscript;
	}
	public void setApply_postscript(String apply_postscript) {
		this.apply_postscript = apply_postscript;
	}
	public Long getReceive_bank_card() {
		return receive_bank_card;
	}
	public void setReceive_bank_card(Long receive_bank_card) {
		this.receive_bank_card = receive_bank_card;
	}
	public String getReceive_name() {
		return receive_name;
	}
	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}
	@Override
	public String toString() {
		return "BonusExtractApplyEntity [bonus_extract_apply_id="
				+ bonus_extract_apply_id + ", user_basics_id=" + user_basics_id
				+ ", apply_add_date=" + apply_add_date + ", apply_edit_date="
				+ apply_edit_date + ", edit_user_basics_id="
				+ edit_user_basics_id + ", apply_sum=" + apply_sum
				+ ", apply_status=" + apply_status + ", apply_postscript="
				+ apply_postscript + ", receive_bank_card=" + receive_bank_card
				+ ", receive_name=" + receive_name
				+ ", information_compellation=" + information_compellation
				+ ", information_card=" + information_card + "]";
	}
	
	
	
	
	

}
