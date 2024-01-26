package com.rest.webservices.restfulwebservices.service;

import com.rest.webservices.restfulwebservices.bean.Post;
import com.rest.webservices.restfulwebservices.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }
}
