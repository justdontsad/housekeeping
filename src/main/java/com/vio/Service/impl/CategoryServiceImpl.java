package com.vio.Service.impl;

import com.vio.Entity.Category;
import com.vio.Entity.CategoryItem;
import com.vio.Repository.CategoryDao;
import com.vio.Repository.CategoryItemDao;
import com.vio.Service.CategoryService;
import com.vio.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vio
 * @date 2020-01-20   16:28
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    CategoryItemDao categoryItemDao;
    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate template;

    @Override
    public List<CategoryDto> findAllCategory() {
        String key = "category";
        List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();
        List<Category> categoryList = categoryDao.findAll();

        //判断redis中是否有数据
        ListOperations<String, CategoryDto> opsForList = template.opsForList();
        long length = opsForList.size(key);
        if (length > 0) {
            //某一范围内的数据
            List<CategoryDto> dtoList = opsForList.range(key, 0, length - 1);
            return dtoList;
        }
        //redis中无数据，进行mysql查询
        for (Category category : categoryList) {
            CategoryDto dto = new CategoryDto();
            dto.setCategory(category);

            String categoryId = category.getCategoryId();
            List<CategoryItem> items = findCategoryItemByCategoryId(categoryId);

            dto.setCategoryItems(items);
            categoryDtoList.add(dto);
        }
        return categoryDtoList;
    }

    @Override
    public List<Category> findCategory(String CategoryId) {
        return null;
    }

    @Override
    public List<CategoryItem> findCategoryItemByCategoryId(String categoryId) {
        return categoryItemDao.findAllByCategoryId(categoryId);
    }

    @Override
    public CategoryItem findCategoryItemById(String categoryId) {
        return categoryItemDao.findById(categoryId).orElse(null);
    }
}
