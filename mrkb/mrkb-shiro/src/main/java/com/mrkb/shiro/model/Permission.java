package com.mrkb.shiro.model;

import java.util.Date;

/**
 *权限
 * @author Administrator
 * @since 1.0.0
 */
public class Permission {

	//主键ID
    private Integer id;
    
    //权限编码
    private String code;
    
    //url地址
    private String url;
    
    //权限名称
    private String name;
    
    //菜单ID
    private Integer menu_id;
    
    //创建时间
    private Date create_time;

    //菜单名称
    private String menu_name;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = new Date();
	}
	
	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	
	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", code=" + code + ", url=" + url + ", name=" + name + ", menu_id=" + menu_id
				+ ", create_time=" + create_time + "]";
	}

	
}