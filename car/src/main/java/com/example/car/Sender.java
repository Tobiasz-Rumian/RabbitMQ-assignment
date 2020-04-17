package com.example.car;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Sender {
    private final CarService carService;
    private final RabbitTemplate template;
    private final Queue queue;
    private final ObjectMapper objectMapper;

    @Scheduled(fixedDelay = 1000)
    public void send() throws JsonProcessingException {
        String carParametersJson = objectMapper.writeValueAsString(carService.getCarParameters());
        this.template.convertAndSend(queue.getName(), carParametersJson);
        System.out.println(" [x] Sent '" + carParametersJson + "'");
    }
}
