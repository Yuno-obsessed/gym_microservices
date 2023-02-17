package com.sanitynil.paymentservice.controller;

import com.sanitynil.paymentservice.domain.payment.entity.Payment;
import com.sanitynil.paymentservice.domain.payment.entity.PaymentEvent;
import com.sanitynil.paymentservice.service.PaymentProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/payment-service")
public class PaymentController {

    private final PaymentProducer producer;

    private static Integer id = 0;

    public ResponseEntity<String> createPayment(@RequestBody Payment payment){
        id++;
        payment.setPayment_id(id);

        PaymentEvent paymentEvent = new PaymentEvent();
        paymentEvent.setStatus("pending");
        paymentEvent.setMessage("payment status is in pending state");
        paymentEvent.setPayment(payment);

        producer.sendMessage(paymentEvent);

        return ResponseEntity.ok("Payment is pending...\nWait, please...");
    }
}
