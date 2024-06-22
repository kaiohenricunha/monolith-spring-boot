package com.example.monolithspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.monolithspringboot.entity.User;
import com.example.monolithspringboot.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.findByName(name);
    }
}
