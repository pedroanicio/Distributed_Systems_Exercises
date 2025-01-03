package com.br.security_system_backend.service;

import org.springframework.stereotype.Service;

@Service
public class EventProcessor {

    private final ActuatorCommandService actuatorCommandService;

    public EventProcessor(ActuatorCommandService actuatorCommandService) {
        this.actuatorCommandService = actuatorCommandService;
    }

    public void processSensorEvent(String sensorId, String eventType, String value) {
        if (eventType.equals("motion") && value.equalsIgnoreCase("detected")) {
            actuatorCommandService.sendCommand("door_actuator", "lock", "");
        }

        if (eventType.equals("smoke") && value.equalsIgnoreCase("detected")) {
            actuatorCommandService.sendCommand("water_actuator", "ON", "");
        }
    }
}
