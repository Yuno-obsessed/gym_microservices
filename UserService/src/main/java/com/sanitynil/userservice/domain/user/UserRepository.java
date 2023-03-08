package com.sanitynil.userservice.domain.user;

import com.sanitynil.userservice.infra.config.exception.UserException;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Query("UPDATE User u SET u.email = :email," +
            " u.username = :username, " +
            " u.firstName = :firstName, " +
            " u.lastName = :lastName," +
            " u.age = :age, u.city = :city " +
            " WHERE u.userId=:id")
    void updateUser(@Param("id") Integer id,
                    @Param("username") String username,
                    @Param("firstName") String firstName,
                    @Param("lastName") String lastName,
                    @Param("age") Integer age,
                    @Param("city") String city
    );

    Optional<User> findByEmailAndPassword(String email, String password);

    @Query("SELECT u.username, u.email, " +
            "u.firstName, u.lastName, u.age, " +
            "u.city FROM User u")
    List<UserOutDto> safeFindAll();

    boolean existsByPasswordAndEmail(String password, String email);

    boolean existsByEmail(String email);

    @Modifying
    @Query("UPDATE User u Set u.password = :newPassword " +
            "WHERE u.password = :oldPassword AND u.email = :email")
    void changePassword(@Param("email") String email,
                        @Param("oldPassword") String oldPassword,
                        @Param("newPassword") String newPassword);
}
