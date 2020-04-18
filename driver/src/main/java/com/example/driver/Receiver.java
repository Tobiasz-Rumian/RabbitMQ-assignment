package com.example.driver;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class Receiver {

    @RabbitListener(queues = "#{anonymousQueue.name}")
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
    }
}
