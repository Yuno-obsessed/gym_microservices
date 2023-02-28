package com.sanitynil.orderservice.service;

import com.sanitynil.orderservice.domain.order.entity.Order;
import com.sanitynil.orderservice.domain.order.repository.OrderRepository;
import com.sanitynil.orderservice.infra.config.kafka.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;
    private OrderProducer orderProducer;

    @Transactional
    public Order createOrder(Order order){
        ApplicationEvent
    }
}
