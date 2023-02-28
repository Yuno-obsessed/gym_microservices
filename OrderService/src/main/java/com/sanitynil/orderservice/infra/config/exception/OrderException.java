package com.sanitynil.orderservice.infra.config.exception;

import org.springframework.http.HttpStatus;

public class OrderException extends CustomException {

    public OrderException(HttpStatus status, String errorMessage) {
        super(status, errorMessage);
    }
}
