package com.sl.automobile.controller;

import com.sl.automobile.pojo.CarTable;
import com.sl.automobile.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by happy on 2019/9/16.
 */
@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/loadAllCar/{page}/{rows}")
    public List<CarTable> loadAllCar(@PathVariable("page") int page,@PathVariable("rows") int rows){
        /*int count=carService.findMaxcount();*/
        ArrayList<Integer> list = new ArrayList<>();
        list.add(page);
        list.add(rows);
        List<CarTable> userList = carService.findAll(page,rows);
        return userList;
    }

    @RequestMapping("/findMaxCount/{rows}")
    public int findCount(@PathVariable("rows") int rows){
    int maxPage=carService.findCount(rows);
        return maxPage;
    }

    @RequestMapping("/loadCarById/{id}")
    public CarTable loadCarById(@PathVariable("id") int id){
        CarTable byId = carService.findById(id);
        return byId;
    }

    @RequestMapping("/loadCarByNa/{name}")
    public CarTable loadCarByNa(@PathVariable("name")String name){
        CarTable byName = carService.findByName(name);
        return byName;
    }
    @RequestMapping("/loadCarByNaLike/{name}")
    public CarTable loadCarByNaLike(@PathVariable("name")String name){
        CarTable byNameLike = carService.findByNameLike(name);
        return byNameLike;
    }

    @RequestMapping("/addCar")
    public boolean addCar(@RequestBody CarTable carTable){
        boolean b = carService.insertCar(carTable);
        return b;
    }

    @RequestMapping("/updateCarByCar")
    public boolean updateCarByCar(@RequestBody CarTable carTable){
        boolean b = carService.updateByCar(carTable);
        return b;
    }

    @RequestMapping("/deleteCarById/{id}")
    public boolean deleteCarById(@PathVariable("id")int id){
        boolean b = carService.deleteById(id);
        return b;
    }
    @RequestMapping("/deleteCarByName/{name}")
    public boolean deleteCarByName(@PathVariable("name")String name){
        boolean b = carService.deleteByName(name);
        return b;
    }

}
