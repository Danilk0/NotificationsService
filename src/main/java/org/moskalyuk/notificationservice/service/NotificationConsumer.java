package org.moskalyuk.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.moskalyuk.notificationservice.dto.NotificationRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(NotificationRequest request) {
        emailService.sendEmail(request);
    }
}
