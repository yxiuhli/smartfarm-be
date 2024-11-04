package com.dadn.smartfarm.controller;

import com.dadn.smartfarm.model.User;
import com.dadn.smartfarm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "success";
    }

}
