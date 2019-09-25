package com.sl.automobile.service;

import com.sl.automobile.pojo.Permission;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "producer")
public interface PermissionService {
    //加载所有权限列表
    @RequestMapping("/loadPermissionAll")
    public List<Permission> loadPermissionAll();
}
