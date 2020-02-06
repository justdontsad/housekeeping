package com.vio.Controller;

import com.vio.Entity.CategoryItem;
import com.vio.Entity.Service;
import com.vio.Service.CategoryService;
import com.vio.Service.ServiceService;
import com.vio.dto.ResultVO;
import com.vio.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author vio
 * @date 2020-01-30   20:44
 */
@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @Autowired
    CategoryService categoryService;

    /**
     * 获取分类明细下的所有服务
     * @param id   分类明细ID
     * @return
     */
    @GetMapping("/ServiceList")
    public ResultVO<Service> getServiceByCategoryId(String id ) {
        CategoryItem item = categoryService.findCategoryItemById(id);
        List<Service> serviceByCategoryId = serviceService.findServiceByCategoryId(item);
        return ResultVOUtil.success(serviceByCategoryId);
    }

    /**
     * 获取分类下的所有服务
     * @param id  分类id
     * @return
     */
    @GetMapping("/AllServiceList")
    public ResultVO<Service> getServiceByCategoryItemId(String id){
        /**
         * 1.根据id获取所有的明细
         * 2.循环明细，查出所有服务
         */
        List<CategoryItem> categoryItems = categoryService.findCategoryItemByCategoryId(id);
        List<Service> serviceByCategoryId = serviceService.findServiceByCategoryId(categoryItems);
        return ResultVOUtil.success(serviceByCategoryId);
    }
}
