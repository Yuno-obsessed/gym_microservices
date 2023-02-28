package com.sanitynil.paymentservice.domain.payment.repository;

import com.sanitynil.paymentservice.infra.config.exception.PaymentException;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository {
    void pay(Integer amount) throws PaymentException;
}
