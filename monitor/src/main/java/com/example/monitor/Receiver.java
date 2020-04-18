package com.example.monitor;

import com.example.commons.CarParameters;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Receiver {
    private final ObjectMapper objectMapper;
    private final MonitorService monitorService;

    @RabbitListener(queues = "#{anonymousQueue.name}")
    public void receive(String in) throws JsonProcessingException {
        CarParameters carParameters = objectMapper.readValue(in, CarParameters.class);
        System.out.println(" [x] Received '" + in + "'");
        monitorService.checkAndRouteCarInfo(carParameters);
    }
}
