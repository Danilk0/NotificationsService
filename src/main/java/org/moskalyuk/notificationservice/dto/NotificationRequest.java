package org.moskalyuk.notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {
    String username;
    String password;
    String email;

    String event;

    public String getSubject(){
     return event+" пользователь "+username;
    }

    public String getMessage(){
        return event + " пользователь с именем - " + username + ", паролем - " + password+" и почтой - "+email;
    }
}
