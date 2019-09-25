package com.sl.automobile.controller;

import com.sl.automobile.pojo.UserTable;
import com.sl.automobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by happy on 2019/9/16.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/loadAll")
    public List<UserTable> loadAll(){
        List<UserTable> userList = userService.findAll();
        return userList;
    }

    @RequestMapping("/loadById/{id}")
    public UserTable loadById(@PathVariable("id") int id){
        UserTable byId = userService.findById(id);
        return byId;
    }
    @RequestMapping("/loadMaxId")
    public int userMaxId(){
        int Maxid = userService.userMaxId();
        return Maxid;
    }
    @RequestMapping("/loadByNa/{name}")
    public UserTable loadByNa(@PathVariable("name") String name){
        UserTable byName = userService.findByName(name);
        return byName;
    }

    @RequestMapping("/add")
    public boolean add(@RequestBody UserTable userTable){
        boolean b = userService.insertUser(userTable);
        return b;
    }

    @RequestMapping("/updateByUser")
    public boolean updateByUser(UserTable userTable){
        boolean b = userService.updateByUser(userTable);
        return b;
    }

    @RequestMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable("id")int id){
        boolean b = userService.deleteById(id);
        return b;
    }
    @RequestMapping("/deleteByNa/{name}")
    public boolean deleteByName(@PathVariable("name")String name){
        boolean b = userService.deleteByName(name);
        return b;
    }
}
