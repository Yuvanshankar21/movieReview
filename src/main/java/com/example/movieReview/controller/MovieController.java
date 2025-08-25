package com.example.movieReview.controller;

import com.example.movieReview.domain.model.Movie;
import com.example.movieReview.domain.model.MovieWithReviews;
import com.example.movieReview.domain.model.ReviewWithUser;
import com.example.movieReview.services.MovieService;
import com.example.movieReview.services.ReviewService;
import com.example.movieReview.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @GetMapping
    public Flux<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Mono<Movie> getMovie(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Mono<Movie> addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping("/reviews")
    public Flux<MovieWithReviews> getMoviesWithReviews() {
        return movieService.getAllMovies()
                .flatMap(movie ->
                        reviewService.getReviewsByMovieId(movie.id())
                                .flatMap(review ->
                                        userService.getUserById(review.userId())
                                                .map(user -> new ReviewWithUser(review, user))
                                )
                                .collectList()
                                .map(reviewWithUsers -> new MovieWithReviews(movie, reviewWithUsers))
                );
    }
}
