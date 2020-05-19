/**
 * FileName:         AdminLoginRecord.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-6-1     下午4:36:41
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-6-1     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.system;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class AdminLoginRecordEntity {//后台登陆记录
	private Integer admin_login_record_id;//主键
	private Integer login_facility;//登陆设备（1电脑登陆）
	private Integer login_mode;//登陆方式(1账号、密码登陆)
	private String facility;//登陆设备标识
	private Integer user_basics_id;//用户id
	private Integer login_finally;//登陆结果（1：成功，2失败）
	private Long login_data;//登陆时间
	private String login_ip;//登陆ip
	public Integer getAdmin_login_record_id() {
		return admin_login_record_id;
	}
	public void setAdmin_login_record_id(Integer admin_login_record_id) {
		this.admin_login_record_id = admin_login_record_id;
	}
	public Integer getLogin_facility() {
		return login_facility;
	}
	public void setLogin_facility(Integer login_facility) {
		this.login_facility = login_facility;
	}
	public Integer getLogin_mode() {
		return login_mode;
	}
	public void setLogin_mode(Integer login_mode) {
		this.login_mode = login_mode;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getLogin_finally() {
		return login_finally;
	}
	public void setLogin_finally(Integer login_finally) {
		this.login_finally = login_finally;
	}
	public Long getLogin_data() {
		return login_data;
	}
	public void setLogin_data(Long login_data) {
		this.login_data = login_data;
	}
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	@Override
	public String toString() {
		return "AdminLoginRecordEntity [admin_login_record_id="
				+ admin_login_record_id + ", login_facility=" + login_facility
				+ ", login_mode=" + login_mode + ", facility=" + facility
				+ ", user_basics_id=" + user_basics_id + ", login_finally="
				+ login_finally + ", login_data=" + login_data + ", login_ip="
				+ login_ip + "]";
	}
	
}
