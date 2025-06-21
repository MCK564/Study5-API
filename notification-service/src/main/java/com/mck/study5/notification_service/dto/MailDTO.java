package com.mck.study5.notification_service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailDTO {
    private String toEmail;
    private String subject;
    private String body;
}
