package com.mrkb.shiro.service;

import java.util.List;
import java.util.Map;

import com.mrkb.shiro.model.SysMenu;

public interface SysMenuService {
	
	//菜单列表
	public List<SysMenu> listMenue(Integer userid);
	
	//新增菜单
	public int addMenu(SysMenu menu);
	
	//删除菜单
	int removeMenu(Integer menuid);
	
	//修改菜单
	int updateMenu(SysMenu menu);
	
	//根据主键查询菜单
	SysMenu getmenuByid(Integer menuid);
	
	//菜单列表分页查询
	List<SysMenu> list(SysMenu param);

	//查询所有父级菜单
	List<SysMenu> creat_menuselect();
	
	//根据ID查询
	SysMenu findById(Integer menuid);
	
	//检查菜单是否已经分配权限
	boolean checkIsPermission(Integer menu_id);

	//查询树形菜单
	public List<Map<String, Object>> getMenuListTree(Integer roeid);
	
	//分配角色菜单
	int distributionRoleMeun(Map<String, Object>param);
	
	//删除角色菜单权限
	public int removePermission(Integer id);

	
	public Integer redistributionRoleMeun(Map<String, Object> param);
}
