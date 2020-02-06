package com.vio.Repository;

import com.vio.Entity.Category;
import com.vio.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author vio
 * @date 2020-01-29   21:24
 */
public interface CityDao  extends JpaRepository<City,String> {

}
