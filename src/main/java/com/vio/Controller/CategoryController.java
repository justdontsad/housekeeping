package com.vio.Controller;

import com.vio.Entity.CategoryItem;
import com.vio.Service.CategoryService;
import com.vio.dto.CategoryDto;
import com.vio.dto.ResultVO;
import com.vio.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author vio
 * 8 @date 2020-01-20   15:06
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService service;

    @GetMapping("/getCategoryItem")
    public ResultVO<List<CategoryDto>> getCategoryItem(){
        List<CategoryDto> allCategory = service.findAllCategory();
        return ResultVOUtil.success(allCategory);
    }

    /**
     * 根据分类id获取分类明细
     * @param categoryId
     * @return
     */
    @GetMapping("/getItem")
    public ResultVO<CategoryItem> getItem(String categoryId){
        List<CategoryItem> categoryItems=service.findCategoryItemByCategoryId(categoryId);
        return ResultVOUtil.success(categoryItems);
    }




}
