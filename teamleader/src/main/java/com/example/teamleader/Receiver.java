package com.example.teamleader;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class Receiver {
    private final Random randomGenerator = new Random();

    @RabbitListener(queues = "#{anonymousQueue.name}")
    public boolean canDriverGoToPitStop() {
        var response = randomGenerator.nextBoolean();
        System.out.println("Received request for pitStop and responded:" + response);
        return response;
    }
}
