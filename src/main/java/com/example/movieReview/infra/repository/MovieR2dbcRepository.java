package com.example.movieReview.infra.repository;

import com.example.movieReview.infra.entity.MovieEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MovieR2dbcRepository extends ReactiveCrudRepository<MovieEntity, Long> {
}
