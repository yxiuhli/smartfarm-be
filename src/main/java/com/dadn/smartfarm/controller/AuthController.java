package com.dadn.smartfarm.controller;


import com.dadn.smartfarm.model.User;
import com.dadn.smartfarm.repository.UserRepository;
import com.dadn.smartfarm.dto.LoginRequest;
import com.dadn.smartfarm.dto.RegisterRequest;
import com.dadn.smartfarm.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        // Check if username is already taken
        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new AuthResponse(false, "Username is already taken!"));
        }

        // Check if email is already registered
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new AuthResponse(false, "Email is already registered!"));
        }

        // Create new user
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setPassword(request.getPassword());
        userRepository.save(user);

        return ResponseEntity.ok(new AuthResponse(true, "User registered successfully!"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElse(null);

        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//        if (user == null || !Objects.equals(request.getPassword(), user.getPassword())) {
            return ResponseEntity
                    .badRequest()
                    .body(new AuthResponse(false, "Invalid username or password!"));
        }

        return ResponseEntity.ok(new AuthResponse(true, "Login successful!"));
    }
}
