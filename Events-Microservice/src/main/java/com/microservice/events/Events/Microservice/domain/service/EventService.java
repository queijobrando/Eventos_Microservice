package com.microservice.events.Events.Microservice.domain.service;

import com.microservice.events.Events.Microservice.api.dto.EmailRequestDto;
import com.microservice.events.Events.Microservice.api.dto.EventRequestDto;
import com.microservice.events.Events.Microservice.domain.model.Event;
import com.microservice.events.Events.Microservice.domain.model.Subscription;
import com.microservice.events.Events.Microservice.infra.config.exceptions.EventIsFullException;
import com.microservice.events.Events.Microservice.infra.config.exceptions.EventNotFoundException;
import com.microservice.events.Events.Microservice.infra.repository.EventRepository;
import com.microservice.events.Events.Microservice.infra.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final EmailService emailService;

    @Transactional
    public Event createEvent(EventRequestDto dto){
        Event newEvent = new Event(dto);
        return eventRepository.save(newEvent);
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Boolean isEventFull(Event event){
        return event.getRegisteredParticipants() >= event.getMaxParticipants();
    }

    @Transactional
    public void eventSubscribe(UUID eventId, String participantEmail){
        Event event = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);

        if (isEventFull(event)){
            throw new EventIsFullException();
        }

        event.setRegisteredParticipants(event.getRegisteredParticipants() + 1);
        Subscription subscription = new Subscription(event, participantEmail);
        subscriptionRepository.save(subscription);

        EmailRequestDto emailRequest = new EmailRequestDto(participantEmail, "Confirmação de Inscrição", "Você foi inscrito no evento com sucesso!");
        try {
            emailService.sendEmail(emailRequest);
            System.out.println("Enviando email para: " + emailRequest.receiver());
        } catch (Exception e) {
            System.out.println("Erro ao enviar email: " + e.getMessage());
        }
    }

}
