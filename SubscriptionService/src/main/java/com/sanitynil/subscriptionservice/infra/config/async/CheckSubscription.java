package com.sanitynil.subscriptionservice.infra.config.async;

import com.sanitynil.subscriptionservice.domain.subscription.SubscriptionRepository;
import com.sanitynil.subscriptionservice.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
@EnableScheduling
public class CheckSubscription {

    private final SubscriptionProducer subscriptionProducer;

    private final SubscriptionService subscriptionService;

    @Async
    @Scheduled(fixedDelay = 24 * 60 * 60 * 1000) // 1 day in miliseconds
    public void asyncCheckSubscription(){
        List<String> emails = subscriptionService.getSubscriptionsExpireInWeek();
        System.out.println("Checking if subscription is active...");

        //
    }
}
