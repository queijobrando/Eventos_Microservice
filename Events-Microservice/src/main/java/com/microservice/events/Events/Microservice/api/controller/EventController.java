package com.microservice.events.Events.Microservice.api.controller;

import com.microservice.events.Events.Microservice.api.dto.EventRequestDto;
import com.microservice.events.Events.Microservice.api.dto.EventSubscribeDto;
import com.microservice.events.Events.Microservice.domain.model.Event;
import com.microservice.events.Events.Microservice.domain.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/events")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventRequestDto dto){
        return ResponseEntity.ok(eventService.createEvent(dto));
    }

    @PostMapping("{eventId}/subscribe")
    public ResponseEntity<?> subscribeEvent(@PathVariable UUID eventId, @RequestBody EventSubscribeDto dto){
        eventService.eventSubscribe(eventId, dto.participantEmail());
        return ResponseEntity.ok(Map.of("message", "Event subscription success"));
    }

}
