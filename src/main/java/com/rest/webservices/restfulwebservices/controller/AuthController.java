package com.rest.webservices.restfulwebservices.controller;

import com.rest.webservices.restfulwebservices.bean.AuthRequest;
import com.rest.webservices.restfulwebservices.bean.TokenResponse;
import com.rest.webservices.restfulwebservices.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/generateToken")
    public TokenResponse generateToken(@RequestBody AuthRequest authRequest, HttpServletRequest request) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("invalid username or password");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
}
