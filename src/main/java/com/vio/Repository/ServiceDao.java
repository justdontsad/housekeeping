package com.vio.Repository;

import com.vio.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceDao extends JpaRepository<Service,String> {
    public List<Service> findByServiceCategory(String categoryID);
}
