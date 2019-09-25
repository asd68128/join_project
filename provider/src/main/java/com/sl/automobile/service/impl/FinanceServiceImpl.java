package com.sl.automobile.service.impl;

import com.sl.automobile.mapper.FinanceMapper;
import com.sl.automobile.pojo.Finance;
import com.sl.automobile.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    private FinanceMapper financeMapper;
    @Override
    public List<Finance> loadFinanceAll() {
        List<Finance> financeList = financeMapper.loadFinanceAll();
        return financeList;
    }
}
