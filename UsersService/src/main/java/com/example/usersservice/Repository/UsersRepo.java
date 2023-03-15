package com.example.usersservice.Repository;

import com.example.usersservice.Domain.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findUsersById(long id);
    boolean existsByEmail(String email);
}
