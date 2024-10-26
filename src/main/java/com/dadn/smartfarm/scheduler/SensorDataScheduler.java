package com.dadn.smartfarm.scheduler;

import com.dadn.smartfarm.entity.Sensor;
import com.dadn.smartfarm.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Service
@EnableScheduling
@Component
public class SensorDataScheduler {

    private static final Logger logger = LoggerFactory.getLogger(SensorService.class);

    @Autowired
    private SimpMessagingTemplate template;



    @Autowired
    private SensorService sensorService;

    @Scheduled(fixedRate = 10000)
    public void sendSensorData() {
        List<Sensor> sensors = sensorService.getAllSensors();
        logger.info("Sending sensor data: {} sensors found", sensors.size());
        template.convertAndSend("/topic/sensors", sensors);
        logger.info("Sensor data sent successfully");
    }
}

