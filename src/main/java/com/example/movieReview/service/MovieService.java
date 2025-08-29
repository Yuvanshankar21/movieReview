package com.example.movieReview.service;

import com.example.movieReview.domain.model.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    public Flux<Movie> getAllMovies();
    public Mono<Movie> getMovieById(Long id);
    public Mono<Movie> addMovie(Movie movie);
}
