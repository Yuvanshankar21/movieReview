package com.example.movieReview.infra.adaptor;

import com.example.movieReview.domain.model.Review;
import com.example.movieReview.domain.model.User;
import com.example.movieReview.infra.entity.UserEntity;
import com.example.movieReview.infra.repository.UserR2dbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserRepositoryAdapter{


    @Autowired
    UserR2dbcRepository userRepo;

    public Flux<User> findAll() {
        return userRepo.findAll()
                .map(e -> new User(e.id(), e.name(), e.email()));
    }

    public Mono<User> findById(Long id) {
        return userRepo.findById(id)
                .map(e -> new User(e.id(), e.name(), e.email()));
    }

    public Mono<User> save(User user) {
        return userRepo.save(new UserEntity(user.id(), user.name(), user.email()))
                .map(e -> new User(e.id(), e.name(), e.email()));
    }
}
