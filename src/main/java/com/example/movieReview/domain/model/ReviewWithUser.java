package com.example.movieReview.domain.model;

public record ReviewWithUser(
        Review review,
        User user
) {
}
