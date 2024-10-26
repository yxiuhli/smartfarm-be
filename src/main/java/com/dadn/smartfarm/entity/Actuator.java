package com.dadn.smartfarm.entity;

import jakarta.persistence.*;

@Entity(name = "Actuator")
@Table(name = "actuators")
public class Actuator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actuatorId;
    private String actuatorType;
    private String status;
    private Integer deviceId;
    // getters and setters
}