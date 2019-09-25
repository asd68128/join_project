package com.sl.automobile.service;

import com.sl.automobile.pojo.RoleTable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "producer")
public interface RoleService {
    //批量删除
    @RequestMapping(value = "/deleteRoles/{ids}")
    public boolean deleteRoles(@PathVariable("ids") List<Integer> ids);


    //查询该用户拥有的角色
    @RequestMapping(value = "/containRole/{userId}")
    public List<RoleTable> containRole(@PathVariable("userId") int userId);
    //查询该用户未拥有角色
    @RequestMapping(value = "/unContainRole/{userId}")
    public List<RoleTable> unContainRole(@PathVariable("userId") int userId);
    //将新的角色分配信息添加到关系表中
    @RequestMapping("/insertByName/{userId}/{ids}")
    public int insertByName(@PathVariable("userId") int userId, @PathVariable("ids") String ids);
    //将新的角色分配信息添加到关系表中
    @RequestMapping("/deleteByName/{userId}/{ids}")
    public int deleteByName(@PathVariable("userId") int userId, @PathVariable("ids") String ids);
}
