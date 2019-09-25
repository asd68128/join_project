package com.sl.automobile.service;

import com.sl.automobile.pojo.AdminTable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "producer")
public interface AdminService {
    //管理员全查
    @RequestMapping("/findAdminAll")
    public List<AdminTable> findAdminAll();

}
