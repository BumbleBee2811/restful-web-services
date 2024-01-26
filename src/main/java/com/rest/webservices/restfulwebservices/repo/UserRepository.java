package com.rest.webservices.restfulwebservices.repo;

import com.rest.webservices.restfulwebservices.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
