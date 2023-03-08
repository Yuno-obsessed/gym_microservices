package com.sanitynil.subscriptionservice.domain.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sanitynil.subscriptionservice.infra.util.SubscriptionType;
import lombok.Data;

@Data
public class SubscriptionDto {
    @JsonProperty(value = "user_id")
    private Integer userId;
    @JsonProperty(value = "subscription_type")
    private SubscriptionType subscriptionType;
}
