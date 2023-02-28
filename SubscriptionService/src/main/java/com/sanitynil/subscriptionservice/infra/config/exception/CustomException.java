package com.sanitynil.subscriptionservice.infra.config.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class CustomException extends RuntimeException{
   private final HttpStatus status;

   public CustomException(HttpStatus status, String errorMessage){
       super(errorMessage);
       this.status = status;
   }
}
