package com.example.driver.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverConfiguration {

    @Bean
    public Queue warningsAnonymousQueue() {
        return new AnonymousQueue();
    }

    @Bean("WarningsExchange")
    public DirectExchange directExchange() {
        return new DirectExchange("sri.warnings");
    }

    @Bean("TeamLeaderExchange")
    public DirectExchange teamLeaderDirectExchange() {
        return new DirectExchange("sri.teamLeader");
    }

    @Bean
    public Binding binding(@Qualifier("WarningsExchange") DirectExchange direct, Queue anonymousQueue) {
        return BindingBuilder.bind(anonymousQueue).to(direct).with("Driver");
    }
}
