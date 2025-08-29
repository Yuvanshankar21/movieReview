package com.example.movieReview.service;

import com.example.movieReview.domain.model.Review;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReviewService {
    public Flux<Review> getReviewsByMovieId(Long movieId);
    public Flux<Review> getReviewsByUserId(Long userId);
    public Mono<Review> addReview(Review review);
}
