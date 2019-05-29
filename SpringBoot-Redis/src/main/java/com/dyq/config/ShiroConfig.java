package com.dyq.config;

import java.util.LinkedHashMap;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dyq.util.UserRealm;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfig {

	// thymeleaf模板使用shiro标签
	@Bean
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}
	
	//创建ShiroFilterFactoryBean
	@Bean(name="shiroFilterFactoryBean")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
		//配置登录的url和登录成功的url
		shiroFilterFactoryBean.setLoginUrl("/loginpage");
		shiroFilterFactoryBean.setSuccessUrl("/indexpage");
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        // filterChainDefinitionMap.put("/loginpage*", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/admin/*", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/logout*","anon");
        filterChainDefinitionMap.put("/img/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/fomts/**","anon");
        filterChainDefinitionMap.put("/**", "anon");		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;	
	}

	@Bean(name="defaultWebSecurityManager")
	//创建DefaultWebSecurityManager
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(userRealm);
		return defaultWebSecurityManager;
	}
	
	//创建Realm
	@Bean(name="userRealm")
	public UserRealm getUserRealm(){
		return new UserRealm();
	}	
	
}
