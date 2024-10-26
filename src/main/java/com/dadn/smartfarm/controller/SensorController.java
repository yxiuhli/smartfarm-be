package com.dadn.smartfarm.controller;

import com.dadn.smartfarm.entity.Sensor;
import com.dadn.smartfarm.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {
    @Autowired
    SensorService sensorService;

    @GetMapping("/")
    public List<Sensor> getAllSensor() {
        return sensorService.getAllSensors();
    }

}
