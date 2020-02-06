package com.vio.Repository;

import com.vio.Entity.Category;
import com.vio.Entity.CategoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,String> {
    public Category findByCategoryId(String categoryId);
}
