package com.mrkb.shiro.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.shiro.model.Role;
import com.mrkb.shiro.service.ShiroUserRoleService;

@Controller
@RequestMapping("/userRole")
public class ShiroUserRoleController {
	
	
	@Autowired
	private ShiroUserRoleService shiroseService;
	
	/**
	 * 跳转角色管理页面
	 * @return
	 */
	@RequestMapping("/rolePage")
	public String showRolePage(){
		return "sys/sysUserRole";
	}
	
	
	/**
	 * 角色菜单编辑页面跳转
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/sysRolePernissionPage/{id}")
	public String rolePermissionPage(@PathVariable("id") Integer id,HttpServletRequest req){
		req.setAttribute("role_id", id);
		return "sys/sysRolePernissionEdit";
	}
	
	
	/**
	 * 查询角色分页列表
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/RolePageList")
	public ResponseData getRolePageList(@RequestParam("pageSize") Integer pageSize,@RequestParam("pageIndex") Integer pageIndex,HttpServletRequest req){
		ResponseData R = new ResponseData();
		Role role = new Role();
		String name = req.getParameter("name");
		role.setName(name);
		PageHelper.startPage(pageIndex, pageSize);
		List<Role> list = new ArrayList<Role>();
		list = shiroseService.list(role);
		PageInfo<Role> PageInfo = new PageInfo<>(list);
	    R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        R.setMessage(ResponseCode.SUCC_DO.getMsg());
        R.setData(PageInfo);
		return R;
	}
	
	
	
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insertRole")
	public ResponseData addRole(@RequestBody Role role){
		ResponseData R = new ResponseData();
		role.setCreate_time(new Date());
		Integer num = shiroseService.addRole(role);
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
	 * 删除角色
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/removeRole/{id}")
	public ResponseData deleteRole(@PathVariable("id") Integer id){
		ResponseData R = new ResponseData();
		Integer num = shiroseService.removeRole(id);
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
	 * 查询所有用户角色
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getRoleList")
	public ResponseData getRoleList(){
		ResponseData R = new ResponseData();
		List<Role> list = new ArrayList<Role>();
		Role roel = new Role();
		list = shiroseService.list(roel);
		R.setData(list);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		return R;
	}
	
	
	
	/**
	 * 根据用户ID查询用户角色
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getRoleByUserId/{user_id}")
	public ResponseData getRoleByUserId(@PathVariable Integer user_id){
		ResponseData R = new ResponseData();
		Map<String, Object> role = new HashMap<String, Object>();
		role=shiroseService.getRoleByUserId(user_id);
		R.setData(role);
		return R;
	}
	
}
