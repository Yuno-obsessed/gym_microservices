package com.sanitynil.mailservice.domain.mail.repository;

import com.sanitynil.mailservice.domain.mail.entity.EmailDao;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailSendRepository {
    String sendSimpleMail(EmailDao emailDao);
    // add send qr code in pdf as attachment
//    String sendMailWithAttachment(Email email);

}
