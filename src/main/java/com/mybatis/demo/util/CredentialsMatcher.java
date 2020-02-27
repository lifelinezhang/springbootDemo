package com.mybatis.demo.util;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

public class CredentialsMatcher extends SimpleCredentialsMatcher {
    // 判断md5加密后的密码是否跟数据库一致
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;
        String password = new String(utoken.getPassword());
        String newPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        return this.equals(newPassword, info.getCredentials());
    }
}
