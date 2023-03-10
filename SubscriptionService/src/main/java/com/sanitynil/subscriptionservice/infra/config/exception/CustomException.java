package com.sanitynil.subscriptionservice.infra.config.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Getter
public abstract class CustomException extends RuntimeException{

   private final HttpStatus status;
   private final LocalDate localDate;

   public CustomException(HttpStatus status, String errorMessage){
       super(errorMessage);
       this.status = status;
       this.localDate = LocalDate.now();
   }
}
