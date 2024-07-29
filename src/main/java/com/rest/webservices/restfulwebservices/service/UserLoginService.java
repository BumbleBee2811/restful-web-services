package com.rest.webservices.restfulwebservices.service;

import com.rest.webservices.restfulwebservices.bean.UserLogin;
import com.rest.webservices.restfulwebservices.repo.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserLoginService implements UserDetailsService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin userLogin = userLoginRepository.findByUserName(username);
        return new User(userLogin.getUserName(), userLogin.getPassword(),new ArrayList<>());
    }
}
