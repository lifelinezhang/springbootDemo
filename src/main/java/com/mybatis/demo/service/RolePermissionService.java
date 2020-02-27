package com.mybatis.demo.service;

import com.mybatis.demo.pojo.Role;
import com.mybatis.demo.pojo.RolePermission;

import java.util.List;

public interface RolePermissionService {

    List<String> getPermissionByRole(RolePermission role);

}
