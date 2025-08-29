package com.example.movieReview.infra.adaptor;


import com.example.movieReview.domain.model.Review;
import com.example.movieReview.infra.entity.ReviewEntity;
import com.example.movieReview.infra.repository.ReviewR2dbcRepository;
import com.example.movieReview.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ReviewRepositoryAdapter {


    private final ReviewR2dbcRepository reviewRepo;
    private final ReviewMapper mapper;


    public Flux<Review> findByMovieId(Long movieId) {
        return reviewRepo.findByMovieId(movieId)
                .map(mapper::toDomain);
    }

    public Flux<Review> findByUserId(Long id) {
        return reviewRepo.findByUserId(id)
                .map(mapper::toDomain);
    }

    public Mono<Review> save(Review review) {
        return reviewRepo.save(mapper.toEntity(review))
                .map(mapper::toDomain);
    }
}
