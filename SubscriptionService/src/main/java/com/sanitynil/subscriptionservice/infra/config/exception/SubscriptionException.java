package com.sanitynil.subscriptionservice.infra.config.exception;

import org.springframework.http.HttpStatus;

public class SubscriptionException extends CustomException {

    public SubscriptionException(HttpStatus status, String errorMessage) {
        super(status, errorMessage);
    }
}
