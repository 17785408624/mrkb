package com.mrkb.shiro.model;

import java.util.List;

public class SysMenu {
	//主键ID
	private Integer id;
	//排序编号
	private Integer sn;
	//菜单名称
	private String name;
	//菜单图标
	private String icon;
	//菜单地址
	private String url;
	//菜单介绍
	private String intro;
	//父级菜单ID
	private Integer parent_id;
	//子菜单
	private List<SysMenu> menuelist;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSn() {
		return sn;
	}
	public void setSn(Integer sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public List<SysMenu> getMenuelist() {
		return menuelist;
	}
	public void setMenuelist(List<SysMenu> menuelist) {
		this.menuelist = menuelist;
	}
	
}
