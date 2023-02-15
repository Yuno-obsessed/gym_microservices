package com.sanitynil.userservice.domain.user;

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
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "username", nullable = false, length = 60)
    private String username;
    @Column(name = "email", nullable = false, length = 60)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private int age;
    @Column(name = "country", nullable = false, length = 60)
    private String country;

    public User(String email, String password){
        this.email=email;
        this.password=password;
    }
}
