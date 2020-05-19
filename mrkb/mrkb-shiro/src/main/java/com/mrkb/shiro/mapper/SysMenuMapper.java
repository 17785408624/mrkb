package com.mrkb.shiro.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.common.util.BaseDao;
import com.mrkb.shiro.model.SysMenu;

@Mapper
public interface SysMenuMapper extends BaseDao{
	
	//父级菜单
	public List<SysMenu> listMenue_parent(Integer userid) throws Exception;
	//子菜单
	public List<SysMenu> listMenue_son(Map<String, Object>param)throws Exception;
	//查询所有父级菜单，下拉框选择菜单使用
	public List<SysMenu> creat_menuselect()throws Exception;
	//检查菜单是否被分配权限
	public int checkIsPermission(Integer menu_id)throws Exception;
	//查询树形菜单父级
	public List<Map<String, Object>> getMenuParentTree()throws Exception;
	//查询树形菜单子菜单
	public List<Map<String, Object>>getMenuParentTreeNodes(Map<String, Object>param)throws Exception;
	//检查是否是父级菜单
	public SysMenu isparentmenu(Integer menuid);
	//根据子菜单获取父级菜单信息
	public SysMenu getParentByMenuId(Integer menuid);

}
