package com.mrkb.dao.modle.pagestructure;

import java.util.List;

public class MenuEntity {
	private Integer menu_id;//数据主键
	private Integer menu_superior_id=0;//上级菜单id
	private Integer menu_priority;//显示优先级
	private Integer menu_code_num;//权限数字code  1后台菜单栏2pc菜单栏 3微信端菜单栏 app端菜单栏
	private String menu_style;//菜单样式类型
	private String menu_name;//菜单名字
	private Integer menu_nature;//菜单性质 （如左侧菜单栏，顶部菜单栏）
	private String menu_url;//菜单url链接
	private Integer menu_series;//菜单级数
	private Integer privilege_id;//对应权限id
	private List<MenuEntity> listMenu_subordinate;//下级菜单
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public Integer getMenu_superior_id() {
		return menu_superior_id;
	}
	public void setMenu_superior_id(Integer menu_superior_id) {
		this.menu_superior_id = menu_superior_id;
	}
	public Integer getMenu_priority() {
		return menu_priority;
	}
	public void setMenu_priority(Integer menu_priority) {
		this.menu_priority = menu_priority;
	}
	public Integer getMenu_code_num() {
		return menu_code_num;
	}
	public void setMenu_code_num(Integer menu_code_num) {
		this.menu_code_num = menu_code_num;
	}
	public String getMenu_style() {
		return menu_style;
	}
	public void setMenu_style(String menu_style) {
		this.menu_style = menu_style;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public Integer getMenu_nature() {
		return menu_nature;
	}
	public void setMenu_nature(Integer menu_nature) {
		this.menu_nature = menu_nature;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	public Integer getMenu_series() {
		return menu_series;
	}
	public void setMenu_series(Integer menu_series) {
		this.menu_series = menu_series;
	}
	public Integer getPrivilege_id() {
		return privilege_id;
	}
	public void setPrivilege_id(Integer privilege_id) {
		this.privilege_id = privilege_id;
	}
	public List<MenuEntity> getListMenu_subordinate() {
		return listMenu_subordinate;
	}
	public void setListMenu_subordinate(List<MenuEntity> listMenu_subordinate) {
		this.listMenu_subordinate = listMenu_subordinate;
	}
	@Override
	public String toString() {
		return "MenuEntity [menu_id=" + menu_id + ", menu_superior_id="
				+ menu_superior_id + ", menu_priority=" + menu_priority
				+ ", menu_code_num=" + menu_code_num + ", menu_style="
				+ menu_style + ", menu_name=" + menu_name + ", menu_nature="
				+ menu_nature + ", menu_url=" + menu_url + ", menu_series="
				+ menu_series + ", privilege_id=" + privilege_id
				+ ", listMenu_subordinate=" + listMenu_subordinate + "]";
	}
	
	
}
