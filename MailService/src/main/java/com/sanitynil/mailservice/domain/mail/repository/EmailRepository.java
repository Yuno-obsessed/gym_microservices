package com.sanitynil.mailservice.domain.mail.repository;

import com.sanitynil.mailservice.domain.mail.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {
    void deleteAllByEmailAndSentDate(String email, LocalDate sentDate);
    Optional<Email> getEmailByMailId(Integer id);
    Optional<List<Email>> getEmailsByEmail(String email);
    Optional<List<Email>> getEmailsByEmailAndSentDate(String email, LocalDate sentDate);
}
