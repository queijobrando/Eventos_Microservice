package com.microservice.events.Events.Microservice.infra.repository;

import com.microservice.events.Events.Microservice.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {
}
