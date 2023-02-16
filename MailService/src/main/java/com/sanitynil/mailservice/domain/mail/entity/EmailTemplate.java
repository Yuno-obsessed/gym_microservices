package com.sanitynil.mailservice.domain.mail.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
public enum EmailTemplate {
    // Email body templates
    EMAIL_LOGIN_SUCCESS("Successful login from your "),
    EMAIL_LOGIN_FAIL("some"),
    EMAIL_REGISTER_SUCCESS("You were registered successfully.\\nThank you for choosing us."),
    EMAIL_ORDER_ERROR("text"),
    EMAIL_ORDER_SUCCESS("about"),
    EMAIL_SUBSCRIPTION("this");
    private final String value;
}
