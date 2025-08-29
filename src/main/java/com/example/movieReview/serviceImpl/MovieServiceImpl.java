package com.example.movieReview.serviceImpl;

import com.example.movieReview.domain.model.Movie;
import com.example.movieReview.infra.adaptor.MovieRepositoryAdapter;
import com.example.movieReview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepositoryAdapter adapter;

    @Override
    public Flux<Movie> getAllMovies() {
        return adapter.findAll();
    }

    @Override
    public Mono<Movie> getMovieById(Long id) {
        return adapter.findById(id);
    }

    @Override
    public Mono<Movie> addMovie(Movie movie) {
        return adapter.save(movie);
    }

}
