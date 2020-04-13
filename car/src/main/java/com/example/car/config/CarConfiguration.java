package com.example.car.config;

import com.example.car.Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfiguration {

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Bean
    public Sender sender() {
        return new Sender();
    }

}
