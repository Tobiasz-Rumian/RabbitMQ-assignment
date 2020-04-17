package com.example.logger;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RabbitListener(queues = "hello")
@RequiredArgsConstructor
@Component
public class Receiver {
    private final LoggerService loggerService;

    @RabbitHandler
    public void receive(String in) throws IOException {
        loggerService.writeToFile(in);
        System.out.println(" [x] Received '" + in + "'");
    }
}
