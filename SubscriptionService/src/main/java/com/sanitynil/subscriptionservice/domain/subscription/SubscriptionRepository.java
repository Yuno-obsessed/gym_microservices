package com.sanitynil.subscriptionservice.domain.subscription;

import com.sanitynil.subscriptionservice.infra.util.SubscriptionStatus;
import com.sanitynil.subscriptionservice.infra.util.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    @Query("SELECT u.email FROM users u JOIN Subscription s WHERE s.expiryDate IN (:from, :to)")
    Optional<List<String>> findSubscriptionExpiresIn(@Param("from") LocalDate from, @Param("to") LocalDate to);

    @Query("SELECT s.expiryDate FROM Subscription s WHERE s.subscriptionId=:id")
    LocalDate getSubscriptionExpiry_date(@Param("subscription_id") Integer id);

    @Query("SELECT s.expiryDate FROM Subscription s WHERE s.subscriptionId=:id AND s.expiryDate > CURRENT_DATE")
    LocalDate getSubscriptionExpiry_dateIfNotExpired(@Param("subscription_id") Integer id);

    @Modifying
    @Query("UPDATE Subscription s SET s.subscriptionStatus=:status WHERE s.subscriptionId=:id")
    void updateSubscriptionStatus(@Param("subscription_id") Integer id,
                                  @Param("subscription_status") SubscriptionStatus status);
}
