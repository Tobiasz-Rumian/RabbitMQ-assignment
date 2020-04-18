package com.example.monitor.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonitorConfiguration {

    @Bean
    public Queue anonymousQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("tut.fanout");
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("tut.direct");
    }

    @Bean
    public Binding binding(FanoutExchange fanoutExchange,Queue anonymousQueue){
        return BindingBuilder.bind(anonymousQueue).to(fanoutExchange);
    }
}
