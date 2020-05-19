package com.mrkb.shiro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.shiro.model.Permission;
import com.mrkb.shiro.service.ShiroUserPermissionService;

@Controller
@RequestMapping("/userPermission")
public class ShiroUserPermissionController {
	
	
	@Autowired
	private ShiroUserPermissionService permissionService;
	
	/**
	 * 跳转权限管理页面
	 * @return
	 */
	@RequestMapping("/permissionShow")
	public String pageUserPermissionShowPage(){
		return "sys/sysUserPermission";
	}
	
	
	/**
	 * 跳转菜单权限编辑页面
	 * @return
	 */
	@RequestMapping("/permissionEditPage/{id}")
	public String pagePermissionEdit(@PathVariable("id") Integer id,HttpServletRequest req){
		req.setAttribute("menu_id", id);
		return "sys/sysMenuPermissionEdit";
	}
	
	/**
	 * 菜单列表分页查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/permissionList")
	public ResponseData getMenuPageList(@RequestParam("pageSize") Integer pageSize,@RequestParam("pageIndex") Integer pageIndex,HttpServletRequest req){
		ResponseData R = new ResponseData();
		String name = req.getParameter("name");
		Permission permission = new Permission();
		permission.setName(name);
		PageHelper.startPage(pageIndex, pageSize);
		List<Permission> list = new ArrayList<Permission>();
		list = permissionService.list(permission);
		PageInfo<Permission> PageInfo = new PageInfo<>(list);
	    R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        R.setMessage(ResponseCode.SUCC_DO.getMsg());
        R.setData(PageInfo);
		return R;
	}
	
	
	
	
	/**
	 * 根据菜单ID查询菜单权限
	 * @return
	 */
	@ResponseBody
	@GetMapping("/getMenuPemission/{menu_id}")
	public ResponseData getPemissionByMenuId(@PathVariable("menu_id") Integer menu_id){
		ResponseData R = new ResponseData();
		Permission permission = permissionService.getPemissionByMenuId(menu_id);
		R.setData(permission);
		return R;
	}
	
	
	
	/**
	 * 新增菜单权限
	 * @param permission
	 * @return
	 */
	@ResponseBody
	@PostMapping("/permissionSave")
	public ResponseData savePermission(@RequestBody Permission permission){
		ResponseData R = new ResponseData();
		Integer num = permissionService.savePermission(permission);
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
	 * 菜单权限修改
	 * @param permission
	 * @return
	 */
	@ResponseBody
	@PostMapping("/permissionUpdate")
	public ResponseData updatePermission(@RequestBody Permission permission){
		ResponseData R = new ResponseData();
		Integer num = permissionService.updatePermission(permission);
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
	 * 删除权限
	 * @param id
	 * @return
	 */
	@ResponseBody
	@GetMapping("/removePermission/{id}")
	public ResponseData deletePermission(@PathVariable("id") Integer id){
		ResponseData R = new ResponseData();
		Integer num = permissionService.removePermission(id);
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
