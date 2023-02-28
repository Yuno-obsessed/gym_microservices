package com.sanitynil.paymentservice.controller;

import com.sanitynil.paymentservice.domain.payment.entity.Payment;
import com.sanitynil.paymentservice.infra.config.util.PaymentStatus;
import com.sanitynil.paymentservice.infra.config.kafka.PaymentProducer;
import com.sanitynil.paymentservice.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/payment-service")
public class PaymentController {

    private final PaymentProducer producer;

    private final PaymentService service;

    private static Integer id = 0;

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createPayment(@RequestBody Payment payment){
//        id++;
//        payment.setPayment_id(id);

//        PaymentEvent paymentEvent = new PaymentEvent();
//        paymentEvent.setStatus("pending");
//        paymentEvent.setMessage("payment status is in pending state");
//        paymentEvent.setPayment(paymentEvent);
        service.savePayment(payment);

        producer.sendMessage(PaymentStatus.STATUS_PENDING);

        return ResponseEntity.ok("Payment is pending...\nWait, please...");
    }
}
