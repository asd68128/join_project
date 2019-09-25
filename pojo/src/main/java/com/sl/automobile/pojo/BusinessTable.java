package com.sl.automobile.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessTable implements Serializable {
    private int businessId;//id
    private String businessName;//商家名称
    private String businessAdress;//地址
    private String businessPhone;//联系电话
}
