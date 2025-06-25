package com.ff.clients_service.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String CLIENT_EXCHANGE = "client.exchange";
    public static final String CLIENT_QUEUE    = "client.queue";
    public static final String CLIENT_ROUTING  = "client.created";

    @Bean TopicExchange clientExchange() { return new TopicExchange(CLIENT_EXCHANGE); }
    @Bean Queue clientQueue() { return new Queue(CLIENT_QUEUE); }
    @Bean Binding clientBinding() {
        return BindingBuilder.bind(clientQueue()).to(clientExchange()).with(CLIENT_ROUTING);
    }
}
