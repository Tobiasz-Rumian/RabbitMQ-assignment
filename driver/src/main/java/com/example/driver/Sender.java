package com.example.driver;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    private final RabbitTemplate template;
    private final DirectExchange teamLeaderExchange;

    public Sender(RabbitTemplate template, @Qualifier("TeamLeaderExchange") DirectExchange teamLeaderExchange) {
        this.template = template;
        this.teamLeaderExchange = teamLeaderExchange;
    }


    @Scheduled(fixedDelay = 15000)
    public void send() {
        Boolean response = (Boolean) template.convertSendAndReceive(
                teamLeaderExchange.getName(),
                "teamLeader",
                ""
        );
        System.out.println("Team leader responded with: '" + response + "'");
    }
}
