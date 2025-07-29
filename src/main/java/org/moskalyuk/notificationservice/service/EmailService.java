package org.moskalyuk.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.moskalyuk.notificationservice.dto.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmailService{

    @Value("${admin.emails.url}")
    private String adminEmailsUrl;

    @Value("${spring.mail.username}")
    private String senderEmail;

    private final JavaMailSender emailSender;
    private final RestTemplate restTemplate;


    public void sendEmail(NotificationRequest notificationRequest) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(senderEmail);
        simpleMailMessage.setTo(getEmails().toArray(new String[0]));
        simpleMailMessage.setSubject(notificationRequest.getSubject());
        simpleMailMessage.setText(notificationRequest.getMessage());
        emailSender.send(simpleMailMessage);
    }

    private List<String> getEmails() {
        ResponseEntity<List<String>> response = restTemplate.exchange(
                adminEmailsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }
}
