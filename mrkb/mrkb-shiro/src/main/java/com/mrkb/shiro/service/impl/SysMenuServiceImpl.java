package com.mrkb.shiro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrkb.common.util.Pingyin;
import com.mrkb.shiro.mapper.ShiroUserPermissionMapper;
import com.mrkb.shiro.mapper.ShiroUserRoleMapper;
import com.mrkb.shiro.mapper.SysMenuMapper;
import com.mrkb.shiro.model.Permission;
import com.mrkb.shiro.model.SysMenu;
import com.mrkb.shiro.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	/**
	 * 菜单
	 */
	@Autowired
	private SysMenuMapper menuMapper;
	
	/**
	 * 权限
	 */
	@Autowired
	private ShiroUserPermissionMapper permissionMapper;
	
	/**
	 * 角色
	 */
	@Autowired
	private ShiroUserRoleMapper roleMapper;
	
	
	//得到log对象 操作日志 可以通过log去打印日志信息
    private static final transient Logger log = LoggerFactory.getLogger(SysMenuServiceImpl.class);
    
    
	
	/**
	 * 查询菜单列表
	 */
	public List<SysMenu> listMenue(Integer userid) {
		///查询父级菜单
		List<SysMenu> list = new ArrayList<SysMenu>();
		try {
			list = menuMapper.listMenue_parent(userid);
			//查询子菜单
			List<SysMenu> nodelist = new ArrayList<SysMenu>();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("userid", userid);
			for(int i=0;i<list.size();i++){
				param.put("parent_id", list.get(i).getId());
				nodelist = menuMapper.listMenue_son(param);
				list.get(i).setMenuelist(nodelist);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("查询菜单列表异常");
			return null;
		}
		return list;
	}


	

	/**
	 * 新增菜单
	 */
	public int addMenu(SysMenu menu) {
		Integer num=0;
		try {
			num = menuMapper.insert(menu);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("新增菜单列表异常");
			return 0;
		}
		return num;
	}



	
	/**
	 * 删除菜单
	 */
	public int removeMenu(Integer menuid) {
		Integer num=0;
		try {
			num = menuMapper.delete(menuid);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("删除菜单列表异常");
			return 0;
		}
		return num;
	}



	/**
	 * 修改菜单
	 */
	public int updateMenu(SysMenu menu) {
		Integer num=0;
		try {
			num = menuMapper.update(menu);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("修改菜单列表异常");
			return 0;
		}
		return num;
	}



	/**
	 * 根据ID查询菜单
	 */
	public SysMenu getmenuByid(Integer menuid) {
		SysMenu menu = new SysMenu();
		try {
			menu = (SysMenu) menuMapper.get(menuid);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("查询菜单列表异常");
			return null;
		}
		return menu;
	}




	
	/**
	 * 菜单列表分页查询
	 */
	public List<SysMenu> list(SysMenu param) {
		List<SysMenu> list = new ArrayList<SysMenu>();
		try {
			list = menuMapper.pageList(param);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("查询菜单列表异常");
			return null;
		}
		return list;
	}




	/**
	 * 查询所有父级菜单
	 */
	public List<SysMenu> creat_menuselect() {
		List<SysMenu> list = new ArrayList<SysMenu>();
		try {
			list = menuMapper.creat_menuselect();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("菜单下拉框查询失败");
			return null;
		}
		return list;
	}




	/**
	 * 根据ID查询
	 */
	public SysMenu findById(Integer menuid) {
		SysMenu menu = new SysMenu();
		try {
			menu = (SysMenu) menuMapper.get(menuid);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("根据主键查询菜单异常");
			return null;
		}
		return menu;
	}




	/**
	 * 检查菜单是否已经分配过权限
	 */
	public boolean checkIsPermission(Integer menu_id) {
		boolean isChecked=false;
		try {
			Integer num = menuMapper.checkIsPermission(menu_id);
			if(num>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("删除菜单检查权限异常");
		}
		return false;
	}




	/**
	 * 查询树形菜单
	 */
	public List<Map<String, Object>> getMenuListTree(Integer roeid) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>>reslutlist = new ArrayList<Map<String,Object>>();
		Map<String, Object>param = new HashMap<String, Object>();
		param.put("role_id", roeid);
		try {
			list=menuMapper.getMenuParentTree();
			for(Map<String, Object>pram :list){
				param.put("parent_id", Integer.parseInt(pram.get("value").toString()));
				Map<String, Object>R = new HashMap<String, Object>();
				List<Map<String, Object>>node_list= menuMapper.getMenuParentTreeNodes(param);
				R.put("value", pram.get("value"));
				R.put("title", pram.get("title"));
				R.put("disabled",true);
				R.put("data", node_list);
				reslutlist.add(R);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("查询树形菜单异常");
		}
		return reslutlist;
	}



	/**
	 * 分配角色菜单
	 */
	public int distributionRoleMeun(Map<String, Object> param) {
		int num=0;
		//查询是否是父级菜单
		SysMenu isprent = menuMapper.isparentmenu(Integer.parseInt(param.get("menu_id").toString()));
		if(isprent != null){
			//如果是父级菜单，查询父级菜单权限表是否存在
			List<Map<String, Object>>checkpermission = new ArrayList<Map<String,Object>>();
			checkpermission = permissionMapper.findRolePermissionByMenuid(Integer.parseInt(param.get("menu_id").toString()));
			if(checkpermission.size()>0){
				//如果角色权限已经分配则删除已分配的权限
				this.removePermission(Integer.parseInt(param.get("menu_id").toString()));
				num=1;
			}else{
				Permission permisison = new Permission();
				permisison.setCode("menu:"+Pingyin.getAllFirstLetter(param.get("name").toString()));
				permisison.setCreate_time(new Date());
				permisison.setMenu_id(Integer.parseInt(param.get("menu_id").toString()));
				permisison.setName(param.get("name").toString());
				num = permissionMapper.insert(permisison);
				int permission_id=permisison.getId();
				if(num>0){
					//新增角色菜单
					Map<String, Object> sysRolePermission = new HashMap<String, Object>();
					sysRolePermission.put("role_id", param.get("role_id"));
					sysRolePermission.put("permission_id", permission_id);
					sysRolePermission.put("create_time", new Date());
					num=permissionMapper.insertRolePermission(sysRolePermission);
				}else{
					return 0;
				}
			}
		}else{
			//新增子菜单角色权限表
			Permission permisison = new Permission();
			permisison.setCode("menu:"+Pingyin.getAllFirstLetter(param.get("name").toString()));
			permisison.setCreate_time(new Date());
			permisison.setMenu_id(Integer.parseInt(param.get("menu_id").toString()));
			permisison.setName(param.get("name").toString());
			num = permissionMapper.insert(permisison);
			int permission_id=permisison.getId();
			if(num>0){
				//新增角色菜单
				Map<String, Object> sysRolePermission = new HashMap<String, Object>();
				sysRolePermission.put("role_id", param.get("role_id"));
				sysRolePermission.put("permission_id", permission_id);
				sysRolePermission.put("create_time", new Date());
				num=permissionMapper.insertRolePermission(sysRolePermission);
			}else{
				return 0;
			}
		}
		return num;
	}


	
	/**
	 * 删除角色菜单权限
	 */
	public int removePermission(Integer id) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		list = permissionMapper.findRolePermissionByMenuid(id);
		int  num=0;
		if(list != null){
			num=permissionMapper.delete(Integer.parseInt(list.get(0).get("id").toString()));
			num=permissionMapper.removePermission(Integer.parseInt(list.get(0).get("role_permission_id").toString()));
		}
		return num;
	}
	
	
	//新增子级父级菜单角色权限
	public int addParentPermissionRole(Map<String, Object>param){
		int num=0;
		//同时新增子菜单和父菜单角色权限表
		Permission permisison = new Permission();
		permisison.setCode("menu:"+Pingyin.getAllFirstLetter(param.get("name").toString()));
		permisison.setCreate_time(new Date());
		permisison.setMenu_id(Integer.parseInt(param.get("menu_id").toString()));
		permisison.setName(param.get("name").toString());
		num = permissionMapper.insert(permisison);
		int permission_id=permisison.getId();
		if(num>0){
			//新增角色菜单
			Map<String, Object> sysRolePermission = new HashMap<String, Object>();
			sysRolePermission.put("role_id", param.get("role_id"));
			sysRolePermission.put("permission_id", permission_id);
			sysRolePermission.put("create_time", new Date());
			num=permissionMapper.insertRolePermission(sysRolePermission);
		}
		return num;
	}
	
	
	/**
	 * 分配角色菜单
	 */
	public Integer redistributionRoleMeun(Map<String, Object> param) {
		int num=0;
		SysMenu getParent = (SysMenu) menuMapper.get(Integer.parseInt(param.get("menu_id").toString()));
		SysMenu getNode = (SysMenu) menuMapper.get(getParent.getParent_id());
		//查询父级菜单权限表是否存在
		List<Map<String, Object>>checkpermission = new ArrayList<Map<String,Object>>();
		checkpermission = permissionMapper.findRolePermissionByMenuid(getNode.getId());
		if(checkpermission.size()>0){
			//如果父级菜单角色权限已经分配直接分配子级菜单权限
			num=this.addParentPermissionRole(param);
		}else{
			//如果父级菜单未分配角色权限则先查询该菜单父级菜单信息
			Map<String, Object> parentParem = new HashMap<String, Object>();
			parentParem .put("role_id", param.get("role_id"));
			parentParem.put("name", getNode.getName());
			parentParem.put("menu_id", getNode.getId());
			num = this.addParentPermissionRole(parentParem);
			if(num>0){
				num = this.addParentPermissionRole(param);
			}
		}
		return num;
	}
	
}
