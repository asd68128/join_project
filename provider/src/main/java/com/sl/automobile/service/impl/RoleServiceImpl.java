package com.sl.automobile.service.impl;

import com.sl.automobile.mapper.RoleMapper;
import com.sl.automobile.pojo.RoleTable;
import com.sl.automobile.service.RoleService;
import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<RoleTable> findRoleAll() {
        return roleMapper.findRoleAll();
    }

    @Override
    public boolean insertRole(RoleTable roleTable) {
        int i = roleMapper.insertRole(roleTable);
        return i>0?true:false;
    }

    @Override
    public boolean deleteRole(int roleId) {
        int i = roleMapper.deleteRole(roleId);
        return i>0?true:false;
    }

    @Override
    public boolean updateRole(RoleTable roleTable) {
        int i = roleMapper.updateRole(roleTable);
        return i>0?true:false;
    }

    @Override
    public RoleTable loadRoleByRoleId(int roleId) {
        return roleMapper.loadRoleByRoleId(roleId);
    }

    @Override
    public boolean deleteRoles(List<Integer> ids) {
        int i = roleMapper.deleteRoles(ids);
        return i>0?true:false;
    }

    @Override
    public List<RoleTable> containRole(int userId) {
        return roleMapper.containRole(userId);
    }

    @Override
    public List<RoleTable> unContainRole(int userId) {
        return roleMapper.unContainRole(userId);
    }

    @Override
    public int insertByName(int userId, String ids) {
        return roleMapper.insertByName(userId, ids);
    }

    @Override
    public int deleteByName(int userId, String ids) {
        return roleMapper.deleteByName(userId, ids);
    }

   /* @Override
    public int getRoleMaxId() {
        int maxId = roleMapper.getRoleMaxId();
        return maxId;
    }*/
}
