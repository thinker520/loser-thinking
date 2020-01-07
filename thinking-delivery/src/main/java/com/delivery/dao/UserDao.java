package com.delivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.delivery.entity.User;

public interface UserDao extends JpaRepository<User, Long>{

}
