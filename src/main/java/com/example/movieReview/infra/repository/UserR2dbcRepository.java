package com.example.movieReview.infra.repository;

import com.example.movieReview.infra.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserR2dbcRepository extends ReactiveCrudRepository<UserEntity,Long> {
}
