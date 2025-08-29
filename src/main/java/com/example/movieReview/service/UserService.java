package com.example.movieReview.service;

import com.example.movieReview.domain.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    public Flux<User> getAllUsers();
    public Mono<User> getUserById(Long id);
    public Mono<User> addUser(User user);
}
