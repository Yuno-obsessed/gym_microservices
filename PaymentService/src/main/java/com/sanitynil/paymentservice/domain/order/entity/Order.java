package com.sanitynil.paymentservice.domain.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Setter
@Getter
@Component
public class Order {
    private Integer order_id;
    private String order_status;
    private Integer user_id;
}
