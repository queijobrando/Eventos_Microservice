package com.microservice.events.Events.Microservice.infra.config.exceptions;

public class EventIsFullException extends RuntimeException{

    public EventIsFullException(){
        super("Event is full");
    }

    public EventIsFullException(String message){
        super(message);
    }
}
