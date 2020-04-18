package com.example.engineer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Receiver {

    @RabbitListener(queues = "#{anonymousQueue.name}")
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
    }
}
