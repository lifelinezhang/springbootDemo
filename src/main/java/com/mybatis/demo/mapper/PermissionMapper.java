package com.mybatis.demo.mapper;

import com.mybatis.demo.pojo.Permission;
import org.springframework.stereotype.Component;

@Component
public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}