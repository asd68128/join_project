package com.sl.automobile.service.impl;

import com.sl.automobile.mapper.PermissionMapper;
import com.sl.automobile.pojo.Permission;
import com.sl.automobile.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> loadPermissionAll() {
        List<Permission> List = permissionMapper.loadPermissionAll();
        return List;
    }
}
