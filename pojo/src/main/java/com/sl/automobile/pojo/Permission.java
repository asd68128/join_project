package com.sl.automobile.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permission implements Serializable {
    private int permissionId;
    private String permissionName;
    private String menu_name;
    private String menu_type;
    private String menu_url;
    private String per_desc;
    private int if_vilid;
    private int parent_id;
}
