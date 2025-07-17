package com.sender.mail.Mail.Sender.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    @Value("${spring.mail.username}")
    private String sender;

    private final JavaMailSender javaMailSender;

    public String sendEmailText(EmailDto dto) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(dto.receiver());
            simpleMailMessage.setSubject(dto.subject());
            simpleMailMessage.setText(dto.text());

            javaMailSender.send(simpleMailMessage);
            return "Email enviado";
        } catch (Exception e){
            return "Failed sending mail" + e.getLocalizedMessage();
        }
    }
}
