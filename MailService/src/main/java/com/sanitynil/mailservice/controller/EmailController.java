package com.sanitynil.mailservice.controller;

import com.sanitynil.mailservice.domain.mail.entity.Email;
import com.sanitynil.mailservice.domain.mail.entity.EmailAndDate;
import com.sanitynil.mailservice.domain.mail.entity.EmailDao;
import com.sanitynil.mailservice.service.EmailSendService;
import com.sanitynil.mailservice.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/mail-service")
public class EmailController {

    private final EmailSendService emailSendService;

    private final EmailService emailService;

    @GetMapping(value = "/send/simple",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendMail(@RequestBody EmailDao emailDao){
        emailService.save(new Email(emailDao));
       return ResponseEntity.ok(emailSendService.sendSimpleMail(emailDao));
    }

    public ResponseEntity<List<Email>> getAllByEmailAndDate(@RequestBody EmailAndDate emailAndDate){
        Optional<List<Email>> emails = emailService.getAllByEmailAndDate(emailAndDate.getEmail(), emailAndDate.getDate());

        return emails.isEmpty() ? ResponseEntity.badRequest().build() : ResponseEntity.ok(emails.orElseThrow());
    }

    public ResponseEntity<List<Email>> getAllByEmail(@RequestBody String email){
        Optional<List<Email>> emails = emailService.getAllByEmail(email);

        return emails.isEmpty() ? ResponseEntity.badRequest().build() : ResponseEntity.ok(emails.orElseThrow());
    }

    public ResponseEntity<String> deleteMail(@RequestBody EmailAndDate emailAndDate){
        emailService.deleteByEmailAndDate(emailAndDate.getEmail(), emailAndDate.getDate());
        return ResponseEntity.ok().build();
    }
}
