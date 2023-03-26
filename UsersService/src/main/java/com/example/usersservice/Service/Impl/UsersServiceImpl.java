package com.example.usersservice.Service.Impl;

import com.example.usersservice.Domain.DTOs.UsersDto;
import com.example.usersservice.Domain.Entity.Users;
import com.example.usersservice.Repository.UsersRepo;
import com.example.usersservice.Service.UsersService;
import com.example.usersservice.Util.EmailValidator;
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
        return modelMapper.map(usersRepo.findById(id).get(), UsersDto.class);
    }

    @Override
    public int addUser(UsersDto user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (!EmailValidator.isValid(user.getEmail()))
            return 0;
        if(usersRepo.existsByEmail(user.getEmail()))
            return -1;
        usersRepo.save(modelMapper.map(user, Users.class));
        return 1;
    }
}
