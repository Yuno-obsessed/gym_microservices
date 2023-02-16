package com.sanitynil.mailservice.service;

import com.sanitynil.mailservice.domain.mail.entity.Email;
import com.sanitynil.mailservice.domain.mail.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public void save(Email email){
       emailRepository.save(email);
    }

    public void delete(Integer id){
        emailRepository.deleteById(id);
    }

    public void deleteByEmailAndDate(String email, LocalDate date) {
        emailRepository.deleteAllByEmailAndSentDate(email,date);
    }

    public Optional<Email> getById(Integer id){
        return emailRepository.getEmailByMailId(id);
    }

    public Optional<List<Email>> getAllByEmail(String email){
        return emailRepository.getEmailsByEmail(email);
    }

    public Optional<List<Email>> getAllByEmailAndDate(String email, LocalDate date){
        return emailRepository.getEmailsByEmailAndSentDate(email,date);
    }
}
