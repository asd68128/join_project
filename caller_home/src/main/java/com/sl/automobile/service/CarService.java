package com.sl.automobile.service;

        import com.sl.automobile.pojo.CarTable;
        import com.sl.automobile.pojo.UserTable;
        import org.springframework.cloud.openfeign.FeignClient;
        import org.springframework.stereotype.Service;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

        import java.util.List;

@FeignClient(value = "producer")
public interface CarService {

    @RequestMapping("/loadAllCar/{page}/{rows}")
    public List<CarTable> loadCar(@PathVariable("page") int page,@PathVariable("rows") int rows);
    @RequestMapping("/findMaxCount/{rows}")
    public int findCount(@PathVariable("rows") int rows);
    @RequestMapping("/loadCarById/{id}")
    public CarTable loadCarById(@PathVariable("id") int id);

}
