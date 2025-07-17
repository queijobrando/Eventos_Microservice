package com.sender.mail.Mail.Sender.api;

import com.sender.mail.Mail.Sender.domain.EmailDto;
import com.sender.mail.Mail.Sender.domain.MailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/email")
@AllArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestBody EmailDto dto){
        System.out.println("Recebido email para: " + dto.receiver());
        return ResponseEntity.ok(mailService.sendEmailText(dto));
    }

}
