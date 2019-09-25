package com.sl.automobile.controller;

import com.sl.automobile.service.SendSmsService;
import com.sl.automobile.utils.ImgCode;
import com.sl.automobile.pojo.UserTable;
import com.sl.automobile.service.UserService;
import com.sl.automobile.utils.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by happy on 2019/9/16.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SendSmsService sendSmsService;

    @RequestMapping("/loadById")
    @ResponseBody
    public UserTable loadById(int id) {
        UserTable byId = userService.loadById(id);
        return byId;
    }
    /*   //主页面
    @RequestMapping("/Car")
    public String CarView(HttpSession session, Model model){
        String userName =(String) session.getAttribute("userName");
        System.out.println(userName);
         model.addAttribute("userName", userName);
        return "index";
    }*/
    @RequestMapping("loginOut")
    public String loginOut() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();//用户登出，清除用户在shiro中的驻留信息
        return "redirect:http://localhost:9028/Car";
    }

    //登陆页面
    @RequestMapping("/View")
    public String view() {
        return "login";
    }
    //注册页面
    @RequestMapping("/reg_r")
    public String reg_r(){
        return "reg";
    }

    @RequestMapping("/loadAll")
    @ResponseBody
    public List<UserTable> loadAll() {
        List<UserTable> userTables = userService.loadAll();
        return userTables;
    }

    //用户注册
    @RequestMapping("/register")
    public String register(String userName, String userPwd, String userPhone, String userImgCode, Model model, HttpSession session) {
        if (userName != null && userName != "" && userPwd != null && userPwd != "" && userPhone != null && userPhone != "") {
            String imgCode = (String) session.getAttribute(ImgCode.RANDOMCODEKEY);
           /* boolean bool = sendSmsService.checkSmsCode(userPhone, userImgCode);*/
            if (StringUtils.startsWithIgnoreCase(imgCode, userImgCode)) {//验证码正确
           /* if (bool){//验证码正确*/
                UserTable userByLoginName = userService.loadByNa(userName);
                if (userByLoginName != null) {
                    model.addAttribute("error", "您输入的用户名已存在，请重新输入");
                    return "reg";
                } else {
                    String md5Upwd = new MD5().getMD5ofStr(userPwd);
                    Date date = new Date();
                    //  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
                    UserTable userTable = new UserTable(0, userName, md5Upwd, null, date, null, null, 1, null, userPhone);

                    boolean b = userService.add(userTable);

                    if (b) {//添加成功
                        return "redirect:View";
                    } else {
                        model.addAttribute("error", "注册失败,请再试一遍");
                        return "reg";
                    }
                }
            } else {
                model.addAttribute("error", "必填项不能为空");
                return "reg";
            }
        } else {
            model.addAttribute("error", "验证码错误");
            return "reg";
        }
    }


    //验证码显示
    @RequestMapping("/getImg")
    public void getImg(HttpServletRequest request, HttpServletResponse response) {

        new ImgCode().getRandcode(request, response);
    }

    @RequestMapping("/yzm")
    @ResponseBody
    public String yzm(String phoneNum){
        System.out.println(phoneNum);
        String info = sendSmsService.sendSms(phoneNum);
        if (info.equals("OK")){
            System.out.println(phoneNum);
            //发送成功
            return "success";
        }else {
            //发送失败
            return null;
        }

    }
    /*@RequestMapping("/jyyzm")
    public String jyyzm(String phoneNum,String smsCode){

        boolean b = sendSmsService.checkSmsCode(phoneNum, smsCode);

        if (b){
            //验证码正确
            return "";
        }else {
            return "";
        }

    }*/


    //登录验证
    @RequestMapping(value = "/Denglu",method = RequestMethod.POST)
    public String Denglu(@RequestParam("userName") String userName,
                         @RequestParam("userPwd") String userPwd,
                         @RequestParam("userCode") String userCode,
                         Model model, HttpSession session) {

        if (userName != null && userName != "" && userCode != null && userCode != "" && userPwd != null && userPwd != "") {
            String imgCode = (String) session.getAttribute(ImgCode.RANDOMCODEKEY);

            if (StringUtils.startsWithIgnoreCase(imgCode, userCode)) {
                Subject subject = SecurityUtils.getSubject();
                String md5Upwd = new MD5().getMD5ofStr(userPwd);
                UsernamePasswordToken token = new UsernamePasswordToken(userName, md5Upwd);
                try {
                    subject.login(token);
                    if (subject.isAuthenticated()) {
                        session.setAttribute("userName", userName);
                        UserTable userTable = userService.loadByNa(userName);
                        int userType = userTable.getUserType();
                        if (userType==1){
                            return "redirect:http://localhost:9028/ZhanShi";
                        }else if (userType==0){
                           return "index";
                        }
                        } else {
                            model.addAttribute("error", "登陆失败，请重新登录");
                            return "redirect:View";
                        }
                } catch (UnknownAccountException un) {
                    model.addAttribute("error", "用户名不存在");
                    return "redirect:View";
                } catch (IncorrectCredentialsException ice) {
                    model.addAttribute("error", "用户名或密码错误");
                    return "redirect:View";
                } catch (AuthenticationException ae) {
                    ae.printStackTrace();
                }
            } else {
                model.addAttribute("error", "验证码错误");
                return "redirect:View";
            }
        } else {
            model.addAttribute("error", "请输入完整的用户名密码");
            return "redirect:View";
        }
        return "redirect:View";
    }

    //个人中心
    @RequestMapping("/MySelf")
    public String MySelf(HttpSession session, Model model){
        String userName = (String)session.getAttribute("userName");
        UserTable userInfo = userService.loadByNa(userName);
        model.addAttribute("userList",userInfo);
        return "Myself";
    }


  /*  @RequestMapping("/loadById")

    public String loadById(int id,Model model){
        // System.out.println(id);
        UserTable userUpdate = userMapper.loadById(id);
        model.addAttribute("userUpdate",userUpdate);
        return "member-update";
    }
    @RequestMapping("loadAll")
    public String loadAll(Model model){
        List<UserTable> userList = userService.loadAll();
        model.addAttribute("userList",userList);
        return "member-list";
    }
    @RequestMapping("deleteUser")
    public String deleteUser(int id){
        System.out.println("-----------"+id);
        UserTable userll = userMapper.loadById(id);
        System.out.println(userll+"=s=s=s=s=s=s=s=");
        boolean bool1= delUserMapper.addUser1(userll);
        System.out.println(bool1);
        boolean bool2 = userMapper.deleteYs(id);
        System.out.println(id+"555555555555555555555");
        boolean bool= userMapper.deleteById(id);
        return  bool?"redirect:loadAll":"404";
    }
    @RequestMapping("/addUserTable")
    public String addUser(String userName, String userPwd, String userSex,String userPhone){
        Date date = new Date();
        UserTable userTable=new UserTable(0,userName ,userPwd,userSex,date,null,null,1,null,userPhone);
        System.out.println(userTable);

        boolean bool= userMapper.addUser(userTable);

        return  bool?"redirect:loadAll":"404";
    }
    @RequestMapping("/updateUserTable")
    public String updateUser(UserTable userTable){
        //System.out.println(userTable+"--------------");
        boolean bool= userMapper.updateByUser(userTable);
        return  bool?"redirect:loadAll":"404";
    }*/
}
