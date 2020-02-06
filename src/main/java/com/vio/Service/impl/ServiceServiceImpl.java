package com.vio.Service.impl;

import com.vio.Entity.CategoryItem;
import com.vio.Entity.Service;
import com.vio.Repository.ServiceDao;
import com.vio.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vio
 * @date 2020-01-30   18:18
 */
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceDao serviceDao;


    @Override
    public List<Service> findServiceByCategoryId(CategoryItem item) {
        return serviceDao.findByServiceCategory(item.getCategoryItemId());
    }

    @Override
    public List<Service> findServiceByCategoryId(List<CategoryItem> items) {
        List<Service> rs =new ArrayList<Service>();
        for (CategoryItem item : items) {
            rs.addAll(findServiceByCategoryId(item));
        }
        return rs;
    }


}
