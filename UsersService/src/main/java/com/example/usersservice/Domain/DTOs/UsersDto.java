package com.example.usersservice.Domain.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private long id;
    private String firstName;
    private String lastName;
    private String Password;
    private String email;
    private Date creationDate;
    private Date updatedTime;
}
