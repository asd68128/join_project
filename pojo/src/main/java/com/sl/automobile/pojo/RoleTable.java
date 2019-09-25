package com.sl.automobile.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleTable implements Serializable {
    private int roleId;
    private String roleName;//角色名称
    private String roleList;//角色列表
    private String roleDescribe;//角色描述
}
