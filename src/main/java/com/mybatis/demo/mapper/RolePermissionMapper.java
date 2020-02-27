package com.mybatis.demo.mapper;

import com.mybatis.demo.pojo.Role;
import com.mybatis.demo.pojo.RolePermission;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RolePermissionMapper {

    List<String> getPermissionByRole(RolePermission role);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}