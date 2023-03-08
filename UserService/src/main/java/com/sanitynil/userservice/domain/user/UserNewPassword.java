package com.sanitynil.userservice.domain.user;

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
public class UserNewPassword {

    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "old_password")
    private String oldPassword;
    @JsonProperty(value = "new_password")
    private String newPassword;
    @JsonProperty(value = "repeat_new_password")
    private String repeatNewPassword;
}
