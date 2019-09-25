package com.sl.automobile.controller;

import com.sl.automobile.pojo.AdminTable;
import com.sl.automobile.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/findAdminAll")
    public String findAdminAll(Model model){
        List<AdminTable> adminList = adminService.findAdminAll();
        model.addAttribute("adminList", adminList);
        return "admin-list";
    }
}
