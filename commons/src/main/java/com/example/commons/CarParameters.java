package com.example.commons;

import lombok.Value;

import java.time.ZonedDateTime;

@Value(staticConstructor = "of")
public class CarParameters {
    double engineTemperature;
    double tirePressure;
    double oilPressure;
    ZonedDateTime currentTime;
}
