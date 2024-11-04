package com.dadn.smartfarm.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class AuthResponse {
    private boolean success;
    private String message;
}
