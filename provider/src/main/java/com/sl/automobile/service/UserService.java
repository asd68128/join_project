package com.sl.automobile.service;

import com.sl.automobile.pojo.UserTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by happy on 2019/9/11.
 */
public interface UserService {

    public List<UserTable> findAll();
    public UserTable findById(int id);
    public UserTable findByName(String name);
    public boolean findByUnameUpwd(String userName,String userPwd);
    public boolean insertUser(UserTable user);
    public boolean updateByUser(UserTable user);
    public boolean deleteById(int id);
    public boolean deleteByName(String name);
    public int userMaxId();
}
