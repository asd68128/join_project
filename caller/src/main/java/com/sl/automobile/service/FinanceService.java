package com.sl.automobile.service;

import com.sl.automobile.pojo.Finance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "producer")
public interface FinanceService {
    //查询所有财务报表
    @RequestMapping("/loadFinanceAll")
    public List<Finance> loadFinanceAll();
}
