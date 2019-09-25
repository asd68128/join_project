package com.sl.automobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/index")
    public String indexView(){
        return "index";
    }
    @RequestMapping("/welcome")
    public String welcomeView(){
        return "welcome";
    }
    @RequestMapping("/admin-role")
    public String adminView(){
        return "admin-role";
    }
    @RequestMapping("/admin-role-add")
    public String adminAddView(){
        return "admin-role-add";
    }
    @RequestMapping("/admin-role-edit")
    public String adminEditView(){
        return "admin-role-edit";
    }
    @RequestMapping("/admin-permission")
    public String adminPermissionView(){
        return "admin-permission";
    }

    @RequestMapping("/admin-list")
    public String adminListView(){
        return "admin-list";
    }
    @RequestMapping("/admin_edit")
    public String adminEditsView(){
        return "admin_edit";
    }
    @RequestMapping("/admin_add")
    public String adminAddsView(){
        return "admin_add";
    }

    @RequestMapping("/editPassword")
    public String editPasswordView(){
        return "editPassword";
    }

    @RequestMapping("/myselfInfo")
    public String myselfInfoView(){
        return "myselfInfo";
    }

    @RequestMapping("/assignRole")
    public String assignRoleView(){
        return "assignRole";
    }

    @RequestMapping("/charts-4")
    public String chartsView(){
        return "charts-4";
    }

    @RequestMapping("/charts")
    public String chartView(){
        return "charts";
    }

}
