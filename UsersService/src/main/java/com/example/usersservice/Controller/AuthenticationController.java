package com.example.usersservice.Controller;


import com.example.usersservice.Domain.DTOs.UsersDto;
import com.example.usersservice.Service.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    private final UsersService usersService;

    public AuthenticationController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public void signUp(@RequestBody UsersDto user){
        usersService.addUser(user);
    }
}
