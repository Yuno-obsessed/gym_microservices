package com.sanitynil.subscriptionservice.domain.subscription;

import com.sanitynil.subscriptionservice.infra.util.SubscriptionStatus;
import com.sanitynil.subscriptionservice.infra.util.SubscriptionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subscriptions")
public class Subscription implements Serializable {
    @Id
    @Column(name = "subscription_id")
    private Integer subscriptionId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "expiry_date")
    private LocalDate expiryDate;
    @Column(name = "subscription_type")
    private SubscriptionType subscriptionType;
    @Column(name = "subscription_status")
    private SubscriptionStatus subscriptionStatus;
    public Subscription(SubscriptionBuilder builder){
        this.userId = builder.subscriptionDto.getUserId();
        this.startDate = builder.startDate;
        this.expiryDate = builder.expiryDate;
        this.subscriptionType = builder.subscriptionDto.getSubscriptionType();
        this.subscriptionStatus = SubscriptionStatus.PENDING;
    }


    public static class SubscriptionBuilder{
        private SubscriptionDto subscriptionDto;
        private LocalDate startDate;
        private LocalDate expiryDate;

        public SubscriptionBuilder(SubscriptionDto dto){
            this.subscriptionDto = dto;
        }

        public SubscriptionBuilder setStartAndExpiryDate(LocalDate date){
            this.startDate = date;
            long duration = 0;
            switch (this.subscriptionDto.getSubscriptionType()){
                case ANNUAL -> duration = 12L;
                case SEMIANNUAL -> duration = 6L;
                case MONTHLY -> duration = 1L;
            }
            this.expiryDate = date.plusMonths(duration);
            return this;
        }

        public Subscription build(){
            return new Subscription(this);
        }
    }
}
