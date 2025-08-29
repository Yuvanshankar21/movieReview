package com.example.movieReview.serviceImpl;

import com.example.movieReview.domain.model.Review;
import com.example.movieReview.infra.adaptor.ReviewRepositoryAdapter;
import com.example.movieReview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepositoryAdapter adapter;

    @Override
    public Flux<Review> getReviewsByMovieId(Long movieId) {
        return adapter.findByMovieId(movieId);
    }

    @Override
    public Flux<Review> getReviewsByUserId(Long userId) {
        return adapter.findByUserId(userId);
    }

    @Override
    public Mono<Review> addReview(Review review) {
        return adapter.save(review);
    }

}
