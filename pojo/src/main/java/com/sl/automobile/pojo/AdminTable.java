package com.sl.automobile.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AdminTable implements Serializable {
    private int adminId;
    private String adminName;
    private String adminPhone;
    private String adminEmail;
    private String adminRole;
    private Date adminTime;
}
