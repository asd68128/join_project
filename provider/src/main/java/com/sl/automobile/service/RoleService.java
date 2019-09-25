package com.sl.automobile.service;

import com.sl.automobile.pojo.RoleTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    //加载所有角色管理用户
    public List<RoleTable> findRoleAll();
    //增加角色管理新用户
    public boolean insertRole(RoleTable roleTable);
    //单个删除角色管理用户
    public boolean deleteRole(int roleId);
    //修改角色管理用户信息
    public boolean updateRole(RoleTable roleTable);
    //通过Id获得角色用户信息
    public RoleTable loadRoleByRoleId(int roleId);
    //批量删除
    public boolean deleteRoles(List<Integer> ids);

    /*//获取当前角色最大ID
    public int getRoleMaxId();*/



    //查询该用户拥有的角色
    public List<RoleTable> containRole(int userId);
    //查询该用户未拥有角色
    public List<RoleTable> unContainRole(int userId);
    //将新的角色分配信息添加到关系表中
    public int insertByName(int userId, String ids);
    //将新的角色分配信息添加到关系表中
    public int deleteByName(int userId, String ids);
}
