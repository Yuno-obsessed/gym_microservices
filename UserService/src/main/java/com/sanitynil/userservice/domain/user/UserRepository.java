package com.sanitynil.userservice.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Query("UPDATE User u SET u.username = :username," +
            " u.password = :password, u.age = :age, " +
            " u.country = :country")
    User updateUser(@Param("username") String username, @Param("password") String password,
                    @Param("age") Integer age, @Param("country") String country);

    Optional<User> findByEmailAndPassword(String email, String password);

    List<User> findAll();
}
