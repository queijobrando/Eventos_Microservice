package com.microservice.events.Events.Microservice.api.dto;

public record EmailRequestDto(
        String receiver,
        String subject,
        String text
) {
}