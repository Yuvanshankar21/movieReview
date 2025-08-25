package com.example.movieReview.services;

import com.example.movieReview.domain.model.Review;
import com.example.movieReview.infra.adaptor.ReviewRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReviewService {

    @Autowired
    ReviewRepositoryAdapter adapter;

    public Flux<Review> getReviewsByMovieId(Long movieId) {
        return adapter.findByMovieId(movieId);
    }

    public Flux<Review> getReviewsByUserId(Long userId) {
        return adapter.findByUserId(userId);
    }

    public Mono<Review> addReview(Review review) {
        return adapter.save(review);
    }
}
