package com.mybatis.demo.service;

import com.mybatis.demo.pojo.Permission;

public interface PermissionService {
    Permission selectByPrimaryKey(Integer id);
}
