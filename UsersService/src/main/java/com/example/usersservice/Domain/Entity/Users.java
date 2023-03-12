package com.example.usersservice.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(indexes ={@Index(columnList = "id", name = "userIdIndex")})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    @Basic(fetch = FetchType.LAZY)
    private String Password;

    @Column(unique = true)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @PreUpdate
    public void onUpdate() {
        this.updatedTime = new Date();
    }


}
