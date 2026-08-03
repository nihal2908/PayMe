package com.example.payme.controller;

import com.example.payme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.payme.model.User;
import com.example.payme.dto.CreateUserRequest;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public String createUser(@RequestBody CreateUserRequest request) {
        userService.createUser(request);
        return "User created successfully";
    }
    
}
