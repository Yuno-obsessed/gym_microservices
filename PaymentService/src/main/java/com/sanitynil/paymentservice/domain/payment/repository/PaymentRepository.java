package com.sanitynil.paymentservice.domain.payment.repository;

import com.sanitynil.paymentservice.domain.payment.entity.Payment;
import com.sanitynil.paymentservice.infra.config.util.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    Optional<Payment> findByPayment_id(Integer id);

    List<Payment> findAllByPayment_status(PaymentStatus status);

    boolean existsByPayment_id(Integer id);
}
