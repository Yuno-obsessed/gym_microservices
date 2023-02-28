package com.sanitynil.paymentservice.service;

import com.sanitynil.paymentservice.domain.payment.entity.Payment;
import com.sanitynil.paymentservice.domain.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;

   public void savePayment(Payment payment){
       repository.save(payment);
   }
}
