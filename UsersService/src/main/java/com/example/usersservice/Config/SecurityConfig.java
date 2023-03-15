package com.example.usersservice.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
//
//        security.authorizeHttpRequests()
//                .requestMatchers("api/v1/users/***").permitAll()
//                .requestMatchers("api/v1/auth/***").permitAll()
//                .anyRequest()
//                .authenticated();
////                .and()
////                .formLogin();
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//
//        security.csrf().disable();
//        security.httpBasic().disable();
//
////        security.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//        return security.build();
//
//    }

}
