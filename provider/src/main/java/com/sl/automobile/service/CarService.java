package com.sl.automobile.service;

import com.sl.automobile.pojo.CarTable;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by happy on 2019/9/16.
 */
public interface CarService {

    public List<CarTable> findAll(@Param("page") int page,@Param("rows") int rows);
    public CarTable findById(@Param("carId") int id);
    public CarTable findByName(@Param("carName") String name);
    public CarTable findByNameLike(@Param("carName") String name);
    public boolean insertCar(CarTable carTable);
    public boolean updateByCar(CarTable carTable);
    public boolean deleteById(@Param("carId") int id);
    public boolean deleteByName(@Param("carName") String name);
    public int findCount(@PathVariable("rows") int rows);

    }
