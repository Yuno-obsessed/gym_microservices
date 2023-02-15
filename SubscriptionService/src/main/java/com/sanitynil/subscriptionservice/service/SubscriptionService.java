package com.sanitynil.subscriptionservice.service;

import com.sanitynil.subscriptionservice.domain.entity.Subscription;
import com.sanitynil.subscriptionservice.domain.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SubscriptionService {
    @Autowired
   private SubscriptionRepository subscriptionRepository;

    public void save(Subscription subscription){
        subscriptionRepository.save(subscription);
    }

    public Optional<Subscription> getByOrderId(Integer id){
        return subscriptionRepository.findSubscriptionByOrder_id(id);
    }

    public Optional<Subscription> getByExpiryDate(LocalDate date){
        return subscriptionRepository.findSubscriptionByExpiry_date(date);
    }

    public boolean isValid(Integer id){
        return subscriptionRepository.getSubscriptionExpiry_dateIfNotExpired(id) != null;
    }
}
