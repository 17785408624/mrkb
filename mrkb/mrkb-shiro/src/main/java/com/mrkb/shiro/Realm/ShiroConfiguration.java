package com.mrkb.shiro.Realm;

import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

import java.util.LinkedHashMap;
import java.util.Properties;

/**
 *
 * @author Administrator
 * @create 2017/12/2
 * @since 1.0.0
 */
//启动时，先运行configuration注解的类
@Configuration
public class ShiroConfiguration  {

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager){
        System.out.println("********************拦截器注入成功****************");
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);

        bean.setLoginUrl("/weixin/weixinidex");
        bean.setUnauthorizedUrl("/unauthorized");
        
        //请求拦截 key-访问请路径  value-使用的拦截方式
        LinkedHashMap<String, String> filterChainDefinittionMap = new LinkedHashMap<>();
        //静态资源
        filterChainDefinittionMap.put("/static/**", "anon");
        filterChainDefinittionMap.put("/templates/**", "anon");
        filterChainDefinittionMap.put("/common/**", "anon");
        filterChainDefinittionMap.put("/statics/**", "anon");
        filterChainDefinittionMap.put("/img/**", "anon");
        filterChainDefinittionMap.put("/menuicon/**", "anon");
        filterChainDefinittionMap.put("/images/**", "anon");
        filterChainDefinittionMap.put("/css/**", "anon");
        filterChainDefinittionMap.put("/js/**", "anon");
        filterChainDefinittionMap.put("/plugin/**", "anon");
        filterChainDefinittionMap.put("/layer/**", "anon");
        filterChainDefinittionMap.put("/layui/**", "anon");
        filterChainDefinittionMap.put("/font/**", "anon");
        filterChainDefinittionMap.put("/pop/**", "anon");
        filterChainDefinittionMap.put("/swipper/**", "anon");
        filterChainDefinittionMap.put("/common.html", "anon");
        
        filterChainDefinittionMap.put("/kaptcha.jpg", "anon");// 验证码
        filterChainDefinittionMap.put("/admin/login","anon");//不需要验证
        filterChainDefinittionMap.put("/user/loginUser","anon");//不需要验证
//        filterChainDefinittionMap.put("/admin","roles[admin]");//只允许admin用户
//        filterChainDefinittionMap.put("/add","perms[add]");//只允许权限又add的用户
        filterChainDefinittionMap.put("/druid/**", "anon");// 数据库监控
        filterChainDefinittionMap.put("/weixin/**","anon");//需要验证--已经登录的用户
//        filterChainDefinittionMap.put("/**","user");//需要验证--已经登录的用户
        bean.setFilterChainDefinitionMap(filterChainDefinittionMap);
        return bean;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm){
        System.out.println("**********************自定Realm注入成功********************");
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        return manager;
    }

    @Bean("authRealm")
    public AuthRealm authRealm(@Qualifier("credentialMatcher") CredentialMatcher matcher){
        System.out.println("*******************缓存器authRealm注入成功*****************");
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCacheManager(new MemoryConstrainedCacheManager());//启用缓存
        authRealm.setCredentialsMatcher(matcher);
        return  authRealm;
    }

    @Bean("credentialMatcher")
    public CredentialMatcher credentialMatcher(){
        System.out.println("***************Credentialmatcher注入成功***************");
        return new CredentialMatcher();
    }

    
    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager){
        System.out.println("***************shiro-aop注解支持注入成功**************");
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        System.out.println("*********************defaultAdvisorAutoProxyCreator注入成功**********************");
        DefaultAdvisorAutoProxyCreator creater = new DefaultAdvisorAutoProxyCreator();
        creater.setProxyTargetClass(true);
        return creater;
    }
    
    
    /**
     * shiro缓存管理器;
     * 需要注入对应的其它的实体类中：
     * 1、安全管理器：securityManager
     * 可见securityManager是整个shiro的核心；
     *
     * @return
     */
    @Bean
    public EhCacheManager ehCacheManager() {
        System.out.println("shiro缓存管理器注入成功");
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
        return cacheManager;
    }
    
    
    /**
     * cookie管理对象;
     *
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        System.out.println("shiro-cookie管理对象注入成功");
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

    
    /**
     * cookie对象;
     *
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        System.out.println("rememberMeCookie()注入成功");
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }
    
    

    /**
     * 添加ShiroDialect 为了在thymeleaf里使用shiro的标签的bean
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect(){
    	System.out.println("shiro-thymeleaf注入成功");
        return new ShiroDialect();
    }
    
    
    
    /**
     * 无权限页面跳转
     * @return
     */
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
    	SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
    	Properties propertie = new Properties();
    	propertie.setProperty("UnauthorizedException", "/unauthorized");
    	exceptionResolver.setExceptionMappings(propertie);
    	return exceptionResolver;
    }
    
}