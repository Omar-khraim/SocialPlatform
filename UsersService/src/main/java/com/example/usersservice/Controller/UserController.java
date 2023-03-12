package com.example.usersservice.Controller;

import com.example.usersservice.Domain.DTOs.UsersDto;
import com.example.usersservice.Service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/{id}")
    UsersDto findUserById(@PathVariable long id){
        return usersService.findUserById(id);
    }

}
