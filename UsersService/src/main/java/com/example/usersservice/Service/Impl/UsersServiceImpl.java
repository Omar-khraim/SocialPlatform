package com.example.usersservice.Service.Impl;

import com.example.usersservice.Domain.DTOs.UsersDto;
import com.example.usersservice.Repository.UsersRepo;
import com.example.usersservice.Service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {


    private final UsersRepo usersRepo;
    private final ModelMapper modelMapper;

    public UsersServiceImpl(UsersRepo usersRepo, ModelMapper modelMapper) {
        this.usersRepo = usersRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UsersDto> findAllUsers() {
        return null;
    }

    @Override
    public UsersDto findUserById(Long id) {
        return modelMapper.map(usersRepo.findUsersById(id), UsersDto.class);
    }
}
