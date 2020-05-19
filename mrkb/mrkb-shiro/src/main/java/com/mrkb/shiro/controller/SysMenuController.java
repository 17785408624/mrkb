package com.mrkb.shiro.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.shiro.model.SysMenu;
import com.mrkb.shiro.service.SysMenuService;
import com.mrkb.shiro.util.GetLoginUser;


@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {
	
	
	@Autowired
	private SysMenuService menuService;
	
	
	
	/**
	 * 跳转菜单管理页面
	 * @return
	 */
//	@RequiresPermissions("sys:cdgl")
	@RequestMapping("/showMenupage")
	public String showMenupage(){
		return "sys/sysMenu";
	}
	
	
	/**
	 * 查询用户菜单
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/sysMenuTree")
	public ResponseData getMenuTree(){
		ResponseData R = new ResponseData();
		Integer userid = GetLoginUser.getUserInfo().getUser_basics_id();
		List<SysMenu> list = new ArrayList<SysMenu>();
		list = menuService.listMenue(userid);
		if(list.size()>0){
			R.setData(list);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage("菜单列表获取失败");
		return R;
	}
	
	
	/**
	 * 新增菜单
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insertMenue")
	public ResponseData addMenu(@RequestBody SysMenu menu){
		ResponseData R = new ResponseData();
		if(menu.getParent_id()==null){
			menu.setParent_id(0);
		}
		Integer num = menuService.addMenu(menu);
		if(num>0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	
	/*
	 * 删除菜单
	 */
	@ResponseBody
	@RequestMapping("/removeMenu/{id}")
	public ResponseData deleteMenu(@PathVariable("id") Integer id){
		ResponseData R = new ResponseData();
		Integer num = menuService.removeMenu(id);
		if(num>0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	
	
	/**
	 * 菜单列表分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/menueList")
	public ResponseData getMenuPageList(@RequestParam("pageSize") Integer pageSize,@RequestParam("pageIndex") Integer pageIndex,HttpServletRequest req){
		ResponseData R = new ResponseData();
		String name = req.getParameter("name");
		SysMenu menu = new SysMenu();
		menu.setName(name);
		PageHelper.startPage(pageIndex, pageSize);
		List<SysMenu> list = new ArrayList<SysMenu>();
		list = menuService.list(menu);
		PageInfo<SysMenu> PageInfo = new PageInfo<>(list);
	    R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        R.setMessage(ResponseCode.SUCC_DO.getMsg());
        R.setData(PageInfo);
		return R;
	}
	
	
	
	/**
	 * 查询所有父级菜单，下拉框使用
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/get_menuselect")
	public ResponseData creat_menuselect(){
		ResponseData R = new ResponseData();
		List<SysMenu> list = menuService.creat_menuselect();
		if(list != null){
			R.setData(list);
		    R.setErrorCode(ResponseCode.SUCC_DO.getCode());
	        R.setMessage(ResponseCode.SUCC_DO.getMsg());
	        return R;
		}
	    R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
        R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	
	
	/**
	 * 根据主键ID查询菜单
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getById/{id}")
	public ResponseData findById(@PathVariable("id") Integer id){
		ResponseData R = new ResponseData();
		SysMenu menu = menuService.findById(id);
		if(menu != null){
			R.setData(menu);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
        R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	
	
	/**
	 * 检查菜单是否已经分配权限
	 * @return
	 */
	@ResponseBody
	@GetMapping("/isPermission/{id}")
	public ResponseData checkIsPermission(@PathVariable("id") Integer id){
		ResponseData R = new ResponseData();
		boolean ischck = menuService.checkIsPermission(id);
		R.setData(ischck);
		return R;
	}
	
	
	
	
	/**
	 * 修改菜单
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editMenu")
	public ResponseData updateMenu(@RequestBody SysMenu menu){
		ResponseData R = new ResponseData();
		if(menu.getParent_id()==null){
			menu.setParent_id(0);
		}
		Integer num = menuService.updateMenu(menu);
		if(num>0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	
	
	
	
	/**
	 * 查询树形菜单
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMenuListTree/{roeid}")
	public ResponseData getMenuListTree(@PathVariable("roeid") Integer roeid){
		ResponseData R = new ResponseData();
		List<Map<String, Object>>list = new ArrayList<Map<String,Object>>();
		Integer userid = GetLoginUser.getUserInfo().getUser_basics_id();
		list = menuService.getMenuListTree(roeid);
		R.setData(list);
		return R;
	}
	
	
	
	
	
	/**
	 * 角色菜单分配
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/roleMeunDistribution/{role_id}/{name}/{menu_id}")
	public ResponseData distributionRoleMeun(@PathVariable("role_id")Integer role_id,@PathVariable("name")String name,@PathVariable("menu_id")Integer menu_id){
		ResponseData R  = new ResponseData();
		Map<String, Object>param = new HashMap<String, Object>();
		param.put("name", name);
		param.put("role_id", role_id);
		param.put("menu_id", menu_id);
		Integer result=menuService.redistributionRoleMeun(param);
		if(result>0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	
	
	/**
	 * 移除角色菜单权限
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/removePermission/{menu_id}")
	public ResponseData delPermission(@PathVariable("menu_id")Integer menu_id){
		ResponseData R = new ResponseData();
		Integer num = menuService.removePermission(menu_id);
		if(num>0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
}
