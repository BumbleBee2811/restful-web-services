package com.rest.webservices.restfulwebservices.service;

import com.rest.webservices.restfulwebservices.bean.User;
import com.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import com.rest.webservices.restfulwebservices.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new UserNotFoundException("No data available in the database");
        }
        return users;
    }

    public User findOne(int id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException(String.format("Invalid user id %s", id));
        }
        return user.get();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
