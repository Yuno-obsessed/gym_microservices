package com.sanitynil.mailservice.service;

import com.sanitynil.mailservice.domain.mail.entity.EmailDao;
import com.sanitynil.mailservice.domain.mail.repository.EmailSendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService implements EmailSendRepository {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendSimpleMail(EmailDao emailDao) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(emailDao.getRecipient());
            mailMessage.setText(emailDao.getEmailTemplate().getValue());
            mailMessage.setSubject(emailDao.getEmailType().getValue());

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully.";
        } catch (Exception e){
            return "Error Sending mail" + e.getMessage();
        }
    }
}
