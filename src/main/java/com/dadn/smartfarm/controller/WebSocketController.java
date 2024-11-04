package com.dadn.smartfarm.controller;

import com.dadn.smartfarm.model.Sensor;
import com.dadn.smartfarm.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WebSocketController {

    @Autowired
    SensorService sensorService;

    @MessageMapping("/send")
    @SendTo("/topic/sensors")
    public List<Sensor> send() {

        return sensorService.getAllSensors();
    }
}

