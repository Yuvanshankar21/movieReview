package com.example.movieReview.services;

import com.example.movieReview.domain.model.Movie;
import com.example.movieReview.infra.adaptor.MovieRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

    @Autowired
    MovieRepositoryAdapter adapter;

    public Flux<Movie> getAllMovies() {
        return adapter.findAll();
    }

    public Mono<Movie> getMovieById(Long id) {
        return adapter.findById(id);
    }

    public Mono<Movie> addMovie(Movie movie) {
        return adapter.save(movie);
    }

}
