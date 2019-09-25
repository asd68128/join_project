package com.sl.automobile.controller;

import com.sl.automobile.pojo.RoleTable;

import com.sl.automobile.pojo.UserTable;
import com.sl.automobile.service.RoleService;
import com.sl.automobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;
    //角色管理
    @Autowired
    private UserService userService;
    @RequestMapping("/loadUserAll")
    public String loadAll(Model model){
        List<UserTable> userList = userService.loadAll();
        model.addAttribute("userList", userList);
        return "admin-role";
    }

    @RequestMapping("/findRoleAll")
    public String findRoleAll(Model model){
        List<RoleTable> roleList = userService.findRoleAll();
        model.addAttribute("roleList", roleList);
        return "admin-list";
    }
    //增加角色管理新用户
    @RequestMapping("/insertRoleAdd")
    public String insertRole( RoleTable roleTable){
        boolean b = userService.insertRole(roleTable);
        return b?"redirect:findRoleAll":"error";
    }
    //单个删除角色管理用户
    @RequestMapping("/deleteRole")
    public String deleteRole(int roleId){
        boolean b = userService.deleteRole(roleId);
        return b?"redirect:findRoleAll":"error";
    }
    //用Id获取角色信息
    @RequestMapping("/loadRoleByRoleId")
    public String loadRoleByRoleId(int roleId, Model model){
        RoleTable roleTable = userService.loadRoleByRoleId(roleId);
        model.addAttribute("roleTable", roleTable);
        return "admin-role-edit";
    }
    //修改角色管理用户信息
    @RequestMapping("/updateRole")
    public String updateRole(RoleTable roleTable){
        boolean b = userService.updateRole(roleTable);
        return b?"redirect:findRoleAll":"error";
    }
    //批量删除
    @RequestMapping("/deleteRoles")
    public String deleteRoles(@RequestParam("ids") List<Integer> ids){
        System.out.println(ids);
        boolean b = roleService.deleteRoles(ids);
        return b?"redirect:findRoleAll":"error";
    }



    //加载所有角色用户信息
    @RequestMapping("/loadAssignRole")
    public String loadAssignRole(Integer userId, Model model, HttpSession session){

        List<RoleTable> roleList = roleService.containRole(userId);
        model.addAttribute("roleList", roleList);
        session.setAttribute("userId", userId);

        List<RoleTable> roleList1 = roleService.unContainRole(userId);
        model.addAttribute("roleList1", roleList1);
        return "assignRole";
    }
    //向右移
    @RequestMapping("/roleRight")
    public String roleRight( String ids, HttpSession session){
        int userId = (int)session.getAttribute("userId");
        roleService.insertByName(userId, ids);
        return "redirect:loadAssignRole?userId="+userId;
    }
    //向左移
    @RequestMapping("/roleLeft")
    public String roleLeft(String ids, HttpSession session){
        int userId = (int)session.getAttribute("userId");
        roleService.deleteByName(userId, ids);
        return "redirect:loadAssignRole?userId="+userId;
    }
}
