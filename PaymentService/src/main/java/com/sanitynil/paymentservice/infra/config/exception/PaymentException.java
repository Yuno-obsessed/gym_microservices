package com.sanitynil.paymentservice.infra.config.exception;

import org.springframework.http.HttpStatus;

public class PaymentException extends CustomException {

    public PaymentException(HttpStatus status, String errorMessage) {
        super(status, errorMessage);
    }
}
