package com.sanitynil.paymentservice.domain.payment.repository;

import com.sanitynil.paymentservice.domain.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
