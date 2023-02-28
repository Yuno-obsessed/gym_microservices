package com.sanitynil.paymentservice.domain.payment.repository;

import com.sanitynil.paymentservice.infra.config.exception.PaymentException;
import org.springframework.stereotype.Repository;

@Repository
abstract class PaymentGoogleRepository implements PaymentMethodRepository {
    @Override
    public void pay(Integer amount) throws PaymentException {
       //
    }
}
