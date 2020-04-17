package com.example.car;

import com.example.commons.CarParameters;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Random;

@Service
public class CarService {

    private Random randomGenerator = new Random();

    public CarParameters getCarParameters() {
        return CarParameters.of(
                getEngineTemperature(),
                getTirePressure(),
                getOilPressure(),
                getCurrentTime()
        );
    }

    private double getEngineTemperature() {
        return randomGenerator.nextDouble();
    }

    private double getTirePressure() {
        return randomGenerator.nextDouble();
    }

    private double getOilPressure() {
        return randomGenerator.nextDouble();
    }

    private ZonedDateTime getCurrentTime() {
        return ZonedDateTime.now();
    }

}
