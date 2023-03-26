package com.example.usersservice.Repository;

import com.example.usersservice.Domain.Entity.UserDetails;
import com.example.usersservice.Domain.Entity.Users;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@Transactional
class UsersRepoTest {
    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private UserDetailsRepo detailsRepo;


    @Test
    public void UserRepo_saveAll_ReturnSavedUser(){
        // Arrange
        Users user = Users.builder()
                .firstName("Test Repo")
                .lastName("Unit Testing")
                .email("Test@Tester.com")
                .Password("596633")
                .build();
        //Act
        Users saved = usersRepo.save(user);

        //Assert
        Assertions.assertThat(saved).isNotNull();
    }

    @Test
    public  void Users_findAll_returnTwo(){
        // Arrange
        Users user = Users.builder()
                .firstName("Test Repo")
                .lastName("Unit Testing")
                .email("Test@Tester.com")
                .Password("596633")
                .build();
        Users user2 = Users.builder()
                .firstName("Test ")
                .lastName("User Two")
                .email("TestTwo@Tester.com")
                .Password("596655")
                .build();

        usersRepo.save(user);
        usersRepo.save(user2);

        //Act
        List<Users> listUsers = usersRepo.findAll();

        //Assert
        Assertions.assertThat(listUsers).isNotNull();
    }

    @Test
    public void Users_findById_returnThirdUser(){
        // Arrange

        Users user3 = Users.builder()
                .firstName("Test")
                .lastName("Three")
                .email("TestThree@Tester.com")
                .Password("596655")
                .build();

        usersRepo.save(user3);

        //Act
        Users foundUser = usersRepo.findById(user3.getId()).get();

        //Assert
        Assertions.assertThat(foundUser.getLastName()).isEqualTo(user3.getLastName());

    }

    @Test
    public void Users_UserhasEmail_returnTrue(){
        // Arrange

        Users user3 = Users.builder()
                .firstName("Test")
                .lastName("Three")
                .email("TestThree@Tester.com")
                .Password("596655")
                .build();

        usersRepo.save(user3);

        //Act
        boolean Exists = usersRepo.existsByEmail(user3.getEmail());

        //Assert
        Assertions.assertThat(Exists).isTrue();
    }

    @Test
    public void UserRepo_updateUser_returnTrueFOrChanges(){
        // Arrange

        Users user3 = Users.builder()
                .firstName("Test")
                .lastName("Three")
                .email("TestThree@Tester.com")
                .Password("596655")
                .build();

        usersRepo.save(user3);

        //Act
        Users userSaved = usersRepo.findById(user3.getId()).get();

        userSaved.setEmail("EmailTested@test.com");
        userSaved.setLastName("Updated");

        Users userUpdated = usersRepo.save(userSaved);



        //Assert
        Assertions.assertThat(userUpdated.getLastName()).isNotNull();
        Assertions.assertThat(userUpdated.getLastName()).isEqualTo(userSaved.getLastName());
        Assertions.assertThat(userUpdated.getEmail()).isNotNull();
        Assertions.assertThat(userUpdated.getEmail()).isEqualTo(userSaved.getEmail());
    }

    @Test
    public void Users_deleteById_returnNull(){
        // Arrange

        Users user3 = Users.builder()
                .firstName("Test")
                .lastName("Three")
                .email("TestThree@Tester.com")
                .Password("596655")
                .build();

        usersRepo.save(user3);
        usersRepo.deleteById(user3.getId());

        //Act
        Optional<Users> foundUser = usersRepo.findById(user3.getId());

        //Assert
        Assertions.assertThat(foundUser).isEmpty();

    }

    @Test
    public void Users_fidnByPictureLink_returnAllUsersThatHasPic(){
        // Arrange

        UserDetails details = UserDetails.builder()
                .bio("TestBio")
                .pictureLink("link")
                .gender((byte) 0)
                .build();
        detailsRepo.save(details);
        Users user3 = Users.builder()
                .firstName("Test")
                .lastName("Three")
                .email("TestThree@Tester.com")
                .Password("596655")
                .details(details)
                .build();

        usersRepo.save(user3);

        //Act
//        Users foundUser = usersRepo.findById(user3.getId()).get();

        List<Users> userHasPic = usersRepo.findAllByCreationDateIsNotNull();
        //Assert
//        Assertions.assertThat(foundUser.getDetails().getPictureLink())
//                .isEqualTo(user3.getDetails().getPictureLink());
        Assertions.assertThat(userHasPic).isNotNull();
        Assertions.assertThat(userHasPic.size()).isEqualTo(1);

    }


}