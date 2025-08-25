package com.example.movieReview.controller;

import com.example.movieReview.domain.model.Review;
import com.example.movieReview.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;


    @GetMapping("/movie/{movieId}")
    public Flux<Review> getReviewsByMovie(@PathVariable Long movieId) {
        return reviewService.getReviewsByMovieId(movieId);
    }

    @GetMapping("/user/{userId}")
    public Flux<Review> getReviewsByUser(@PathVariable Long userId) {
        return reviewService.getReviewsByUserId(userId);
    }

    @PostMapping
    public Mono<Review> addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }
}
