package com.sl.automobile.service;

import com.sl.automobile.pojo.Permission;

import java.util.List;

public interface PermissionService {
    //加载所有权限列表
    public List<Permission> loadPermissionAll();
}
