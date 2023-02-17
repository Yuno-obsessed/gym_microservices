package com.sanitynil.paymentservice.domain.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class PaymentEvent {
    private String message;
    private String status;
    private Payment payment;
}
