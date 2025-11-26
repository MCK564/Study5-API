package com.mck.study5.notification_service.services;



import com.mck.study5.notification_service.constants.MessageKeys;
import com.mck.study5.notification_service.dto.MailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String mailFrom;

    public String sendHtmlEmail(String toEmail, String subject, String body) throws Exception {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setText(body,true);
            helper.setFrom(mailFrom);
            helper.setTo(toEmail);
            helper.setSubject(subject);

            mailSender.send(mimeMessage);
            return MessageKeys.MAIL_SENT_SUCCESSFULLY+ " to "+ toEmail;
        }catch(Exception e){
            return MessageKeys.MAIL_SEND_FAIL + " to "+ toEmail;
        }
    }
}
