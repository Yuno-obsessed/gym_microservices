package com.sanitynil.mailservice.domain.mail.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
public enum EmailType {
    // Email subject templates
    EMAIL_LOGIN_SUCCESS("Successful login with your email."),
    EMAIL_REGISTER_SUCCESS("Successful register with your email."),
    EMAIL_ORDER_ERROR("Error processing order."),
    EMAIL_ORDER_SUCCESS("Your order was processed with success."),
    EMAIL_SUBSCRIPTION("Here is your QR code");
    private final String value;
}
