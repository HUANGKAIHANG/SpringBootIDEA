package com.hkh.SpringBootIDEA.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        System.out.println("加载Shiro配置。。。");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器实例
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        //配置不会被拦截的链接 顺序判断 anon:可以匿名访问
        filterChainDefinitionMap.put("/static/**","anon");
        //配置退出过滤器
        filterChainDefinitionMap.put("/logout","logout");

        //过滤链定义，从上往下顺序执行 一般将/**放在最下边 /**+authc：所有url都必须得到认证
        filterChainDefinitionMap.put("/**","authc");

        shiroFilterFactoryBean.setLoginUrl("/login"); //登录页
        shiroFilterFactoryBean.setSuccessUrl("/index"); //首页
        shiroFilterFactoryBean.setUnauthorizedUrl("/403"); //未授权页
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
