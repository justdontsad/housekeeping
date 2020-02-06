package com.vio.Repository;

import com.vio.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface UserDao extends JpaRepository<User,String> {
    List<User> findUserByUserTel(String tel);
}
