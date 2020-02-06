package com.vio.Service.impl;

import com.vio.Entity.City;
import com.vio.Repository.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vio
 * @date 2020-01-29   21:25
 */
@Service
public class CityService {
    @Autowired
    CityDao dao;
    public void save(City city){
        dao.save(city);
    }
}
