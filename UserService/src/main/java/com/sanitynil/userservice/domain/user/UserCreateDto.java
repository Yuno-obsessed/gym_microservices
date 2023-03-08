package com.sanitynil.userservice.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

// Should I map it to user and delete login table,
// or initialize table login that takes the fields it needs
// from user table and work with it?

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserCreateDto {

        @JsonProperty(value = "username")
        private String username;
        @JsonProperty(value = "first_name")
        private String firstName;
        @JsonProperty(value = "last_name")
        private String lastName;
        @JsonProperty(value = "email")
        private String email;
        @JsonProperty(value = "password")
        private String password;
        @JsonProperty(value = "age")
        private Integer age;
        @JsonProperty(value = "city")
        private String city;
}
