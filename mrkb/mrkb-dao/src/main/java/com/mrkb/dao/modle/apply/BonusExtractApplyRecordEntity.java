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
 * @description excel导出记录表实体类
 *@param
 *@return 
 * @author liangyi
 *
 */

public class BonusExtractApplyRecordEntity {
	private Integer bonus_extract_apply_record_id;//excel导出记录表id(提现申请)
	private Integer user_basics_id;//申请的用户
	private Long excel_date;//导出时间
	private String excel_name;//导出文件名
	private String excel_url;//excel导出路径
	public Integer getBonus_extract_apply_record_id() {
		return bonus_extract_apply_record_id;
	}
	public void setBonus_extract_apply_record_id(
			Integer bonus_extract_apply_record_id) {
		this.bonus_extract_apply_record_id = bonus_extract_apply_record_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Long getExcel_date() {
		return excel_date;
	}
	public void setExcel_date(Long excel_date) {
		this.excel_date = excel_date;
	}
	public String getExcel_name() {
		return excel_name;
	}
	public void setExcel_name(String excel_name) {
		this.excel_name = excel_name;
	}
	public String getExcel_url() {
		return excel_url;
	}
	public void setExcel_url(String excel_url) {
		this.excel_url = excel_url;
	}
	@Override
	public String toString() {
		return "BonusExtractApplyRecordEntity [bonus_extract_apply_record_id="
				+ bonus_extract_apply_record_id + ", user_basics_id="
				+ user_basics_id + ", excel_date=" + excel_date
				+ ", excel_name=" + excel_name + ", excel_url=" + excel_url
				+ "]";
	}

	
	
	
	
	
	
	

}
