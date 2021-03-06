package com.example.engineer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EngineerConfiguration {

    @Bean
    public Queue anonymousQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("sri.warnings");
    }

    @Bean
    public Binding binding(DirectExchange direct, Queue anonymousQueue) {
        return BindingBuilder.bind(anonymousQueue).to(direct).with("Engineer");
    }
}
