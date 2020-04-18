package com.example.car;

import com.example.commons.CarParameters;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Random;

@Service
public class CarService {

    private final Random randomGenerator = new Random();

    public CarParameters getCarParameters() {
        return CarParameters.of(
                getEngineTemperature(),
                getTirePressure(),
                getOilPressure(),
                getCurrentTime()
        );
    }

    private double getEngineTemperature() {
        return 90 + (150 - 90) * randomGenerator.nextDouble();
    }

    private double getTirePressure() {
        return 0.9 + (1.4 - 0.9) * randomGenerator.nextDouble();
    }

    private double getOilPressure() {
        return 680 + (920 - 680) * randomGenerator.nextDouble();
    }

    private ZonedDateTime getCurrentTime() {
        return ZonedDateTime.now();
    }

}
