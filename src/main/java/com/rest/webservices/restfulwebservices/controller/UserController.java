package com.rest.webservices.restfulwebservices.controller;

import com.rest.webservices.restfulwebservices.bean.Post;
import com.rest.webservices.restfulwebservices.bean.User;
import com.rest.webservices.restfulwebservices.exceptions.PostNotFoundException;
import com.rest.webservices.restfulwebservices.service.PostService;
import com.rest.webservices.restfulwebservices.service.UserService;
import com.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable Integer id) {
        User user = userService.findOne(id);
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        return new ResponseEntity<>(
                savedUser,
                headers,
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @GetMapping(path = "/users/{id}/posts")
    public List<Post> getPostsForUser(@PathVariable Integer id) {
        return userService.findOne(id).getPosts();
    }

    @PostMapping(path = "/users/{id}/posts")
    public ResponseEntity<Post> createPostsForUser(@PathVariable Integer id, @Valid @RequestBody Post post) {
        User user = userService.findOne(id);
        post.setUser(user);
        Post savedPost = postService.save(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        return new ResponseEntity<>(
                savedPost,
                headers,
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/users/{id}/posts/{pid}")
    public EntityModel<Post> retrieveSinglePostForUser(@PathVariable Integer id, @PathVariable Integer pid) {
        User user = userService.findOne(id);
        List<Post> userPosts = user.getPosts().stream().filter(post -> post.getId().equals(pid)).collect(Collectors.toList());
        if (userPosts.isEmpty()) {
            throw new PostNotFoundException(String.format("Post id %s is not mapped to the user id %s ", pid, id));
        }
        EntityModel<Post> entityModel = EntityModel.of(userPosts.stream().findFirst().get());
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPostsForUser(id));
        entityModel.add(link.withRel("user-posts"));
        return entityModel;
    }
}
