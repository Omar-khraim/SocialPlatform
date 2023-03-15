package com.example.usersservice.Controller;


import com.example.usersservice.Domain.DTOs.UsersDto;
import com.example.usersservice.Service.UsersService;
import jakarta.servlet.http.HttpServletResponse;
//import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    private final UsersService usersService;

    public AuthenticationController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public void signUp( @RequestBody UsersDto user, HttpServletResponse response) throws IOException {
       int res =usersService.addUser(user);

        if (res == 0) {
            response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
            response.getWriter().write("wrong email format");}
            else if (res == -1) {
                response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
                response.getWriter().write("Email is already taken");
        } else {
            response.setStatus(HttpStatus.OK.value());
        }
    }
}
