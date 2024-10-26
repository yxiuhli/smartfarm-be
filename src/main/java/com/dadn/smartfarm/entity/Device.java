package com.dadn.smartfarm.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;


@Entity(name = "Device")
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deviceId;
    private String deviceType;
    private String location;
    private Integer userId;
    private Timestamp createdAt;
    private String deviceCategory;
    // getters and setters
}
