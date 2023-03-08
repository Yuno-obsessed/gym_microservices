package com.sanitynil.subscriptionservice.service;

import com.sanitynil.subscriptionservice.domain.subscription.Subscription;
import com.sanitynil.subscriptionservice.domain.subscription.SubscriptionDto;
import com.sanitynil.subscriptionservice.domain.subscription.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public void save(SubscriptionDto subscriptionDto){
        Subscription subscription =
                new Subscription.SubscriptionBuilder(subscriptionDto).
                        setStartAndExpiryDate(LocalDate.now()).
                        build();
        subscriptionRepository.save(subscription);
    }

    public boolean isValid(Integer id){
        return subscriptionRepository.getSubscriptionExpiry_dateIfNotExpired(id) != null;
    }

    public Optional<List<String>> getSubscriptionsExpireInWeek(){
        LocalDate expireBetween = LocalDate.now().plusDays(6L);
       return subscriptionRepository.findSubscriptionExpiresIn(expireBetween, expireBetween.plusDays(1L));
    }
}
