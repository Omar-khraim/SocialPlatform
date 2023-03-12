package com.example.usersservice.Service;


import com.example.usersservice.Domain.DTOs.UsersDto;
import com.example.usersservice.Domain.Entity.Users;

import java.util.List;

public interface UsersService {
    List<UsersDto> findAllUsers();
    UsersDto findUserById(Long id);
    void addUser(UsersDto user);
}
