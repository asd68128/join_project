package com.sl.automobile.mapper;

import com.sl.automobile.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    //加载所有权限列表
    public List<Permission> loadPermissionAll();
}
