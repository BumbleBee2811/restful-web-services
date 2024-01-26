package com.rest.webservices.restfulwebservices.repo;

import com.rest.webservices.restfulwebservices.bean.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
