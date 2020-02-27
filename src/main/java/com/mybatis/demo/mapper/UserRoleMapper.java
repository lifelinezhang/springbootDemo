package com.mybatis.demo.mapper;

import com.mybatis.demo.pojo.User;
import com.mybatis.demo.pojo.UserRole;
import org.springframework.stereotype.Component;

@Component
public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    String[] getRolesByUserName(User user);
}