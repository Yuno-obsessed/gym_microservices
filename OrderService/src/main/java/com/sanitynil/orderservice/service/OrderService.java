package com.sanitynil.orderservice.service;

import com.sanitynil.orderservice.domain.order.entity.Order;
import com.sanitynil.orderservice.domain.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> getOrderById(Integer id){
        return orderRepository.findById(id);
    }
}
