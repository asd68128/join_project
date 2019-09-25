package com.sl.automobile.config;


import com.sl.automobile.shiro.MyRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

//表明本类为配置类，
@Configuration
public class ShiroConfig {
    //创建shiro安全过滤器
    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(
            @Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给过滤器装配安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String,String> map = new HashMap<>();
        //定义过滤规则
        map.put("/drink","authc");//需要登陆之后才能访问点餐页面
        map.put("/pay","authc");//需要登陆之后才能访问支付页面
        map.put("/member","authc");//需要登陆之后才能访问购买会员页面
        map.put("/new_custom","authc");//需要登陆之后才能访问新客优惠页面
        map.put("/member_coupon","authc");//需要登陆之后才能访问新客优惠页面

        //map.put("/member","perms[sales,exclusive]");//需要(特价优惠、会员专享)权限才能访问
        //map.put("/new_custom","roles[新用户]");//需要新客户角色才能访问
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);//需要过滤链的定义
        shiroFilterFactoryBean.setLoginUrl("/one");//设置默认登录页
        shiroFilterFactoryBean.setUnauthorizedUrl("/bm_pay");//权限不足显示购买会员页面
        return shiroFilterFactoryBean;
    }

    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("myRealm")MyRealm myRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //组装realm到securitymanager中
        defaultWebSecurityManager.setRealm(myRealm);
        return defaultWebSecurityManager;
    }
    //创建realm
    @Bean(name = "myRealm")
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }
//  通过aop代理拦截权限设定
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);//设置代理的模式为cglib(还有相对的jdk代理)

        return proxyCreator;
    }
//    设置注解拦截 源码中的权限设定
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            @Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor( );
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
