package com.mrkb.common.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class SpringTool implements ApplicationContextAware{
	private static ApplicationContext applicationContext = null;
	
    public void setApplicationContext(ApplicationContext applicationContext)  {
        if (SpringTool.applicationContext == null) {
            SpringTool.applicationContext = applicationContext;
            System.out.println(
                    "========ApplicationContext配置成功,在普通类可以通过调用ToolSpring.getAppContext()获取applicationContext对象,applicationContext="
                            + applicationContext + "========");
        }else{
        	System.out.println("********************************************************");
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }
    public static Object getBeanClass(Class<?> obj) {
        return getApplicationContext().getBean(obj);
    }

}
