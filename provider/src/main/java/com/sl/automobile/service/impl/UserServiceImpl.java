package com.sl.automobile.service.impl;

import com.sl.automobile.mapper.UserMapper;
import com.sl.automobile.pojo.UserTable;
import com.sl.automobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by happy on 2019/9/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserTable> findAll() {
        List<UserTable> userList = userMapper.findAll();
        return userList;
    }

    @Override
    public UserTable findById(int id) {
        UserTable byId = userMapper.findById(id);
        return byId;
    }

    @Override
    public UserTable findByName(String name) {
        UserTable byName = userMapper.findByName(name);
        return byName;
    }

    @Override
    public boolean findByUnameUpwd(String userName, String userPwd) {
        UserTable byUnameUpwd = userMapper.findByUnameUpwd(userName, userPwd);
        return byUnameUpwd!=null?true:false;
    }

    @Override
    public boolean insertUser(UserTable user) {
        int count = userMapper.insertUser(user);
        return count>0?true:false;
    }

    @Override
    public boolean updateByUser(UserTable user) {
        int count = userMapper.updateByUser(user);
        return count>0?true:false;
    }

    @Override
    public boolean deleteById(int id) {
        int count = userMapper.deleteById(id);
        return count>0?true:false;
    }

    @Override
    public boolean deleteByName(String name) {
        int count = userMapper.deleteByName(name);
        return count>0?true:false;
    }

    @Override
    public int userMaxId() {
        return userMapper.loadMaxId();
    }
}
