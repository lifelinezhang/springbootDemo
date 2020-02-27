package com.mybatis.demo.service.impl;

import com.mybatis.demo.mapper.UserRoleMapper;
import com.mybatis.demo.pojo.User;
import com.mybatis.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public String[] getRolesByUserName(User user) {
        return userRoleMapper.getRolesByUserName(user);
    }
}
