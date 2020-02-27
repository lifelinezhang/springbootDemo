package com.mybatis.demo.config;

import com.mybatis.demo.shiro.UserRealm;
import com.mybatis.demo.util.CredentialsMatcher;
import com.mybatis.demo.util.PasswordHelper;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    // 这个过滤器之前没有配置，也报错
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 这个地方之前把anon写成了anno
        filterChainDefinitionMap.put("/user/login", "anon");
        // 这个配置是说 要访问这些方法就需要先认证，也就是登录，不然就去登录页面，然后注解用来控制权限
        filterChainDefinitionMap.put("/article/add", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }



    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }


    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher()); // 自定义密码比较方式
        return userRealm;
    }

    // 自定义密码加密算法
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(PasswordHelper.ALGORITHM_NAME); // 散列算法
        hashedCredentialsMatcher.setHashIterations(PasswordHelper.HASH_ITERATIONS); // 散列次数
        return hashedCredentialsMatcher;
    }

    /**
     * 开启注解
     * @param securityManager
     * @return
     */
    // 这个地方需要添加这个bean，不然注解requirePermission等不起作用
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
