package com.mybatis.demo.service;

import com.mybatis.demo.pojo.User;

import javax.jws.soap.SOAPBinding;

public interface UserService {

    int insert(User user);

    User findUserByName(User user);

}
