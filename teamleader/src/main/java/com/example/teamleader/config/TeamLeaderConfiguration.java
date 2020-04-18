package com.example.teamleader.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeamLeaderConfiguration {

    @Bean
    public Queue anonymousQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("sri.teamLeader");
    }

    @Bean
    public Binding binding(DirectExchange direct, Queue queue) {
        return BindingBuilder.bind(queue).to(direct).with("teamLeader");
    }
}
