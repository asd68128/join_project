package com.sl.automobile.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CarTable implements Serializable {
    private int carId;
    private String carName;
    private double carPrice;//价格
    private String carInfo;//信息
    private Date carCreateDate;//生产时间
    private String carType;//车型
    private String carColor;//颜色
    private String carzuowei;//座位
    private int carXuHang;//历程
    private String carBusiness;//生产厂家
    private String carXiLie;//系列
    private String carPhoto;//照片
    private String Gearbox;//油料类型
    private int  carPower;//功率

}
