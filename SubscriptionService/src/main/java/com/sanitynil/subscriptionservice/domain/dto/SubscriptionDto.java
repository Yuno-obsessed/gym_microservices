package com.sanitynil.subscriptionservice.domain.dto;

import com.sanitynil.subscriptionservice.infra.util.SubscriptionType;
import lombok.Data;

@Data
public class SubscriptionDto {
    private SubscriptionType subscriptionType;
}
