package com.sanitynil.mailservice.domain.mail.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
public class EmailDao {
    // For json requests to this service?
    private String recipient;
    private EmailType emailType;
    private EmailTemplate emailTemplate;
    private String username;
}
