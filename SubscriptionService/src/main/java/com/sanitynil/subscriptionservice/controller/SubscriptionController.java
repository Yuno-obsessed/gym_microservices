package com.sanitynil.subscriptionservice.controller;

import com.sanitynil.subscriptionservice.domain.subscription.SubscriptionDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/subscription-service")
public class SubscriptionController {

    @PostMapping(value = "/subscribe",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> subscribe(@RequestBody SubscriptionDto subscriptionDto){

        //
        return ResponseEntity.ok("Success");
    }
}
