package com.mrkb.shiro.Realm;


import com.mrkb.shiro.model.Permission;
import com.mrkb.shiro.model.Role;
import com.mrkb.shiro.model.SysUser;
import com.mrkb.shiro.model.User;
import com.mrkb.shiro.service.ShiroUserPermissionService;
import com.mrkb.shiro.service.ShiroUserRoleService;
import com.mrkb.shiro.service.ShiroUserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  Realm
 * @author Administrator
 * @create 2017/12/2
 * @since 1.0.0
 */
public class AuthRealm extends AuthorizingRealm{

    @Autowired
    private ShiroUserService shiroUserService;
    
    @Autowired
    private ShiroUserPermissionService permission;
    
    @Autowired
    private ShiroUserRoleService userRole;

    /**
     *  授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	User user = (User) SecurityUtils.getSubject().getPrincipal();
		String userName = user.getUser_account_num();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 获取用户角色集
		List<Role> roleList = userRole.findByUserName(userName);
		Set<String> roleSet = new HashSet<String>();
		for (Role r : roleList) {
			roleSet.add(r.getName());
		}
		simpleAuthorizationInfo.setRoles(roleSet);
		// 获取用户权限集
		List<Permission> permissionList = permission.findByUserName(userName);
		Set<String> permissionSet = new HashSet<String>();
		for (Permission p : permissionList) {
			permissionSet.add(p.getCode());
		}
		simpleAuthorizationInfo.setStringPermissions(permissionSet);
		return simpleAuthorizationInfo;
    }




    /**
     *  认证登录
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("***************登陆认证**************");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User user = this.shiroUserService.findByUsername(username);
        SimpleAuthenticationInfo s = new SimpleAuthenticationInfo();
        return new SimpleAuthenticationInfo(user,user.getUser_password(),getName());
    }
}