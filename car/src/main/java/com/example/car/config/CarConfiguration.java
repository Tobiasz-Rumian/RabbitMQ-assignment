package com.example.car.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfiguration {

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("sri.pitStop");
    }

}
