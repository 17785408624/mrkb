/**
 * FileName:         PageStructureEntity.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-3-19     下午3:29:39
 * Copyright:        Copyright(C) 2016-2017 陈世洲
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-3-19     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.system;

/**
 *@param
 *@return
 * @author moerka-1
 *菜单栏数据实体类
 */
public class PageStructureEntity {
	private Integer pagestructure_id;//主键
	private String page_name;//菜单名字
	private String page_superior_id;//上级菜单id
	private String page_priority;//显示优先级
	private String page_code_num;//权限数字code 1后台页面 2pc页面 3微信端页面 app端页面
	private String page_tier;//页面层数
	public Integer getPagestructure_id() {
		return pagestructure_id;
	}
	public void setPagestructure_id(Integer pagestructure_id) {
		this.pagestructure_id = pagestructure_id;
	}
	public String getPage_name() {
		return page_name;
	}
	public void setPage_name(String page_name) {
		this.page_name = page_name;
	}
	public String getPage_superior_id() {
		return page_superior_id;
	}
	public void setPage_superior_id(String page_superior_id) {
		this.page_superior_id = page_superior_id;
	}
	public String getPage_priority() {
		return page_priority;
	}
	public void setPage_priority(String page_priority) {
		this.page_priority = page_priority;
	}
	public String getPage_code_num() {
		return page_code_num;
	}
	public void setPage_code_num(String page_code_num) {
		this.page_code_num = page_code_num;
	}
	public String getPage_tier() {
		return page_tier;
	}
	public void setPage_tier(String page_tier) {
		this.page_tier = page_tier;
	}
	@Override
	public String toString() {
		return "PageStructureEntity [pagestructure_id=" + pagestructure_id
				+ ", page_name=" + page_name + ", page_superior_id="
				+ page_superior_id + ", page_priority=" + page_priority
				+ ", page_code_num=" + page_code_num + ", page_tier="
				+ page_tier + "]";
	}
	

}
