package com.sanitynil.orderservice.domain.order.dto;

import lombok.Builder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Builder
public class OrderDto {
    private int amount;
    private LocalDateTime orderDate;
}