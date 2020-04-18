package com.example.car;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Sender {
    private final CarService carService;
    private final RabbitTemplate template;
    private final ObjectMapper objectMapper;
    private final FanoutExchange fanoutExchange;

    @Scheduled(fixedDelay = 15000)
    public void send() throws JsonProcessingException {
        String carParametersJson = objectMapper.writeValueAsString(carService.getCarParameters());
        template.convertAndSend(fanoutExchange.getName(), "", carParametersJson);
        System.out.println("Sent '" + carParametersJson + "'");
    }
}
