package com.sanitynil.orderservice.controller;

import com.sanitynil.orderservice.domain.order.entity.Order;
import com.sanitynil.orderservice.infra.config.kafka.OrderProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/order-service")
public class OrderController {

    private final OrderProducer producer;


    @PostMapping("/order/place")
    public ResponseEntity<String> placeOrder(@RequestBody Order order){

//        producer.sendMessage(order);

        return ResponseEntity.ok("Order placed successfully...");
    }
}
