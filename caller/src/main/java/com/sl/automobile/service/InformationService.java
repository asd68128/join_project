package com.sl.automobile.service;

import com.sl.automobile.pojo.InformationTable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface InformationService {
    public List<InformationTable> findAll();
}
