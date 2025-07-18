package com.microservice.events.Events.Microservice.infra.repository;

import com.microservice.events.Events.Microservice.domain.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
