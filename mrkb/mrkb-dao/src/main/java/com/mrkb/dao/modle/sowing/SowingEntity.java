/**
 * FileName:         SowingEntity.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-14     上午10:05:44
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-14     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.sowing;


/**
 *@param
 *@return
 * @author liangyi
 *
 */
public class SowingEntity {
	
	private Integer sowing_id;//轮播图id
	private Integer  type_id; //类型id
	private Integer user_basic_id;//添加人id 
	private String sowing_title;//轮播图标题
	private Integer sowing_mode;//轮播图类型(1.首页，2.商城，3.定制)
	private Integer sowing_type;//轮播图所属类型(1.商品，2.知识动态,3广告)
	private Integer sort;//轮播图顺序
	private Integer  status_state;//审核状态(0.通过，1.待审核，2拒绝，3.删除)
	private Long   add_date;//添加日期 
	private String  sowing_picture;//轮播图图片
	private String  url;//路径(点击轮播图跳转至详情信息)
	private String  sowing_content;//轮播图内容
	
	public Integer getSowing_id() {
		return sowing_id;
	}
	public void setSowing_id(Integer sowing_id) {
		this.sowing_id = sowing_id;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public Integer getUser_basic_id() {
		return user_basic_id;
	}
	public void setUser_basic_id(Integer user_basic_id) {
		this.user_basic_id = user_basic_id;
	}
	public String getSowing_title() {
		return sowing_title;
	}
	public void setSowing_title(String sowing_title) {
		this.sowing_title = sowing_title;
	}
	public Integer getSowing_mode() {
		return sowing_mode;
	}
	public void setSowing_mode(Integer sowing_mode) {
		this.sowing_mode = sowing_mode;
	}
	public Integer getSowing_type() {
		return sowing_type;
	}
	public void setSowing_type(Integer sowing_type) {
		this.sowing_type = sowing_type;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
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
	public String getSowing_picture() {
		return sowing_picture;
	}
	public void setSowing_picture(String sowing_picture) {
		this.sowing_picture = sowing_picture;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getSowing_content() {
		return sowing_content;
	}
	public void setSowing_content(String sowing_content) {
		this.sowing_content = sowing_content;
	}
	@Override
	public String toString() {
		return "SowingEntity [sowing_id=" + sowing_id + ", type_id=" + type_id
				+ ", user_basic_id=" + user_basic_id + ", sowing_title="
				+ sowing_title + ", sowing_mode=" + sowing_mode
				+ ", sowing_type=" + sowing_type + ", sort=" + sort
				+ ", status_state=" + status_state + ", add_date=" + add_date
				+ ", sowing_picture=" + sowing_picture + ", url=" + url
				+ ", sowing_content=" + sowing_content + "]";
	}
	
	
	
}
