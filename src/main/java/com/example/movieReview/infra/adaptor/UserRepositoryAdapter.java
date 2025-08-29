package com.example.movieReview.infra.adaptor;

import com.example.movieReview.domain.model.Review;
import com.example.movieReview.domain.model.User;
import com.example.movieReview.infra.entity.UserEntity;
import com.example.movieReview.infra.repository.UserR2dbcRepository;
import com.example.movieReview.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter{



    private final UserR2dbcRepository userRepo;
    private final UserMapper mapper;

    public Flux<User> findAll() {
        return userRepo.findAll()
                .map(mapper::toDomain);
    }

    public Mono<User> findById(Long id) {
        return userRepo.findById(id)
                .map(mapper::toDomain);
    }

    public Mono<User> save(User user) {
        return userRepo.save(mapper.toEntity(user))
                .map(mapper::toDomain);
    }
}
