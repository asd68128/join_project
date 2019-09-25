package com.sl.automobile.service;

import com.sl.automobile.pojo.RoleTable;
import com.sl.automobile.pojo.UserTable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@FeignClient(value = "producer")
public interface UserService {

    @RequestMapping("/loadById/{id}")
    public UserTable loadById(@PathVariable("id") int id);
    @RequestMapping("/loadAll")
    public List<UserTable> loadAll();
    @RequestMapping("/loadByNa/{name}")
    public UserTable loadByNa(@PathVariable("name") String name);
    @RequestMapping("/loadMaxId")
    public int useruserInfoMaxId();
    @RequestMapping("/add")
    public boolean add(@RequestBody UserTable userTable);
    //角色管理
    @RequestMapping("/findRoleAll")
    public List<RoleTable> findRoleAll();
    //增加角色管理新用户
    @RequestMapping("/insertRoleAdd")
    public boolean insertRole(@RequestBody RoleTable roleTable);

    /*@RequestMapping("/getRoleMaxId")
    //获取当前角色最大ID
    public int getRoleMaxId();*/

    //单个删除角色管理用户
    @RequestMapping("/deleteRole/{roleId}")
    public boolean deleteRole(@PathVariable("roleId") int roleId);

    //修改角色管理用户信息
    @RequestMapping(value = "/updateRole")
    public boolean updateRole(@RequestBody RoleTable roleTable);
    //通过Id获得角色用户信息
    @RequestMapping("/loadRoleByRoleId/{roleId}")
    public RoleTable loadRoleByRoleId(@PathVariable("roleId") int roleId);

    /*public boolean delete(int id);
    public boolean addUser(UserTable userTable);
    public boolean updateByUser( UserTable userTable);*/
}
