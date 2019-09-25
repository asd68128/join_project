package com.sl.automobile.mapper;

import com.sl.automobile.pojo.UserTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * Created by happy on 2019/9/16.
 */
@Mapper
public interface UserMapper {
    //全查
    public List<UserTable> findAll();
    //id查找用户
    public UserTable findById(@Param("userId") int id);
    //name查找用户
    public UserTable findByName(@Param("userName")String userName);
    //用户名密码验证
    public UserTable findByUnameUpwd(@Param("userName") String userName,@Param("userPwd") String userPwd);
    //添加用户
    public int insertUser(UserTable user);
    //通过用户信息修改用户
    public int updateByUser(UserTable user);
    //通过id删除用户
    public int deleteById(@Param("userId")int id);
    //通过name删除用户
    public int deleteByName(@Param("userName")String name);
    //查询最大Id 用于注册
    public int loadMaxId();
}
