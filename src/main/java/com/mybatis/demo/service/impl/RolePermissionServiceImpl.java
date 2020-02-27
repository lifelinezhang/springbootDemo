package com.mybatis.demo.service.impl;

import com.mybatis.demo.mapper.RolePermissionMapper;
import com.mybatis.demo.pojo.Role;
import com.mybatis.demo.pojo.RolePermission;
import com.mybatis.demo.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<String> getPermissionByRole(RolePermission role) {
        return rolePermissionMapper.getPermissionByRole(role);
    }
}
