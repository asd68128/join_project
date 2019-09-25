package com.sl.automobile.mapper;

import com.sl.automobile.pojo.CarTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by happy on 2019/9/16.
 */
@Mapper
public interface CarMapper {
    //全查
    public List<CarTable> findAll();
    //id查找车辆
    public CarTable findById(@Param("carId") int id);
    //name查找车辆
    public CarTable findByName(@Param("carName") String name);
    //name模糊查询车辆
    public CarTable findByNameLike(@Param("carName") String name);
    //添加车辆
    public int insertCar(CarTable carTable);
    //通过车辆信息修改车辆
    public int updateByCar(CarTable carTable);
    //通过id删除车辆
    public int deleteById(@Param("carId") int id);
    //通过name删除车辆
    public int deleteByName(@Param("carName") String name);
    //查询最大行数 分页
    public int findMaxCount();
}
