package org.moskalyuk.notificationservice.controller;

import lombok.RequiredArgsConstructor;
import org.moskalyuk.notificationservice.dto.NotificationRequest;
import org.moskalyuk.notificationservice.service.EmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public String sendTestEmail(@RequestBody NotificationRequest request) {
        emailService.sendEmail(request);
        return "Sent";
    }
}
