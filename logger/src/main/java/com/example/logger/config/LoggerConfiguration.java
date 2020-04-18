package com.example.logger.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfiguration {

    @Bean
    public Queue anonymousQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("sri.pitStop");
    }

    @Bean
    public Binding binding(FanoutExchange fanoutExchange, Queue anonymousQueue) {
        return BindingBuilder.bind(anonymousQueue).to(fanoutExchange);
    }
}
