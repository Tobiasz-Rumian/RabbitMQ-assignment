package com.example.monitor;

import com.example.commons.CarParameters;
import com.example.commons.ParameterSeverity;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MonitorService {
    private final DirectExchange directExchange;
    private final RabbitTemplate template;

    public void checkAndRouteCarInfo(CarParameters carParameters) {
        var engineTemperatureStatus = checkEngineTemperature(carParameters.getEngineTemperature());
        var oilPressureStatus = checkOilPressure(carParameters.getOilPressure());
        var tirePressureStatus = checkTirePressure(carParameters.getTirePressure());
        switch (engineTemperatureStatus) {
            case WARN -> sendWarningAboutCar("Driver", "Przekroczona norma temperatury silnika!");
            case ERR -> sendWarningAboutCar("Engineer", "Niebezpiecznie przekroczona norma temperatury silnika!");
        }
        switch (oilPressureStatus) {
            case WARN -> sendWarningAboutCar("Driver", "Przekroczona norma ciśnienia oleju!");
            case ERR -> sendWarningAboutCar("Engineer", "Niebezpiecznie przekroczona norma ciśnienia oleju!");
        }
        switch (tirePressureStatus) {
            case WARN -> sendWarningAboutCar("Driver", "Przekroczona norma ciśnienia w oponach!");
            case ERR -> sendWarningAboutCar("Engineer", "Niebezpiecznie przekroczona norma ciśnienia w oponach!");
        }
    }

    private void sendWarningAboutCar(String routingKey, String message) {
        template.convertAndSend(directExchange.getName(), routingKey, message);
        System.out.println("+++++++++++++++++++++++");
        System.out.println(routingKey + " " + message);
        System.out.println("+++++++++++++++++++++++");
    }

    private ParameterSeverity checkEngineTemperature(double engineTemperature) {
        if (checkIfBetween(engineTemperature, 100, 130)) return ParameterSeverity.OK;
        if (checkIfBetween(engineTemperature, 90, 140)) return ParameterSeverity.WARN;
        return ParameterSeverity.ERR;
    }

    private ParameterSeverity checkOilPressure(double oilPressure) {
        if (checkIfBetween(oilPressure, 700, 900)) return ParameterSeverity.OK;
        if (checkIfBetween(oilPressure, 690, 910)) return ParameterSeverity.WARN;
        return ParameterSeverity.ERR;
    }

    private ParameterSeverity checkTirePressure(double tirePressure) {
        if (checkIfBetween(tirePressure, 1.1, 1.2)) return ParameterSeverity.OK;
        if (checkIfBetween(tirePressure, 1.0, 1.3)) return ParameterSeverity.WARN;
        return ParameterSeverity.ERR;
    }


    private boolean checkIfBetween(double parameter, double min, double max) {
        return parameter >= min && parameter <= max;
    }
}
