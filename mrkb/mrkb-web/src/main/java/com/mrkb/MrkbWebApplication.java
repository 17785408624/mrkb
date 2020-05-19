package com.mrkb;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan
@MapperScans(value = { @MapperScan(value = "com.mrkb.dao.dao"),@MapperScan(value = "com.mrkb.shiro.mapper")})
@ImportResource(locations={"classpath:mykaptcha.xml"})

public class MrkbWebApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(MrkbWebApplication.class, args);
    }


    @Override//打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

}
