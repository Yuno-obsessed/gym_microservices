package com.sanitynil.mailservice.domain.mail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class Email {

    private String recipient;
    private String body;
    private String subject;
}
