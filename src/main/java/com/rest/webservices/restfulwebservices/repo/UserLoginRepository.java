package com.rest.webservices.restfulwebservices.repo;

import com.rest.webservices.restfulwebservices.bean.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {
    UserLogin findByUserName(String username);
}
