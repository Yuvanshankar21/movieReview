package com.example.movieReview.services;


import com.example.movieReview.domain.model.User;
import com.example.movieReview.infra.adaptor.UserRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {


    @Autowired
    UserRepositoryAdapter adapter;

    public Flux<User> getAllUsers() {
        return adapter.findAll();
    }

    public Mono<User> getUserById(Long id) {
        return adapter.findById(id);
    }

    public Mono<User> addUser(User user) {
        return adapter.save(user);
    }
}
