package com.example.usersservice.Service.Impl;

import com.example.usersservice.Domain.DTOs.UsersDto;
import com.example.usersservice.Domain.Entity.Users;
import com.example.usersservice.Repository.UsersRepo;
import com.example.usersservice.Service.UsersService;
import org.modelmapper.ModelMapper;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {


    private final UsersRepo usersRepo;
    private final ModelMapper modelMapper;
//    private final PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepo usersRepo, ModelMapper modelMapper) {
        this.usersRepo = usersRepo;
        this.modelMapper = modelMapper;
//        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UsersDto> findAllUsers() {
        return null;
    }

    @Override
    public UsersDto findUserById(Long id) {
        return modelMapper.map(usersRepo.findUsersById(id), UsersDto.class);
    }

    @Override
    public void addUser(UsersDto user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepo.save(modelMapper.map(user, Users.class));
    }
}
