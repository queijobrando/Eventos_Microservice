package com.microservice.events.Events.Microservice.domain.service;

import com.microservice.events.Events.Microservice.api.dto.EmailRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "email-service", url = "http://mail:8081/api/email")
public interface EmailService {

    @PostMapping("/send")
    void sendEmail(@RequestBody EmailRequestDto emailRequest);

}
