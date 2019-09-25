package com.sl.automobile.mapper;


import com.sl.automobile.pojo.Finance;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FinanceMapper {
    //通过id查询季度所有报表
    public List<Finance> loadFinanceAll();
}
