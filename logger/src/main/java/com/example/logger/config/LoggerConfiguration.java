package com.example.logger.config;

import com.example.logger.Receiver;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfiguration {


    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }
}