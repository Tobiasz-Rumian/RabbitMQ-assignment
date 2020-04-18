package com.example.driver.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverConfiguration {

    @Bean
    public Queue anonymousQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("tut.direct");
    }

    @Bean
    public Binding binding(DirectExchange direct, Queue anonymousQueue) {
        return BindingBuilder.bind(anonymousQueue).to(direct).with("Driver");
    }
}
