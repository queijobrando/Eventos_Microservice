package com.sender.mail.Mail.Sender.domain;

public record EmailDto(
        String receiver,
        String subject,
        String text
) {
}
