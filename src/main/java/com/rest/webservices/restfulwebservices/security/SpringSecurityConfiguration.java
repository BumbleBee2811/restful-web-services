package com.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // All request should be authenticated
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        // Adding basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());

        // Disable CSRF
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }
}
