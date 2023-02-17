package com.sanitynil.orderservice.controller;

import com.sanitynil.orderservice.domain.order.entity.Order;
import com.sanitynil.orderservice.domain.order.entity.OrderEvent;
import com.sanitynil.orderservice.service.OrderProducer;
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

    private static Integer id = 0;

    @PostMapping("/order/place")
    public ResponseEntity<String> placeOrder(@RequestBody Order order){
        id++;
        order.setOrder_id(id);

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("pending");
        orderEvent.setMessage("order status is in pending state");
        orderEvent.setOrder(order);

        producer.sendMessage(orderEvent);

        return ResponseEntity.ok("Order placed successfully...");
    }
}
