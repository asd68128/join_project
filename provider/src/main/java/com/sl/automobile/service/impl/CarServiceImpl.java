package com.sl.automobile.service.impl;

import com.github.pagehelper.PageHelper;
import com.sl.automobile.mapper.CarMapper;
import com.sl.automobile.pojo.CarTable;
import com.sl.automobile.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by happy on 2019/9/16.
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<CarTable> findAll(int page, int rows) {
        List<CarTable> carMapperAll = carMapper.findAll();
        PageHelper.startPage(page,rows);
        return carMapperAll;
    }

    @Override
    public CarTable findById(int id) {
        CarTable byId = carMapper.findById(id);
        return byId;
    }

    @Override
    public CarTable findByName(String name) {
        CarTable byName = carMapper.findByName(name);
        return byName;
    }

    @Override
    public CarTable findByNameLike(String name) {
        CarTable byNameLike = carMapper.findByNameLike(name);
        return byNameLike;
    }

    @Override
    public boolean insertCar(CarTable carTable) {
        int count = carMapper.insertCar(carTable);
        return count > 0 ? true : false;
    }

    @Override
    public boolean updateByCar(CarTable carTable) {
        int count = carMapper.updateByCar(carTable);
        return count > 0 ? true : false;
    }

    @Override
    public boolean deleteById(int id) {
        int count = carMapper.deleteById(id);
        return count > 0 ? true : false;
    }

    @Override
    public boolean deleteByName(String name) {
        int count = carMapper.deleteByName(name);
        return count > 0 ? true : false;
    }

    public int findCount(@PathVariable("rows") int rows) {
        int count = carMapper.findMaxCount();
        return count % rows == 0 ? count / rows : count / rows + 1;
    }
}