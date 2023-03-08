package com.sanitynil.userservice.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(required = false)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "username", nullable = false, length = 60)
    private String username;
    @Column(name = "first_name", nullable = false, length = 60)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;
    @Column(name = "email", nullable = false, length = 60)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private Integer age;
    @Column(name = "city", nullable = false, length = 60)
    private String city;

    public User(String email, String password){
        this.email=email;
        this.password=password;
    }

    public User(UserCreateDto dto){
        this.username = dto.getUsername();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.age = dto.getAge();
        this.city = dto.getCity();
    }
}
