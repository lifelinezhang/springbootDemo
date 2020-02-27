package com.mybatis.demo.service;

import com.mybatis.demo.pojo.User;

public interface UserRoleService {
    String[] getRolesByUserName(User user);
}
