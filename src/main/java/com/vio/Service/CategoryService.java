package com.vio.Service;

import com.vio.Entity.Category;
import com.vio.Entity.CategoryItem;
import com.vio.Entity.City;
import com.vio.dto.CategoryDto;

import java.util.List;

/**
 * @author vio
 * 1.分类相关
 * 2.分类明细相关
 * @date 2020-01-20   16:18
 */
public interface CategoryService {
    /**
     * 获取所有的分类
     * 组装成CategoryDto类
     * @return
     */
    public List<CategoryDto> findAllCategory();


    /**
     * 根据分类明细的categoryId查找分类
     * @param categoryId 分类明细id
     */
    public List<Category> findCategory(String categoryId);

    /**
     * 根据分类id获取分类明细
     * @param CategoryId  分类id
     */
    public List<CategoryItem> findCategoryItemByCategoryId(String CategoryId);

    /**
     * 根据分类明细Id获取对应的分类明细
     * @param categoryItemId 分类明细Id
     * @return
     */
    public CategoryItem findCategoryItemById(String categoryItemId);

}
