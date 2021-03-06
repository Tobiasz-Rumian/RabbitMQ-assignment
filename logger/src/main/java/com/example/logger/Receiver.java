package com.example.logger;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class Receiver {
    private final LoggerService loggerService;

    @RabbitListener(queues = "#{anonymousQueue.name}")
    public void receive(String in) throws IOException {
        loggerService.writeToFile(in);
        System.out.println(" [x] Received '" + in + "'");
    }
}
