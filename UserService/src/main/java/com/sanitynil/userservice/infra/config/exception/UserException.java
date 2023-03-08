package com.sanitynil.userservice.infra.config.exception;

import org.springframework.http.HttpStatus;

public class UserException extends CustomException {

    public UserException(HttpStatus status, String errorMessage) {
        super(status, errorMessage);
    }

}
