package com.example.usersservice.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String phoneNumber;
    private String pictureLink;
    private byte gender;
    private String bio;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;


    @OneToOne
    Users user;

    @PreUpdate
    public void onUpdate() {
        this.updatedTime = new Date();
    }


}