package com.microservice.events.Events.Microservice.domain.model;

import com.microservice.events.Events.Microservice.api.dto.EventRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name="event")
@Table(name="event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    private Integer maxParticipants;
    private Integer registeredParticipants;
    private LocalDate date;
    private String title;
    private String description;

    public Event(EventRequestDto dto) {
        this.maxParticipants = dto.maxParticipants();
        this.date = dto.date();
        this.title = dto.title();
        this.description = dto.description();
        this.registeredParticipants = 0;
    }
}
