package com.sanitynil.mailservice.domain.mail.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class EmailAndDate {
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "date")
    private LocalDate date;
}
