package com.example.driver;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Receiver {

    @RabbitListener(queues = "#{warningsAnonymousQueue.name}")
    public void receiveWarnings(String in) {
        System.out.println(" [x] Received '" + in + "'");
    }
}
