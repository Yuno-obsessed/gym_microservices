package com.sanitynil.authservice.domain.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class LoginDao {
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "password")
    private String password;
}
