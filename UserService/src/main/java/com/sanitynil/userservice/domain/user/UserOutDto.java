package com.sanitynil.userservice.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@Component
public class UserOutDto {

    @JsonProperty(value = "username")
    private String username;
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "first_name")
    private String firstName;
    @JsonProperty(value = "last_name")
    private String lastName;
    @JsonProperty(value = "age")
    private Integer age;
    @JsonProperty(value = "city")
    private String city;
}
