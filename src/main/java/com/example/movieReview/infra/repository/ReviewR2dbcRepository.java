package com.example.movieReview.infra.repository;

import com.example.movieReview.infra.entity.ReviewEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ReviewR2dbcRepository extends ReactiveCrudRepository<ReviewEntity,Long> {
    Flux<ReviewEntity> findByMovieId(Long movieId);
    Flux<ReviewEntity> findByUserId(Long userId);
}
