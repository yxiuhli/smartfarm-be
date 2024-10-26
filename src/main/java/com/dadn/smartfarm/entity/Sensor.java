package com.dadn.smartfarm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity(name = "Sensor")
@Table(name = "sensors")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sensorId;

    @Column(name = "sensor_type")
    private String sensorType;

    @Column(name = "data")
    private String data;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "device_id")
    private Integer deviceId;
}
