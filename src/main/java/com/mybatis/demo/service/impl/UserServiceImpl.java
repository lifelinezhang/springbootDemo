package com.mybatis.demo.service.impl;

import com.mybatis.demo.mapper.UserMapper;
import com.mybatis.demo.pojo.User;
import com.mybatis.demo.service.UserService;
import com.mybatis.demo.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public int insert(User user) {
        // 对密码进行加密
        user = PasswordHelper.encryptUser(user);
        return userMapper.insert(user);
    }

    @Override
    public User findUserByName(User user) {
        return userMapper.findUserByName(user);
    }
}
