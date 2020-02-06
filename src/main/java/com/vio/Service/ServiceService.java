package com.vio.Service;

import com.vio.Entity.CategoryItem;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ServiceService {

    /**
     * 查询分类明细下对应的服务
     * @param item
     * @return
     */
    public List<com.vio.Entity.Service> findServiceByCategoryId(CategoryItem item);

    /**
     * 查询多个分类明细下对应的服务
     * @param items
     * @return
     */
    public List<com.vio.Entity.Service> findServiceByCategoryId(List<CategoryItem> items);
}
