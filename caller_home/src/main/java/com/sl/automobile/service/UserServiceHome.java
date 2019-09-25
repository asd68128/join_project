package com.sl.automobile.service;

import com.sl.automobile.pojo.UserTable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "producer")
public interface UserServiceHome {
    @RequestMapping("/loadByNa/{name}")
    public UserTable loadByNa(@PathVariable("name") String name);
}
