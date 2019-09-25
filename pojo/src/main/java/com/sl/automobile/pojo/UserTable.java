package com.sl.automobile.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserTable implements Serializable {
    private int userId;//用户id
    private String userName;//姓名
    private String userPwd;//密码
    private String userSex;//性别
    private Date userCreateDate;//注册时间
    private String userPhoto;//头像
    private  String userLike;//爱好
    private int userType;
    private String userReallyName;
    private String userPhone;

    public UserTable() {
    }

    public UserTable(int userId, String userName, String userPwd, String userSex, Date userCreateDate, String userPhoto, String userLike, int userType, String userReallyName, String userPhone) {

        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userSex = userSex;
        this.userCreateDate = userCreateDate;
        this.userPhoto = userPhoto;
        this.userLike = userLike;
        this.userType = userType;
        this.userReallyName = userReallyName;
        this.userPhone = userPhone;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Date userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserLike() {
        return userLike;
    }

    public void setUserLike(String userLike) {
        this.userLike = userLike;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserReallyName() {
        return userReallyName;
    }

    public void setUserReallyName(String userReallyName) {
        this.userReallyName = userReallyName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "UserTable{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userCreateDate=" + userCreateDate +
                ", userPhoto='" + userPhoto + '\'' +
                ", userLike='" + userLike + '\'' +
                ", userType=" + userType +
                ", userReallyName='" + userReallyName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
}
