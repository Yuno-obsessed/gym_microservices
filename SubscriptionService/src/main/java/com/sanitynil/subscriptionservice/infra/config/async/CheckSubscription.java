package com.sanitynil.subscriptionservice.infra.config.async;

import com.sanitynil.subscriptionservice.domain.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@EnableScheduling
public class CheckSubscription {

    private final SubscriptionProducer subscriptionProducer;

    private final SubscriptionRepository subscriptionRepository;

    @Async
    @Scheduled(fixedDelay = 24 * 60 * 60 * 1000) // 1 day in miliseconds
    public void asyncCheckSubscription(){
        System.out.println("Checking if subscription is active...");

        //
    }
}
