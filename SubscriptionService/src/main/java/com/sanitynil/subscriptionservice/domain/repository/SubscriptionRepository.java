package com.sanitynil.subscriptionservice.domain.repository;

import com.sanitynil.subscriptionservice.domain.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;


@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    Optional<Subscription> findSubscriptionByOrder_id(Integer id);
    Optional<Subscription> findSubscriptionByExpiry_date(LocalDate date);

    @Query("SELECT s.expiry_date from Subscription s where s.subscription_id=:id")
    LocalDate getSubscriptionExpiry_date(@Param("subscription_id") Integer id);

    @Query("SELECT s.expiry_date from Subscription s where s.subscription_id=:id and s.expiry_date > CURRENT_DATE ")
    LocalDate getSubscriptionExpiry_dateIfNotExpired(@Param("subscription_id") Integer id);
}
