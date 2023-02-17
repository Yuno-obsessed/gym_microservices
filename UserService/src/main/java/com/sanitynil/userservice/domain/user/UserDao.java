package com.sanitynil.userservice.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

// Should I map it to user and delete login table,
// or initialize table login that takes the fields it needs
// from user table and work with it?

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserDao {

        @JsonProperty(value = "email")
        private String email;

        @JsonProperty(value = "password")
        private String password;
}
