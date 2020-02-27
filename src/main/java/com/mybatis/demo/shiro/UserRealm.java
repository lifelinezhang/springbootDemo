package com.mybatis.demo.shiro;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.demo.pojo.User;
import com.mybatis.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    // 这个方法没有调用的原因是，要使用aop功能，所以需要 1、添加aop依赖 2、在配置文件中开启requirePermission注解
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("用户权限认证");
        Session session = SecurityUtils.getSubject().getSession();
        Set<String> permissionSet = (Set<String>) session.getAttribute("permission");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        System.out.println(permissionSet.toString());
        // addStringPermission方法的参数是字符串
        permissionSet.forEach(e -> authorizationInfo.addStringPermission(e));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("验证用户登录信息");
        String userName = (String)token.getPrincipal();
        // 这个地方之前写的是： String password = (String) token.getCredentials(); 但是密码是以char数组的形式存储的，所以需要转换
        String password = new String((char[]) token.getCredentials());
        User user = new User();
        user.setUserName(userName);
        User resultUser = userService.findUserByName(user);
        if(resultUser == null) {
            return null;
        }
        System.out.println(resultUser.getPhone());
        // 这个地方传进去的是查询到的用户名和密码，之前写错了导致密码无法验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(resultUser.getUserName(), resultUser.getPassword(), ByteSource.Util.bytes(resultUser.getPhone()), getName());
        // 将用户信息放到session里面
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userInfo", user);
        return authenticationInfo;
    }
}
