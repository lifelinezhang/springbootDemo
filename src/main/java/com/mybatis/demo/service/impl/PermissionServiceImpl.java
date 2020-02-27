package com.mybatis.demo.service.impl;

import com.mybatis.demo.mapper.PermissionMapper;
import com.mybatis.demo.pojo.Permission;
import com.mybatis.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Permission selectByPrimaryKey(Integer id) {
        return permissionMapper.selectByPrimaryKey(id);
    }
}
