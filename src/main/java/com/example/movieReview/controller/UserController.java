package com.example.movieReview.controller;

import com.example.movieReview.domain.model.User;
import com.example.movieReview.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping
    public Flux<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable Long id) {
        return userServiceImpl.getUserById(id);
    }

    @PostMapping
    public Mono<User> addUser(@RequestBody User user) {
        return userServiceImpl.addUser(user);
    }
}
