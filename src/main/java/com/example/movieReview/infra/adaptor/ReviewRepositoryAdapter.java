package com.example.movieReview.infra.adaptor;


import com.example.movieReview.domain.model.Review;
import com.example.movieReview.infra.entity.ReviewEntity;
import com.example.movieReview.infra.repository.ReviewR2dbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReviewRepositoryAdapter {

    @Autowired
    ReviewR2dbcRepository reviewRepo;


    public Flux<Review> findByMovieId(Long movieId) {
        return reviewRepo.findByMovieId(movieId)
                .map(e -> new Review(e.id(), e.rating(), e.comment(), e.movieId(), e.userId()));
    }

    public Flux<Review> findByUserId(Long id) {
        return reviewRepo.findByUserId(id)
                .map(e -> new Review(e.id(), e.rating(), e.comment(), e.movieId(), e.userId()));
    }

    public Mono<Review> save(Review review) {
        return reviewRepo.save(new ReviewEntity(review.id(), review.rating(), review.comment(), review.movieId(), review.userId()))
                .map(e -> new Review(e.id(), e.rating(), e.comment(), e.movieId(), e.userId()));
    }
}
