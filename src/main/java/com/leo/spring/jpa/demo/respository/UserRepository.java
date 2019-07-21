package com.leo.spring.jpa.demo.respository;

import com.leo.spring.jpa.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
