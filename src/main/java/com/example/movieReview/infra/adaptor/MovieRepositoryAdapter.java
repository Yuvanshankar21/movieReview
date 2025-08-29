package com.example.movieReview.infra.adaptor;

import com.example.movieReview.domain.model.Movie;
import com.example.movieReview.infra.repository.MovieR2dbcRepository;
import com.example.movieReview.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MovieRepositoryAdapter {


    private final MovieR2dbcRepository movieRepo;

    private final MovieMapper mapper;

    public Flux<Movie> findAll() {
       return movieRepo.findAll()
               .switchIfEmpty(Mono.error(new Throwable()))
               .map(mapper::toDomain);
    }

    public Mono<Movie> findById(Long id) {
        return movieRepo.findById(id).map(mapper::toDomain);
    }

    public Mono<Movie> save(Movie movie) {
        return movieRepo.save(mapper.toEntity(movie))
                .map(mapper::toDomain);
    }
}
