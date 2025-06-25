package com.ff.clients_service.rabbitmq.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEvent {
    private Long id;
    private Long clientId;
    private String name;
    private String email;
    private LocalDateTime createdAt;

    public ClientEvent(Long id, String email, LocalDateTime now) {
        this.id = id;
        this.email = email;
        this.createdAt = now;
    }
}
