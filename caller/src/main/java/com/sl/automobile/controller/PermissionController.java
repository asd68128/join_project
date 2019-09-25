package com.sl.automobile.controller;

import com.sl.automobile.pojo.Permission;
import com.sl.automobile.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/loadPermissionAll")
    public String loadPermissionAll(Model model){
        List<Permission> permissionList = permissionService.loadPermissionAll();
        model.addAttribute("permissionList", permissionList);
        return "admin-permission";
    }
}
