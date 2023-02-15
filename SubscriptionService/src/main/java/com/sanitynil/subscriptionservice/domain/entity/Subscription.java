package com.sanitynil.subscriptionservice.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subscriptions")
public class Subscription implements Serializable {
    @Id
    @Column(name = "subscription_id")
    private Integer subscription_id;
    @Column(name = "order_id")
    private Integer order_id;
    @Column(name = "expiry_date")
    private LocalDate expiry_date;
}
