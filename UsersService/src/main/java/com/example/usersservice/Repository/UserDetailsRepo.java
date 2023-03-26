package com.example.usersservice.Repository;

import com.example.usersservice.Domain.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Long> {
}
