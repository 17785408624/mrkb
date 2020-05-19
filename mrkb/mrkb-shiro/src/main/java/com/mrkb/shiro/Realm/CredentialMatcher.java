package com.mrkb.shiro.Realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 *  自我实现密码比较器
 * @author Administrator
 * @create 2017/12/2
 * @since 1.0.0
 */
public class CredentialMatcher extends SimpleCredentialsMatcher{

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        System.out.println("doCredentialsMatch:"+token);
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String password = new String(usernamePasswordToken.getPassword());
        String dbPassword =  (String)info.getCredentials();
        System.out.println("doCredentialsMatch:"+password.toString()+" "+dbPassword);
        return this.equals(password,dbPassword);
    }
}