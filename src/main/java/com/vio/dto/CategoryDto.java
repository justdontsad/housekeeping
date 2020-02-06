package com.vio.dto;

import com.vio.Entity.Category;
import com.vio.Entity.CategoryItem;

import java.util.List;

/**
 * @author vio
 * @date 2020-01-20   15:58
 */
public class CategoryDto {
    Category category;
    List<CategoryItem> categoryItems;
    public CategoryDto(){}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<CategoryItem> getCategoryItems() {
        return categoryItems;
    }

    public void setCategoryItems(List<CategoryItem> categoryItems) {
        this.categoryItems = categoryItems;
    }
}
