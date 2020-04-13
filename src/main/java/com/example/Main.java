package com.example;

import com.example.car.CarApplication;
import com.example.logger.LoggerApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        switch (args[0]) {
            case "Car" -> SpringApplication.run(CarApplication.class, args);
            case "Logger" -> SpringApplication.run(LoggerApplication.class, args);
        }
    }
}
