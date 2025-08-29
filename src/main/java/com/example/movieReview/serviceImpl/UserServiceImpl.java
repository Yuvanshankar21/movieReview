package com.example.movieReview.serviceImpl;


import com.example.movieReview.domain.model.User;
import com.example.movieReview.infra.adaptor.UserRepositoryAdapter;
import com.example.movieReview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepositoryAdapter adapter;

    @Override
    public Flux<User> getAllUsers() {
        return adapter.findAll();
    }

    @Override
    public Mono<User> getUserById(Long id) {
        return adapter.findById(id);
    }

    @Override
    public Mono<User> addUser(User user) {
        return adapter.save(user);
    }
}
