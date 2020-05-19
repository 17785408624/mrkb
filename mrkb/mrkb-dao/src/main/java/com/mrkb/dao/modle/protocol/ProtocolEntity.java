/**
 * FileName:         BonusEntity.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-8     下午10:23:51
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-8     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.protocol;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class ProtocolEntity {
	private Integer protocol_id;//协议ID
	private Integer protocol_type;//协议类型
	private String protocol_title;//协议标题
	private String protocol_content;//协议内容
	private Integer status_state;//协议状态（预留字段）
	private Long    add_date;//协议生成日期
	private Long  update_date;//协议修改日期
	public Integer getProtocol_id() {
		return protocol_id;
	}
	public void setProtocol_id(Integer protocol_id) {
		this.protocol_id = protocol_id;
	}
	public Integer getProtocol_type() {
		return protocol_type;
	}
	public void setProtocol_type(Integer protocol_type) {
		this.protocol_type = protocol_type;
	}
	public String getProtocol_title() {
		return protocol_title;
	}
	public void setProtocol_title(String protocol_title) {
		this.protocol_title = protocol_title;
	}
	public String getProtocol_content() {
		return protocol_content;
	}
	public void setProtocol_content(String protocol_content) {
		this.protocol_content = protocol_content;
	}
	public Integer getStatus_state() {
		return status_state;
	}
	public void setStatus_state(Integer status_state) {
		this.status_state = status_state;
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
		return "ProtocolEntity [protocol_id=" + protocol_id + ", protocol_type=" + protocol_type + ", protocol_title="
				+ protocol_title + ", protocol_content=" + protocol_content + ", status_state=" + status_state
				+ ", add_date=" + add_date + ", update_date=" + update_date + "]";
	}
	
	
}