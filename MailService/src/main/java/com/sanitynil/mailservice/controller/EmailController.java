package com.sanitynil.mailservice.controller;

import com.sanitynil.mailservice.domain.mail.Email;
import com.sanitynil.mailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mail-service/send")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/simple",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String sendMail(@RequestBody Email email){
       return emailService.sendSimpleMail(email);
    }
}
