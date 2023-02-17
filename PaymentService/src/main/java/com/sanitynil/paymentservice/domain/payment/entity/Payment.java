package com.sanitynil.paymentservice.domain.payment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer payment_id;
    @Column(name = "subscription_id")
    private Integer subscription_id;
    @Column(name = "payment_date")
    private LocalDate payment_date;
    @Column(name = "payment_status")
    private String payment_status;
    @Column(name = "payment_amount")
    private Integer payment_amount;
    @Column(name = "payment_method")
    private PaymentMethod payment_method;
}
