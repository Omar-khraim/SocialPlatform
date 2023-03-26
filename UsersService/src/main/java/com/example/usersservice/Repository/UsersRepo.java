package com.example.usersservice.Repository;

import com.example.usersservice.Domain.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    boolean existsByEmail(String email);
    List<Users> findAllByCreationDateIsNotNull();
    List<Users> findAllByDetailsPictureLinkIsNotNull();
}
