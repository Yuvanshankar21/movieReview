package com.example.movieReview.domain.model;

import java.util.List;

public record MovieWithReviews(
        String movieName,
        List<ReviewWithUser> reviews
) {
}
