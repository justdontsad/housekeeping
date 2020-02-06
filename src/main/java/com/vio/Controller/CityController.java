package com.vio.Controller;

import com.vio.Entity.City;
import com.vio.Service.impl.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author vio
 * @date 2020-01-29   21:23
 */
@RestController
public class CityController {
    @Autowired
    CityService service;

    @RequestMapping("saveCity")
    public void saveCity(@RequestBody List<City>  citylist){
        for (City city1 : citylist) {
            service.save(city1);
        }
    }
}
