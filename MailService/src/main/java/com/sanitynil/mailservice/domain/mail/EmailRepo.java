package com.sanitynil.mailservice.domain.mail;

public interface EmailRepo {
    String sendSimpleMail(Email email);
//    String sendMailWithAttachment(Email email);
}
