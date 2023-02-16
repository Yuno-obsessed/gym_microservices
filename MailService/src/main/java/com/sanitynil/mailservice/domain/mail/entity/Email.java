package com.sanitynil.mailservice.domain.mail.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "mails")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mail_id")
    private Integer mailId;
    @Column(name = "mail_type", nullable = false, length = 100)
    private EmailType emailType;
    @Column(name = "email", nullable = false, length = 60)
    private String email;
    @Column(name = "sent_date", nullable = false)
    private LocalDate sentDate;

    public Email(EmailDao emailDao){
       this.emailType = emailDao.getEmailType();
       this.email = emailDao.getRecipient();
       this.sentDate = LocalDate.now();
    }

}
