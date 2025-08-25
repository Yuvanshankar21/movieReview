package com.example.movieReview.domain.model;

import java.util.List;

public record MovieWithReviews(
        Movie movie,
        List<ReviewWithUser> reviews
) {
}
