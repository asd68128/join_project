package com.sl.automobile.controller;

import com.sl.automobile.pojo.CarTable;
import com.sl.automobile.service.CarService;
import com.sl.automobile.service.UserServiceHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;
     @Autowired
     private UserServiceHome userService;
     //注销
    @RequestMapping("/Out")
       public String Out(){
     return "redirect:Car";
 }
    //跳转到登录
    @RequestMapping("/Denglu")
    public String Denglu(){
        return "redirect:http://localhost:9020/View";
    }
    //跳转到注册页面
    @RequestMapping("/register")
    public String register(){
        return "redirect:http://localhost:9020/reg_r";
    }
    //个人中心
    @RequestMapping("/MySelf")
    public String MySelf(HttpSession session, Model model){
        return "contact";
    }
    //显示展示页面
   @RequestMapping("/ZhanShi")
    public String Zhanshi(@RequestParam(required = false,defaultValue = "1")int page,
                          @RequestParam(required = false,defaultValue = "4")int rows,
                          Model model ,HttpSession session){

       int maxPage=carService.findCount(rows);
        session.setAttribute("name","boss");
       if(page>maxPage){
           page=1;
       }
       if(page<1){
           page=maxPage;
       }
       List<CarTable> carList = carService.loadCar(page,rows);
       model.addAttribute("goodsList",maxPage);
       model.addAttribute("currentPage",page);
       model.addAttribute("carList",carList);
       return "index";
    }
    //详情页面
    @RequestMapping("/XiangQ")
    public String XiangQ(){
        return "single";
    }
    @RequestMapping("/Car")
    public String CarView(){
        return "one";
    }

    @RequestMapping("/Business")
    public String Business(){
       return "business";
    }
   //地图
    @RequestMapping("/Mapp")
    public String mapp(){
        return "mapp";
    }

    @RequestMapping("/loginOut")
    public String loginOut(){
        return "redirect:http://localhost:9020/loginOut";
    }
}
