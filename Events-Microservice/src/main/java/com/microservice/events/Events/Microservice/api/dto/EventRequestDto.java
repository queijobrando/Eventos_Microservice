package com.microservice.events.Events.Microservice.api.dto;

import java.time.LocalDate;

public record EventRequestDto(
        Integer maxParticipants,
        LocalDate date,
        String title,
        String description
) {
}
