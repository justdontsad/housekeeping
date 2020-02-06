package com.vio.Repository;

import com.vio.Entity.CategoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author vio
 * @date 2020-01-20   15:51
 */
public interface CategoryItemDao extends JpaRepository<CategoryItem,String> {
    public List<CategoryItem> findAllByCategoryId(String categoryId);
}
