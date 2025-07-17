package com.microservice.events.Events.Microservice.infra.config.exceptions;

public class EventNotFoundException extends RuntimeException{

    public EventNotFoundException(){
        super("Event not found");
    }

    public EventNotFoundException(String message) {
        super(message);
    }

}
