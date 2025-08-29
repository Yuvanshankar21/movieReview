package com.example.movieReview.controller;

import com.example.movieReview.domain.model.Movie;
import com.example.movieReview.domain.model.MovieWithReviews;
import com.example.movieReview.domain.model.ReviewWithUser;
import com.example.movieReview.mapper.MovieWithReviewMapper;
import com.example.movieReview.serviceImpl.MovieServiceImpl;
import com.example.movieReview.serviceImpl.ReviewServiceImpl;
import com.example.movieReview.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {


    private final MovieServiceImpl movieServiceImpl;

    private final ReviewServiceImpl reviewServiceImpl;

    private final UserServiceImpl userServiceImpl;

    private final MovieWithReviewMapper movieReviewMapper;

    @GetMapping
    public Flux<Movie> getAllMovies() {
        return movieServiceImpl.getAllMovies();
    }

    @GetMapping("/{id}")
    public Mono<Movie> getMovie(@PathVariable Long id) {
        return movieServiceImpl.getMovieById(id);
    }

    @PostMapping
    public Mono<Movie> addMovie(@RequestBody Movie movie) {
        return movieServiceImpl.addMovie(movie);
    }

    @GetMapping("/reviews")
    public Flux<MovieWithReviews> getMoviesWithReviews() {
        return movieServiceImpl.getAllMovies()
                .flatMap(movie ->
                        reviewServiceImpl.getReviewsByMovieId(movie.id())
                                .flatMap(review ->
                                        userServiceImpl.getUserById(review.userId())
                                                .map(user -> new ReviewWithUser(review, user))
                                )
                                .collectList()
                                .map(reviewWithUsers -> movieReviewMapper.toDomain(movie, reviewWithUsers))
                );
    }
}
