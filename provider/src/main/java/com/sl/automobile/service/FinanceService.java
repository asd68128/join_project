package com.sl.automobile.service;

import com.sl.automobile.pojo.Finance;

import java.util.List;

public interface FinanceService {
    //查询所有财务报表
    public List<Finance> loadFinanceAll();
}
