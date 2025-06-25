package com.ff.clients_service.rabbitmq.events;

import com.ff.clients_service.rabbitmq.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientEventPublisher {
    private final RabbitTemplate rabbitTemplate;

    public void publish(ClientEvent event) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.CLIENT_EXCHANGE,
                RabbitMQConfig.CLIENT_ROUTING,
                event
        );
    }
}
