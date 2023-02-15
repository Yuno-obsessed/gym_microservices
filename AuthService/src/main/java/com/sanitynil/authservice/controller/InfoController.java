package com.sanitynil.authservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth-service")
public class InfoController {

    @GetMapping("/home")
    public ResponseEntity<String> home(){
       return ResponseEntity.status(200).body("Home handler");
    }
}
