package com.sanitynil.userservice.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserValidate {

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "password")
    private String password;
}
