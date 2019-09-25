/*
package com.sl.automobile.controller;

import com.sl.automobile.pojo.Deluser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DelUserController {
    @Autowired
    private DelUserMapper delUserMapper;
    @RequestMapping("/deletemember")
    public String findAll(Model model){
        List<Deluser> delusers = delUserMapper.loadAlls();
        model.addAttribute("delusers",delusers);
        return "member-del";
    }
   */
/* @RequestMapping("/adddeluser")
    public String addUser1(UserTable userTable){

        boolean bool = delUserService.addUser1(userTable);
        return  bool?"redirect:deletemember":"404";
    }*//*

   @RequestMapping("/delDelUser")
    public String delDell(int id){
       System.out.println(id+"1111111111111");
       boolean bool = delUserMapper.deleteDelUser(id);
       return  bool?"redirect:deletemember":"404";
   }
}

*/
